package com.bluecc.hubs.fund.model;

// with tempExprId
public interface WithSchedule {

    // Temporal expression type constants
    String DATE_RANGE = "DATE_RANGE";
    String DAY_IN_MONTH = "DAY_IN_MONTH";
    String DAY_OF_MONTH_RANGE = "DAY_OF_MONTH_RANGE";
    String DAY_OF_WEEK_RANGE = "DAY_OF_WEEK_RANGE";
    String DIFFERENCE = "DIFFERENCE";
    String FREQUENCY = "FREQUENCY";
    String HOUR_RANGE = "HOUR_RANGE";
    String INTERSECTION = "INTERSECTION";
    String MINUTE_RANGE = "MINUTE_RANGE";
    String MONTH_RANGE = "MONTH_RANGE";
    String SUBSTITUTION = "SUBSTITUTION";
    String UNION = "UNION";
    String[] EXP_TYPE_LIST = {DATE_RANGE, DAY_IN_MONTH, DAY_OF_MONTH_RANGE, DAY_OF_WEEK_RANGE,
            DIFFERENCE, FREQUENCY, HOUR_RANGE, INTERSECTION, MINUTE_RANGE, MONTH_RANGE, SUBSTITUTION, UNION};

    // Temporal expression assoc type constants
    String INCLUDE = "INCLUDE";
    String EXCLUDE = "EXCLUDE";
    String SUBSTITUTE = "SUBSTITUTE";

    String getTempExprId();

    void setTempExprId(String tempExprId);
}

