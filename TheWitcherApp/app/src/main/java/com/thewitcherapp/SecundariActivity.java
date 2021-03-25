package com.thewitcherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SecundariActivity extends AppCompatActivity {

    RadioButton rdbPagPrincipal, rdbPagSecundaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_secundari);

        //TextView txvSortida = findViewById(R.id.txvSortida);

        //txvSortida.setText(b.toString());

        rdbPagPrincipal = findViewById(R.id.rdbPagPrincipal);
        rdbPagSecundaria = findViewById(R.id.rdbPagPrincipal);

        rdbPagPrincipal.setChecked(false);
        rdbPagSecundaria.setChecked(true);

    }

    public void click_alchemy(View view) {
        //Intent i = new Intent(this, BestiaryActivity.class);
        //setResult(BestiaryActivity.RESULT_OK,i);
        //startActivity(i);
    }

    public void click_activity_main(View view) {
        Intent i = new Intent();
        setResult(MainActivity.RESULT_OK,i);
        finish();

    }
}