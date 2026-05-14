package com.angelemanuel.inmobiliariaangel.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelemanuel.inmobiliariaangel.databinding.FragmentPerfilBinding;
import com.angelemanuel.inmobiliariaangel.modelo.Propietario;

public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;
    private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupObservers();
        perfilViewModel.cargarPerfil();

        return root;
    }

    private void setupObservers() {
        perfilViewModel.getPropietarioMutable().observe(getViewLifecycleOwner(), propietario -> {
            if (propietario != null) {
                llenarCampos(propietario);
            }
        });

        perfilViewModel.getErrorMutable().observe(getViewLifecycleOwner(), error -> {
            if (error != null && !error.isEmpty()) {
                Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void llenarCampos(Propietario p) {
        binding.etDni.setText(p.getDni());
        binding.etNombre.setText(p.getNombre());
        binding.etApellido.setText(p.getApellido());
        binding.etTelefono.setText(p.getTelefono());
        binding.etEmail.setText(p.getEmail());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
