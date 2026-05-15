package com.angelemanuel.inmobiliariaangel.request;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.angelemanuel.inmobiliariaangel.ui.login.LoginActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor de OkHttp que centraliza la seguridad de las peticiones a la API.
 * Responsabilidades:
 * 1. Inyección de Token: Agrega el encabezado 'Authorization' con el JWT almacenado.
 * 2. Gestión de Sesión: Si el servidor devuelve 401 (Unauthorized), borra los datos
 *    locales y redirige al usuario al Login.
 */
public class AuthInterceptor implements Interceptor {
    private Context context;

    public AuthInterceptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        // Recuperamos el token de SharedPreferences
        SharedPreferences sp = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");

        Request.Builder requestBuilder = chain.request().newBuilder();
        
        // Si el token existe, lo inyectamos en la petición antes de enviarla
        if (!token.isEmpty()) {
            requestBuilder.addHeader("Authorization", token);
        }

        Request request = requestBuilder.build();
        Response response = chain.proceed(request);

        // Si la respuesta es 401 (No autorizado/Token expirado), forzamos el cierre de sesión
        if (response.code() == 401) {
            // Limpiamos los datos de autenticación locales
            sp.edit().clear().apply();
            
            // Redirigimos al LoginActivity con un mensaje amigable
            Intent intent = new Intent(context, LoginActivity.class);
            intent.putExtra("mensaje", "Sesión expirada, inicia sesión de nuevo");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }

        return response;
    }
}
