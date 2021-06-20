package com.example.verticaltickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class TicketListActivity extends AppCompatActivity {

    ListView listViewFly2;
    private ListAdapterFly adap;
    private List<AdapterFly> fListAdapter;

    //Firbase
    FirebaseDatabase database;
    DatabaseReference tableRef;

    ArrayList<String> arrayFrom = new ArrayList<>();
    ArrayList<String> arrayTo = new ArrayList<>();
    ArrayList<String> arrayDate = new ArrayList<>();
    ArrayList<String> arrayTime = new ArrayList<>();
    ArrayList<String> arrayCost = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);

        fListAdapter = new ArrayList<>();

        listViewFly2 = (ListView)findViewById(R.id.listViewFlys2);


        database = FirebaseDatabase.getInstance();
        tableRef = database.getReference("tableFlyList22");

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
                listViewFly2.invalidateViews();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });




        adap = new ListAdapterFly(getApplicationContext(),fListAdapter);
        listViewFly2.setAdapter(adap);
    }

    public void backfind2(View view){
        Intent intent = new Intent(this,MainPageActivity.class);
        startActivity(intent);
    }

    public void paymets(View view) {
        Intent intent = new Intent(this, paymentActivity.class);
        startActivity(intent);
    }
}