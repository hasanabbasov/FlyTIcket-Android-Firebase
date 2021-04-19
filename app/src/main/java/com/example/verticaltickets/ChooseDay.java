package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_day);
    }

    public void backfind(View view){
        Intent intent = new Intent(this,FindFlightsActivity.class);
        startActivity(intent);
    }
}