package com.gallia.planif.dao.model.business;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkedHoursNumber {
    private double morning;
    private double night;
    private double holiday;
    private double nightHoliday;
    private double sunday;

    public static WorkedHoursNumber zero() {
        return new WorkedHoursNumber(0, 0, 0, 0, 0);
    }

    public void add(WorkedHoursNumber object) {
        this.morning = this.morning + object.getMorning();
        this.night = this.night + object.getNight();
        this.holiday = this.holiday + object.getHoliday();
        this.sunday = this.sunday + object.getSunday();
    }
}
