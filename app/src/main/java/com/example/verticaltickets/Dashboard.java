package com.example.verticaltickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;

    ListView listViewFly;
    private ListAdapterFly adap;
    private List<AdapterFly> fListAdapter;

    //Firbase
    FirebaseDatabase database;
    DatabaseReference tableRef;
    //For Data push Adapter
    ArrayList<String> arrayFrom = new ArrayList<>();
    ArrayList<String> arrayTo = new ArrayList<>();
    ArrayList<String> arrayDate = new ArrayList<>();
    ArrayList<String> arrayTime = new ArrayList<>();
    ArrayList<String> arrayCost = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        fListAdapter = new ArrayList<>();

       // fListAdapter.add(new AdapterFly("baku", "baku", "12 21 21", "12:12", "123$"));
       // fListAdapter.add(new AdapterFly("baku", "baku", "12 21 21", "12:12", "123$"));

        listViewFly = (ListView)findViewById(R.id.listViewFlys);

        // Read Data

        database = FirebaseDatabase.getInstance();
        tableRef = database.getReference("tableFlyList");

        tableRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()){

                    Map<String,String> map = (Map<String, String>) postSnapshot.getValue();

                    if (map.get("from")!=null && map.get("to")!=null && map.get("date")!=null && map.get("time")!=null && map.get("cost")!=null){

                        arrayFrom.add(map.get("from").toString());
                        arrayTo.add(map.get("to").toString());
                        arrayDate.add(map.get("date").toString());
                        arrayTime.add(map.get("time").toString());
                        arrayCost.add(map.get("cost").toString());

                    }

                }

                for (int i = 0 ; i<arrayFrom.size() ; i++){
                    fListAdapter.add(new AdapterFly(arrayFrom.get(i), arrayTo.get(i), arrayDate.get(i), arrayTime.get(i), arrayCost.get(i)));

                }
                listViewFly.invalidateViews();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });




        adap = new ListAdapterFly(getApplicationContext(),fListAdapter);
        listViewFly.setAdapter(adap);

        //Draw Meni

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