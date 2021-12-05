package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.SurveyQuestionOptionData;
import com.bluecc.hubs.stub.SurveyMultiRespData;
import com.bluecc.hubs.stub.ProductStoreSurveyApplData;
import com.bluecc.hubs.stub.SurveyPageData;
import com.bluecc.hubs.stub.SurveyData;
import com.bluecc.hubs.stub.SurveyQuestionCategoryData;
import com.bluecc.hubs.stub.SurveyMultiRespColumnData;
import com.bluecc.hubs.stub.SurveyQuestionApplData;
import com.bluecc.hubs.stub.SurveyQuestionData;

public final class StereoDemoSurvey {
    public final static SurveyQuestionOptionData SurveyQuestionOption_1030_00001 = SurveyQuestionOptionData.newBuilder()
        .setDescription("1-2 times per year")
        .setSequenceNum(1)
        .setSurveyOptionSeqId("00001")
        .setSurveyQuestionId("1030")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1030_00002 = SurveyQuestionOptionData.newBuilder()
        .setDescription("2-5 times per year")
        .setSequenceNum(2)
        .setSurveyOptionSeqId("00002")
        .setSurveyQuestionId("1030")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1030_00003 = SurveyQuestionOptionData.newBuilder()
        .setDescription("6-10 time per year")
        .setSequenceNum(3)
        .setSurveyOptionSeqId("00003")
        .setSurveyQuestionId("1030")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1030_00004 = SurveyQuestionOptionData.newBuilder()
        .setDescription("more then 10 times per year")
        .setSequenceNum(4)
        .setSurveyOptionSeqId("00004")
        .setSurveyQuestionId("1030")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1033_00001 = SurveyQuestionOptionData.newBuilder()
        .setDescription("The Best!")
        .setSequenceNum(1)
        .setSurveyOptionSeqId("00001")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1033_00002 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Above Average")
        .setSequenceNum(2)
        .setSurveyOptionSeqId("00002")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1033_00003 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Average")
        .setSequenceNum(3)
        .setSurveyOptionSeqId("00003")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1033_00004 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Below Average")
        .setSequenceNum(4)
        .setSurveyOptionSeqId("00004")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1033_00005 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Poor")
        .setSequenceNum(5)
        .setSurveyOptionSeqId("00005")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1034_00001 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Excellent Functionality")
        .setSequenceNum(1)
        .setSurveyOptionSeqId("00001")
        .setSurveyQuestionId("1034")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1034_00002 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Good Functionality")
        .setSequenceNum(2)
        .setSurveyOptionSeqId("00002")
        .setSurveyQuestionId("1034")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1034_00003 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Poor Functionality")
        .setSequenceNum(3)
        .setSurveyOptionSeqId("00003")
        .setSurveyQuestionId("1034")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1040_00001 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Right Side")
        .setSequenceNum(1)
        .setSurveyOptionSeqId("00001")
        .setSurveyQuestionId("1040")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1040_00002 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Left Side")
        .setSequenceNum(2)
        .setSurveyOptionSeqId("00002")
        .setSurveyQuestionId("1040")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1041_00001 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Right Hand")
        .setSequenceNum(1)
        .setSurveyOptionSeqId("00001")
        .setSurveyQuestionId("1041")
        .build();

    public final static SurveyQuestionOptionData SurveyQuestionOption_1041_00002 = SurveyQuestionOptionData.newBuilder()
        .setDescription("Left Hand")
        .setSequenceNum(2)
        .setSurveyOptionSeqId("00002")
        .setSurveyQuestionId("1041")
        .build();

    public final static SurveyMultiRespData SurveyMultiResp_1002_01 = SurveyMultiRespData.newBuilder()
        .setMultiRespTitle("In the last...")
        .setSurveyId("1002")
        .setSurveyMultiRespId("01")
        .build();

    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1000 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-24 16:00:02.467"))
        .setProductCategoryId("GC-101")
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1000")
        .setSurveyApplTypeId("CART_ADD")
        .setSurveyId("1000")
        .setSurveyTemplate("component://content/template/survey/GenericSurvey.ftl")
        .build();

    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1001 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-24 16:00:51.693"))
        .setProductCategoryId("GC-102")
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1001")
        .setSurveyApplTypeId("CART_ADD")
        .setSurveyId("1001")
        .setSurveyTemplate("component://content/template/survey/GenericSurvey.ftl")
        .build();

    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1002 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-12-05 19:22:40.925"))
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1002")
        .setResultTemplate("component://ecommerce/template/survey/GenericResult.ftl")
        .setSequenceNum(1)
        .setSurveyApplTypeId("CUSTOMER_PROFILE")
        .setSurveyId("1002")
        .setSurveyTemplate("component://content/template/survey/GenericSurvey.ftl")
        .build();

    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1003 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-12-05 19:22:40.925"))
        .setGroupName("testSurveyGroup")
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1003")
        .setResultTemplate("component://ecommerce/template/survey/MiniResult.ftl")
        .setSequenceNum(1)
        .setSurveyApplTypeId("RANDOM_POLL")
        .setSurveyId("1003")
        .setSurveyTemplate("component://ecommerce/template/survey/MiniSurvey.ftl")
        .build();

    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1004 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-12-05 19:22:40.925"))
        .setGroupName("testSurveyGroup")
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1004")
        .setResultTemplate("component://ecommerce/template/survey/MiniResult.ftl")
        .setSequenceNum(1)
        .setSurveyApplTypeId("RANDOM_POLL")
        .setSurveyId("1004")
        .setSurveyTemplate("component://ecommerce/template/survey/MiniSurvey.ftl")
        .build();

    public final static SurveyPageData SurveyPage_1002_02 = SurveyPageData.newBuilder()
        .setPageName("Shopping Survey Page 2")
        .setSequenceNum(2)
        .setSurveyId("1002")
        .setSurveyPageSeqId("02")
        .build();

    public final static SurveyMultiRespColumnData SurveyMultiRespColumn_1002_01_01 = SurveyMultiRespColumnData.newBuilder()
        .setColumnTitle("Last Month")
        .setSequenceNum(1)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("01")
        .setSurveyMultiRespId("01")
        .build();

    public final static SurveyMultiRespColumnData SurveyMultiRespColumn_1002_01_02 = SurveyMultiRespColumnData.newBuilder()
        .setColumnTitle("Last Six Months")
        .setSequenceNum(2)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("02")
        .setSurveyMultiRespId("01")
        .build();

    public final static SurveyMultiRespColumnData SurveyMultiRespColumn_1002_01_03 = SurveyMultiRespColumnData.newBuilder()
        .setColumnTitle("Last Year")
        .setSequenceNum(3)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("03")
        .setSurveyMultiRespId("01")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1000_1000_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(1)
        .setSurveyId("1000")
        .setSurveyQuestionId("1000")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1000_1001_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(2)
        .setSurveyId("1000")
        .setSurveyQuestionId("1001")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1000_1002_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(3)
        .setSurveyId("1000")
        .setSurveyQuestionId("1002")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1000_1003_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1000")
        .setSurveyQuestionId("1003")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1001_1010_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(1)
        .setSurveyId("1001")
        .setSurveyQuestionId("1010")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1001_1011_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(2)
        .setSurveyId("1001")
        .setSurveyQuestionId("1011")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1037_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1002")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1037")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1030_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(2)
        .setSurveyId("1002")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1030")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1031_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(3)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("01")
        .setSurveyMultiRespId("01")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1031")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1031B_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(3)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("02")
        .setSurveyMultiRespId("01")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1031B")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1031C_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(3)
        .setSurveyId("1002")
        .setSurveyMultiRespColId("03")
        .setSurveyMultiRespId("01")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1031C")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1032_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1002")
        .setSurveyPageSeqId("01")
        .setSurveyQuestionId("1032")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1033_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1002")
        .setSurveyMultiRespId("01")
        .setSurveyPageSeqId("02")
        .setSurveyQuestionId("1033")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1034_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(6)
        .setSurveyId("1002")
        .setSurveyMultiRespId("01")
        .setSurveyPageSeqId("02")
        .setSurveyQuestionId("1034")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1038_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1002")
        .setSurveyPageSeqId("02")
        .setSurveyQuestionId("1038")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1042_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1002")
        .setSurveyPageSeqId("02")
        .setSurveyQuestionId("1042")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1035_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1002")
        .setSurveyPageSeqId("02")
        .setSurveyQuestionId("1035")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1002_1036_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1002")
        .setSurveyQuestionId("1036")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1003_1040_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(1)
        .setSurveyId("1003")
        .setSurveyQuestionId("1040")
        .build();

    public final static SurveyQuestionApplData SurveyQuestionAppl_1004_1041_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(1)
        .setSurveyId("1004")
        .setSurveyQuestionId("1041")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1010 = SurveyQuestionData.newBuilder()
        .setDescription("giftCardNumber")
        .setQuestion("Gift Card Number:")
        .setSurveyQuestionCategoryId("1000")
        .setSurveyQuestionId("1010")
        .setSurveyQuestionTypeId("GIFT_CARD")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1011 = SurveyQuestionData.newBuilder()
        .setDescription("giftCardPin")
        .setQuestion("PIN Number:")
        .setSurveyQuestionCategoryId("1000")
        .setSurveyQuestionId("1011")
        .setSurveyQuestionTypeId("TEXT_SHORT")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1030 = SurveyQuestionData.newBuilder()
        .setQuestion("How often do you shop on-line?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1030")
        .setSurveyQuestionTypeId("OPTION")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1031 = SurveyQuestionData.newBuilder()
        .setQuestion("Have you shopped here?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1031")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1031B = SurveyQuestionData.newBuilder()
        .setQuestion("Have you shopped here in the last six months?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1031B")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1031C = SurveyQuestionData.newBuilder()
        .setQuestion("Have you shopped here in the last year?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1031C")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1032 = SurveyQuestionData.newBuilder()
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1032")
        .setSurveyQuestionTypeId("SEPERATOR_LINE")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1033 = SurveyQuestionData.newBuilder()
        .setQuestion("How would you rate this store for products?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1033")
        .setSurveyQuestionTypeId("OPTION")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1034 = SurveyQuestionData.newBuilder()
        .setQuestion("How would you rate this store for on-line functionality?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1034")
        .setSurveyQuestionTypeId("OPTION")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1035 = SurveyQuestionData.newBuilder()
        .setQuestion("What is your favorite on-line store? (Enter Valid URL)")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1035")
        .setSurveyQuestionTypeId("URL")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1036 = SurveyQuestionData.newBuilder()
        .setQuestion("Comments:")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1036")
        .setSurveyQuestionTypeId("TEXTAREA")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1037 = SurveyQuestionData.newBuilder()
        .setQuestion("<img src='https://localhost:8443/images/ofbiz_logo.png'>")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1037")
        .setSurveyQuestionTypeId("SEPERATOR_TEXT")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1038 = SurveyQuestionData.newBuilder()
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1038")
        .setSurveyQuestionTypeId("SEPERATOR_LINE")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1042 = SurveyQuestionData.newBuilder()
        .setQuestion("Do you have a picture you would like to attach?")
        .setSurveyQuestionCategoryId("1001")
        .setSurveyQuestionId("1042")
        .setSurveyQuestionTypeId("CONTENT")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1040 = SurveyQuestionData.newBuilder()
        .setQuestion("Which side should the mini-poll box show?")
        .setSurveyQuestionCategoryId("1002")
        .setSurveyQuestionId("1040")
        .setSurveyQuestionTypeId("OPTION")
        .build();

    public final static SurveyQuestionData SurveyQuestion_1041 = SurveyQuestionData.newBuilder()
        .setQuestion("Which hand do you use your mouse with?")
        .setSurveyQuestionCategoryId("1002")
        .setSurveyQuestionId("1041")
        .setSurveyQuestionTypeId("OPTION")
        .build();

}
