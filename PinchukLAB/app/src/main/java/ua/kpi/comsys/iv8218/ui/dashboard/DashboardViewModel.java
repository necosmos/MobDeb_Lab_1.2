package ua.kpi.comsys.iv8218.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ua.kpi.comsys.iv8218.lab1_2.TimeMP;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        String error = "";
        try{
            TimeMP lastTest = new TimeMP(23, 62, 60);
        }catch (IllegalArgumentException e){
            error = e.getMessage();
        }

        TimeMP test1 = new TimeMP(4, 7, 49);
        TimeMP test2 = new TimeMP(16, 11, 48);
        TimeMP test2_1 = new TimeMP(23, 59, 59);
        mText = new MutableLiveData<>();
        Calendar calendar = new GregorianCalendar(2001, 9, 11);
        calendar.set(Calendar.HOUR, 13);
        calendar.set(Calendar.MINUTE, 20);
        calendar.set(Calendar.SECOND, 51);


        mText.setValue(test1.getTime() +
                "\n" + test2.getTime() + "+" + test2_1.getTime() + "=" + test2.plus2Time(test2_1).getTime() +
                "\n" + test2.getTime() + "-" + test2_1.getTime() + "=" + test2.minus2Time(test2_1).getTime() +
                "\n" + TimeMP.minus2Time(new TimeMP(), new TimeMP(6, 5, 50)).getTime() +
                "\n" + TimeMP.plus2Time(new TimeMP(12, 10, 0), new TimeMP(calendar)).getTime()+
                "\n" + error);

    }
    public LiveData<String> getText() {
        return mText;
    }

}