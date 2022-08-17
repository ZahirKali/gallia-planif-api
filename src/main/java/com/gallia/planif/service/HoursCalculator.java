package com.gallia.planif.service;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.business.WorkedHoursNumber;

public interface HoursCalculator {

    /**
     * Calculate number of worked hours (morning and night hours)
     * @param mission mission
     * @return worked hours number
     */
    WorkedHoursNumber calculateNumberOfWorkedHours(Mission mission);
}
