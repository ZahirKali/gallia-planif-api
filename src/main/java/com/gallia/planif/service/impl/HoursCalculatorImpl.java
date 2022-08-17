package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.business.WorkedHoursNumber;
import com.gallia.planif.service.HoursCalculator;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class HoursCalculatorImpl implements HoursCalculator {
    static final int MORNING_HOUR = 6;
    static final int NIGHT_HOUR = 21;

    @Override
    public WorkedHoursNumber calculateNumberOfWorkedHours(Mission mission) {
        ZonedDateTime startDate = mission.getStartDate();
        ZonedDateTime endDate = mission.getEndDate();
        int startDateDayOfYear = startDate.getDayOfYear();
        int endDateDayOfYear = endDate.getDayOfYear();

        if (startDateDayOfYear == endDateDayOfYear) {
            return calculateNumberOfWorkedHoursInSameDay(startDate, endDate);
        }

        WorkedHoursNumber result = WorkedHoursNumber.zero();

        int daysNumber = endDateDayOfYear - startDateDayOfYear;

        ZonedDateTime start = startDate;
        ZonedDateTime end = endDate;

        for (int i = 0; i <= daysNumber; i++) {
            // if first iteration, start hour is the real start hour else 0
            if (i == 0) {
                end = start.withHour(0).withMinute(0).plusDays(1);
            } else if (i == daysNumber) {
                start = end;
                end = endDate;
            } else {
                start = end;
                end = start.withHour(0).plusDays(1);
            }
            result.add(calculateNumberOfWorkedHoursInSameDay(start, end));
        }

        return result;
    }

    protected WorkedHoursNumber calculateNumberOfWorkedHoursInSameDay(ZonedDateTime startDate, ZonedDateTime endDate) {

        WorkedHoursNumber result = WorkedHoursNumber.zero();

        int startDayOfMonth = startDate.getDayOfMonth();
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        ZoneId zone = startDate.getZone();

        ZonedDateTime sixAM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        MORNING_HOUR, 0, 0, 0, zone);

        ZonedDateTime twentyOnePM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        NIGHT_HOUR, 0, 0, 0, zone);

        if (startDate.isEqual(endDate)) {
            return result;
        }
        // start before 6AM and finish before 6AM OR start after 21PM and finish after 21PM
        else if (isBeforeOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, sixAM) ||
                isAfterOrEqual(startDate, twentyOnePM) && isAfterOrEqual(endDate, twentyOnePM)) {
            result.setNight(minutesToHours(ChronoUnit.MINUTES.between(startDate, endDate)));
        }
        // start before 6AM and finish after 21PM
        if (isBeforeOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, twentyOnePM)) {
            result.setMorning(minutesToHours(ChronoUnit.MINUTES.between(sixAM, twentyOnePM)));
            result.setNight(minutesToHours(ChronoUnit.MINUTES.between(startDate, sixAM) + ChronoUnit.MINUTES.between(twentyOnePM, endDate)));
        }
        // start before 6AM and finish between 6AM and 21PM
        else if (isBeforeOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            result.setMorning(minutesToHours(ChronoUnit.MINUTES.between(sixAM, endDate)));
            result.setNight(minutesToHours(ChronoUnit.MINUTES.between(startDate, sixAM)));
        }
        // start between 6AM and 21PM, and finish after 21PM
        else if (isAfterOrEqual(startDate, sixAM) && isBeforeOrEqual(startDate, twentyOnePM) && isAfterOrEqual(endDate, twentyOnePM)) {
            result.setMorning(minutesToHours(ChronoUnit.MINUTES.between(startDate, twentyOnePM)));
            result.setNight(minutesToHours(ChronoUnit.MINUTES.between(startDate, twentyOnePM)));
        }
        // start after 6AM and finish before 21PM
        else if (isAfterOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            result.setMorning(minutesToHours(ChronoUnit.MINUTES.between(startDate, endDate)));
        }

        // sunday worked hours
        if(DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())) {
            result.setSunday(result.getMorning() + result.getNight());
        }


        return result;
    }

    private static boolean isBeforeOrEqual(ZonedDateTime first, ZonedDateTime second) {
        return first.isBefore(second) || first.isEqual(second);
    }

    private static boolean isAfterOrEqual(ZonedDateTime first, ZonedDateTime second) {
        return first.isAfter(second) || first.isAfter(second);
    }

    private static double minutesToHours(double minutes) {
        return roundToHalf(minutes / 60);
    }

    public static double roundToHalf(double d) {
        return Math.round(d * 2) / 2.0;
    }
}
