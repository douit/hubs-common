package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.TerminationTypeData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.DeductionTypeData;
import com.bluecc.hubs.stub.WorkEffortTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.PerfRatingTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.BenefitTypeData;
import com.bluecc.hubs.stub.EmploymentAppSourceTypeData;
import com.bluecc.hubs.stub.PerfReviewItemTypeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.EmplPositionTypeData;
import com.bluecc.hubs.stub.EmplLeaveTypeData;
import com.bluecc.hubs.stub.ResponsibilityTypeData;
import com.bluecc.hubs.stub.TrainingClassTypeData;
import com.bluecc.hubs.stub.PartyQualTypeData;
import com.bluecc.hubs.stub.EmplLeaveReasonTypeData;
import com.bluecc.hubs.stub.SecurityPermissionData;
import com.bluecc.hubs.stub.JobInterviewTypeData;

public final class HumanResSeedData {
    public final static TerminationTypeData TerminationType_RESIGN = TerminationTypeData.newBuilder()
        .setDescription("Resignation")
        .setHasTable(castIndicator("N"))
        .setTerminationTypeId("RESIGN")
        .build();


    public final static TerminationTypeData TerminationType_FIRE = TerminationTypeData.newBuilder()
        .setDescription("Fired")
        .setHasTable(castIndicator("N"))
        .setTerminationTypeId("FIRE")
        .build();


    public final static TerminationTypeData TerminationType_RETIRE = TerminationTypeData.newBuilder()
        .setDescription("Retirement")
        .setHasTable(castIndicator("N"))
        .setTerminationTypeId("RETIRE")
        .build();


    public final static EnumerationData Enumeration_INTR_RATNG_A = EnumerationData.newBuilder()
        .setDescription("A (above 75%)")
        .setEnumCode("RATING_A")
        .setEnumId("INTR_RATNG_A")
        .setEnumTypeId("INTR_RATNG")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_INTR_RATNG_B = EnumerationData.newBuilder()
        .setDescription("B (60-75%)")
        .setEnumCode("RATING_B")
        .setEnumId("INTR_RATNG_B")
        .setEnumTypeId("INTR_RATNG")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_INTR_RATNG_C = EnumerationData.newBuilder()
        .setDescription("C (45-60%)")
        .setEnumCode("RATING_C")
        .setEnumId("INTR_RATNG_C")
        .setEnumTypeId("INTR_RATNG")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_INTR_RATNG_D = EnumerationData.newBuilder()
        .setDescription("D (below 40%)")
        .setEnumCode("RATING_D")
        .setEnumId("INTR_RATNG_D")
        .setEnumTypeId("INTR_RATNG")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_JOB_POSTING_INTR = EnumerationData.newBuilder()
        .setDescription("Internal Job Posting")
        .setEnumCode("POSTING_INTR")
        .setEnumId("JOB_POSTING_INTR")
        .setEnumTypeId("JOB_POSTING")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_JOB_POSTING_EXTR = EnumerationData.newBuilder()
        .setDescription("External Job Posting")
        .setEnumCode("POSTING_INTR")
        .setEnumId("JOB_POSTING_EXTR")
        .setEnumTypeId("JOB_POSTING")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_EXAM_WRITTEN_APT = EnumerationData.newBuilder()
        .setDescription("Written Aptitude Exam")
        .setEnumCode("WRITTEN_APT")
        .setEnumId("EXAM_WRITTEN_APT")
        .setEnumTypeId("EXAM_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_EXAM_TECHNICAL = EnumerationData.newBuilder()
        .setDescription("Technical Exam")
        .setEnumCode("TECHNICAL")
        .setEnumId("EXAM_TECHNICAL")
        .setEnumTypeId("EXAM_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_EXAM_GROUP_DISCN = EnumerationData.newBuilder()
        .setDescription("Group Discussion")
        .setEnumCode("GROUP_DISCN")
        .setEnumId("EXAM_GROUP_DISCN")
        .setEnumTypeId("EXAM_TYPE")
        .setSequenceId("03")
        .build();


    public final static DeductionTypeData DeductionType_FED_TAX = DeductionTypeData.newBuilder()
        .setDeductionTypeId("FED_TAX")
        .setDescription("Federal Tax")
        .build();


    public final static DeductionTypeData DeductionType_STATE_TAX = DeductionTypeData.newBuilder()
        .setDeductionTypeId("STATE_TAX")
        .setDescription("State Tax")
        .build();


    public final static DeductionTypeData DeductionType_INSURANCE = DeductionTypeData.newBuilder()
        .setDeductionTypeId("INSURANCE")
        .setDescription("Insurance")
        .build();


    public final static DeductionTypeData DeductionType_CAFE_PLAN = DeductionTypeData.newBuilder()
        .setDeductionTypeId("CAFE_PLAN")
        .setDescription("Cafeteria Plan")
        .build();


    public final static WorkEffortTypeData WorkEffortType_PUBLIC_HOLIDAY = WorkEffortTypeData.newBuilder()
        .setDescription("Public Holiday")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("PUBLIC_HOLIDAY")
        .build();


    public final static EnumerationTypeData EnumerationType_INTR_RATNG = EnumerationTypeData.newBuilder()
        .setDescription("Interview Rating")
        .setEnumTypeId("INTR_RATNG")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_JOB_POSTING = EnumerationTypeData.newBuilder()
        .setDescription("Job Posting Types")
        .setEnumTypeId("JOB_POSTING")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_EXAM_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Exam Type")
        .setEnumTypeId("EXAM_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static PerfRatingTypeData PerfRatingType_1 = PerfRatingTypeData.newBuilder()
        .setDescription("Fails to Meet Expectations")
        .setHasTable(castIndicator("N"))
        .setPerfRatingTypeId("1")
        .build();


    public final static PerfRatingTypeData PerfRatingType_2 = PerfRatingTypeData.newBuilder()
        .setDescription("Inconsistently Fulfills")
        .setHasTable(castIndicator("N"))
        .setPerfRatingTypeId("2")
        .build();


    public final static PerfRatingTypeData PerfRatingType_3 = PerfRatingTypeData.newBuilder()
        .setDescription("Fulfilled Expectations")
        .setHasTable(castIndicator("N"))
        .setPerfRatingTypeId("3")
        .build();


    public final static PerfRatingTypeData PerfRatingType_4 = PerfRatingTypeData.newBuilder()
        .setDescription("Frequently Exceeds")
        .setHasTable(castIndicator("N"))
        .setPerfRatingTypeId("4")
        .build();


    public final static PerfRatingTypeData PerfRatingType_5 = PerfRatingTypeData.newBuilder()
        .setDescription("Consistently Exceeds")
        .setHasTable(castIndicator("N"))
        .setPerfRatingTypeId("5")
        .build();


    public final static StatusItemData StatusItem_EMPL_POS_PLANNEDFOR = StatusItemData.newBuilder()
        .setDescription("Planned For")
        .setSequenceId("01")
        .setStatusCode("PLANNED_FOR")
        .setStatusId("EMPL_POS_PLANNEDFOR")
        .setStatusTypeId("EMPL_POSITION_STATUS")
        .build();


    public final static StatusItemData StatusItem_EMPL_POS_ACTIVE = StatusItemData.newBuilder()
        .setDescription("Active/Open")
        .setSequenceId("02")
        .setStatusCode("ACTIVE")
        .setStatusId("EMPL_POS_ACTIVE")
        .setStatusTypeId("EMPL_POSITION_STATUS")
        .build();


    public final static StatusItemData StatusItem_EMPL_POS_INACTIVE = StatusItemData.newBuilder()
        .setDescription("Inactive/Closed")
        .setSequenceId("03")
        .setStatusCode("INACTIVE")
        .setStatusId("EMPL_POS_INACTIVE")
        .setStatusTypeId("EMPL_POSITION_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_DS_COMPLETE = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("01")
        .setStatusCode("COMPLETE")
        .setStatusId("HR_DS_COMPLETE")
        .setStatusTypeId("HR_DEGREE_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_DS_INCOMPLETE = StatusItemData.newBuilder()
        .setDescription("Incomplete")
        .setSequenceId("02")
        .setStatusCode("INCOMPLETE")
        .setStatusId("HR_DS_INCOMPLETE")
        .setStatusTypeId("HR_DEGREE_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_DS_DEFERRED = StatusItemData.newBuilder()
        .setDescription("Deferred")
        .setSequenceId("03")
        .setStatusCode("DEFERRED")
        .setStatusId("HR_DS_DEFERRED")
        .setStatusTypeId("HR_DEGREE_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_JS_FULLTIME = StatusItemData.newBuilder()
        .setDescription("Full time")
        .setSequenceId("01")
        .setStatusCode("FULLTIME")
        .setStatusId("HR_JS_FULLTIME")
        .setStatusTypeId("HR_JOB_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_JS_PARTTIME = StatusItemData.newBuilder()
        .setDescription("Part time")
        .setSequenceId("02")
        .setStatusCode("PARTTIME")
        .setStatusId("HR_JS_PARTTIME")
        .setStatusTypeId("HR_JOB_STATUS")
        .build();


    public final static StatusItemData StatusItem_HR_JS_CONTRACTOR = StatusItemData.newBuilder()
        .setDescription("Contractor")
        .setSequenceId("03")
        .setStatusCode("CONTRACTOR")
        .setStatusId("HR_JS_CONTRACTOR")
        .setStatusTypeId("HR_JOB_STATUS")
        .build();


    public final static StatusItemData StatusItem_PQV_NOT_VERIFIED = StatusItemData.newBuilder()
        .setDescription("Not verified")
        .setSequenceId("01")
        .setStatusCode("NOT_VERIFIED")
        .setStatusId("PQV_NOT_VERIFIED")
        .setStatusTypeId("PARTYQUAL_VERIFY")
        .build();


    public final static StatusItemData StatusItem_PQV_VERIFIED = StatusItemData.newBuilder()
        .setDescription("Verified")
        .setSequenceId("02")
        .setStatusCode("VERIFIED")
        .setStatusId("PQV_VERIFIED")
        .setStatusTypeId("PARTYQUAL_VERIFY")
        .build();


    public final static StatusItemData StatusItem_IJP_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setStatusId("IJP_APPROVED")
        .setStatusTypeId("IJP_STATUS")
        .build();


    public final static StatusItemData StatusItem_IJP_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setStatusId("IJP_REJECTED")
        .setStatusTypeId("IJP_STATUS")
        .build();


    public final static StatusItemData StatusItem_STATUS_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setStatusId("STATUS_PENDING")
        .setStatusTypeId("RELOCATION_STATUS")
        .build();


    public final static StatusItemData StatusItem_STATUS_RELOCATED = StatusItemData.newBuilder()
        .setDescription("Relocated")
        .setStatusId("STATUS_RELOCATED")
        .setStatusTypeId("RELOCATION_STATUS")
        .build();


    public final static StatusItemData StatusItem_TRAINING_APPLIED = StatusItemData.newBuilder()
        .setDescription("Applied")
        .setStatusId("TRAINING_APPLIED")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusItemData StatusItem_TRAINING_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setStatusId("TRAINING_APPROVED")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusItemData StatusItem_TRAINING_ASSIGNED = StatusItemData.newBuilder()
        .setDescription("Assigned")
        .setStatusId("TRAINING_ASSIGNED")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusItemData StatusItem_TRAINING_PROPOSED = StatusItemData.newBuilder()
        .setDescription("Proposed")
        .setStatusId("TRAINING_PROPOSED")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusItemData StatusItem_TRAINING_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setStatusId("TRAINING_REJECTED")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusItemData StatusItem_LEAVE_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setStatusId("LEAVE_APPROVED")
        .setStatusTypeId("LEAVE_STATUS")
        .build();


    public final static StatusItemData StatusItem_LEAVE_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setStatusId("LEAVE_CREATED")
        .setStatusTypeId("LEAVE_STATUS")
        .build();


    public final static StatusItemData StatusItem_LEAVE_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setStatusId("LEAVE_REJECTED")
        .setStatusTypeId("LEAVE_STATUS")
        .build();


    public final static BenefitTypeData BenefitType_HEALTH = BenefitTypeData.newBuilder()
        .setBenefitTypeId("HEALTH")
        .setDescription("Health")
        .setHasTable(castIndicator("N"))
        .build();


    public final static BenefitTypeData BenefitType_VACATION = BenefitTypeData.newBuilder()
        .setBenefitTypeId("VACATION")
        .setDescription("Vacation")
        .setHasTable(castIndicator("N"))
        .build();


    public final static BenefitTypeData BenefitType_SICK_LEAVE = BenefitTypeData.newBuilder()
        .setBenefitTypeId("SICK_LEAVE")
        .setDescription("Sick Leave")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmploymentAppSourceTypeData EmploymentAppSourceType_NEWS_PAPER = EmploymentAppSourceTypeData.newBuilder()
        .setDescription("NewsPaper")
        .setEmploymentAppSourceTypeId("NEWS_PAPER")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmploymentAppSourceTypeData EmploymentAppSourceType_PER_REF = EmploymentAppSourceTypeData.newBuilder()
        .setDescription("PersonalReferal")
        .setEmploymentAppSourceTypeId("PER_REF")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmploymentAppSourceTypeData EmploymentAppSourceType_INTERNET = EmploymentAppSourceTypeData.newBuilder()
        .setDescription("Internet")
        .setEmploymentAppSourceTypeId("INTERNET")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmploymentAppSourceTypeData EmploymentAppSourceType_ADV = EmploymentAppSourceTypeData.newBuilder()
        .setDescription("Advertisement")
        .setEmploymentAppSourceTypeId("ADV")
        .setHasTable(castIndicator("N"))
        .build();


    public final static PerfReviewItemTypeData PerfReviewItemType_TECH = PerfReviewItemTypeData.newBuilder()
        .setDescription("Technical skills")
        .setHasTable(castIndicator("N"))
        .setPerfReviewItemTypeId("TECH")
        .build();


    public final static PerfReviewItemTypeData PerfReviewItemType_RESP = PerfReviewItemTypeData.newBuilder()
        .setDescription("Responsibility")
        .setHasTable(castIndicator("N"))
        .setPerfReviewItemTypeId("RESP")
        .build();


    public final static PerfReviewItemTypeData PerfReviewItemType_ATT = PerfReviewItemTypeData.newBuilder()
        .setDescription("Attitude")
        .setHasTable(castIndicator("N"))
        .setPerfReviewItemTypeId("ATT")
        .build();


    public final static PerfReviewItemTypeData PerfReviewItemType_COMM = PerfReviewItemTypeData.newBuilder()
        .setDescription("Communication skills")
        .setHasTable(castIndicator("N"))
        .setPerfReviewItemTypeId("COMM")
        .build();


    public final static PerfReviewItemTypeData PerfReviewItemType_JOBSAT = PerfReviewItemTypeData.newBuilder()
        .setDescription("Job Satisfaction")
        .setHasTable(castIndicator("N"))
        .setPerfReviewItemTypeId("JOBSAT")
        .build();


    public final static StatusTypeData StatusType_EMPLOYMENT_APP_STTS = StatusTypeData.newBuilder()
        .setDescription("Employment Application")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("EMPLOYMENT_APP_STTS")
        .build();


    public final static StatusTypeData StatusType_EMPL_POSITION_STATUS = StatusTypeData.newBuilder()
        .setDescription("Employee Position Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("EMPL_POSITION_STATUS")
        .build();


    public final static StatusTypeData StatusType_UNEMPL_CLAIM_STATUS = StatusTypeData.newBuilder()
        .setDescription("Unemployment Claim")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("UNEMPL_CLAIM_STATUS")
        .build();


    public final static StatusTypeData StatusType_HR_DEGREE_STATUS = StatusTypeData.newBuilder()
        .setDescription("Degree status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("HR_DEGREE_STATUS")
        .build();


    public final static StatusTypeData StatusType_HR_JOB_STATUS = StatusTypeData.newBuilder()
        .setDescription("Job status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("HR_JOB_STATUS")
        .build();


    public final static StatusTypeData StatusType_PARTYQUAL_VERIFY = StatusTypeData.newBuilder()
        .setDescription("PartyQual verification status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PARTYQUAL_VERIFY")
        .build();


    public final static StatusTypeData StatusType_IJP_STATUS = StatusTypeData.newBuilder()
        .setDescription("Internal Job Posting Status")
        .setStatusTypeId("IJP_STATUS")
        .build();


    public final static StatusTypeData StatusType_RELOCATION_STATUS = StatusTypeData.newBuilder()
        .setDescription("Relocation Status")
        .setStatusTypeId("RELOCATION_STATUS")
        .build();


    public final static StatusTypeData StatusType_TRAINING_STATUS = StatusTypeData.newBuilder()
        .setDescription("Training Status")
        .setStatusTypeId("TRAINING_STATUS")
        .build();


    public final static StatusTypeData StatusType_LEAVE_STATUS = StatusTypeData.newBuilder()
        .setDescription("Employee Leave Status")
        .setStatusTypeId("LEAVE_STATUS")
        .build();


    public final static EmplPositionTypeData EmplPositionType_PROGRAMMER = EmplPositionTypeData.newBuilder()
        .setDescription("Programmer")
        .setEmplPositionTypeId("PROGRAMMER")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_SYS_ADMIN = EmplPositionTypeData.newBuilder()
        .setDescription("System Administrator")
        .setEmplPositionTypeId("SYS_ADMIN")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_BIZ_ANALYST = EmplPositionTypeData.newBuilder()
        .setDescription("Business Analyst")
        .setEmplPositionTypeId("BIZ_ANALYST")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CEO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Executive Officer")
        .setEmplPositionTypeId("CEO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CFO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Financial Officer")
        .setEmplPositionTypeId("CFO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CIO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Information Officer")
        .setEmplPositionTypeId("CIO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CMO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Marketing Officer")
        .setEmplPositionTypeId("CMO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CCO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Compliance Officer")
        .setEmplPositionTypeId("CCO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType_CSO = EmplPositionTypeData.newBuilder()
        .setDescription("Chief Security Officer")
        .setEmplPositionTypeId("CSO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplPositionTypeData EmplPositionType__NA_ = EmplPositionTypeData.newBuilder()
        .setEmplPositionTypeId("_NA_")
        .build();


    public final static EmplLeaveTypeData EmplLeaveType_INLAND_EARNED = EmplLeaveTypeData.newBuilder()
        .setDescription("Inland Earned Leave")
        .setHasTable(castIndicator("N"))
        .setLeaveTypeId("INLAND_EARNED")
        .build();


    public final static EmplLeaveTypeData EmplLeaveType_LOSS_OF_PAY = EmplLeaveTypeData.newBuilder()
        .setDescription("Inland Loss of Pay")
        .setHasTable(castIndicator("N"))
        .setLeaveTypeId("LOSS_OF_PAY")
        .build();


    public final static EmplLeaveTypeData EmplLeaveType_RESTRICTED_HOLIDAY = EmplLeaveTypeData.newBuilder()
        .setDescription("Inland Restricted Holiday")
        .setHasTable(castIndicator("N"))
        .setLeaveTypeId("RESTRICTED_HOLIDAY")
        .build();


    public final static EmplLeaveTypeData EmplLeaveType_SPECIAL_DAY_OFF = EmplLeaveTypeData.newBuilder()
        .setDescription("Inland Special Day Off")
        .setHasTable(castIndicator("N"))
        .setLeaveTypeId("SPECIAL_DAY_OFF")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_FIN_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Finance Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("FIN_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_INV_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Inventory Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("INV_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_PUR_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Purchase Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("PUR_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_RES_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Resource Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("RES_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_PROD_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Production Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("PROD_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_SALES_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Sales Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("SALES_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_GENERAL_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("General Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("GENERAL_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_INFO_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Information Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("INFO_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_MKTG_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Marketing Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("MKTG_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_COMPLI_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Compliance Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("COMPLI_MGMT")
        .build();


    public final static ResponsibilityTypeData ResponsibilityType_SECUR_MGMT = ResponsibilityTypeData.newBuilder()
        .setDescription("Security Management")
        .setHasTable(castIndicator("N"))
        .setResponsibilityTypeId("SECUR_MGMT")
        .build();


    public final static TrainingClassTypeData TrainingClassType_BASIC_TRAINING = TrainingClassTypeData.newBuilder()
        .setDescription("Basic Training")
        .setTrainingClassTypeId("BASIC_TRAINING")
        .build();


    public final static TrainingClassTypeData TrainingClassType_ONJOB_TRAINING = TrainingClassTypeData.newBuilder()
        .setDescription("On Job Training")
        .setTrainingClassTypeId("ONJOB_TRAINING")
        .build();


    public final static TrainingClassTypeData TrainingClassType_ADVAN_TRAINING = TrainingClassTypeData.newBuilder()
        .setDescription("Advance Training")
        .setTrainingClassTypeId("ADVAN_TRAINING")
        .build();


    public final static TrainingClassTypeData TrainingClassType_IMPRO_TRAINING = TrainingClassTypeData.newBuilder()
        .setDescription("Improvement Training")
        .setTrainingClassTypeId("IMPRO_TRAINING")
        .build();


    public final static PartyQualTypeData PartyQualType_DEGREE = PartyQualTypeData.newBuilder()
        .setDescription("Degree")
        .setHasTable(castIndicator("N"))
        .setPartyQualTypeId("DEGREE")
        .build();


    public final static PartyQualTypeData PartyQualType_CERTIFICATION = PartyQualTypeData.newBuilder()
        .setDescription("Certification")
        .setHasTable(castIndicator("N"))
        .setPartyQualTypeId("CERTIFICATION")
        .build();


    public final static PartyQualTypeData PartyQualType_B_Tech = PartyQualTypeData.newBuilder()
        .setDescription("Bachelor of Technology")
        .setParentTypeId("DEGREE")
        .setPartyQualTypeId("B.Tech")
        .build();


    public final static PartyQualTypeData PartyQualType_MBA = PartyQualTypeData.newBuilder()
        .setDescription("Masters of business administration")
        .setParentTypeId("DEGREE")
        .setPartyQualTypeId("MBA")
        .build();


    public final static PartyQualTypeData PartyQualType_MSC = PartyQualTypeData.newBuilder()
        .setDescription("Masters of Science")
        .setParentTypeId("DEGREE")
        .setPartyQualTypeId("MSC")
        .build();


    public final static PartyQualTypeData PartyQualType_BSC = PartyQualTypeData.newBuilder()
        .setDescription("Bachelor of Science")
        .setParentTypeId("DEGREE")
        .setPartyQualTypeId("BSC")
        .build();


    public final static EmplLeaveReasonTypeData EmplLeaveReasonType_MEDICAL = EmplLeaveReasonTypeData.newBuilder()
        .setDescription("Medical")
        .setEmplLeaveReasonTypeId("MEDICAL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EmplLeaveReasonTypeData EmplLeaveReasonType_CASUAL = EmplLeaveReasonTypeData.newBuilder()
        .setDescription("Casual")
        .setEmplLeaveReasonTypeId("CASUAL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static SecurityPermissionData SecurityPermission_EMPLOYEE_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("Employee can check the status of his requests and trainings assigned to him with this permission.")
        .setPermissionId("EMPLOYEE_VIEW")
        .build();


    public final static JobInterviewTypeData JobInterviewType_JOB_INTERVW = JobInterviewTypeData.newBuilder()
        .setDescription("It is a process in which an employee is evaluated by an employer for prospective employment in their company")
        .setJobInterviewTypeId("JOB_INTERVW")
        .build();


    public final static JobInterviewTypeData JobInterviewType_EXIT_INTERVW = JobInterviewTypeData.newBuilder()
        .setDescription("It is conducted by an employer of a departing employee")
        .setJobInterviewTypeId("EXIT_INTERVW")
        .build();


    public final static JobInterviewTypeData JobInterviewType_INFORMAL_INTERVW = JobInterviewTypeData.newBuilder()
        .setDescription("It is a meeting in which a job seeker asks for advice rather than employment")
        .setJobInterviewTypeId("INFORMAL_INTERVW")
        .build();


    public final static JobInterviewTypeData JobInterviewType_CASE_INTERVW = JobInterviewTypeData.newBuilder()
        .setDescription("It is an interview in which the applicant is given a question/situation and asked to resolve it")
        .setJobInterviewTypeId("CASE_INTERVW")
        .build();

}
