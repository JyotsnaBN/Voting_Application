package com.example.myvotingapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.myvotingapplication.adapters.customAdapter;
import com.example.myvotingapplication.adapters.customAdapter2;
import com.example.myvotingapplication.model.Data;
import com.example.myvotingapplication.model.Data2;

import java.util.ArrayList;

public class Admin_Info extends AppCompatActivity {
    private Button logout;
    //LayoutInflater inflater;
    //int count = 0;

    ListView lv1,lv2;
    ArrayList<Data> dataArrayList1;
    ArrayList<Data2> dataArrayList2;
    FirebaseDatabase firebaseDatabase1, firebaseDatabase2;
    DatabaseReference dbReference1, dbReference2;
    Data data1;
    Data2 data2;
    customAdapter customAdapter1;
    customAdapter2 customAdapter2;


    String key1, key2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__info);


        firebaseDatabase1 = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference1 = firebaseDatabase1.getReference().child("Voter_List");

        firebaseDatabase2 = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference2 = firebaseDatabase2.getReference().child("Party_List");

        key1 = dbReference1.push().getKey();
        key2 = dbReference2.push().getKey();


        lv1 =findViewById(R.id.voter_list);
        dataArrayList1 = new ArrayList<Data>();
        customAdapter1 = new customAdapter(Admin_Info.this,dataArrayList1);
        lv1.setAdapter(customAdapter1);


        lv2 =findViewById(R.id.party_list);
        dataArrayList2 = new ArrayList<Data2>();
        customAdapter2 = new customAdapter2(Admin_Info.this,dataArrayList2);
        lv2.setAdapter(customAdapter2);




        //LOGOUT
        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Info.this, MainActivity.class);
                startActivity(intent);
            }
        });

        realTimeUpdate();
        realTimeUpdate2();



        dbReference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

                Data mData = dataSnapshot.getValue(Data.class);
                dataArrayList1.add(mData);
                customAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        dbReference2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

                Data2 mData = dataSnapshot.getValue(Data2.class);
                dataArrayList2.add(mData);
                customAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void realTimeUpdate() {
        dbReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataArrayList1.clear();

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    data1 = dataSnapshot.getValue(Data.class);
                    dataArrayList1.add(data1);
                }

                customAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    String pkey;
    int pvotes;
    private void realTimeUpdate2() {
        dbReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataArrayList2.clear();
                pvotes = Integer.valueOf(dataSnapshot.child("Party1").child("no_votes").getValue().toString());
                pkey = dataSnapshot.child("Party1").child("key").getValue().toString();
                Data2 d = new Data2(pkey, "AAP", pvotes);
                dataArrayList2.add(d);

                pvotes = Integer.valueOf(dataSnapshot.child("Party2").child("no_votes").getValue().toString());
                pkey = dataSnapshot.child("Party2").child("key").getValue().toString();
                d = new Data2(pkey, "YSR", pvotes);
                dataArrayList2.add(d);

                pvotes = Integer.valueOf(dataSnapshot.child("Party3").child("no_votes").getValue().toString());
                pkey = dataSnapshot.child("Party3").child("key").getValue().toString();
                d = new Data2(pkey, "NPP", pvotes);
                dataArrayList2.add(d);

                pvotes = Integer.valueOf(dataSnapshot.child("NOTA").child("no_votes").getValue().toString());
                pkey = dataSnapshot.child("NOTA").child("key").getValue().toString();
                d = new Data2(pkey, "NOTA", pvotes);
                dataArrayList2.add(d);


                customAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
