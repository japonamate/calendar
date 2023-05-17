package com.moz.calendar.controller;

import com.moz.calendar.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CalendarTable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";




    @GetMapping("/calendar")
    public String mainCalendar() {
        Calendar calendar = Calendar.getInstance();

        int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
        int thisMonth = calendar.get(Calendar.MONTH) + 2;     // month (Jan = 1, Dec = 12)
        int thisYear = calendar.get(Calendar.YEAR);


        // months[i] = name of month i
        String[] months = {
                "",                               // leave empty so that months[1] = "January"
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        // days[i] = number of days in month i
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // check for leap year
        if (thisMonth == 2 && isLeapYear(thisYear)) days[thisMonth] = 29;


        // print calendar header
        System.out.println("   " + months[thisMonth] + " " + thisYear);
        System.out.println(" M  Tu  W Th F  S  S");

        // starting day
        int d = day(thisMonth, 0, thisYear);       //:: d - day of the week [0..6] ::

        // print the calendar
        for (int i = 0; i < d; i++) System.out.print("   ");
        for (int i = 1; i <= days[thisMonth]; i++) {
            if (i != thisDay) {
                System.out.printf("%2d ", i);
            }
            else {
                System.out.printf(ANSI_RED + "%2d " + ANSI_RESET, i);
            }
            if (((i + d) % 7 == 0) || (i == days[thisMonth]))
                System.out.println();     //:: need to go to the next line ::
        }
        return "index";
    }


    public static int day(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = M + 12 * ((14 - M) / 12) - 2;
        int d = (D + x + (31 * m) / 12) % 7;
        return d;
    }

    // return true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) return true;
        if (year % 400 == 0) return true;
        return false;
    }


}

