package com.example.vegetablesshop2.ui.MyOrders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyOrdersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyOrdersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("My orders");
    }

    public LiveData<String> getText() {
        return mText;
    }
}