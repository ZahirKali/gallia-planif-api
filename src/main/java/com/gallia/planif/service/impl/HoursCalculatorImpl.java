package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.service.HoursCalculator;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class HoursCalculatorImpl implements HoursCalculator {
    static final int MORNING_HOUR = 6 ;
    static final int NIGHT_HOUR = 21 ;

    @Override
    public Pair<Double, Double> calculateNumberOfWorkedHours(Mission mission) {
        ZonedDateTime startDate = mission.getStartDate();
        ZonedDateTime endDate = mission.getEndDate();
        int startDateDayOfYear = startDate.getDayOfYear();
        int endDateDayOfYear = endDate.getDayOfYear();

        if(startDateDayOfYear == endDateDayOfYear) {
            return calculateNumberOfWorkedHoursInSameDay(startDate, endDate);
        }

        double nightResult = 0;
        double morningResult = 0;

        int daysNumber = endDateDayOfYear - startDateDayOfYear;

        ZonedDateTime start = startDate;
        ZonedDateTime end = endDate;

        for(int i = 0; i <= daysNumber; i++) {
            // if first iteration, start hour is the real start hour else 0
            if(i == 0) {
                end = start.withHour(0).plusDays(1);
            } else if(i == daysNumber){
                start = end;
                end = endDate;
            } else {
                start = end;
                end = start.withHour(0).plusDays(1);
            }
            Pair<Double, Double> pair = calculateNumberOfWorkedHoursInSameDay(start, end);
            morningResult = morningResult + pair.getLeft();
            nightResult = nightResult + pair.getRight();
        }

        return Pair.of(morningResult, nightResult);
    }

    protected Pair<Double, Double> calculateNumberOfWorkedHoursInSameDay(ZonedDateTime startDate, ZonedDateTime endDate) {

        double nightResult = 0;
        double morningResult = 0;

        int startDayOfMonth = startDate.getDayOfMonth();
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        int startMinute = startDate.getMinute();
        ZoneId zone = startDate.getZone();

        ZonedDateTime sixAM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        MORNING_HOUR, startMinute, 0, 0, zone);

        ZonedDateTime twentyOnePM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        NIGHT_HOUR, startMinute, 0, 0, zone);


        // start before 6AM and finish after 21PM
        if(isBeforeOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, twentyOnePM)) {
            morningResult = morningResult + ChronoUnit.MINUTES.between(sixAM, twentyOnePM) / 60;
            nightResult = ChronoUnit.MINUTES.between(startDate, sixAM) / 60 + ChronoUnit.HOURS.between(twentyOnePM, endDate) / 60;
        }
        // start before 6AM and finish before 21PM
        else if(isBeforeOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.MINUTES.between(sixAM, endDate) / 60;
            nightResult = ChronoUnit.MINUTES.between(startDate, sixAM) / 60;
        }
        // start after 6AM and finish after 21PM
        else if(isAfterOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.MINUTES.between(startDate, twentyOnePM) / 60;
            nightResult = ChronoUnit.MINUTES.between(twentyOnePM, endDate) / 60;
        }
        // start after 6AM and finish before 21PM
        else if(isAfterOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.MINUTES.between(startDate, endDate) / 60;
        }
        return Pair.of(morningResult, nightResult);
    }

    private static boolean isBeforeOrEqual(ZonedDateTime first, ZonedDateTime second) {
        return first.isBefore(second) || first.isEqual(second);
    }
    private static boolean isAfterOrEqual(ZonedDateTime first, ZonedDateTime second) {
        return first.isAfter(second) || first.isAfter(second);
    }
}
