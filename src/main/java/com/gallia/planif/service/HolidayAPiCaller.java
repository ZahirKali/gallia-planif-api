package com.gallia.planif.service;

import java.util.Date;
import java.util.Map;

public interface HolidayAPiCaller {

    Map<Date, String> getHoliday(int year);
}
