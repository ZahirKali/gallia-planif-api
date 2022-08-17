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
    private double sunday;

    public static WorkedHoursNumber zero() {
        return new WorkedHoursNumber(0, 0, 0, 0);
    }

    public void add(WorkedHoursNumber object) {
        this.morning = this.morning + object.getMorning();
        this.night = this.night + object.getNight();
        this.holiday = this.holiday + object.getHoliday();
        this.sunday = this.sunday + object.getSunday();
    }
    public void incrementMorning(double val) {
        this.morning = this.morning + val;
    }
    public void incrementNight(double val) {
        this.night = this.night + val;
    }
    public void incrementHoliday(double val) {
        this.holiday = this.holiday + val;
    }
    public void incrementSunday(double val) {
        this.sunday = this.sunday + val;
    }
}
