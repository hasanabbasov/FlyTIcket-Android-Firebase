package com.example.verticaltickets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("On Start Works!!");
    }


    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("On Resume Works!!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("On pause Mode!!!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        System.out.println("On Stop Mode!!!");
    }

    @Override
    protected void  onDestroy(){
        super.onDestroy();
        System.out.println("On Destroy Mode!!!");

    }




    public void Transfer(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}