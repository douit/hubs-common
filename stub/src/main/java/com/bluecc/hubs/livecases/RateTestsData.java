package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.RateAmountData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.EmplPositionTypeData;
import com.bluecc.hubs.stub.PartyRateData;

public final class RateTestsData {
    public static RateAmountData RateAmount_AVERAGE_PAY_RATE_USD_RATE_MONTH__NA___NA__TEST_EMPLOYEE_() {
        return RateAmountData.newBuilder()
            .setEmplPositionTypeId("TEST_EMPLOYEE")
            .setFromDate(getTimestamp("2013-07-04 00:00:00"))
            .setPartyId("_NA_")
            .setPeriodTypeId("RATE_MONTH")
            .setRateCurrencyUomId("USD")
            .setRateTypeId("AVERAGE_PAY_RATE")
            .setWorkEffortId("_NA_")
            .build();
    }


    public static RateAmountData RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR__NA__Test_effort__NA__() {
        return RateAmountData.newBuilder()
            .setEmplPositionTypeId("_NA_")
            .setFromDate(getTimestamp("2013-07-04 00:00:00"))
            .setPartyId("_NA_")
            .setPeriodTypeId("RATE_HOUR")
            .setRateAmount(getCurrency("75"))
            .setRateCurrencyUomId("USD")
            .setRateTypeId("AVERAGE_PAY_RATE")
            .setWorkEffortId("Test_effort")
            .build();
    }


    public static RateAmountData RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR_TEST_PARTY__NA___NA__() {
        return RateAmountData.newBuilder()
            .setEmplPositionTypeId("_NA_")
            .setFromDate(getTimestamp("2013-07-04 00:00:00"))
            .setPartyId("TEST_PARTY")
            .setPeriodTypeId("RATE_HOUR")
            .setRateCurrencyUomId("USD")
            .setRateTypeId("AVERAGE_PAY_RATE")
            .setWorkEffortId("_NA_")
            .build();
    }


    public static RateAmountData RateAmount_AVERAGE_PAY_RATE_USD_RATE_HOUR__NA___NA__TEST_EMPLOYEE_() {
        return RateAmountData.newBuilder()
            .setEmplPositionTypeId("TEST_EMPLOYEE")
            .setFromDate(getTimestamp("2013-07-04 00:00:00"))
            .setPartyId("_NA_")
            .setPeriodTypeId("RATE_HOUR")
            .setRateCurrencyUomId("USD")
            .setRateTypeId("AVERAGE_PAY_RATE")
            .setWorkEffortId("_NA_")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_Test_effort() {
        return WorkEffortFlatData.newBuilder()
            .setWorkEffortId("Test_effort")
            .setWorkEffortName("Test workeffort")
            .build();
    }


    public static PartyFlatData Party_TEST_PARTY() {
        return PartyFlatData.newBuilder()
            .setPartyId("TEST_PARTY")
            .build();
    }


    public static EmplPositionTypeData EmplPositionType_TEST_EMPLOYEE() {
        return EmplPositionTypeData.newBuilder()
            .setDescription("Test employee")
            .setEmplPositionTypeId("TEST_EMPLOYEE")
            .setHasTable(castIndicator("N"))
            .build();
    }


    public static PartyRateData PartyRate_TEST_PARTY_AVERAGE_PAY_RATE_() {
        return PartyRateData.newBuilder()
            .setFromDate(getTimestamp("2013-07-04 00:00:00"))
            .setPartyId("TEST_PARTY")
            .setRateTypeId("AVERAGE_PAY_RATE")
            .build();
    }

}
