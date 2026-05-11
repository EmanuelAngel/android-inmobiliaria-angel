package com.angelemanuel.inmobiliariaangel.request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://capacitacion.alwaysdata.net/";
    private static AuthService authService;

    public static AuthService getAuthService() {
        if (authService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            authService = retrofit.create(AuthService.class);
        }
        return authService;
    }
}
