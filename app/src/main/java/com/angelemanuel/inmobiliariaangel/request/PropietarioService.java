package com.angelemanuel.inmobiliariaangel.request;

import com.angelemanuel.inmobiliariaangel.modelo.Propietario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface PropietarioService {
    @GET("api/Propietarios")
    Call<Propietario> getPerfil(@Header("Authorization") String token);
}
