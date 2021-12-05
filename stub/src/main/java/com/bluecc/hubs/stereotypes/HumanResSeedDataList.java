package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.HumanResSeedData.*;

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

public final class HumanResSeedDataList {
    public static final List<TerminationTypeData> terminationTypeList=ImmutableList.of(        
            TerminationType_RESIGN,        
            TerminationType_FIRE,        
            TerminationType_RETIRE);

    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_INTR_RATNG_A,        
            Enumeration_INTR_RATNG_B,        
            Enumeration_INTR_RATNG_C,        
            Enumeration_INTR_RATNG_D,        
            Enumeration_JOB_POSTING_INTR,        
            Enumeration_JOB_POSTING_EXTR,        
            Enumeration_EXAM_WRITTEN_APT,        
            Enumeration_EXAM_TECHNICAL,        
            Enumeration_EXAM_GROUP_DISCN);

    public static final List<DeductionTypeData> deductionTypeList=ImmutableList.of(        
            DeductionType_FED_TAX,        
            DeductionType_STATE_TAX,        
            DeductionType_INSURANCE,        
            DeductionType_CAFE_PLAN);

    public static final List<WorkEffortTypeData> workEffortTypeList=ImmutableList.of(        
            WorkEffortType_PUBLIC_HOLIDAY);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_INTR_RATNG,        
            EnumerationType_JOB_POSTING,        
            EnumerationType_EXAM_TYPE);

    public static final List<PerfRatingTypeData> perfRatingTypeList=ImmutableList.of(        
            PerfRatingType_1,        
            PerfRatingType_2,        
            PerfRatingType_3,        
            PerfRatingType_4,        
            PerfRatingType_5);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_EMPL_POS_PLANNEDFOR,        
            StatusItem_EMPL_POS_ACTIVE,        
            StatusItem_EMPL_POS_INACTIVE,        
            StatusItem_HR_DS_COMPLETE,        
            StatusItem_HR_DS_INCOMPLETE,        
            StatusItem_HR_DS_DEFERRED,        
            StatusItem_HR_JS_FULLTIME,        
            StatusItem_HR_JS_PARTTIME,        
            StatusItem_HR_JS_CONTRACTOR,        
            StatusItem_PQV_NOT_VERIFIED,        
            StatusItem_PQV_VERIFIED,        
            StatusItem_IJP_APPROVED,        
            StatusItem_IJP_REJECTED,        
            StatusItem_STATUS_PENDING,        
            StatusItem_STATUS_RELOCATED,        
            StatusItem_TRAINING_APPLIED,        
            StatusItem_TRAINING_APPROVED,        
            StatusItem_TRAINING_ASSIGNED,        
            StatusItem_TRAINING_PROPOSED,        
            StatusItem_TRAINING_REJECTED,        
            StatusItem_LEAVE_APPROVED,        
            StatusItem_LEAVE_CREATED,        
            StatusItem_LEAVE_REJECTED);

    public static final List<BenefitTypeData> benefitTypeList=ImmutableList.of(        
            BenefitType_HEALTH,        
            BenefitType_VACATION,        
            BenefitType_SICK_LEAVE);

    public static final List<EmploymentAppSourceTypeData> employmentAppSourceTypeList=ImmutableList.of(        
            EmploymentAppSourceType_NEWS_PAPER,        
            EmploymentAppSourceType_PER_REF,        
            EmploymentAppSourceType_INTERNET,        
            EmploymentAppSourceType_ADV);

    public static final List<PerfReviewItemTypeData> perfReviewItemTypeList=ImmutableList.of(        
            PerfReviewItemType_TECH,        
            PerfReviewItemType_RESP,        
            PerfReviewItemType_ATT,        
            PerfReviewItemType_COMM,        
            PerfReviewItemType_JOBSAT);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_EMPLOYMENT_APP_STTS,        
            StatusType_EMPL_POSITION_STATUS,        
            StatusType_UNEMPL_CLAIM_STATUS,        
            StatusType_HR_DEGREE_STATUS,        
            StatusType_HR_JOB_STATUS,        
            StatusType_PARTYQUAL_VERIFY,        
            StatusType_IJP_STATUS,        
            StatusType_RELOCATION_STATUS,        
            StatusType_TRAINING_STATUS,        
            StatusType_LEAVE_STATUS);

    public static final List<EmplPositionTypeData> emplPositionTypeList=ImmutableList.of(        
            EmplPositionType_PROGRAMMER,        
            EmplPositionType_SYS_ADMIN,        
            EmplPositionType_BIZ_ANALYST,        
            EmplPositionType_CEO,        
            EmplPositionType_CFO,        
            EmplPositionType_CIO,        
            EmplPositionType_CMO,        
            EmplPositionType_CCO,        
            EmplPositionType_CSO,        
            EmplPositionType__NA_);

    public static final List<EmplLeaveTypeData> emplLeaveTypeList=ImmutableList.of(        
            EmplLeaveType_INLAND_EARNED,        
            EmplLeaveType_LOSS_OF_PAY,        
            EmplLeaveType_RESTRICTED_HOLIDAY,        
            EmplLeaveType_SPECIAL_DAY_OFF);

    public static final List<ResponsibilityTypeData> responsibilityTypeList=ImmutableList.of(        
            ResponsibilityType_FIN_MGMT,        
            ResponsibilityType_INV_MGMT,        
            ResponsibilityType_PUR_MGMT,        
            ResponsibilityType_RES_MGMT,        
            ResponsibilityType_PROD_MGMT,        
            ResponsibilityType_SALES_MGMT,        
            ResponsibilityType_GENERAL_MGMT,        
            ResponsibilityType_INFO_MGMT,        
            ResponsibilityType_MKTG_MGMT,        
            ResponsibilityType_COMPLI_MGMT,        
            ResponsibilityType_SECUR_MGMT);

    public static final List<TrainingClassTypeData> trainingClassTypeList=ImmutableList.of(        
            TrainingClassType_BASIC_TRAINING,        
            TrainingClassType_ONJOB_TRAINING,        
            TrainingClassType_ADVAN_TRAINING,        
            TrainingClassType_IMPRO_TRAINING);

    public static final List<PartyQualTypeData> partyQualTypeList=ImmutableList.of(        
            PartyQualType_DEGREE,        
            PartyQualType_CERTIFICATION,        
            PartyQualType_B_Tech,        
            PartyQualType_MBA,        
            PartyQualType_MSC,        
            PartyQualType_BSC);

    public static final List<EmplLeaveReasonTypeData> emplLeaveReasonTypeList=ImmutableList.of(        
            EmplLeaveReasonType_MEDICAL,        
            EmplLeaveReasonType_CASUAL);

    public static final List<SecurityPermissionData> securityPermissionList=ImmutableList.of(        
            SecurityPermission_EMPLOYEE_VIEW);

    public static final List<JobInterviewTypeData> jobInterviewTypeList=ImmutableList.of(        
            JobInterviewType_JOB_INTERVW,        
            JobInterviewType_EXIT_INTERVW,        
            JobInterviewType_INFORMAL_INTERVW,        
            JobInterviewType_CASE_INTERVW);

}
