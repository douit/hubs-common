package com.bluecc.livegen;

import com.bluecc.hubs.fund.MeshProfiles;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.income.exchange.FlatMessageCollector;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.protobuf.Message;
import io.vavr.Tuple;
import io.vavr.Tuple3;
import io.vavr.control.Try;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.junit.Test;
import org.w3c.dom.Document;
import org.yaml.snakeyaml.Yaml;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import static com.bluecc.hubs.stereotypes.OrderSeedData.*;
import static com.bluecc.hubs.stereotypes.OrderSeedData.StatusItem_ORDER_CANCELLED;
import static com.bluecc.livegen.ModelStates.*;
import static com.bluecc.livegen.ModelStates.statusItems;
import static org.junit.Assert.*;

public class ModelStatesTest {

    @Test
    public void testStatusDataToXml() throws ParserConfigurationException {
        Document doc = FlatMessageCollector.toXmlDocument(
                Iterables.concat(Collections.singletonList(StatusType_ORDER_STATUS),
                        statusItemList,
                        statusValidChangeList)
        );

        // System.out.println(doc);
        assertEquals(29, Util.childElements(doc.getDocumentElement()).size());
        assertEquals("ORDER_STATUS", Util.childElements(doc.getDocumentElement())
                .get(0).getAttribute("statusTypeId"));

        StatusTypeData statusTypeData = StatusType_ORDER_STATUS;
        ModelTransition.ObjectStatus objectStatus = getObjectStatus(doc, statusTypeData);

        printObjectStatus(objectStatus);
    }

    @Test
    public void testGetObjectStatus() {
        System.out.println(typeData("Order"));
        statusItems("Order", "Creating", "Created")
                .forEach(e -> System.out.println(e));
        System.out.println(statusChanges("Order", "Create Order",
                "Creating", "Created"));

        // ....
        StatesDefs statesDefs=StatesDefs.builder()
                .typeName("Order")
                .item("Creating")
                .item("Created")
                .change(Tuple.of("Create Order", "Creating", "Created"))
                .build();
        statesDefs.build().forEach(e -> System.out.println(e));

        System.out.println("===========");
        statesDefs.treePrint();
    }

    @Test
    public void testMeshProfiles() throws FileNotFoundException {
        MeshProfiles.MeshesProfile profile = sampleMeshes();
        MeshProfiles.MeshProfile dummyStore=profile.getMeshProfile("dummyStore");

        StatesDefs.StatesDefsBuilder builder=StatesDefs.builder();
        builder.typeName("Store");
        dummyStore.getMeshStates().forEach(st -> {
            System.out.println(st.getStateName());
            builder.item(st.getStateName());
            st.getBranchList().forEach(b -> {
                System.out.format("\t%s - %s\n", b.getEvent().getEventName(), b.getTargetState());
                builder.change(Tuple.of(b.getEvent().getEventName(),
                        st.getStateName(),
                        b.getTargetState()));
            });
        });

        System.out.println(dummyStore.getGraph().successors("openning"));
        assertTrue(dummyStore.getGraph().hasEdgeConnecting("opened", "ordering"));
        assertFalse(dummyStore.getGraph().hasEdgeConnecting("opened", "openning"));

        // convert
        builder.build().treePrint();
    }

    Yaml yaml=new Yaml();
    private MeshProfiles.MeshesProfile sampleMeshes() throws FileNotFoundException {
        File simpleFile= SystemDefs.prependHubsHomeFile("asset/mesh/draft.yml");
        MeshProfiles.MeshesProfile profile=yaml.loadAs(new FileReader(simpleFile),
                MeshProfiles.MeshesProfile.class);
        return profile;
    }

    public static final List<StatusItemData> statusItemList = ImmutableList.of(
            StatusItem_ORDER_CREATED,
            StatusItem_ORDER_PROCESSING,
            StatusItem_ORDER_APPROVED,
            StatusItem_ORDER_SENT,
            StatusItem_ORDER_HOLD,
            StatusItem_ORDER_COMPLETED,
            StatusItem_ORDER_REJECTED,
            StatusItem_ORDER_CANCELLED);

    public static final List<StatusValidChangeData> statusValidChangeList = ImmutableList.of(
            StatusValidChange_ORDER_CREATED_ORDER_PROCESSING,
            StatusValidChange_ORDER_CREATED_ORDER_APPROVED,
            StatusValidChange_ORDER_CREATED_ORDER_HOLD,
            StatusValidChange_ORDER_CREATED_ORDER_REJECTED,
            StatusValidChange_ORDER_CREATED_ORDER_CANCELLED,

            StatusValidChange_ORDER_PROCESSING_ORDER_HOLD,
            StatusValidChange_ORDER_PROCESSING_ORDER_APPROVED,
            StatusValidChange_ORDER_PROCESSING_ORDER_REJECTED,
            StatusValidChange_ORDER_PROCESSING_ORDER_CANCELLED,

            StatusValidChange_ORDER_APPROVED_ORDER_SENT,
            StatusValidChange_ORDER_APPROVED_ORDER_PROCESSING,
            StatusValidChange_ORDER_APPROVED_ORDER_COMPLETED,
            StatusValidChange_ORDER_APPROVED_ORDER_CANCELLED,
            StatusValidChange_ORDER_APPROVED_ORDER_HOLD,
            StatusValidChange_ORDER_HOLD_ORDER_PROCESSING,
            StatusValidChange_ORDER_HOLD_ORDER_APPROVED,
            StatusValidChange_ORDER_HOLD_ORDER_CANCELLED,
            StatusValidChange_ORDER_SENT_ORDER_COMPLETED,
            StatusValidChange_ORDER_SENT_ORDER_CANCELLED,
            StatusValidChange_ORDER_COMPLETED_ORDER_APPROVED
    );

}