package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.entity.MissionEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class MissionServiceImpl extends AbstractGenericService<Mission, MissionEntity> {

    static final int MORNING_HOUR = 6 ;
    static final int EVENING_HOUR = 21 ;

    public MissionServiceImpl(GenericRepository<MissionEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }

    private long calculateNumberOfWorkedHours(Mission mission) {
        return ChronoUnit.HOURS.between(mission.getStartDate(), mission.getEndDate());
    }

    protected Pair<Long, Long> calculate(Mission mission) {
        ZonedDateTime startDate = mission.getStartDate();
        ZonedDateTime endDate = mission.getEndDate();
        int startDateDayOfYear = startDate.getDayOfYear();
        int endDateDayOfYear = endDate.getDayOfYear();
        if(startDateDayOfYear == endDateDayOfYear) {
            return calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(startDate, endDate);
        }

        long nightResult = 0;
        long morningResult = 0;
        int startDayOfMonth = startDate.getDayOfMonth();
        int startDay = startDate.getDayOfYear();
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        int startMinute = startDate.getMinute();
        ZoneId zone = startDate.getZone();

        int daysNumber = startDateDayOfYear - endDateDayOfYear;
        for(int i = 0; i < daysNumber -1; i++) {
            // if first iteration, start hour is the real start hour else 0
            int startHour = i == 0 ? startDate.getHour() : 0;
            int endHour =  i == daysNumber - 1 ? endDate.getHour() : 23;
            int endDay =
            if(i == daysNumber - 1) {
                endHour = endDate.getHour();
            } else {
                endHour = 0;

            }

            ZonedDateTime start = ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                    0, startMinute, 0, 0, zone);
        }

        return null;
    }

    protected Pair<Long, Long> calculateNightAndMorningNumberOfHoursBetweenDatesInSameDay(ZonedDateTime startDate, ZonedDateTime endDate) {

        long nightResult = 0;
        long morningResult = 0;

        int startDayOfMonth = startDate.getDayOfMonth();
        int startDay = startDate.getDayOfYear();
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        int startMinute = startDate.getMinute();
        ZoneId zone = startDate.getZone();

        int endDay = endDate.getDayOfYear();

        ZonedDateTime zeroAM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        0, startMinute, 0, 0, zone);

        ZonedDateTime sixAM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        6, startMinute, 0, 0, zone);

        ZonedDateTime twentyOnePM =
                ZonedDateTime.of(startYear, startMonth, startDayOfMonth,
                        21, startMinute, 0, 0, zone);

        ZonedDateTime midnight = zeroAM.plusDays(1);

        // start before 6AM and finish after 21PM
        if(isBeforeOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, twentyOnePM)) {
            morningResult = morningResult + ChronoUnit.HOURS.between(sixAM, twentyOnePM);
            nightResult = ChronoUnit.HOURS.between(startDate, sixAM) + ChronoUnit.HOURS.between(twentyOnePM, endDate);
        }
        // start before 6AM and finish before 21PM
        else if(isBeforeOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.HOURS.between(sixAM, endDate);
            nightResult = ChronoUnit.HOURS.between(startDate, sixAM);
        }
        // start after 6AM and finish after 21PM
        else if(isAfterOrEqual(startDate, sixAM) && isAfterOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.HOURS.between(startDate, twentyOnePM);
            nightResult = ChronoUnit.HOURS.between(twentyOnePM, endDate);
        }
        // start after 6AM and finish before 21PM
        else if(isAfterOrEqual(startDate, sixAM) && isBeforeOrEqual(endDate, twentyOnePM)) {
            morningResult = ChronoUnit.HOURS.between(startDate, endDate);
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
