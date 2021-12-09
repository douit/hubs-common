package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.FinAccount_SC_CHECKING.*;

import com.bluecc.hubs.stub.FinAccountStatusData;
import com.bluecc.hubs.stub.CreditCardData;
import com.bluecc.hubs.stub.FinAccountFlatData;
import com.bluecc.hubs.stub.PaymentMethodData;
import com.bluecc.hubs.stub.EftAccountData;

public final class FinAccount_SC_CHECKINGList {
    public static List<FinAccountStatusData> finAccountStatusList() {
        return ImmutableList.of(        
            FinAccountStatus_SC_CHECKING_FNACT_ACTIVE_(),        
            FinAccountStatus_ABN_CHECKING_FNACT_ACTIVE_(),        
            FinAccountStatus_AMEX_01_FNACT_ACTIVE_());
    }

    public static List<CreditCardData> creditCardList() {
        return ImmutableList.of(        
            CreditCard_AMEX_01());
    }

    public static List<FinAccountFlatData> finAccountList() {
        return ImmutableList.of(        
            FinAccount_SC_CHECKING(),        
            FinAccount_ABN_CHECKING(),        
            FinAccount_AMEX_01());
    }

    public static List<PaymentMethodData> paymentMethodList() {
        return ImmutableList.of(        
            PaymentMethod_SC_CHECKING(),        
            PaymentMethod_ABN_CHECKING(),        
            PaymentMethod_AMEX_01(),        
            PaymentMethod_PETTY_CASH());
    }

    public static List<EftAccountData> eftAccountList() {
        return ImmutableList.of(        
            EftAccount_SC_CHECKING(),        
            EftAccount_ABN_CHECKING());
    }

}
