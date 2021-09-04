package com.example.myvotingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class View_Result extends AppCompatActivity {
    TextView res1,res2,res3,res4;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__result);
        firebaseDatabase = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference = firebaseDatabase.getReference();


        res1 = findViewById(R.id.result1);
        res2 = findViewById(R.id.result2);
        res3 = findViewById(R.id.result3);
        res4 = findViewById(R.id.result4);



        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                res1.setText(dataSnapshot.child("Party_List").child("Party1").child("no_votes").getValue().toString());
                res2.setText(dataSnapshot.child("Party_List").child("Party2").child("no_votes").getValue().toString());
                res3.setText(dataSnapshot.child("Party_List").child("Party3").child("no_votes").getValue().toString());
                res4.setText(dataSnapshot.child("Party_List").child("NOTA").child("no_votes").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}