package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.FixedAssetGeoPointData;
import com.bluecc.hubs.stub.TechDataCalendarExcDayData;
import com.bluecc.hubs.stub.FixedAssetDepMethodData;
import com.bluecc.hubs.stub.CustomMethodData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.TechDataCalendarData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.TechDataCalendarWeekData;

public final class ManufacturingDemoData {
    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_MACHINE_GROUP_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_MACHINE_GROUP")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_MACHINE_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_MACHINE")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_FOOD_GROUP_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_FOOD_GROUP")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_FOOD_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_FOOD")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_PROD_EQUIPMT_1_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_PROD_EQUIPMT_1")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_PROD_EQUIPMT_2_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_PROD_EQUIPMT_2")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_BOOK_GROUP_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_BOOK_GROUP")
            .setFromDate(getTimestamp("2011-08-02 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_BOOK_9000_() {
        return FixedAssetGeoPointData.newBuilder()
            .setFixedAssetId("DEMO_BOOK")
            .setFromDate(getTimestamp("2011-08-02 00:00:00.000"))
            .setGeoPointId("9000")
            .build();
    }


    public static TechDataCalendarExcDayData TechDataCalendarExcDay_DEMO_CALENDAR_() {
        return TechDataCalendarExcDayData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setDescription("Christmas Day")
            .setExceptionCapacity(getFixedPoint("0"))
            .setExceptionDateStartTime(getTimestamp("2004-12-24 00:01:00.0"))
            .build();
    }


    public static FixedAssetDepMethodData FixedAssetDepMethod_STR_LINE_DEP_FORMULA_DEMO_PROD_EQUIPMT_1() {
        return FixedAssetDepMethodData.newBuilder()
            .setDepreciationCustomMethodId("STR_LINE_DEP_FORMULA")
            .setFixedAssetId("DEMO_PROD_EQUIPMT_1")
            .build();
    }


    public static FixedAssetDepMethodData FixedAssetDepMethod_DBL_DECL_DEP_FORMULA_DEMO_PROD_EQUIPMT_2() {
        return FixedAssetDepMethodData.newBuilder()
            .setDepreciationCustomMethodId("DBL_DECL_DEP_FORMULA")
            .setFixedAssetId("DEMO_PROD_EQUIPMT_2")
            .build();
    }


    public static CustomMethodData CustomMethod_6000() {
        return CustomMethodData.newBuilder()
            .setCustomMethodId("6000")
            .setCustomMethodName("exampleTaskFormula")
            .setCustomMethodTypeId("TASK_FORMULA")
            .setDescription("Example task formula (qty * estimatedMilliSeconds * 10)")
            .build();
    }


    public static CustomMethodData CustomMethod_6001() {
        return CustomMethodData.newBuilder()
            .setCustomMethodId("6001")
            .setCustomMethodName("exampleComponentFormula")
            .setCustomMethodTypeId("BOM_FORMULA")
            .setDescription("Example bom formula (qty * k)")
            .build();
    }


    public static CustomMethodData CustomMethod_6002() {
        return CustomMethodData.newBuilder()
            .setCustomMethodId("6002")
            .setCustomMethodName("linearComponentFormula")
            .setCustomMethodTypeId("BOM_FORMULA")
            .setDescription("Bom formula for linear components")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_MACHINE_GROUP() {
        return FixedAssetFlatData.newBuilder()
            .setFixedAssetId("DEMO_MACHINE_GROUP")
            .setFixedAssetName("Demo Machine Group")
            .setFixedAssetTypeId("GROUP_EQUIPMENT")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_MACHINE() {
        return FixedAssetFlatData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setFixedAssetId("DEMO_MACHINE")
            .setFixedAssetName("Demo Machine")
            .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
            .setParentFixedAssetId("DEMO_MACHINE_GROUP")
            .setPurchaseCost(getCurrency("50000"))
            .setPurchaseCostUomId("USD")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_FOOD_GROUP() {
        return FixedAssetFlatData.newBuilder()
            .setFixedAssetId("DEMO_FOOD_GROUP")
            .setFixedAssetName("Demo Food Group")
            .setFixedAssetTypeId("GROUP_EQUIPMENT")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_FOOD() {
        return FixedAssetFlatData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setFixedAssetId("DEMO_FOOD")
            .setFixedAssetName("Demo Food")
            .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
            .setParentFixedAssetId("DEMO_FOOD_GROUP")
            .setPurchaseCost(getCurrency("7000"))
            .setPurchaseCostUomId("USD")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_PROD_EQUIPMT_1() {
        return FixedAssetFlatData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setDateAcquired(getTimestamp("2005-01-01 00:01:00.0"))
            .setExpectedEndOfLife(getDate("2010-01-01"))
            .setFixedAssetId("DEMO_PROD_EQUIPMT_1")
            .setFixedAssetName("Demo Production Equipment One")
            .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
            .setPurchaseCost(getCurrency("1000"))
            .setPurchaseCostUomId("USD")
            .setSalvageValue(getCurrency("50"))
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_PROD_EQUIPMT_2() {
        return FixedAssetFlatData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setDateAcquired(getTimestamp("2005-01-01 00:01:00.0"))
            .setExpectedEndOfLife(getDate("2010-01-01"))
            .setFixedAssetId("DEMO_PROD_EQUIPMT_2")
            .setFixedAssetName("Demo Production Equipment Two")
            .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
            .setPurchaseCost(getCurrency("1000"))
            .setPurchaseCostUomId("USD")
            .setSalvageValue(getCurrency("50"))
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_BOOK_GROUP() {
        return FixedAssetFlatData.newBuilder()
            .setFixedAssetId("DEMO_BOOK_GROUP")
            .setFixedAssetName("Demo Book Group")
            .setFixedAssetTypeId("GROUP_EQUIPMENT")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_BOOK() {
        return FixedAssetFlatData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setFixedAssetId("DEMO_BOOK")
            .setFixedAssetName("Demo Book")
            .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
            .setParentFixedAssetId("DEMO_BOOK_GROUP")
            .setPurchaseCost(getCurrency("200"))
            .setPurchaseCostUomId("USD")
            .build();
    }


    public static TechDataCalendarData TechDataCalendar_DEMO_CALENDAR() {
        return TechDataCalendarData.newBuilder()
            .setCalendarId("DEMO_CALENDAR")
            .setCalendarWeekId("DEMO_WEEK")
            .setDescription("Demo Workcenter Calendar")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FULLADMIN_MANUFACTURING_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FULLADMIN")
            .setPermissionId("MANUFACTURING_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_MANUFACTURING_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("MANUFACTURING_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_MANUFACTURING_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("MANUFACTURING_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_MANUFACTURING_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("MANUFACTURING_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_MANUFACTURING_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("MANUFACTURING_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_MANUFACTURING_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("MANUFACTURING_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_BIZADMIN_MANUFACTURING_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("BIZADMIN")
            .setPermissionId("MANUFACTURING_ADMIN")
            .build();
    }


    public static TechDataCalendarWeekData TechDataCalendarWeek_DEMO_WEEK() {
        return TechDataCalendarWeekData.newBuilder()
            .setCalendarWeekId("DEMO_WEEK")
            .setDescription("Demo calendar week of 8hours/days 5days/week starting at 8h30 from monday to friday")
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
    }

}
