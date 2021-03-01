package com.thewitcherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.SelectedItemListener;
import com.adapters.MonstersAdapter;
import com.example.Bestiary;
import com.google.gson.Gson;
import com.thewitcherapp.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

//import com.thewitcherapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SelectedItemListener {

    ActivityMainBinding binding;
    RecyclerView rcyLlistaMonsters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);

        //TextView txvSortida = findViewById(R.id.txvSortida);

        Bestiary b = loadBestiary();
        //txvSortida.setText(b.toString());


        rcyLlistaMonsters = findViewById(R.id.rcyLlistaMonsters);
        rcyLlistaMonsters.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        rcyLlistaMonsters.setHasFixedSize(true);
        // ara li posem l'adapter
        MonstersAdapter adapter = new MonstersAdapter(b.getMonsters(),this, this);
        rcyLlistaMonsters.setAdapter(adapter);

    }


    private Bestiary loadBestiary() {
        String json = loadJSON();
        Gson gson = new Gson();
        return gson.fromJson(json, Bestiary.class);
    }

    private String loadJSON(){
        String json = "";
        InputStream is = null;
        try {
            is = getResources().openRawResource(R.raw.bestiary);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader reader2 = new BufferedReader(reader);

            String line = "";
            try {
                while ((line = reader2.readLine()) != null) {
                    json += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } finally {
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    @Override
    public void onSelectedItem(int filaSeleccionada) {
    }
}