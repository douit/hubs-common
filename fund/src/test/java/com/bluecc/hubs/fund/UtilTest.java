package com.bluecc.hubs.fund;

import com.google.common.base.CaseFormat;
import com.pivovarit.function.ThrowingPredicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

// import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void snakeToCamel() {
        String words="Scrum Project status";
        // System.out.println(Util.toClassName(words));
        String result=CaseFormat.LOWER_UNDERSCORE.to(
                CaseFormat.UPPER_CAMEL, words.replaceAll(" ", "_"));
        System.out.println(result);
    }

    @Test
    public void testWordsConvert(){
        // System.out.println(Util.wordsToClassName(Util.toSnakecase("Scrum Project status")));
        // System.out.println(Util.wordsToClassName(Util.toSnakecase("ShipmentRouteSegment:CarrierService")));
        assertEquals("ScrumProjectStatus",
                Util.wordsToClassName("Scrum Project status"));
        assertEquals("ShipmentRouteSegmentCarrierService",
                Util.wordsToClassName("ShipmentRouteSegment:CarrierService"));
    }

    @Test
    public void testFirstLetter(){
        assertEquals("HWT", Util.getWordsFirstLetters(" hello World 18 times "));
    }

    @Test
    public void testValidUrl(){
        String url="https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";
        Customer john = new Customer("John P.", 15, url);
        Customer sarah = new Customer("Sarah M.", 200, url);
        Customer charles = new Customer("Charles B.", 150, url);
        Customer mary = new Customer("Mary T.", 1, url);

        List<Customer> customers = Arrays.asList(john, sarah, charles, mary);

        List<Customer> customersWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList());

        List<Customer> customersWithMoreThan100Points2 = customers
                .stream()
                .filter(Customer::hasOverHundredPoints)
                .collect(Collectors.toList());

        assertThat(customersWithMoreThan100Points).hasSize(2);
        assertThat(customersWithMoreThan100Points).contains(sarah, charles);

        List<Customer> charlesWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
                .collect(Collectors.toList());

        assertThat(charlesWithMoreThan100Points).hasSize(1);
        assertThat(charlesWithMoreThan100Points).contains(charles);

        List<Customer> customersWithValidProfilePhoto = customers
                .stream()
                .filter(c -> {
                    try {
                        return c.hasValidProfilePhoto();
                    } catch (IOException e) {
                        //handle exception
                    }
                    return false;
                })
                .collect(Collectors.toList());

        // https://github.com/pivovarit/throwing-function
        List<Customer> customersWithValidProfilePhoto2 = customers
                .stream()
                .filter(ThrowingPredicate.unchecked(Customer::hasValidProfilePhoto))
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    public static class Customer {
        private String name;
        private int points;
        private String profilePhotoUrl;

        public boolean hasValidProfilePhoto() throws IOException {
            URL url = new URL(this.profilePhotoUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
        }

        public boolean hasOverHundredPoints() {
            return this.points > 100;
        }

    }


}