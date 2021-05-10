package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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
}