package com.bluecc.content.dummy.indexer;

// import org.elasticsearch.xpack.sql.jdbc.EsDataSource;

import java.sql.*;
import java.util.Properties;

public class EsSqlMain {
    /*
    public static void main(String[] args) throws SQLException {

        // String elasticsearchAddress = "http://localhost:9200/?timezone=UTC&page.size=250";
        String elasticsearchAddress = "http://localhost:9200";
        String address = "jdbc:es://" + elasticsearchAddress;

        try  {
            Connection connection = DriverManager.getConnection(address);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(
                    "select * from library  LIMIT 5");
            while(results.next()){
                System.out.println(results.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // query(address);
    }

    private static void query(String address) throws SQLException {
        // String address = "jdbc:es://" + elasticsearchAddress;
        // // Properties connectionProperties = connectionProperties();
        // Properties connectionProperties =new Properties();
        // Connection connection =
        //         DriverManager.getConnection(address, connectionProperties);

        EsDataSource dataSource = new EsDataSource();

        dataSource.setUrl(address);
        // Properties properties = new Properties();
        // Properties connectionProperties = connectionProperties();
        Properties connectionProperties = new Properties();
        // connectionProperties.put("user", "test_admin");
        // connectionProperties.put("password", "x-pack-test-password");

        dataSource.setProperties(connectionProperties);
        Connection connection = dataSource.getConnection();

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(
                     " SELECT name, page_count"
                             + "    FROM library"
                             + " ORDER BY page_count DESC"
                             + " LIMIT 1")) {
            // assertTrue(results.next());
            // assertEquals("Don Quixote", results.getString(1));
            // assertEquals(1072, results.getInt(2));
            // SQLException e = expectThrows(SQLException.class, () ->
            //         results.getInt(1));
            // assertThat(e.getMessage(), containsString("Unable to convert "
            //         + "value [Don Quixote] of type [TEXT] to [Integer]"));
            // assertFalse(results.next());
            System.out.println(results.next());
        }
    }

     */
}

/*
6.3之后  driver = "org.elasticsearch.xpack.sql.jdbc.EsDriver";
FAIL: current license is non-compliant for [jdbc]
 */