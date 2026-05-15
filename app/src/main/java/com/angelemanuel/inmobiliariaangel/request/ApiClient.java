package com.angelemanuel.inmobiliariaangel.request;

import android.content.Context;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://capacitacion.alwaysdata.net/";
    private static AuthService authService;
    private static PropietarioService propietarioService;

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

    /**
     * Configura y devuelve un cliente OkHttp con un interceptor de autenticación.
     * El interceptor se encarga de:
     * 1. Inyectar automáticamente el token JWT en el encabezado 'Authorization'.
     * 2. Detectar errores 401 (sesión expirada) y redirigir al Login.
     * @param context Contexto necesario para acceder a SharedPreferences e iniciar Activities.
     * @return Cliente OkHttp configurado.
     */
    private static OkHttpClient getOkHttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(context))
                .build();
    }

    /**
     * Obtiene una instancia única de PropietarioService configurada con seguridad.
     * A diferencia de getAuthService, este utiliza un cliente OkHttp personalizado
     * para manejar la autenticación de forma transparente.
     * @param context Contexto de la aplicación.
     * @return Instancia de PropietarioService.
     */
    public static PropietarioService getPropietarioService(Context context) {
        if (propietarioService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // Se adjunta el cliente con interceptor para inyección automática de token
                    .client(getOkHttpClient(context))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            propietarioService = retrofit.create(PropietarioService.class);
        }
        return propietarioService;
    }
}
