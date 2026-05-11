package com.angelemanuel.inmobiliariaangel.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContratosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContratosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragment de Contratos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}