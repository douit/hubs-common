package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.RateTestsData.*;

import com.bluecc.hubs.stub.RateAmountData;
import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.EmplPositionTypeData;
import com.bluecc.hubs.stub.PartyRateData;

public final class RateTestsDataList {
    public static List<RateAmountData> rateAmountList() {
        return ImmutableList.of(        
            RateAmount_AVERAGE_PAY_RATE_USD_RATE_MONTH__NA___NA__TEST_EMPLOYEE_(),        
            RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR__NA__Test_effort__NA__(),        
            RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR_TEST_PARTY__NA___NA__(),        
            RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR__NA___NA__TEST_EMPLOYEE_());
    }

    public static List<WorkEffortData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_Test_effort());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_TEST_PARTY());
    }

    public static List<EmplPositionTypeData> emplPositionTypeList() {
        return ImmutableList.of(        
            EmplPositionType_TEST_EMPLOYEE());
    }

    public static List<PartyRateData> partyRateList() {
        return ImmutableList.of(        
            PartyRate_TEST_PARTY_AVERAGE_PAY_RATE_());
    }

}
