package com.gallia.planif.service.impl;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MissionServiceImplTest {

    /**
     * start before 6AM and finish after 21PM
     */
    @Test
    void testCalculateNightAndMorningNumberOfHoursBetweenDatesInSameDay_case1() {
        // Given
        ZonedDateTime startDate = ZonedDateTime.parse("2022-01-10T03:00:00Z");
        ZonedDateTime endDate = ZonedDateTime.parse("2022-01-10T22:00:00Z");

        // When
        MissionServiceImpl service = new MissionServiceImpl(null, null);
        Pair<Long, Long> result = service.calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(4, result.getRight());
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
        MissionServiceImpl service = new MissionServiceImpl(null, null);
        Pair<Long, Long> result = service.calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);

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
        MissionServiceImpl service = new MissionServiceImpl(null, null);
        Pair<Long, Long> result = service.calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);

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
        MissionServiceImpl service = new MissionServiceImpl(null, null);
        Pair<Long, Long> result = service.calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);

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
        MissionServiceImpl service = new MissionServiceImpl(null, null);
        Pair<Long, Long> result = service.calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);

        // Then
        assertEquals(15, result.getLeft());
        assertEquals(0, result.getRight());
    }
}