package com.thewitcherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.SelectedItemListener;
import com.adapters.MonsterAdapter;
import com.adapters.MonsterTypeAdapter;
import com.example.Bestiary;
import com.example.MonsterType;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.thewitcherapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements SelectedItemListener {

    ActivityMainBinding binding;
    RecyclerView rcyLlistaMonstersType;
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


        rcyLlistaMonstersType = findViewById(R.id.rcyLlistaMonstersType);
        rcyLlistaMonstersType.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        rcyLlistaMonstersType.setHasFixedSize(true);
        // ara li posem l'adapter
        MonsterTypeAdapter adapterMonsterType = new MonsterTypeAdapter(b.getMonsterTypes(),this, this);
        rcyLlistaMonstersType.setAdapter(adapterMonsterType);

        rcyLlistaMonsters = findViewById(R.id.rcyLlistaMonsters);
        rcyLlistaMonsters.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false));
        rcyLlistaMonsters.setHasFixedSize(true);

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
    public void onSelectedItem(MonsterType monsterType) {
        Bestiary b = loadBestiary();
        MonsterAdapter adapterMonster = new MonsterAdapter(monsterType.getEntries(),this, this);
        rcyLlistaMonsters.setAdapter(adapterMonster);
    }
}