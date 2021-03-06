package com.bluecc.income.common;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.List;

import static io.vavr.API.*;
import static org.junit.Assert.assertEquals;

public class ValidatorTest {
    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }

    static class PersonValidator {
        String NAME_ERR = "Invalid characters in name: ";
        String AGE_ERR = "Age must be at least 0";

        public Validation<Seq<String>, Person> validatePerson(
                String name, int age) {
            return Validation.combine(
                    validateName(name), validateAge(age)).ap(Person::new);
        }

        private Validation<String, String> validateName(String name) {
            String invalidChars = name.replaceAll("[a-zA-Z ]", "");
            return invalidChars.isEmpty() ?
                    Validation.valid(name)
                    : Validation.invalid(NAME_ERR + invalidChars);
        }

        private Validation<String, Integer> validateAge(int age) {
            return age < 0 ? Validation.invalid(AGE_ERR)
                    : Validation.valid(age);
        }
    }

    @Test
    public void whenValidationWorks_thenCorrect() {
        PersonValidator personValidator = new PersonValidator();

        Validation<Seq<String>, Person> valid =
                personValidator.validatePerson("John Doe", 30);

        Validation<Seq<String>, Person> invalid =
                personValidator.validatePerson("John? Doe!4", -1);

        assertEquals("Valid(ValidatorTest.Person(name=John Doe, age=30))", valid.toString());
        assertEquals("Invalid(List(Invalid characters in name: ?!4, Age must be at least 0))",
                invalid.toString());
    }

    @Test
    public void whenMatchworks_thenCorrect() {
        int input = 2;
        String output = Match(input).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(), "?"));

        assertEquals("two", output);
    }
}
