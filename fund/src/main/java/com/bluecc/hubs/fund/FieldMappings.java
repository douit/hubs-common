package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;
import lombok.Data;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Map;

public class FieldMappings {
    @Data
    public static class FieldTypeDef{
        String type;
        String sqlType;
        String javaType;
        String clickhouseType;
    }

    public static void main(String[] args) {
        Map<String, FieldTypeDef> types=getFieldTypes();
        System.out.println(types.get("id").getSqlType());
        System.out.println(types.get("date-time").getSqlType());
    }

    public static Map<String, FieldTypeDef> getFieldTypes() {
        Map<String, FieldTypeDef> fieldTypes= Maps.newHashMap();

        NodeList types=getFieldMappings();
        for(int i=0; i<types.getLength();++i){
            Element element=(Element) types.item(i);
            NamedNodeMap attrs = element.getAttributes();
            FieldTypeDef fld=new FieldTypeDef();
            for (int n = 0; n < attrs.getLength(); ++n) {
                Node node = attrs.item(n);
                // jsonObject.addProperty(node.getNodeName(), node.getNodeValue());
                switch (node.getNodeName()){
                    case "type": fld.setType(node.getNodeValue()); break;
                    case "sql-type": fld.setSqlType(node.getNodeValue()); break;
                    case "java-type": fld.setJavaType(node.getNodeValue()); break;
                    case "clickhouse-type":
                        fld.setClickhouseType(node.getNodeValue());
                        break;
                    default:
                        throw new RuntimeException("Cannot process attribute "+node.getNodeName());
                }

            }
            fieldTypes.put(fld.type, fld);
        }
        return fieldTypes;
    }

    private static NodeList getFieldMappings() {
        try {
            // Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Build Document
            // Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes(StandardCharsets.UTF_8)));
            Document document = builder.parse(Util.dataSource("fieldtypes.xml"));

            // Normalize the XML Structure; It's just too important !!
            document.getDocumentElement().normalize();

            // Here comes the root node
            Element root = document.getDocumentElement();
            // System.out.println(root.getNodeName());
            // return root.getChildNodes();
            return root.getElementsByTagName("field-type-def");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
