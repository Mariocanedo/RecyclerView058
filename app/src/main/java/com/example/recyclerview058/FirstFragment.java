package com.example.recyclerview058;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerview058.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    //  1-creamos un list que representes los datos
    private List<String> datalist = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// PARA PROBAR QUE HAY DATOS
      Log.d("Listado",setData().toString());

        // 1 INSTANCIAR EL ADAPTER Y LE PASAMOS LOS DATOS CON EL METODO PALABRAS
        WordAdapter adapter = new WordAdapter(setData());
        // 2 LE PASAMOS EL ADAPTER AL RECYCLER VIEW
        binding.recyclerview1.setAdapter(adapter);
        //3 Le indicamos al recyclerview como mostrar los datos

        binding.recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview1.setHasFixedSize(true);
    }


    // paso 2 crear listado de palabras
    private List<String> setData() {

        for (int i = 0; i < 99; i++) {
            datalist.add("Palabra:" + i);
        }
        return datalist;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}