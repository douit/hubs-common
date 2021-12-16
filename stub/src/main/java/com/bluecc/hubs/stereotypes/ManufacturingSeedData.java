package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.TechDataCalendarData;
import com.bluecc.hubs.stub.MrpEventTypeData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.CustomMethodTypeData;
import com.bluecc.hubs.stub.TechDataCalendarWeekData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class ManufacturingSeedData {
    public final static EnumerationData Enumeration_WF_PREDECESSOR = EnumerationData.newBuilder()
        .setDescription("Predecessor")
        .setEnumCode("PREDECESSOR")
        .setEnumId("WF_PREDECESSOR")
        .setEnumTypeId("WORKFLOW")
        .setSequenceId("1")
        .build();


    public final static EnumerationData Enumeration_WF_SUCCESSOR = EnumerationData.newBuilder()
        .setDescription("Successor")
        .setEnumCode("SUCCESSOR")
        .setEnumId("WF_SUCCESSOR")
        .setEnumTypeId("WORKFLOW")
        .setSequenceId("2")
        .build();


    public final static TechDataCalendarData TechDataCalendar_SUPPLIER = TechDataCalendarData.newBuilder()
        .setCalendarId("SUPPLIER")
        .setCalendarWeekId("SUPPLIER")
        .setDescription("Calendar used for Re-Order date calculation for bought product")
        .build();


    public final static TechDataCalendarData TechDataCalendar_DEFAULT = TechDataCalendarData.newBuilder()
        .setCalendarId("DEFAULT")
        .setCalendarWeekId("DEFAULT")
        .setDescription("Default calendar used when no specific calendar is defined")
        .build();


    public final static MrpEventTypeData MrpEventType_REQUIRED_MRP = MrpEventTypeData.newBuilder()
        .setDescription("Required planning because QOH is less than minimum quantity")
        .setMrpEventTypeId("REQUIRED_MRP")
        .build();


    public final static MrpEventTypeData MrpEventType_INITIAL_QOH = MrpEventTypeData.newBuilder()
        .setDescription("Initial QOH")
        .setMrpEventTypeId("INITIAL_QOH")
        .build();


    public final static MrpEventTypeData MrpEventType_MRP_REQUIREMENT = MrpEventTypeData.newBuilder()
        .setDescription("Mrp requirement")
        .setMrpEventTypeId("MRP_REQUIREMENT")
        .build();


    public final static MrpEventTypeData MrpEventType_MANUF_ORDER_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Manufacturing Order receipt")
        .setMrpEventTypeId("MANUF_ORDER_RECP")
        .build();


    public final static MrpEventTypeData MrpEventType_MANUF_ORDER_REQ = MrpEventTypeData.newBuilder()
        .setDescription("Manufacturing Order requirement")
        .setMrpEventTypeId("MANUF_ORDER_REQ")
        .build();


    public final static MrpEventTypeData MrpEventType_PROP_MANUF_O_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Proposed Manufacturing Order receipt")
        .setMrpEventTypeId("PROP_MANUF_O_RECP")
        .build();


    public final static MrpEventTypeData MrpEventType_PUR_ORDER_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Purchase Order receipt")
        .setMrpEventTypeId("PUR_ORDER_RECP")
        .build();


    public final static MrpEventTypeData MrpEventType_PROD_REQ_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Product Requirement Receipt")
        .setMrpEventTypeId("PROD_REQ_RECP")
        .build();


    public final static MrpEventTypeData MrpEventType_PROP_PUR_O_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Proposed Purchase Order receipt")
        .setMrpEventTypeId("PROP_PUR_O_RECP")
        .build();


    public final static MrpEventTypeData MrpEventType_SALES_ORDER_SHIP = MrpEventTypeData.newBuilder()
        .setDescription("Sales order shipment")
        .setMrpEventTypeId("SALES_ORDER_SHIP")
        .build();


    public final static MrpEventTypeData MrpEventType_SALES_FORECAST = MrpEventTypeData.newBuilder()
        .setDescription("Sales Forecast")
        .setMrpEventTypeId("SALES_FORECAST")
        .build();


    public final static MrpEventTypeData MrpEventType_ERROR = MrpEventTypeData.newBuilder()
        .setDescription("Error")
        .setMrpEventTypeId("ERROR")
        .build();


    public final static MrpEventTypeData MrpEventType_PROP_TRANSFER_RECP = MrpEventTypeData.newBuilder()
        .setDescription("Proposed Transfer receipt")
        .setMrpEventTypeId("PROP_TRANSFER_RECP")
        .build();


    public final static WorkEffortFlatData WorkEffort_DEFAULT_ROUTING = WorkEffortFlatData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Default Routing")
        .setQuantityToProduce(getFixedPoint("0"))
        .setRevisionNumber(1)
        .setWorkEffortId("DEFAULT_ROUTING")
        .setWorkEffortName("Default Routing")
        .setWorkEffortTypeId("ROUTING")
        .build();


    public final static WorkEffortFlatData WorkEffort_DEFAULT_TASK = WorkEffortFlatData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Default Routing Task")
        .setEstimatedMilliSeconds(0)
        .setEstimatedSetupMillis(0)
        .setRevisionNumber(1)
        .setWorkEffortId("DEFAULT_TASK")
        .setWorkEffortName("Default Routing Task")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static CustomMethodTypeData CustomMethodType_TASK_FORMULA = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("TASK_FORMULA")
        .setDescription("Formula for calculating time estimates for tasks")
        .build();


    public final static CustomMethodTypeData CustomMethodType_BOM_FORMULA = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("BOM_FORMULA")
        .setDescription("Formula for calculating material estimates for boms")
        .build();


    public final static TechDataCalendarWeekData TechDataCalendarWeek_SUPPLIER = TechDataCalendarWeekData.newBuilder()
        .setCalendarWeekId("SUPPLIER")
        .setDescription("8hours/days, currently the Re-Order Process convert day to mms with 8h/days")
        .setFridayCapacity(2.88E7)
        .setFridayStartTime(getTimeOfDay("08:30:00"))
        .setMondayCapacity(2.88E7)
        .setMondayStartTime(getTimeOfDay("08:30:00"))
        .setThursdayCapacity(2.88E7)
        .setThursdayStartTime(getTimeOfDay("08:30:00"))
        .setTuesdayCapacity(2.88E7)
        .setTuesdayStartTime(getTimeOfDay("08:30:00"))
        .setWednesdayCapacity(2.88E7)
        .setWednesdayStartTime(getTimeOfDay("08:30:00"))
        .build();


    public final static TechDataCalendarWeekData TechDataCalendarWeek_DEFAULT = TechDataCalendarWeekData.newBuilder()
        .setCalendarWeekId("DEFAULT")
        .setDescription("8hours/days")
        .setFridayCapacity(2.88E7)
        .setFridayStartTime(getTimeOfDay("08:30:00"))
        .setMondayCapacity(2.88E7)
        .setMondayStartTime(getTimeOfDay("08:30:00"))
        .setThursdayCapacity(2.88E7)
        .setThursdayStartTime(getTimeOfDay("08:30:00"))
        .setTuesdayCapacity(2.88E7)
        .setTuesdayStartTime(getTimeOfDay("08:30:00"))
        .setWednesdayCapacity(2.88E7)
        .setWednesdayStartTime(getTimeOfDay("08:30:00"))
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_DEFAULT_ROUTING_DEFAULT_TASK_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:38.736"))
        .setSequenceNum(10)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("DEFAULT_ROUTING")
        .setWorkEffortIdTo("DEFAULT_TASK")
        .build();

}
