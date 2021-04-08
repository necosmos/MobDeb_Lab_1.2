package ua.kpi.comsys.iv8218.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Пінчук Микита\nГрупа ІВ-82\nЗК ІВ-8218");
    }

    public LiveData<String> getText() {
        return mText;
    }
}