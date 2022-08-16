package com.gallia.planif.service;

import com.gallia.planif.dao.model.business.Mission;
import org.apache.commons.lang3.tuple.Pair;

public interface HoursCalculator {

    /**
     * Calculate number of worked hours (morning and night hours)
     * @param mission mission
     * @return Pair<NUMBER_OF_MORNING_HOURS, NUMBER_OF_NIGHT_HOURS>
     */
    Pair<Double, Double> calculateNumberOfWorkedHours(Mission mission);
}
