package com.angelemanuel.inmobiliariaangel.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PerfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragment de Perfil");
    }

    public LiveData<String> getText() {
        return mText;
    }
}