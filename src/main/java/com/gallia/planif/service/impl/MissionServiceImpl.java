package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.entity.MissionEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class MissionServiceImpl extends AbstractGenericService<Mission, MissionEntity> {

    static final int MORNING_HOUR = 6 ;
    static final int EVENING_HOUR = 22 ;

    public MissionServiceImpl(GenericRepository<MissionEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }

    private long calculateNumberOfWorkedHours(Mission mission) {
        return ChronoUnit.HOURS.between(mission.getStartDate(), mission.getEndDate());
    }

    private long calculateNumberOfHoursBetween(Mission mission, long start, long end) {

        long result = 0;

        ZonedDateTime startDate = mission.getStartDate();
        ZonedDateTime endDate = mission.getEndDate();

        int startDayOfMonth = startDate.getDayOfMonth();
        int startDay = startDate.getDayOfYear();
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        int startMinute = startDate.getMinute();
        ZoneId zone = startDate.getZone();

        int endDay = endDate.getDayOfYear();

        // Mission start and end the same date
        if(startDay == endDay) {
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



        }
        // start day and end day are differents
        else {

        }


        return 0;
    }
}
