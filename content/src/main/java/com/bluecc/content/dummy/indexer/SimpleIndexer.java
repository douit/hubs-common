package com.bluecc.content.dummy.indexer;

import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
// import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SimpleIndexer {
    public static void main(String[] args) throws IOException {
        // RestClientBuilder builder = RestClient.builder(
        //         new HttpHost("localhost", 9200, "http"));
        // builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));

        index(client);

        get(client);

        exists(client);

        search(client);

        // delete(client);

        client.close();
    }

    private static void search(RestHighLevelClient client) throws IOException {
        // SearchRequest searchRequest = new SearchRequest("posts");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        // sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        // sourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));

        // String[] includeFields = new String[] {"title", "innerObject.*"};
        // String[] excludeFields = new String[] {"user"};
        // sourceBuilder.fetchSource(includeFields, excludeFields);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("posts");
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        RestStatus status = searchResponse.status();
        // TimeValue took = searchResponse.getTook();
        Boolean terminatedEarly = searchResponse.isTerminatedEarly();
        boolean timedOut = searchResponse.isTimedOut();

        SearchHits hits = searchResponse.getHits();
        TotalHits totalHits = hits.getTotalHits();
        // the total number of hits, must be interpreted in the context of totalHits.relation
        long numHits = totalHits.value;
        // whether the number of hits is accurate (EQUAL_TO) or a lower bound of the total (GREATER_THAN_OR_EQUAL_TO)
        TotalHits.Relation relation = totalHits.relation;
        float maxScore = hits.getMaxScore();

        System.out.println("hit: "+numHits);

        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            // do something with the SearchHit
            String index = hit.getIndex();
            String id = hit.getId();
            float score = hit.getScore();
            System.out.println("hit id: "+id);

            String sourceAsString = hit.getSourceAsString();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String documentTitle = (String) sourceAsMap.get("title");
            // List<Object> users = (List<Object>) sourceAsMap.get("user");
            // Map<String, Object> innerObject =
            //         (Map<String, Object>) sourceAsMap.get("innerObject");

            System.out.println("search result: "+sourceAsString);
        }
    }

    private static void delete(RestHighLevelClient client) throws IOException {
        {
            DeleteRequest request = new DeleteRequest("posts", "does_not_exist");
            DeleteResponse deleteResponse = client.delete(
                    request, RequestOptions.DEFAULT);
            if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
                System.out.println("test: 'does_not_exist' is not found.");
            }
        }
        {
            DeleteRequest request = new DeleteRequest(
                    "posts",
                    "1");
            DeleteResponse deleteResponse = client.delete(
                    request, RequestOptions.DEFAULT);
            String index = deleteResponse.getIndex();
            String id = deleteResponse.getId();
            long version = deleteResponse.getVersion();

            System.out.println("delete "+id);

            ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

            }
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure :
                        shardInfo.getFailures()) {
                    String reason = failure.reason();
                }
            }
        }
    }

    private static void exists(RestHighLevelClient client) throws IOException {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    private static void get(RestHighLevelClient client) throws IOException {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();

            System.out.println(sourceAsString);
        } else {
            System.out.println("not found.");
        }
    }

    private static void index(RestHighLevelClient client) throws IOException {
        {
            IndexRequest request = new IndexRequest("posts");
            request.id("1");
            String jsonString = "{" +
                    "\"user\":\"kimchy\"," +
                    "\"postDate\":\"2013-01-30\"," +
                    "\"message\":\"trying out Elasticsearch\"" +
                    "}";
            request.source(jsonString, XContentType.JSON);

            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

            String index = indexResponse.getIndex();
            String id = indexResponse.getId();
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                System.out.println("created.");
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                System.out.println("updated.");
            }
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
                System.out.println("shard-info fail");
            }
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure :
                        shardInfo.getFailures()) {
                    String reason = failure.reason();
                    System.out.println("fail: "+reason);
                }
            }
        }
        {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("user", "kimchy");
            jsonMap.put("postDate", new Date());
            jsonMap.put("message", "trying out Elasticsearch");
            IndexRequest indexRequest = new IndexRequest("posts")
                    .id("1").source(jsonMap);
        }
        {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.field("user", "kimchy");
                builder.timeField("postDate", new Date());
                builder.field("message", "trying out Elasticsearch");
            }
            builder.endObject();
            IndexRequest indexRequest = new IndexRequest("posts")
                    .id("1").source(builder);
        }
    }
}
