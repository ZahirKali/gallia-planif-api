package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.entity.MissionEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import com.gallia.planif.service.HoursCalculator;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

@Service
public class MissionServiceImpl extends AbstractGenericService<Mission, MissionEntity> {

    private final HoursCalculator hoursCalculator;
    public MissionServiceImpl(GenericRepository<MissionEntity, Long> repository,
                              BusinessEntityMapper mapper,
                              HoursCalculator hoursCalculator) {
        super(repository, mapper);
        this.hoursCalculator = hoursCalculator;
    }

    @Override
    public Mission create(Mission mission) {
        Pair<Double, Double> workedHours = hoursCalculator.calculateNumberOfWorkedHours(mission);
        mission.setMorningWorkedHoursNumber(workedHours.getLeft());
        mission.setNightWorkedHoursNumber(workedHours.getRight());
        mission.setTotalWorkedHoursNumber(workedHours.getLeft() + workedHours.getRight());
        return super.create(mission);
    }
}
