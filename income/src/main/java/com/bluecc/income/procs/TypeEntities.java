package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.JsonString;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.exchange.GsonConverters;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.ProducesJson;
import com.linecorp.armeria.server.annotation.ResponseConverter;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class TypeEntities {
    @Inject
    FactBag factBag;

    /**
     * GET http://localhost:4940/types/ShoppingListType
     * @param name type entity name
     * @return type list string with json format
     */
    @Get("/types/:name")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public JsonString queryTypes(@Param String name) {
        String result;
        switch (name){
            
            case "ContentAssocType":
                result= quoteList(factBag.allTypes("ContentAssocType", ContentAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CreditCardTypeGlAccount":
                result= quoteList(factBag.allTypes("CreditCardTypeGlAccount", CreditCardTypeGlAccountData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CostComponentCalc":
                result= quoteList(factBag.allTypes("CostComponentCalc", CostComponentCalcData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PaymentGroupType":
                result= quoteList(factBag.allTypes("PaymentGroupType", PaymentGroupTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FileExtension":
                result= quoteList(factBag.allTypes("FileExtension", FileExtensionData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkEffortContentType":
                result= quoteList(factBag.allTypes("WorkEffortContentType", WorkEffortContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GeoAssoc":
                result= quoteList(factBag.allTypes("GeoAssoc", GeoAssocData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductPricePurpose":
                result= quoteList(factBag.allTypes("ProductPricePurpose", ProductPricePurposeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContactMechType":
                result= quoteList(factBag.allTypes("ContactMechType", ContactMechTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SurveyQuestionType":
                result= quoteList(factBag.allTypes("SurveyQuestionType", SurveyQuestionTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContentOperation":
                result= quoteList(factBag.allTypes("ContentOperation", ContentOperationData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "OrderDenylistType":
                result= quoteList(factBag.allTypes("OrderDenylistType", OrderDenylistTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnAdjustmentType":
                result= quoteList(factBag.allTypes("ReturnAdjustmentType", ReturnAdjustmentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductType":
                result= quoteList(factBag.allTypes("ProductType", ProductTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnType":
                result= quoteList(factBag.allTypes("ReturnType", ReturnTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TaxAuthorityAssocType":
                result= quoteList(factBag.allTypes("TaxAuthorityAssocType", TaxAuthorityAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DataSource":
                result= quoteList(factBag.allTypes("DataSource", DataSourceData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductStoreGroup":
                result= quoteList(factBag.allTypes("ProductStoreGroup", ProductStoreGroupData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShoppingListType":
                result= quoteList(factBag.allTypes("ShoppingListType", ShoppingListTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ResponsibilityType":
                result= quoteList(factBag.allTypes("ResponsibilityType", ResponsibilityTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountCategory":
                result= quoteList(factBag.allTypes("GlAccountCategory", GlAccountCategoryData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EntityGroup":
                result= quoteList(factBag.allTypes("EntityGroup", EntityGroupData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DeductionType":
                result= quoteList(factBag.allTypes("DeductionType", DeductionTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "MrpEventType":
                result= quoteList(factBag.allTypes("MrpEventType", MrpEventTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContentPurposeType":
                result= quoteList(factBag.allTypes("ContentPurposeType", ContentPurposeTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FixedAssetStdCostType":
                result= quoteList(factBag.allTypes("FixedAssetStdCostType", FixedAssetStdCostTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductPriceType":
                result= quoteList(factBag.allTypes("ProductPriceType", ProductPriceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContactMechPurposeType":
                result= quoteList(factBag.allTypes("ContactMechPurposeType", ContactMechPurposeTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "Enumeration":
                result= quoteList(factBag.allTypes("Enumeration", EnumerationData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "OrderItemType":
                result= quoteList(factBag.allTypes("OrderItemType", OrderItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnHeaderType":
                result= quoteList(factBag.allTypes("ReturnHeaderType", ReturnHeaderTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkEffortAssocType":
                result= quoteList(factBag.allTypes("WorkEffortAssocType", WorkEffortAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GeoType":
                result= quoteList(factBag.allTypes("GeoType", GeoTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EmplLeaveReasonType":
                result= quoteList(factBag.allTypes("EmplLeaveReasonType", EmplLeaveReasonTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductAverageCostType":
                result= quoteList(factBag.allTypes("ProductAverageCostType", ProductAverageCostTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductMaintType":
                result= quoteList(factBag.allTypes("ProductMaintType", ProductMaintTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TermType":
                result= quoteList(factBag.allTypes("TermType", TermTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WebSiteContentType":
                result= quoteList(factBag.allTypes("WebSiteContentType", WebSiteContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountType":
                result= quoteList(factBag.allTypes("GlAccountType", GlAccountTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "UserPrefGroupType":
                result= quoteList(factBag.allTypes("UserPrefGroupType", UserPrefGroupTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FacilityAssocType":
                result= quoteList(factBag.allTypes("FacilityAssocType", FacilityAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountCategoryType":
                result= quoteList(factBag.allTypes("GlAccountCategoryType", GlAccountCategoryTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "VarianceReasonGlAccount":
                result= quoteList(factBag.allTypes("VarianceReasonGlAccount", VarianceReasonGlAccountData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContentAssocPredicate":
                result= quoteList(factBag.allTypes("ContentAssocPredicate", ContentAssocPredicateData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkEffortPurposeType":
                result= quoteList(factBag.allTypes("WorkEffortPurposeType", WorkEffortPurposeTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PaymentMethodType":
                result= quoteList(factBag.allTypes("PaymentMethodType", PaymentMethodTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlResourceType":
                result= quoteList(factBag.allTypes("GlResourceType", GlResourceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FacilityGroup":
                result= quoteList(factBag.allTypes("FacilityGroup", FacilityGroupData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FinAccountTransType":
                result= quoteList(factBag.allTypes("FinAccountTransType", FinAccountTransTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductFeatureType":
                result= quoteList(factBag.allTypes("ProductFeatureType", ProductFeatureTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EntityGroupEntry":
                result= quoteList(factBag.allTypes("EntityGroupEntry", EntityGroupEntryData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProdConfItemContentType":
                result= quoteList(factBag.allTypes("ProdConfItemContentType", ProdConfItemContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SupplierPrefOrder":
                result= quoteList(factBag.allTypes("SupplierPrefOrder", SupplierPrefOrderData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "RejectionReason":
                result= quoteList(factBag.allTypes("RejectionReason", RejectionReasonData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AllocationPlanType":
                result= quoteList(factBag.allTypes("AllocationPlanType", AllocationPlanTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductCategoryType":
                result= quoteList(factBag.allTypes("ProductCategoryType", ProductCategoryTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CountryCapital":
                result= quoteList(factBag.allTypes("CountryCapital", CountryCapitalData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CommunicationEventType":
                result= quoteList(factBag.allTypes("CommunicationEventType", CommunicationEventTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountGroup":
                result= quoteList(factBag.allTypes("GlAccountGroup", GlAccountGroupData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "OrderAdjustmentType":
                result= quoteList(factBag.allTypes("OrderAdjustmentType", OrderAdjustmentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "QuoteType":
                result= quoteList(factBag.allTypes("QuoteType", QuoteTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DataResourceType":
                result= quoteList(factBag.allTypes("DataResourceType", DataResourceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FixedAssetProductType":
                result= quoteList(factBag.allTypes("FixedAssetProductType", FixedAssetProductTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AgreementItemType":
                result= quoteList(factBag.allTypes("AgreementItemType", AgreementItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AcctgTransType":
                result= quoteList(factBag.allTypes("AcctgTransType", AcctgTransTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InvoiceItemAssocType":
                result= quoteList(factBag.allTypes("InvoiceItemAssocType", InvoiceItemAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "MetaDataPredicate":
                result= quoteList(factBag.allTypes("MetaDataPredicate", MetaDataPredicateData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PerfRatingType":
                result= quoteList(factBag.allTypes("PerfRatingType", PerfRatingTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "UomType":
                result= quoteList(factBag.allTypes("UomType", UomTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "StatusValidChange":
                result= quoteList(factBag.allTypes("StatusValidChange", StatusValidChangeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "QuantityBreakType":
                result= quoteList(factBag.allTypes("QuantityBreakType", QuantityBreakTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EmploymentAppSourceType":
                result= quoteList(factBag.allTypes("EmploymentAppSourceType", EmploymentAppSourceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkEffortGoodStandardType":
                result= quoteList(factBag.allTypes("WorkEffortGoodStandardType", WorkEffortGoodStandardTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayDhl":
                result= quoteList(factBag.allTypes("ShipmentGatewayDhl", ShipmentGatewayDhlData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TerminationType":
                result= quoteList(factBag.allTypes("TerminationType", TerminationTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlJournal":
                result= quoteList(factBag.allTypes("GlJournal", GlJournalData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PartyRelationshipType":
                result= quoteList(factBag.allTypes("PartyRelationshipType", PartyRelationshipTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EnumerationType":
                result= quoteList(factBag.allTypes("EnumerationType", EnumerationTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DocumentType":
                result= quoteList(factBag.allTypes("DocumentType", DocumentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "VarianceReason":
                result= quoteList(factBag.allTypes("VarianceReason", VarianceReasonData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GeoAssocType":
                result= quoteList(factBag.allTypes("GeoAssocType", GeoAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "BenefitType":
                result= quoteList(factBag.allTypes("BenefitType", BenefitTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "Uom":
                result= quoteList(factBag.allTypes("Uom", UomData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CostComponentType":
                result= quoteList(factBag.allTypes("CostComponentType", CostComponentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "JobInterviewType":
                result= quoteList(factBag.allTypes("JobInterviewType", JobInterviewTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PeriodType":
                result= quoteList(factBag.allTypes("PeriodType", PeriodTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DataCategory":
                result= quoteList(factBag.allTypes("DataCategory", DataCategoryData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContentType":
                result= quoteList(factBag.allTypes("ContentType", ContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "RoleType":
                result= quoteList(factBag.allTypes("RoleType", RoleTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayConfigType":
                result= quoteList(factBag.allTypes("ShipmentGatewayConfigType", ShipmentGatewayConfigTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentContactMechType":
                result= quoteList(factBag.allTypes("ShipmentContactMechType", ShipmentContactMechTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CustRequestResolution":
                result= quoteList(factBag.allTypes("CustRequestResolution", CustRequestResolutionData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "BudgetItemType":
                result= quoteList(factBag.allTypes("BudgetItemType", BudgetItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SubscriptionType":
                result= quoteList(factBag.allTypes("SubscriptionType", SubscriptionTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AgreementContentType":
                result= quoteList(factBag.allTypes("AgreementContentType", AgreementContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SegmentGroupType":
                result= quoteList(factBag.allTypes("SegmentGroupType", SegmentGroupTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DataSourceType":
                result= quoteList(factBag.allTypes("DataSourceType", DataSourceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "DataTemplateType":
                result= quoteList(factBag.allTypes("DataTemplateType", DataTemplateTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "UserPreference":
                result= quoteList(factBag.allTypes("UserPreference", UserPreferenceData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayFedex":
                result= quoteList(factBag.allTypes("ShipmentGatewayFedex", ShipmentGatewayFedexData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SkillType":
                result= quoteList(factBag.allTypes("SkillType", SkillTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "Geo":
                result= quoteList(factBag.allTypes("Geo", GeoData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContactMechTypePurpose":
                result= quoteList(factBag.allTypes("ContactMechTypePurpose", ContactMechTypePurposeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TrackingCodeType":
                result= quoteList(factBag.allTypes("TrackingCodeType", TrackingCodeTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnReason":
                result= quoteList(factBag.allTypes("ReturnReason", ReturnReasonData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FixedAssetType":
                result= quoteList(factBag.allTypes("FixedAssetType", FixedAssetTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContentPurposeOperation":
                result= quoteList(factBag.allTypes("ContentPurposeOperation", ContentPurposeOperationData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProdCatalogCategoryType":
                result= quoteList(factBag.allTypes("ProdCatalogCategoryType", ProdCatalogCategoryTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayUsps":
                result= quoteList(factBag.allTypes("ShipmentGatewayUsps", ShipmentGatewayUspsData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductMeterType":
                result= quoteList(factBag.allTypes("ProductMeterType", ProductMeterTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlFiscalType":
                result= quoteList(factBag.allTypes("GlFiscalType", GlFiscalTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "MimeType":
                result= quoteList(factBag.allTypes("MimeType", MimeTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductCategoryContentType":
                result= quoteList(factBag.allTypes("ProductCategoryContentType", ProductCategoryContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "EmplLeaveType":
                result= quoteList(factBag.allTypes("EmplLeaveType", EmplLeaveTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CustomTimePeriod":
                result= quoteList(factBag.allTypes("CustomTimePeriod", CustomTimePeriodData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CharacterSet":
                result= quoteList(factBag.allTypes("CharacterSet", CharacterSetData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "RateType":
                result= quoteList(factBag.allTypes("RateType", RateTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TrainingClassType":
                result= quoteList(factBag.allTypes("TrainingClassType", TrainingClassTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SecurityPermission":
                result= quoteList(factBag.allTypes("SecurityPermission", SecurityPermissionData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "VisualThemeSet":
                result= quoteList(factBag.allTypes("VisualThemeSet", VisualThemeSetData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "StandardLanguage":
                result= quoteList(factBag.allTypes("StandardLanguage", StandardLanguageData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CountryTeleCode":
                result= quoteList(factBag.allTypes("CountryTeleCode", CountryTeleCodeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductAssocType":
                result= quoteList(factBag.allTypes("ProductAssocType", ProductAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FinAccountTypeGlAccount":
                result= quoteList(factBag.allTypes("FinAccountTypeGlAccount", FinAccountTypeGlAccountData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlXbrlClass":
                result= quoteList(factBag.allTypes("GlXbrlClass", GlXbrlClassData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PaymentGatewayConfigType":
                result= quoteList(factBag.allTypes("PaymentGatewayConfigType", PaymentGatewayConfigTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FacilityType":
                result= quoteList(factBag.allTypes("FacilityType", FacilityTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InventoryItemType":
                result= quoteList(factBag.allTypes("InventoryItemType", InventoryItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayConfig":
                result= quoteList(factBag.allTypes("ShipmentGatewayConfig", ShipmentGatewayConfigData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ServerHitType":
                result= quoteList(factBag.allTypes("ServerHitType", ServerHitTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "BudgetType":
                result= quoteList(factBag.allTypes("BudgetType", BudgetTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InvoiceItemTypeMap":
                result= quoteList(factBag.allTypes("InvoiceItemTypeMap", InvoiceItemTypeMapData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WebAnalyticsType":
                result= quoteList(factBag.allTypes("WebAnalyticsType", WebAnalyticsTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkReqFulfType":
                result= quoteList(factBag.allTypes("WorkReqFulfType", WorkReqFulfTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlReconciliation":
                result= quoteList(factBag.allTypes("GlReconciliation", GlReconciliationData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentType":
                result= quoteList(factBag.allTypes("ShipmentType", ShipmentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "OrderType":
                result= quoteList(factBag.allTypes("OrderType", OrderTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PartyClassificationType":
                result= quoteList(factBag.allTypes("PartyClassificationType", PartyClassificationTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnItemTypeMap":
                result= quoteList(factBag.allTypes("ReturnItemTypeMap", ReturnItemTypeMapData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductFeatureApplType":
                result= quoteList(factBag.allTypes("ProductFeatureApplType", ProductFeatureApplTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ContactListType":
                result= quoteList(factBag.allTypes("ContactListType", ContactListTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountCategoryMember":
                result= quoteList(factBag.allTypes("GlAccountCategoryMember", GlAccountCategoryMemberData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InvoiceItemType":
                result= quoteList(factBag.allTypes("InvoiceItemType", InvoiceItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductPriceActionType":
                result= quoteList(factBag.allTypes("ProductPriceActionType", ProductPriceActionTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CountryAddressFormat":
                result= quoteList(factBag.allTypes("CountryAddressFormat", CountryAddressFormatData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PartyContentType":
                result= quoteList(factBag.allTypes("PartyContentType", PartyContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GoodIdentificationType":
                result= quoteList(factBag.allTypes("GoodIdentificationType", GoodIdentificationTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CommunicationEventPrpTyp":
                result= quoteList(factBag.allTypes("CommunicationEventPrpTyp", CommunicationEventPrpTypData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ShipmentGatewayUps":
                result= quoteList(factBag.allTypes("ShipmentGatewayUps", ShipmentGatewayUpsData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountGroupType":
                result= quoteList(factBag.allTypes("GlAccountGroupType", GlAccountGroupTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TelecomMethodType":
                result= quoteList(factBag.allTypes("TelecomMethodType", TelecomMethodTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "RequirementType":
                result= quoteList(factBag.allTypes("RequirementType", RequirementTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CustomMethodType":
                result= quoteList(factBag.allTypes("CustomMethodType", CustomMethodTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ReturnItemType":
                result= quoteList(factBag.allTypes("ReturnItemType", ReturnItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AgreementType":
                result= quoteList(factBag.allTypes("AgreementType", AgreementTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "OrderItemAssocType":
                result= quoteList(factBag.allTypes("OrderItemAssocType", OrderItemAssocTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FacilityGroupType":
                result= quoteList(factBag.allTypes("FacilityGroupType", FacilityGroupTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductFeatureIactnType":
                result= quoteList(factBag.allTypes("ProductFeatureIactnType", ProductFeatureIactnTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "WorkEffortType":
                result= quoteList(factBag.allTypes("WorkEffortType", WorkEffortTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "StatusItem":
                result= quoteList(factBag.allTypes("StatusItem", StatusItemData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PaymentType":
                result= quoteList(factBag.allTypes("PaymentType", PaymentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CountryCode":
                result= quoteList(factBag.allTypes("CountryCode", CountryCodeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PartyQualType":
                result= quoteList(factBag.allTypes("PartyQualType", PartyQualTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PartyType":
                result= quoteList(factBag.allTypes("PartyType", PartyTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "MimeTypeHtmlTemplate":
                result= quoteList(factBag.allTypes("MimeTypeHtmlTemplate", MimeTypeHtmlTemplateData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FinAccountType":
                result= quoteList(factBag.allTypes("FinAccountType", FinAccountTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InvoiceContentType":
                result= quoteList(factBag.allTypes("InvoiceContentType", InvoiceContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountClass":
                result= quoteList(factBag.allTypes("GlAccountClass", GlAccountClassData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "BudgetReviewResultType":
                result= quoteList(factBag.allTypes("BudgetReviewResultType", BudgetReviewResultTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "GlAccountOrganization":
                result= quoteList(factBag.allTypes("GlAccountOrganization", GlAccountOrganizationData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "TaxAuthorityRateType":
                result= quoteList(factBag.allTypes("TaxAuthorityRateType", TaxAuthorityRateTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "UomConversion":
                result= quoteList(factBag.allTypes("UomConversion", UomConversionData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "ProductContentType":
                result= quoteList(factBag.allTypes("ProductContentType", ProductContentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "InvoiceType":
                result= quoteList(factBag.allTypes("InvoiceType", InvoiceTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "PerfReviewItemType":
                result= quoteList(factBag.allTypes("PerfReviewItemType", PerfReviewItemTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "StatusType":
                result= quoteList(factBag.allTypes("StatusType", StatusTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "FixedAssetIdentType":
                result= quoteList(factBag.allTypes("FixedAssetIdentType", FixedAssetIdentTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "AcctgTransEntryType":
                result= quoteList(factBag.allTypes("AcctgTransEntryType", AcctgTransEntryTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "CustomScreenType":
                result= quoteList(factBag.allTypes("CustomScreenType", CustomScreenTypeData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            case "SettlementTerm":
                result= quoteList(factBag.allTypes("SettlementTerm", SettlementTermData::parseFrom)
                        .stream().map(e -> ProtoJsonUtils.toJson(e))
                        .collect(Collectors.joining(",")));
                break;
            
            default:
                result="[]";
                break;
        }

        return new JsonString(result);
    }

    static String quoteList(String jsonLines){
        return String.format("[%s]", jsonLines);
    }
}
