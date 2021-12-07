package com.bluecc.gentool;

import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.ModelTransition.*;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bluecc.hubs.fund.Util.pretty;

@Slf4j
public class SeedScanner {
    public static void main(String[] args) {
        String rootDir = "/opt/app/ofbiz";

        SeedScanner scanner = new SeedScanner();
        scanner.scan(rootDir);

        scanner.statusValidChangeList
                .stream()
                .peek(e -> scanner.setup(e))
                .forEach(Util::pretty);

        printTransitions(scanner);

        String targetDir="asset/transitions";
        writeToFiles(scanner, targetDir);
    }

    private static void printTransitions(SeedScanner scanner) {
        scanner.statusTypeMap.values().stream()
                .map(t -> t.getDescription())
                .sorted()
                .forEach(e -> System.out.println(e));
        System.out.println("total transitions: " + scanner.statusValidChangeList.size());
        System.out.println("total types: " + scanner.statusTypeMap.size());
    }

    private static void writeToFiles(SeedScanner scanner, String targetDir) {
        scanner.statusTypeMap.keySet().forEach(typ ->{
            String typeDesc= scanner.statusTypeMap.get(typ).getDescription();
            Path path=Paths.get(targetDir, Util.wordsToClassName(typeDesc)+".json");
            List<StatusValidChange> changeList= scanner.statusValidChangeList.stream()
                    .filter(s -> s.statusType.getStatusTypeId().equals(typ))
                    .collect(Collectors.toList());
            List<String> statusItems=scanner.statusItemMap.values().stream()
                    .filter(s -> s.getStatusTypeId().equals(typ))
                    .map(s -> s.getStatusId())
                    .collect(Collectors.toList());
            if(!changeList.isEmpty()) {
                try {
                    System.out.format(".. write to %s\n", path);
                    Util.writeJsonFile(StatusTransitions
                                    .createBy(changeList, statusItems),
                            path.toFile());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setup(StatusValidChange change) {
        change.from = statusItemMap.get(change.getStatusId());
        change.to = statusItemMap.get(change.getStatusIdTo());
        change.statusType = statusTypeMap.get(change.from.getStatusTypeId());
    }

    Map<String, StatusItem> statusItemMap = Maps.newHashMap();
    Map<String, StatusType> statusTypeMap = Maps.newHashMap();
    List<StatusValidChange> statusValidChangeList = Lists.newArrayList();

    void scan(String rootDir) {
        Stream.of("applications", "framework", "plugins").forEach(dir -> {
            Path path = Paths.get(rootDir, dir);
            Arrays.stream(Objects.requireNonNull(path.toFile().listFiles()))
                    .filter(f -> f.isDirectory())
                    .peek(System.out::println)
                    .map(f -> Paths.get(f.toString(), "ofbiz-component.xml"))
                    .filter(p -> p.toFile().exists())
                    .peek(compFile -> {
                        System.out.println(compFile.getParent() + ", " + compFile.toFile().getName());
                    })
                    .flatMap(f -> extractResourceFiles(f).stream())
                    .filter(f -> f.toFile().exists())
                    .flatMap(dataFile -> pickupElements(dataFile,
                            "StatusValidChange", "StatusItem", "StatusType").stream())
                    .forEach(e -> {
                        switch (e.getTagName()) {
                            case "StatusValidChange":
                                statusValidChangeList.add(StatusValidChange.builder()
                                        .statusId(e.getAttribute("statusId"))
                                        .statusIdTo(e.getAttribute("statusIdTo"))
                                        .transitionName(e.getAttribute("transitionName"))
                                        .build());
                                break;
                            case "StatusItem":
                                statusItemMap.put(e.getAttribute("statusId"),
                                        StatusItem.builder()
                                                .statusId(e.getAttribute("statusId"))
                                                .description(e.getAttribute("description"))
                                                .sequenceId(e.getAttribute("sequenceId"))
                                                .statusCode(e.getAttribute("statusCode"))
                                                .statusTypeId(e.getAttribute("statusTypeId"))
                                                .build());
                                break;
                            case "StatusType":
                                statusTypeMap.put(e.getAttribute("statusTypeId"),
                                        StatusType.builder()
                                                .statusTypeId(e.getAttribute("statusTypeId"))
                                                .description(e.getAttribute("description"))
                                                .parentTypeId(e.getAttribute("parentTypeId"))
                                                .build()
                                );
                                break;
                        }
                    });
            ;
        });
    }

    private List<Element> pickupElements(Path dataFile, String... tags) {
        List<Element> results = Lists.newArrayList();
        for (String tag : tags) {
            NodeList list = getElements(dataFile, tag);
            for (int temp = 0; temp < list.getLength(); temp++) {
                Element node = (Element) list.item(temp);
                results.add(node);
            }
        }
        return results;
    }

    private List<Path> extractResourceFiles(Path compXmlFile) {
        List<Path> resultList = Lists.newArrayList();
        try {
            NodeList list = getElements(compXmlFile, "entity-resource");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String type = element.getAttribute("type");
                    if (type.equals("data")) {
                        String location = element.getAttribute("location");
                        resultList.add(Paths.get(compXmlFile.getParent().toString(), location));
                    }
                }
            }

            return resultList;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private NodeList getElements(Path compXmlFile, String tag) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(compXmlFile.toFile());
            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName(tag);
            return list;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }
}
