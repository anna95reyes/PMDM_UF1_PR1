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


public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setContentView(R.layout.activity_main);

        //TextView txvSortida = findViewById(R.id.txvSortida);

        //txvSortida.setText(b.toString());

    }
}