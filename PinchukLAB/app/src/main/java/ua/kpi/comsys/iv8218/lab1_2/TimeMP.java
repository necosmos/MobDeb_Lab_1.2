package ua.kpi.comsys.iv8218.lab1_2;

import android.annotation.SuppressLint;

import java.util.Calendar;
public class TimeMP {
    private final int minutes;
    private final int hours;
    private final int seconds;

    public TimeMP(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeMP(int hours, int minutes, int seconds){
        if (hours < 0 || hours > 23)
            throw new IllegalArgumentException("You input wrong hour`s value");
        else if (minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("You input wrong minute's value");
        else if (seconds < 0 || seconds > 59)
            throw new IllegalArgumentException("You input wrong second's value");
        else{
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }}

    public TimeMP(Calendar calendar){
        this.hours = calendar.get(Calendar.HOUR);
        this.minutes = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);
    }

    @SuppressLint("DefaultLocale")
    public String getTime(){
        if (hours < 12)
            return String.format("%02d:%02d:%02d", getHours(),getMinutes(),getSeconds()) + " AM";
        else if (hours == 12){
            return String.format("%02d:%02d:%02d", getHours(),getMinutes(),getSeconds()) + " PM";
        }
        else
            return String.format("%02d:%02d:%02d", getHours() - 12,getMinutes(),getSeconds()) + " PM";
    }

    public int getSeconds(){
        return this.seconds;
    }

    public int getHours(){
        return this.hours;
    }

    public int getMinutes(){
        return this.minutes;
    }
    public TimeMP plus2Time(TimeMP obj) {
        int totalSecs = (this.hours + obj.getHours()) * 3600 + (this.minutes + obj.getMinutes()) * 60 + this.seconds + obj.getSeconds();
        int hours = totalSecs / 60 / 60 % 24;
        int minutes = totalSecs / 60 % 60;
        int seconds = totalSecs % 60;
        return new TimeMP(hours,minutes,seconds);
    }


    public static TimeMP plus2Time(TimeMP obj1, TimeMP obj2) {
        int totalSecs = (obj1.getHours() + obj2.getHours()) * 3600 + (obj1.getMinutes() + obj2.getMinutes()) * 60 + obj1.getSeconds() + obj2.getSeconds();
        int hours = totalSecs / 60 / 60 % 24;
        int minutes = totalSecs / 60 % 60;
        int seconds = totalSecs % 60;
        return new TimeMP(hours,minutes,seconds);
    }



    public TimeMP minus2Time(TimeMP obj) {
        int totalSecs = (this.hours - obj.getHours()) * 3600 + (this.minutes - obj.getMinutes()) * 60 + this.seconds - obj.getSeconds();
        if (totalSecs < 0){
            int newTotalSecs = 24 * 3600 + totalSecs;
            int hours = newTotalSecs / 60 / 60 % 24;
            int minutes = newTotalSecs / 60 % 60;
            int seconds = newTotalSecs % 60;
            return new TimeMP(hours, minutes, seconds);
        }
        else{
            int hours = totalSecs / 60 / 60 % 24;
            int minutes = totalSecs / 60 % 60;
            int seconds = totalSecs % 60;
            return new TimeMP(hours, minutes, seconds);
        }
    }

    public static TimeMP minus2Time(TimeMP obj1, TimeMP obj2) {
        int totalSecs = (obj1.getHours() - obj2.getHours()) * 3600 + (obj1.getMinutes() - obj2.getMinutes()) * 60 + obj1.getSeconds() - obj2.getSeconds();
        if (totalSecs < 0){
            int newTotalSecs = 24 * 3600 + totalSecs;
            int hours = newTotalSecs / 60 / 60 % 24;
            int minutes = newTotalSecs / 60 % 60;
            int seconds = newTotalSecs % 60;
            return new TimeMP(hours, minutes, seconds);
        }
        else{
            int hours = totalSecs / 60 / 60 % 24;
            int minutes = totalSecs / 60 % 60;
            int seconds = totalSecs % 60;
            return new TimeMP(hours, minutes, seconds);
        }
    }
}