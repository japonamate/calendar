package com.moz.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalendarModel {
    private int day;
    private int year;
    private List<String> month;
    private List<String> day_of_the_week;

}
