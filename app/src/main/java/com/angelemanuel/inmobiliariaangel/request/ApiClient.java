package com.angelemanuel.inmobiliariaangel.request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://capacitacion.alwaysdata.net/";
    private static AuthService authService;

    /**
     * Obtiene una instancia única de AuthService.
     * Se utilizan dos conversores:
     * 1. ScalarsConverterFactory: Necesario para manejar respuestas de texto plano (como el token JWT).
     *    Debe ir primero para interceptar las respuestas String antes que GSON.
     * 2. GsonConverterFactory: Para manejar el resto de las respuestas en formato JSON.
     * @return Instancia de AuthService.
     */
    public static AuthService getAuthService() {
        if (authService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            authService = retrofit.create(AuthService.class);
        }
        return authService;
    }
}
