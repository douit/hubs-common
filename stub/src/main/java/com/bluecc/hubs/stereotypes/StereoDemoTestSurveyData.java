package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ProductStoreSurveyApplData;
import com.bluecc.hubs.stub.SurveyData;
import com.bluecc.hubs.stub.SurveyQuestionCategoryData;
import com.bluecc.hubs.stub.SurveyApplTypeData;
import com.bluecc.hubs.stub.SurveyQuestionApplData;
import com.bluecc.hubs.stub.SurveyQuestionData;

public final class StereoDemoTestSurveyData {
    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1401 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1401")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1401")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1501 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1501")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1501")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1601 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1601")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1601")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1701 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1701")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1701")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1801 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1801")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1801")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1901 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1901")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("1901")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_2001 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("2001")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("2001")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_2101 = ProductStoreSurveyApplData.newBuilder()
        .setProductStoreId("9000")
        .setProductStoreSurveyId("2101")
        .setSurveyApplTypeId("TEST_SURVEY")
        .setSurveyId("2101")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static SurveyData Survey_1401 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the Checkout process.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1401")
        .setSurveyName("Checkout Survey")
        .build();


    public final static SurveyData Survey_1501 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the New Customer page.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1501")
        .setSurveyName("New Customer Survey")
        .build();


    public final static SurveyData Survey_1601 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the View Profile page.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1601")
        .setSurveyName("View Profile Survey")
        .build();


    public final static SurveyData Survey_1701 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the Manage Address screen.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1701")
        .setSurveyName("Manage Address Survey")
        .build();


    public final static SurveyData Survey_1801 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you bette.r")
        .setDescription("Please tell us your views on the Category Detail page.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1801")
        .setSurveyName("Category Detail Survey")
        .build();


    public final static SurveyData Survey_1901 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the Product Detail page.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("1901")
        .setSurveyName("Product Detail Survey")
        .build();


    public final static SurveyData Survey_2001 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the Mini Cart section.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("2001")
        .setSurveyName("Mini Cart Survey")
        .build();


    public final static SurveyData Survey_2101 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setComments("Your answers will help us serve you better.")
        .setDescription("Please tell us your views on the Show Cart functionality.")
        .setIsAnonymous(castIndicator("Y"))
        .setSubmitCaption("Complete Survey")
        .setSurveyId("2101")
        .setSurveyName("Show Cart Survey")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1401 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Checkout process questions ")
        .setSurveyQuestionCategoryId("1401")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1501 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("New Customer page questions ")
        .setSurveyQuestionCategoryId("1501")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1601 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("View Profile page questions ")
        .setSurveyQuestionCategoryId("1601")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1701 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Manage Address screen questions ")
        .setSurveyQuestionCategoryId("1701")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1801 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Category Detail page questions ")
        .setSurveyQuestionCategoryId("1801")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1901 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Product Detail page questions ")
        .setSurveyQuestionCategoryId("1901")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_2001 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Mini Cart section questions ")
        .setSurveyQuestionCategoryId("2001")
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_2101 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Show Cart functionality questions ")
        .setSurveyQuestionCategoryId("2101")
        .build();


    public final static SurveyApplTypeData SurveyApplType_TEST_SURVEY = SurveyApplTypeData.newBuilder()
        .setDescription("Used for test a survey")
        .setSurveyApplTypeId("TEST_SURVEY")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1401_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1401")
        .setSurveyQuestionId("1401")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1402_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1401")
        .setSurveyQuestionId("1402")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1403_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1401")
        .setSurveyQuestionId("1403")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1404_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1401")
        .setSurveyQuestionId("1404")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1405_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1401")
        .setSurveyQuestionId("1405")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1406_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1401")
        .setSurveyQuestionId("1406")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1407_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1401")
        .setSurveyQuestionId("1407")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1408_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1401")
        .setSurveyQuestionId("1408")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1409_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1401")
        .setSurveyQuestionId("1409")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1410_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1401")
        .setSurveyQuestionId("1410")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1411_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("1401")
        .setSurveyQuestionId("1411")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1412_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.012"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(12)
        .setSurveyId("1401")
        .setSurveyQuestionId("1412")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1413_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.013"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(13)
        .setSurveyId("1401")
        .setSurveyQuestionId("1413")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1414_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.014"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(14)
        .setSurveyId("1401")
        .setSurveyQuestionId("1414")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1415_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.015"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(15)
        .setSurveyId("1401")
        .setSurveyQuestionId("1415")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1416_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.016"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(16)
        .setSurveyId("1401")
        .setSurveyQuestionId("1416")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1417_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.017"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(17)
        .setSurveyId("1401")
        .setSurveyQuestionId("1417")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1418_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.018"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(18)
        .setSurveyId("1401")
        .setSurveyQuestionId("1418")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1419_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.019"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(19)
        .setSurveyId("1401")
        .setSurveyQuestionId("1419")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1420_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.020"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(20)
        .setSurveyId("1401")
        .setSurveyQuestionId("1420")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1421_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.021"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(21)
        .setSurveyId("1401")
        .setSurveyQuestionId("1421")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1422_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.022"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(22)
        .setSurveyId("1401")
        .setSurveyQuestionId("1422")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1423_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.023"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(23)
        .setSurveyId("1401")
        .setSurveyQuestionId("1423")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1424_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.024"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(24)
        .setSurveyId("1401")
        .setSurveyQuestionId("1424")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1425_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.025"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(25)
        .setSurveyId("1401")
        .setSurveyQuestionId("1425")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1426_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.026"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(26)
        .setSurveyId("1401")
        .setSurveyQuestionId("1426")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1427_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.027"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(27)
        .setSurveyId("1401")
        .setSurveyQuestionId("1427")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1428_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.028"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(28)
        .setSurveyId("1401")
        .setSurveyQuestionId("1428")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1401_1429_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.029"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(29)
        .setSurveyId("1401")
        .setSurveyQuestionId("1429")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1501_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1501")
        .setSurveyQuestionId("1501")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1502_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1501")
        .setSurveyQuestionId("1502")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1503_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1501")
        .setSurveyQuestionId("1503")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1504_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1501")
        .setSurveyQuestionId("1504")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1505_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1501")
        .setSurveyQuestionId("1505")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1506_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1501")
        .setSurveyQuestionId("1506")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1507_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1501")
        .setSurveyQuestionId("1507")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1508_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1501")
        .setSurveyQuestionId("1508")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1509_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1501")
        .setSurveyQuestionId("1509")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1510_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1501")
        .setSurveyQuestionId("1510")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1511_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("1501")
        .setSurveyQuestionId("1511")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1501_1512_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.012"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(12)
        .setSurveyId("1501")
        .setSurveyQuestionId("1512")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1601_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1601")
        .setSurveyQuestionId("1601")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1602_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1601")
        .setSurveyQuestionId("1602")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1603_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1601")
        .setSurveyQuestionId("1603")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1604_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1601")
        .setSurveyQuestionId("1604")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1605_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1601")
        .setSurveyQuestionId("1605")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1606_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1601")
        .setSurveyQuestionId("1606")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1607_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1601")
        .setSurveyQuestionId("1607")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1608_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1601")
        .setSurveyQuestionId("1608")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1609_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1601")
        .setSurveyQuestionId("1609")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1610_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1601")
        .setSurveyQuestionId("1610")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1611_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("1601")
        .setSurveyQuestionId("1611")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1601_1612_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.012"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(12)
        .setSurveyId("1601")
        .setSurveyQuestionId("1612")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1701_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1701")
        .setSurveyQuestionId("1701")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1702_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1701")
        .setSurveyQuestionId("1702")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1703_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1701")
        .setSurveyQuestionId("1703")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1704_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1701")
        .setSurveyQuestionId("1704")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1705_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1701")
        .setSurveyQuestionId("1705")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1706_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1701")
        .setSurveyQuestionId("1706")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1707_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1701")
        .setSurveyQuestionId("1707")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1708_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1701")
        .setSurveyQuestionId("1708")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1709_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1701")
        .setSurveyQuestionId("1709")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1710_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1701")
        .setSurveyQuestionId("1710")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1711_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("1701")
        .setSurveyQuestionId("1711")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1712_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.012"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(12)
        .setSurveyId("1701")
        .setSurveyQuestionId("1712")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1713_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.013"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(13)
        .setSurveyId("1701")
        .setSurveyQuestionId("1713")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1701_1714_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.014"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(14)
        .setSurveyId("1701")
        .setSurveyQuestionId("1714")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1801_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1801")
        .setSurveyQuestionId("1801")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1802_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1801")
        .setSurveyQuestionId("1802")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1803_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1801")
        .setSurveyQuestionId("1803")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1804_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1801")
        .setSurveyQuestionId("1804")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1805_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1801")
        .setSurveyQuestionId("1805")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1801_1806_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1801")
        .setSurveyQuestionId("1806")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1901_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("1901")
        .setSurveyQuestionId("1901")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1902_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("1901")
        .setSurveyQuestionId("1902")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1903_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("1901")
        .setSurveyQuestionId("1903")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1904_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("1901")
        .setSurveyQuestionId("1904")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1905_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("1901")
        .setSurveyQuestionId("1905")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1906_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("1901")
        .setSurveyQuestionId("1906")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1907_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("1901")
        .setSurveyQuestionId("1907")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1908_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("1901")
        .setSurveyQuestionId("1908")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1909_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("1901")
        .setSurveyQuestionId("1909")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1901_1910_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("1901")
        .setSurveyQuestionId("1910")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2001_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("2001")
        .setSurveyQuestionId("2001")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2002_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("2001")
        .setSurveyQuestionId("2002")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2003_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("2001")
        .setSurveyQuestionId("2003")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2004_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("2001")
        .setSurveyQuestionId("2004")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2005_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("2001")
        .setSurveyQuestionId("2005")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2006_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("2001")
        .setSurveyQuestionId("2006")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2007_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("2001")
        .setSurveyQuestionId("2007")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2008_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("2001")
        .setSurveyQuestionId("2008")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2009_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("2001")
        .setSurveyQuestionId("2009")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2010_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("2001")
        .setSurveyQuestionId("2010")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2001_2011_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("2001")
        .setSurveyQuestionId("2011")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2101_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.001"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(1)
        .setSurveyId("2101")
        .setSurveyQuestionId("2101")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2102_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.002"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(2)
        .setSurveyId("2101")
        .setSurveyQuestionId("2102")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2103_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.003"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(3)
        .setSurveyId("2101")
        .setSurveyQuestionId("2103")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2104_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.004"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(4)
        .setSurveyId("2101")
        .setSurveyQuestionId("2104")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2105_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.005"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(5)
        .setSurveyId("2101")
        .setSurveyQuestionId("2105")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2106_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.006"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(6)
        .setSurveyId("2101")
        .setSurveyQuestionId("2106")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2107_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.007"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(7)
        .setSurveyId("2101")
        .setSurveyQuestionId("2107")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2108_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.008"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(8)
        .setSurveyId("2101")
        .setSurveyQuestionId("2108")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2109_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.009"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(9)
        .setSurveyId("2101")
        .setSurveyQuestionId("2109")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2110_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.010"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(10)
        .setSurveyId("2101")
        .setSurveyQuestionId("2110")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2111_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.011"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(11)
        .setSurveyId("2101")
        .setSurveyQuestionId("2111")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2112_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.012"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(12)
        .setSurveyId("2101")
        .setSurveyQuestionId("2112")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2113_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.013"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(13)
        .setSurveyId("2101")
        .setSurveyQuestionId("2113")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2114_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.014"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(14)
        .setSurveyId("2101")
        .setSurveyQuestionId("2114")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2115_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.015"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(15)
        .setSurveyId("2101")
        .setSurveyQuestionId("2115")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2116_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.016"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(16)
        .setSurveyId("2101")
        .setSurveyQuestionId("2116")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_2101_2117_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.017"))
        .setRequiredField(castIndicator("N"))
        .setSequenceNum(17)
        .setSurveyId("2101")
        .setSurveyQuestionId("2117")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1401 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the checkout link in minicart if the user is anonymous then page is displayed https://localhost:8443/ecommerce/control/checkoutoptions")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1401")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1402 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the onePagecheckout link in Top navigator or minicart if the user is anonymous then page is displayed https://localhost:8443/ecommerce/control/onePageCheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1402")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1403 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the quickcheckout link in Top navigator or minicart if the user is anonymous then page is displayed https://localhost:8443/ecommerce/control/quickcheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1403")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1404 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the onePagecheckout link on the login page,if the user is anonymous it takes you to url https://localhost:8443/ecommerce/control/anonOnePageCheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1404")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1405 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the quickCheckout link on the login page,if the user is anonymous it takes you to url https://localhost:8443/ecommerce/control/quickAnonCheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1405")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1406 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the checkout link on the login page,if the user is anonymous it takes you to url https://localhost:8443/ecommerce/control/setCustomer")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1406")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1407 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the checkout link in minicart if user is Registered then it takes you to url https://localhost:8443/ecommerce/control/checkoutoptions")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1407")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1408 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the onPagecheckout link in Top navigator ro minicart if user is Registered then it takes you to url https://localhost:8443/ecommerce/control/onePageCheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1408")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1409 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on the quickCheckout link in Top navigator or minicart if user is Registered then it takes you to url https://localhost:8443/ecommerce/control/quickcheckout")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1409")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1410 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the oneCheckout page displays the panels Shopping Cart,Shipping,Shipping Options,Billing,Submit order ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1410")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1411 = SurveyQuestionData.newBuilder()
        .setQuestion("Does all the products of the cart appear on the list with accurate quantity, unit price,Item total and remove link and the quantity of product is editable ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1411")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1412 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on changing the quantity of product the item total, cart sub total and grand total also changed ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1412")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1413 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking the remove link the product is removed from the shopping cart and also from the product list on UI?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1413")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1414 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on entering the promotion code it is applied to all the products and if it is not valid then does it displays error message ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1414")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1415 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking the 'continue to step 2' button the Edit panel disappears and the Cart summary page appears ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1415")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1416 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on summary panel 'click here to edit' link is appear and it disappear when panel is in edit form ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1416")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1417 = SurveyQuestionData.newBuilder()
        .setQuestion("Does all the fields in the shipping panel have their values already filled in editable form if user is logged in and only email address is non editable?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1417")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1418 = SurveyQuestionData.newBuilder()
        .setQuestion("If user is anonymous then all the fields of shipping panel are blank and editable ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1418")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1419 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Continue to next step button visible on the panel?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1419")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1420 = SurveyQuestionData.newBuilder()
        .setQuestion("If you leave mandatory fields blank then message displayed of required ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1420")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1421 = SurveyQuestionData.newBuilder()
        .setQuestion("Does state drop down is showing state list of selected country if that country have states ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1421")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1422 = SurveyQuestionData.newBuilder()
        .setQuestion("Does state drop down disappeares when selected country does not have state list ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1422")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1423 = SurveyQuestionData.newBuilder()
        .setQuestion("Does click here to edit link is appeared when summary of every panel is shown ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1423")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1424 = SurveyQuestionData.newBuilder()
        .setQuestion("Does shipping methods are appearing into drop down with respective price ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1424")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1425 = SurveyQuestionData.newBuilder()
        .setQuestion("Does first name and last name fields are taking any inputs other than alphabets ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1425")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1426 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on checking the option Billing address same as shipping,all the values of shipping address copied to the billing address fields. And the Billing address fields gets disappeared And billing address is created same as shipping address ?  ")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1426")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1427 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on unchecking the checkbox Billing address same as shipping,the billing address fields are appeared to the user and the billing address created separately?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1427")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1428 = SurveyQuestionData.newBuilder()
        .setQuestion("On clicking submit order Does it shows message of 'Please Wait Processing Order' ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1428")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1429 = SurveyQuestionData.newBuilder()
        .setQuestion("On submission of order successfully Does you are redirected to Order Detail page ?")
        .setSurveyQuestionCategoryId("1401")
        .setSurveyQuestionId("1429")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1501 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on Create on Login page redirects you to following url https://localhost:8443/ecommerce/control/newcustomer")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1501")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1502 = SurveyQuestionData.newBuilder()
        .setQuestion("Does all the UiLabels are showing proper ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1502")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1503 = SurveyQuestionData.newBuilder()
        .setQuestion("On leaving * fields blank Does they showing message of 'Required' ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1503")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1504 = SurveyQuestionData.newBuilder()
        .setQuestion("On submitting blank form, Are you able to submit it ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1504")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1505 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the First name and Last name taking character other than Alphabet ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1505")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1506 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the username field taking any character other than email address ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1506")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1507 = SurveyQuestionData.newBuilder()
        .setQuestion("Is password and confirm password taking same inputs ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1507")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1508 = SurveyQuestionData.newBuilder()
        .setQuestion("Is country drop down showing only limited country ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1508")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1509 = SurveyQuestionData.newBuilder()
        .setQuestion("Is state drop down is showing only the state list of selected country if country have states ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1509")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1510 = SurveyQuestionData.newBuilder()
        .setQuestion("Is state drop down is disappear when a country has no state ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1510")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1511 = SurveyQuestionData.newBuilder()
        .setQuestion("Is use shipping address for billing address checkbox is working and copies data from fields ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1511")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1512 = SurveyQuestionData.newBuilder()
        .setQuestion("If user is creates account successfully then he is able to login by his user Id ?")
        .setSurveyQuestionCategoryId("1501")
        .setSurveyQuestionId("1512")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1601 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on Profile link it takes to https://localhost:8443/ecommerce/control/viewprofile page in case the user is logged in ?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1601")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1602 = SurveyQuestionData.newBuilder()
        .setQuestion("Does My Accounts section displays the name and email of the user corectly as entered?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1602")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1603 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the EDIT link redirects to the page https://localhost:8443/ecommerce/control/editProfile")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1603")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1604 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Billing and shipping address of user displayed correctly?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1604")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1605 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Manage Address link redirects user to manage addresses page https://localhost:8443/ecommerce/control/manageAddress?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1605")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1606 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Quick add takes to the page https://localhost:8443/ecommerce/control/quickadd")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1606")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1607 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the 'Order History' redirects to order detail page. https://localhost:8443/ecommerce/control/orderhistory")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1607")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1608 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Shopping List link redirects to page https://localhost:8443/ecommerce/control/editShoppingList")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1608")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1609 = SurveyQuestionData.newBuilder()
        .setQuestion("Does List quotes link redirects to page https://localhost:8443/ecommerce/control/ListQuotes")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1609")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1610 = SurveyQuestionData.newBuilder()
        .setQuestion("Does List Requests link redirects to page https://localhost:8443/ecommerce/control/ListRequests")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1610")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1611 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on changing the email address the username changed ?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1611")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1612 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the form gets submitted successfully if all the fields are validated properly?")
        .setSurveyQuestionCategoryId("1601")
        .setSurveyQuestionId("1612")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1701 = SurveyQuestionData.newBuilder()
        .setQuestion("Does clicking on MANAGE ADDRESS redirects you to following https://localhost:8443/ecommerce/control/manageAddress")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1701")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1702 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays the three sections namely : Default address which have Billing and Shipping Addresses and Additional Addresses ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1702")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1703 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it diplays the Add New Address link and on click it opens a popup form for making new address ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1703")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1704 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Billing Address displays the correct Billing Address as entered by the user?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1704")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1705 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking the Change Billing Address link opens a pop up form for editing billing address ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1705")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1706 = SurveyQuestionData.newBuilder()
        .setQuestion("If the checkbox in Billing Address section is checked then it creates a shipping address same as billing address and expires the previous shipping address and vice-versa ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1706")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1707 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Additional Addresses section diplays the addresses associated with the Login user without any purpose,if any available ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1707")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1708 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking the Edit Address link opens a pop up for editing address ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1708")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1709 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on checking the option 'Make this My default Shipping address' sets the address as Default Shipping Address and vice-versa?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1709")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1710 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the form gets submitted successfully if it passes all the validations successfuly?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1710")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1711 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the delete address button works properly,on clicking removes the address from the page?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1711")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1712 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking the Add Address link opens a pop up for adding new address ?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1712")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1713 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking cancel button will the form gets disappear?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1713")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1714 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the updated address displayed correctly on manage address form?")
        .setSurveyQuestionCategoryId("1701")
        .setSurveyQuestionId("1714")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1801 = SurveyQuestionData.newBuilder()
        .setQuestion("Are breadcrumbs visible on the page and on clicking them, Are they working proper and takes you to clicked page ?")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1801")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1802 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the mincart visible and does it displays all the details it contains?")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1802")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1803 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the page contains the quantity and Add to cart option that on Clicking adds the Product to the Shopping cart?")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1803")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1804 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it contains the Search in Category options that takes to the Advance Search page https://localhost:8443/ecommerce/control/advancedsearch")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1804")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1805 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the page display the different product list with their names and images if available ?")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1805")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1806 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking onto the product image this redirects you to that specified product detail page ?")
        .setSurveyQuestionCategoryId("1801")
        .setSurveyQuestionId("1806")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1901 = SurveyQuestionData.newBuilder()
        .setQuestion("Are the breadcrumbs visible on the page and on clicking them, are they working proper and takes you to clicked page ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1901")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1902 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the Minicart visible and are all the links in Minicart are working properly ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1902")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1903 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it contains a Quantity text box and Add to Cart link that adds the Product into the Shopping Cart?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1903")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1904 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays all the details of the Product and feature options if the product is configurable ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1904")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1905 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Previous and next navigate properly to target pages ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1905")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1906 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the quantity is editable if required features are selected ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1906")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1907 = SurveyQuestionData.newBuilder()
        .setQuestion("Are you able to add the product into the cart without selecting any feature ?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1907")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1908 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays the links Tell a friend that takes to the respective target page?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1908")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1909 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays the message with link Login You Must Login  To Add Selected Items To Shopping List if the user is not logged in.")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1909")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1910 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Review the Product First link working and takes to the page https://localhost:8443/ecommerce/control/reviewProduct?")
        .setSurveyQuestionCategoryId("1901")
        .setSurveyQuestionId("1910")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2001 = SurveyQuestionData.newBuilder()
        .setQuestion("Is the minicart displayed on the all the pages except profile and checkout page ?")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2001")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2002 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays the View Cart,Checkout,onePageCheckOut,quickCheckoutlink on the mini Cart")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2002")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2003 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the checkout link in case the user is anonymous takes to login page and one clicking again to checkout link takes to https://localhost:8443/ecommerce/control/setCustomer")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2003")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2004 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the checkout link in case the user is anonymous takes to login page and one clicking again to quickCheckout link takes to https://localhost:8443/ecommerce/control/quickAnonCheckout")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2004")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2005 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the checkout link in case the user is anonymous takes to login page and one clicking again to onePageCheckout link takes to https://localhost:8443/ecommerce/control/anonOnePageCheckout")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2005")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2006 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the checkout link in case the user is registered,takes to https://localhost:8443/ecommerce/control/checkoutoptions")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2006")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2007 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the quickCheckout link in case the user is registered,takes to https://localhost:8443/ecommerce/control/quickcheckout")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2007")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2008 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking to the quickCheckout link in case the user is registered,takes to https://localhost:8443/ecommerce/control/onePageCheckout")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2008")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2009 = SurveyQuestionData.newBuilder()
        .setQuestion("Does on clicking ViewCart link will redirect to the show cart page at this url https://localhost:8443/ecommerce/control/view/showcart")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2009")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2010 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the mini cart displays the Quantity,Product and its price and total details correctly ?")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2010")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2011 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Format of amount on mini cart have currency format like $00.00 ?")
        .setSurveyQuestionCategoryId("2001")
        .setSurveyQuestionId("2011")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2101 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Cart link on click takes to the https://localhost:8443/ecommerce/control/view/showcart?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2101")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2102 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it diplays the panels Quick add,shopping cart,promotion coupon code,Special offers,you might interested in,Promotion information on the ViewCart Page")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2102")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2103 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Cart displays the all the cart details ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2103")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2104 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the cart displays the images of the products it has or not and does those product images on clicking takes to the target page ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2104")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2105 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the product link displayed under SKU takes you to the specified product detail page ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2105")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2106 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the delete link is displayed and removes successfully the corresponding item from the cart ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2106")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2107 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the Promotion code text box is displayed and it applies the code successfully ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2107")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2108 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the subtotal,Discount, shipping, and total displayed on the page?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2108")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2109 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it shows the message To save cart you must Login in case if not logged in?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2109")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2110 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it displays the Update,Continue shopping and checkout link ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2110")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2111 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it on clicking the Continue shopping takes to last product detail page ?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2111")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2112 = SurveyQuestionData.newBuilder()
        .setQuestion("Does it on clicking the Details link on Special offers panel takes to https://localhost:8443/ecommerce/control/showPromotionDetails")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2112")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2113 = SurveyQuestionData.newBuilder()
        .setQuestion("Does the shopping cart display the links create request for Quote and create new Quote from cart?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2113")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2114 = SurveyQuestionData.newBuilder()
        .setQuestion("Does You might interested in link contain Add to cart link that adds the product to the shopping cart")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2114")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2115 = SurveyQuestionData.newBuilder()
        .setQuestion("Does You might interested in link contain Product link that https://localhost:8443/ecommerce/control/product")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2115")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2116 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Shopping cart contains the Recalculate Cart,Empty Cart,Remove Selected and Checkout link on the title Bar that takes to their respaective target page?")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2116")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionData SurveyQuestion_2117 = SurveyQuestionData.newBuilder()
        .setQuestion("Does Quick Add panel containing the Add to cart linnk adds the product to the shopping cart successfully on entering the ProductId")
        .setSurveyQuestionCategoryId("2101")
        .setSurveyQuestionId("2117")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();

}
