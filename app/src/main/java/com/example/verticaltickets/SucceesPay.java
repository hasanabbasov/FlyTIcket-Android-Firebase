package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SucceesPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succees_pay);
    }
    public void backMain(View view) {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);}
}