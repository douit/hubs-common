package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.ManufacturingSeedData.*;import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.TechDataCalendarData;
import com.bluecc.hubs.stub.MrpEventTypeData;
import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.CustomMethodTypeData;
import com.bluecc.hubs.stub.TechDataCalendarWeekData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class ManufacturingSeedDataList {
    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_WF_PREDECESSOR,        
            Enumeration_WF_SUCCESSOR);

    public static final List<TechDataCalendarData> techDataCalendarList=ImmutableList.of(        
            TechDataCalendar_SUPPLIER,        
            TechDataCalendar_DEFAULT);

    public static final List<MrpEventTypeData> mrpEventTypeList=ImmutableList.of(        
            MrpEventType_REQUIRED_MRP,        
            MrpEventType_INITIAL_QOH,        
            MrpEventType_MRP_REQUIREMENT,        
            MrpEventType_MANUF_ORDER_RECP,        
            MrpEventType_MANUF_ORDER_REQ,        
            MrpEventType_PROP_MANUF_O_RECP,        
            MrpEventType_PUR_ORDER_RECP,        
            MrpEventType_PROD_REQ_RECP,        
            MrpEventType_PROP_PUR_O_RECP,        
            MrpEventType_SALES_ORDER_SHIP,        
            MrpEventType_SALES_FORECAST,        
            MrpEventType_ERROR,        
            MrpEventType_PROP_TRANSFER_RECP);

    public static final List<WorkEffortData> workEffortList=ImmutableList.of(        
            WorkEffort_DEFAULT_ROUTING,        
            WorkEffort_DEFAULT_TASK);

    public static final List<CustomMethodTypeData> customMethodTypeList=ImmutableList.of(        
            CustomMethodType_TASK_FORMULA,        
            CustomMethodType_BOM_FORMULA);

    public static final List<TechDataCalendarWeekData> techDataCalendarWeekList=ImmutableList.of(        
            TechDataCalendarWeek_SUPPLIER,        
            TechDataCalendarWeek_DEFAULT);

    public static final List<WorkEffortAssocData> workEffortAssocList=ImmutableList.of(        
            WorkEffortAssoc_DEFAULT_ROUTING_DEFAULT_TASK_ROUTING_COMPONENT_);

}
