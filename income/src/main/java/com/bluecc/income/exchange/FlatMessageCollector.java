package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.Map;

@Slf4j
public class FlatMessageCollector extends MessageMapCollector{
    public FlatMessageCollector() {
        super(null, new TravelContext());
    }

    public static Map<String, Object> extract(Message msg){
        return new FlatMessageCollector().extractFromMessage(msg);
    }

    public Map<String, Object> extractFromMessage(Message msg){
        Map<String, Object> map= Maps.newHashMap();
        extractToMap(msg, map);
        return map;
    }

    public static Document toXmlDocument(List<Message> messageList) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);

        for (Message message : messageList) {
            Element element = doc.createElement(ProtoTypes.getEntityTypeByMessage(message, "Raw"));
            root.appendChild(element);
            Map<String, Object> rs = FlatMessageCollector.extract(message);
            rs.forEach((k, v) -> element.setAttribute(CaseFormat.LOWER_UNDERSCORE.
                    to(CaseFormat.LOWER_CAMEL, k), v.toString()));
        }

        return doc;
    }

    @Override
    protected void getEntityField(Message parentMsg,
                                  Descriptors.FieldDescriptor fld,
                                  Object fldVal) {
        log.error("field value type is {}, message type is{}, and repeated: {}",
                fldVal.getClass().getName(),
                fld.getMessageType().getName(),
                fld.isRepeated());
        throw new RuntimeException("Cannot handle field message type: "
                +fld.getMessageType().getName());
    }
}
