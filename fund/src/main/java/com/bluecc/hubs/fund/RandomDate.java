package com.bluecc.hubs.fund;

import org.joda.time.DateTime;

import java.util.Random;

public class RandomDate {
    Long logDateTime = 0L;//
    int maxTimeStep = 0;

    public RandomDate(DateTime startDate, DateTime endDate, int num) {
        long avgStepTime = (endDate.getMillis() - startDate.getMillis()) / num;
        this.maxTimeStep = (int) avgStepTime * 2;
        this.logDateTime = startDate.getMillis();
    }

    public DateTime getRandomDate() {
        int timeStep = new Random().nextInt(maxTimeStep);
        logDateTime = logDateTime + timeStep;
        return new DateTime(logDateTime);
    }
}

