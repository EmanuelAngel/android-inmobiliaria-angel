package com.angelemanuel.inmobiliariaangel.ui.login;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.angelemanuel.inmobiliariaangel.request.ApiClient;
import com.angelemanuel.inmobiliariaangel.request.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<String> tokenLiveData;
    private MutableLiveData<String> errorLiveData;
    private MutableLiveData<Boolean> loadingLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getTokenLiveData() {
        if (tokenLiveData == null) tokenLiveData = new MutableLiveData<>();
        return tokenLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        if (errorLiveData == null) errorLiveData = new MutableLiveData<>();
        return errorLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        if (loadingLiveData == null) loadingLiveData = new MutableLiveData<>();
        return loadingLiveData;
    }

    public void login(String usuario, String clave) {
        if (usuario.isEmpty() || clave.isEmpty()) {
            errorLiveData.setValue("Usuario y clave son obligatorios");
            return;
        }

        loadingLiveData.setValue(true);
        AuthService authService = ApiClient.getAuthService();
        Call<String> call = authService.login(usuario, clave);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                loadingLiveData.postValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    tokenLiveData.postValue(response.body());
                } else {
                    errorLiveData.postValue("Usuario o clave incorrectos");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                loadingLiveData.postValue(false);
                errorLiveData.postValue("Error de red: " + t.getMessage());
                Log.e("LoginError", t.getMessage());
            }
        });
    }
}
