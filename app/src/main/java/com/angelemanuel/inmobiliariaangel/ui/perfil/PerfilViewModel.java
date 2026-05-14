package com.angelemanuel.inmobiliariaangel.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.angelemanuel.inmobiliariaangel.modelo.Propietario;
import com.angelemanuel.inmobiliariaangel.request.ApiClient;
import com.angelemanuel.inmobiliariaangel.request.PropietarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietarioMutable;
    private MutableLiveData<String> errorMutable;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Propietario> getPropietario() {
        if (propietarioMutable == null) {
            propietarioMutable = new MutableLiveData<>();
        }
        return propietarioMutable;
    }

    public LiveData<String> getError() {
        if (errorMutable == null) {
            errorMutable = new MutableLiveData<>();
        }
        return errorMutable;
    }

    public void cargarPerfil() {
        SharedPreferences sp = getApplication().getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");

        if (token.isEmpty()) {
            errorMutable.setValue("Sesión no válida");
            return;
        }

        PropietarioService service = ApiClient.getPropietarioService();
        Call<Propietario> call = service.getPerfil(token);

        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful() && response.body() != null) {
                    propietarioMutable.postValue(response.body());
                } else {
                    errorMutable.postValue("Error al cargar perfil: " + response.code());
                    Log.e("PerfilViewModel", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                errorMutable.postValue("Error de red: " + t.getMessage());
                Log.e("PerfilViewModel", "Failure: " + t.getMessage());
            }
        });
    }
}
