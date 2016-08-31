package com.chenhang.myapplication.pickerview.utils;

import android.view.View;

import com.chenhang.myapplication.pickerview.data.WheelCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by jzxiang on 16/4/20.
 */
public class Utils {

    public static boolean isTimeEquals(WheelCalendar calendar, int... params) {
        switch (params.length) {
            case 1:
                return calendar.year == params[0];
            case 2:
                return calendar.year == params[0] &&
                        calendar.month == params[1];
            case 3:
                return calendar.year == params[0] &&
                        calendar.month == params[1] &&
                        calendar.day == params[2];
            case 4:
                return calendar.year == params[0] &&
                        calendar.month == params[1] &&
                        calendar.day == params[2] &&
                        calendar.hour == params[3];
        }
        return false;
    }

    public static void hideViews(View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setVisibility(View.GONE);
        }
    }

    public static String getDateToString(long time){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date(time);
        return sf.format(d);
    }

    private static String getWeek(long millis) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(millis);
        String week = "";
        int cweek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (cweek) {
            case 1:
                week = "周日";
                break;
            case 2:
                week = "周一";
                break;
            case 3:
                week = "周二";
                break;
            case 4:
                week = "周三";
                break;
            case 5:
                week = "周四";
                break;
            case 6:
                week = "周五";
                break;
            case 7:
                week = "周六";
                break;
        }
        return week;
    }
}
