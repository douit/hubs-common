package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.ManufacturingDemoData.*;

import com.bluecc.hubs.stub.FixedAssetGeoPointData;
import com.bluecc.hubs.stub.TechDataCalendarExcDayData;
import com.bluecc.hubs.stub.FixedAssetDepMethodData;
import com.bluecc.hubs.stub.CustomMethodData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.TechDataCalendarData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.TechDataCalendarWeekData;

public final class ManufacturingDemoDataList {
    public static List<FixedAssetGeoPointData> fixedAssetGeoPointList() {
        return ImmutableList.of(        
            FixedAssetGeoPoint_DEMO_MACHINE_GROUP_9000_(),        
            FixedAssetGeoPoint_DEMO_MACHINE_9000_(),        
            FixedAssetGeoPoint_DEMO_FOOD_GROUP_9000_(),        
            FixedAssetGeoPoint_DEMO_FOOD_9000_(),        
            FixedAssetGeoPoint_DEMO_PROD_EQUIPMT_1_9000_(),        
            FixedAssetGeoPoint_DEMO_PROD_EQUIPMT_2_9000_(),        
            FixedAssetGeoPoint_DEMO_BOOK_GROUP_9000_(),        
            FixedAssetGeoPoint_DEMO_BOOK_9000_());
    }

    public static List<TechDataCalendarExcDayData> techDataCalendarExcDayList() {
        return ImmutableList.of(        
            TechDataCalendarExcDay_DEMO_CALENDAR_());
    }

    public static List<FixedAssetDepMethodData> fixedAssetDepMethodList() {
        return ImmutableList.of(        
            FixedAssetDepMethod_STR_LINE_DEP_FORMULA_DEMO_PROD_EQUIPMT_1(),        
            FixedAssetDepMethod_DBL_DECL_DEP_FORMULA_DEMO_PROD_EQUIPMT_2());
    }

    public static List<CustomMethodData> customMethodList() {
        return ImmutableList.of(        
            CustomMethod_6000(),        
            CustomMethod_6001(),        
            CustomMethod_6002());
    }

    public static List<FixedAssetFlatData> fixedAssetList() {
        return ImmutableList.of(        
            FixedAsset_DEMO_MACHINE_GROUP(),        
            FixedAsset_DEMO_MACHINE(),        
            FixedAsset_DEMO_FOOD_GROUP(),        
            FixedAsset_DEMO_FOOD(),        
            FixedAsset_DEMO_PROD_EQUIPMT_1(),        
            FixedAsset_DEMO_PROD_EQUIPMT_2(),        
            FixedAsset_DEMO_BOOK_GROUP(),        
            FixedAsset_DEMO_BOOK());
    }

    public static List<TechDataCalendarData> techDataCalendarList() {
        return ImmutableList.of(        
            TechDataCalendar_DEMO_CALENDAR());
    }

    public static List<SecurityGroupPermissionData> securityGroupPermissionList() {
        return ImmutableList.of(        
            SecurityGroupPermission_FULLADMIN_MANUFACTURING_ADMIN_(),        
            SecurityGroupPermission_FLEXADMIN_MANUFACTURING_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_MANUFACTURING_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_MANUFACTURING_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_MANUFACTURING_VIEW_(),        
            SecurityGroupPermission_VIEWADMIN_MANUFACTURING_VIEW_(),        
            SecurityGroupPermission_BIZADMIN_MANUFACTURING_ADMIN_());
    }

    public static List<TechDataCalendarWeekData> techDataCalendarWeekList() {
        return ImmutableList.of(        
            TechDataCalendarWeek_DEMO_WEEK());
    }

}
