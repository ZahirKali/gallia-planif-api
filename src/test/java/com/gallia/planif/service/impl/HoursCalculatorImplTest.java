package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.business.WorkedHoursNumber;
import com.gallia.planif.service.HolidayAPiCaller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HoursCalculatorImplTest {

    @InjectMocks
    private HoursCalculatorImpl service;

    @Mock
    private HolidayAPiCaller holidayAPiCaller;

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
    }
    /**
     * start before 6AM and finish after 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case1() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T03:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T22:00:00Z");

        // When
        WorkedHoursNumber result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(15.0, result.getMorning());
        assertEquals(4.0, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(14, result.getMorning());
        assertEquals(6, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getMorning());
        assertEquals(1, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(10, result.getMorning());
        assertEquals(0, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHoursInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getMorning());
        assertEquals(0, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getMorning());
        assertEquals(0, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(17, result.getMorning());
        assertEquals(10, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(30, result.getMorning());
        assertEquals(18, result.getNight());
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
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(Double.valueOf("29.5"), result.getMorning());
        assertEquals(18, result.getNight());
    }


    @Test
    void testCalculateNumberOfWorkedHours_case5() {
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-09-01T00:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-09-02T00:00:00Z"));

        // When
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getMorning());
        assertEquals(9, result.getNight());
    }

    @Test
    void testCalculateNumberOfWorkedHours_case6() {
        // Given
        Mission mission = new Mission();
        mission.setStartDate(ZonedDateTime.parse("2022-09-01T01:00:00Z"));
        mission.setEndDate(ZonedDateTime.parse("2022-09-02T01:00:00Z"));

        // When
        WorkedHoursNumber result = service.calculateNumberOfWorkedHours(mission);

        // Then
        assertEquals(15, result.getMorning());
        assertEquals(9, result.getNight());
    }
}