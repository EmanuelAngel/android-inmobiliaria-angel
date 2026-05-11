package com.angelemanuel.inmobiliariaangel.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragment de Configuración");
    }

    public LiveData<String> getText() {
        return mText;
    }
}