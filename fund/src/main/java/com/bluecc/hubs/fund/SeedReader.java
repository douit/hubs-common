package com.bluecc.hubs.fund;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.bluecc.hubs.fund.Util.GSON;
import static com.bluecc.hubs.fund.Util.pretty;

public class SeedReader {

    public static void main(String[] args) throws Exception {
        String dataFile = "dataset/order/OrderDemoData.xml";
        Set<String> nameSet = collectEntityNames(dataFile);

        // entity types
        System.out.println("total entity types: "+nameSet.size());
        System.out.println(GSON.toJson(nameSet));

        // collect and print data
        printDataMap(dataFile);
    }

    private static void printDataMap(String dataFile) {
        Multimap<String, JsonObject> dataList=ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, true);
        // dataList.forEach(e -> System.out.println(e));
        for (String key : dataList.keySet()) {
            System.out.println(key+":");
            for (JsonObject jsonObject : dataList.get(key)) {
                pretty(jsonObject);
            }
        }
    }

    public static Set<String> collectEntityNames(String... dataFiles)  {
        return collectEntityNames(Arrays.asList(dataFiles), false);
    }

    public static Set<String> collectEntityNames(List<String> dataFiles, boolean defaultLoc)  {
        Set<String> nameSet = Sets.newHashSet();
        for (String dataFile : dataFiles) {
            if(defaultLoc){
                dataFile=SystemDefs.prependHubsHome(dataFile);
            }
            NodeList nodeList = getNodeList(dataFile);

            for (int i = 0; i < nodeList.getLength(); ++i) {
                if (nodeList.item(i) instanceof Element) {
                    Element element = (Element) nodeList.item(i);
                    nameSet.add(element.getTagName());
                }
            }
        }
        return nameSet;
    }

    public static void collectEntityData(Multimap<String, JsonObject> dataList,
                                         String fileName, boolean camelCase) {
        File dataFile=new File(fileName);
        collectEntityData(dataList, dataFile, camelCase);
    }

    public static void collectEntityData(Multimap<String, JsonObject> dataList,
                                         File dataFile, boolean camelCase) {
        // List<JsonObject> rs= Lists.newArrayList();
        // Multimap<String, JsonObject> rs= ArrayListMultimap.create();

        if(!dataFile.exists()){
            dataFile=SystemDefs.prependHubsHomeFile(dataFile);
        }

        NodeList nodeList = getNodeList(dataFile);
        for(int i=0;i<nodeList.getLength();++i){
            if (nodeList.item(i) instanceof Element){
                Element element=(Element) nodeList.item(i);
                dataList.put(element.getTagName(), convertElement(element, camelCase));
            }
        }
    }

    public static JsonObject convertElement(Element element, boolean camelCase) {
        JsonObject jsonObject=new JsonObject();
        NamedNodeMap attrs=element.getAttributes();
        for(int i=0;i<attrs.getLength();++i){
            Node node=attrs.item(i);
            jsonObject.addProperty(camelCase?node.getNodeName():Util.toSnakecase(node.getNodeName()),
                    node.getNodeValue());
        }
        List<Element> children=Util.childElements(element, null);
        children.forEach(c -> jsonObject.addProperty(
                camelCase?c.getTagName():Util.toSnakecase(c.getTagName()),
                c.getTextContent()));
        return jsonObject;
    }

    public static NodeList getNodeList(String fileName) {
        File dataFile=new File(fileName);
        return getNodeList(dataFile);
    }

    public static NodeList getNodeList(File dataFile)  {
        try {
            // Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Build Document
            Document document = builder.parse(dataFile);

            // Normalize the XML Structure; It's just too important !!
            document.getDocumentElement().normalize();

            // Here comes the root node
            Element root = document.getDocumentElement();
            // System.out.println(root.getNodeName());
            return root.getChildNodes();
        }catch (Exception e ){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
