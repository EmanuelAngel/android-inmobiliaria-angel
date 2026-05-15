package com.angelemanuel.inmobiliariaangel.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.angelemanuel.inmobiliariaangel.MainActivity;
import com.angelemanuel.inmobiliariaangel.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkToken()) {
            navigateToMain();
            return;
        }

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Verificamos si venimos de un cierre de sesión forzado (sesión expirada)
        String mensaje = getIntent().getStringExtra("mensaje");
        if (mensaje != null) {
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        }

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        setupObservers();
        setupListeners();
        prefillCredentials();
    }

    private void prefillCredentials() {
        binding.etEmail.setText("luisprofessor@gmail.com");
        binding.etPassword.setText("DEEKQW");
    }

    private boolean checkToken() {
        SharedPreferences sp = getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);
        return sp.contains("token");
    }

    private void setupObservers() {
        loginViewModel.getTokenMutable().observe(this, token -> {
            navigateToMain();
        });

        loginViewModel.getErrorMutable().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });

        loginViewModel.getLoadingMutable().observe(this, isLoading -> {
            binding.pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            binding.btnLogin.setEnabled(!isLoading);
        });
    }

    private void setupListeners() {
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString();
            String pass = binding.etPassword.getText().toString();
            loginViewModel.autenticar(email, pass);
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
