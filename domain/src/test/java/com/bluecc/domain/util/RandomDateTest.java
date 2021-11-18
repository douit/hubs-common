package com.bluecc.domain.util;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomDateTest {

    @Test
    public void getRandomDate() {
        DateTime endTime=DateTime.now();
        DateTime startTime=endTime.minusDays(30);
        RandomDate randomDate=new RandomDate(startTime, endTime, 3600);
        for (int genN=0;genN<3;++genN) {
            System.out.println(randomDate.getRandomDate());
        }

        /*
        2021-10-19T20:36:55.567+08:00
        2021-10-19T20:37:21.983+08:00
        2021-10-19T20:55:07.036+08:00
         */
    }
}