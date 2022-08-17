package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HoursCalculatorImplTest {

    /**
     * start before 6AM and finish after 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case1() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T03:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T22:00:00Z");

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(Double.valueOf(15), result.getLeft());
        assertEquals(Double.valueOf(4), result.getRight());
    }

    /**
     * start before 6AM and finish before 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case2() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T00:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T20:00:00Z");

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(14, result.getLeft());
        assertEquals(6, result.getRight());
    }

    /**
     * start after 6AM and finish after 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case3() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T06:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T22:00:00Z");

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(1, result.getRight());
    }

    /**
     * start after 6AM and finish before 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case4() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T08:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T18:00:00Z");

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(10, result.getLeft());
        assertEquals(0, result.getRight());
    }

    /**
     * start after 6AM and finish before 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case4bis() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T06:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T21:00:00Z");

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(0, result.getRight());
    }

    /**
     * start and end date in the same day
     */
    @Test
    void testCalculateNumberOfWorkedHours_case1(){
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-01-10T06:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-01-10T21:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(0, result.getRight());
    }

    /**
     * mission of 2 days
     */
    @Test
    void testCalculateNumberOfWorkedHours_case2(){
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-01-10T05:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-01-11T08:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(17, result.getLeft());
        assertEquals(10, result.getRight());
    }

    /**
     * mission of 3 days
     */
    @Test
    void testCalculateNumberOfWorkedHours_case3(){
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-01-10T06:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-01-12T06:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(30, result.getLeft());
        assertEquals(18, result.getRight());
    }

    /**
     * mission of 3 days, with half of hour
     */
    @Test
    void testCalculateNumberOfWorkedHours_case4() {
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-01-10T06:30:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-01-12T06:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(Double.valueOf("29.5"), result.getLeft());
        assertEquals(18, result.getRight());
    }


    @Test
    void testCalculateNumberOfWorkedHours_case5() {
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-09-01T00:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-09-02T00:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(9, result.getRight());
    }

    @Test
    void testCalculateNumberOfWorkedHours_case6() {
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-09-01T01:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-09-02T01:00:00Z"));

        // When
        HoursCalculatorImpl service = new HoursCalculatorImpl();
        Pair<Double, Double> result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(9, result.getRight());
    }
}