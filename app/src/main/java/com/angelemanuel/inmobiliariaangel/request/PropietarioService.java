package com.angelemanuel.inmobiliariaangel.request;

import com.angelemanuel.inmobiliariaangel.modelo.Propietario;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PropietarioService {
    @GET("api/Propietarios")

    // Ya no es necesario el `@Header("Authorization")` acá, ya que el interceptor se encargará de
    // agregar el token automáticamente.
    Call<Propietario> getPerfil();
}
