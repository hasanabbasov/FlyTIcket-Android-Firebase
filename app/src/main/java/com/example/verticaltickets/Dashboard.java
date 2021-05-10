package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layouts);
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
        recreate();
    }

    public void ClickAboutUs(View view){
        MainPageActivity.redirectActivity(this, AboutUs.class);
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