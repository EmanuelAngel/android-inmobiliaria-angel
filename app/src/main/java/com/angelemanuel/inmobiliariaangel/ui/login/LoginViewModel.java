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
    private MutableLiveData<String> tokenMutable;
    private MutableLiveData<String> errorMutable;
    private MutableLiveData<Boolean> loadingMutable;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getTokenMutable() {
        if (tokenMutable == null) tokenMutable = new MutableLiveData<>();
        return tokenMutable;
    }

    public LiveData<String> getErrorMutable() {
        if (errorMutable == null) errorMutable = new MutableLiveData<>();
        return errorMutable;
    }

    public LiveData<Boolean> getLoadingMutable() {
        if (loadingMutable == null) loadingMutable = new MutableLiveData<>();
        return loadingMutable;
    }

    public void autenticar(String usuario, String clave) {
        if (usuario.isEmpty() || clave.isEmpty()) {
            errorMutable.setValue("Usuario y clave son obligatorios");
            return;
        }

        loadingMutable.setValue(true);
        AuthService authService = ApiClient.getAuthService();
        Call<String> call = authService.login(usuario, clave);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                loadingMutable.postValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    tokenMutable.postValue(response.body());
                } else {
                    errorMutable.postValue("Usuario o clave incorrectos");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                loadingMutable.postValue(false);
                errorMutable.postValue("Error de red: " + t.getMessage());
                Log.e("LoginError", t.getMessage());
            }
        });
    }
}
