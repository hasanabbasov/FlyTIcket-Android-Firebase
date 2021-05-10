package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.verticaltickets.adapter.RecentsAdapter;
import com.example.verticaltickets.model.RecentsData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {
    //Initalize variable
    DrawerLayout drawerLayout;

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

    TextInputLayout From;
    AutoCompleteTextView act_From;

    TextInputLayout To;
    AutoCompleteTextView act_To;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //*******************
        From = (TextInputLayout) findViewById(R.id.From);
        act_From = (AutoCompleteTextView) findViewById(R.id.act_From);

        To = (TextInputLayout) findViewById(R.id.To);
        act_To = (AutoCompleteTextView) findViewById(R.id.act_To);

        arrayList = new ArrayList<>();
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList);

        act_From.setAdapter(arrayAdapter);
        act_From.setThreshold(1);

        act_To.setAdapter(arrayAdapter);
        act_To.setThreshold(1);

        //add some dummy data in our model class
        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData(" Baku", "From 300$", R.drawable.baki));
        recentsDataList.add(new RecentsData("Istanbul", "From 300$", R.drawable.istanbul));
        recentsDataList.add(new RecentsData("Baku", "From 300$", R.drawable.baki));

        setRecentRecycler(recentsDataList);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {
        recentRecycler = findViewById(R.id.recents_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close driwer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickDasboard(View view){
        //Recreate activity to dashboard
        redirectActivity(this,Dashboard.class);
    }

    public void ClickAboutUs(View view) {
        //Redirect activity to about us
        redirectActivity(this,AboutUs.class );
    }

    public void ClickLogOut(View view){
        //Close app
        logout(this);
    }

    static void logout(final Activity activity) {
        //Initialaze alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });

        //Negative no button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();

    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //Set flog
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);

    }

    public void nextselect(View view){
        Intent intent= new Intent(this, ChooseDay.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}