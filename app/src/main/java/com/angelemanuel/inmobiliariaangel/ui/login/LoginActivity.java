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
        loginViewModel.getToken().observe(this, token -> {
            saveToken(token);
            navigateToMain();
        });

        loginViewModel.getError().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });

        loginViewModel.getLoading().observe(this, isLoading -> {
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

    private void saveToken(String token) {
        SharedPreferences sp = getSharedPreferences("auth_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", "Bearer " + token);
        editor.apply();
    }

    private void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
