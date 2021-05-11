package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutUs extends AppCompatActivity {
    DrawerLayout drawerLayout;

    EditText etto, etsub, etmes;
    Button btsende;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);



        etto = findViewById(R.id.mto);
        etsub = findViewById(R.id.msubject);
        etmes = findViewById(R.id.mmessage);
        btsende = findViewById(R.id.msend);

        btsende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("mailto:" + etto.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, etsub.getText().toString() );
                intent.putExtra(Intent.EXTRA_SUBJECT, etmes.getText().toString() );
                startActivity(intent);
            }
        });

        drawerLayout=findViewById(R.id.drawer_layouts);
    }



    public void ClickMenu(View view){
        MainPageActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        MainPageActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainPageActivity.redirectActivity(this, MainPageActivity.class);
    }

    public void ClickDasboard(View view){
        MainPageActivity.redirectActivity(this, Dashboard.class);
    }

    public void ClickAboutUs(View view){
        recreate();

    }

    public void ClickLogOut(View view){
        MainPageActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainPageActivity.closeDrawer(drawerLayout);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}