package com.example.verticaltickets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.perfmark.Tag;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("17 Haziran");

        mRef.setValue("icerik");

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
 /* @Override
    protected void onStart() {
        super.onStart();

        TextView textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewUser.setText("Welcome: " + mAuth.getCurrentUser().getEmail());

    }*/

}