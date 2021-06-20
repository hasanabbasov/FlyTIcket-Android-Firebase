package com.example.verticaltickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.example.verticaltickets.adapter.RecentsAdapter;
import com.example.verticaltickets.model.RecentsData;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainPageActivity extends AppCompatActivity {
    //Initalize variable
    DrawerLayout drawerLayout;

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;



    //Spinner From To
    Spinner spinner;
    Spinner spinner1;
    DatabaseReference databaseReference;
    List<String> country;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        country = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("tableCountry").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot chilSnapshot: snapshot.getChildren()) {
                    String spinnerCountry = chilSnapshot.child("country").getValue(String.class);
                    country.add(spinnerCountry);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>( MainPageActivity.this, android.R.layout.simple_spinner_item,country);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner.setAdapter(arrayAdapter);
                spinner1.setAdapter(arrayAdapter);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //*******************




       /* arrayList = new ArrayList<>();
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");
        arrayList.add("Baku");*/







        //**** Best Tour
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);


    }
    public void paymetss(View view) {
        Intent intent = new Intent(this, paymentActivity.class);
        startActivity(intent);}
}