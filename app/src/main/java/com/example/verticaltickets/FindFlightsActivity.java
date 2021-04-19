package com.example.verticaltickets;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verticaltickets.adapter.RecentsAdapter;
import com.example.verticaltickets.model.RecentsData;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class FindFlightsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

    TextInputLayout From;
    AutoCompleteTextView act_From;

    TextInputLayout To;
    AutoCompleteTextView act_To;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;




    //private FirebaseAuth mAuth;

    //gelistirilicek
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_flights);

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



    }


    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = findViewById(R.id.recents_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    public void backstart(View view){
        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void nextselect(View view){
        Intent intent= new Intent(this, ChooseDay.class);
        startActivity(intent);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    /* @Override
    protected void onStart() {
        super.onStart();

        TextView textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewUser.setText("Welcome: " + mAuth.getCurrentUser().getEmail());

    }*/


    }





