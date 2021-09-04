package com.example.myvotingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myvotingapplication.adapters.customAdapter;
import com.example.myvotingapplication.adapters.customAdapter2;
import com.example.myvotingapplication.model.Data;
import com.example.myvotingapplication.model.Data2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Admin_Login extends AppCompatActivity {
    private EditText Admin_UID, Password;
    private Button Login;
    private int counter = 5;
    String admin_uid, password;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbReference;

    Data2 data;
    int count = 0;

    ListView lv;
    ArrayList<Data2> dataArrayList;
    customAdapter2 customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);

        firebaseDatabase = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference = firebaseDatabase.getReference().child("Admin_List");

        Admin_UID = (EditText)findViewById(R.id.etAdminUID);
        Password = (EditText)findViewById(R.id.etAdminPass);
        Login = (Button)findViewById(R.id.btnAdminLogin);
        //dataArrayList = new ArrayList<Data2>();
        //customAdapter = new customAdapter2(getApplicationContext(), dataArrayList);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                admin_uid = Admin_UID.getText().toString().trim();
                password = Password.getText().toString().trim();


                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(admin_uid) && (password.equals(dataSnapshot.child(admin_uid).child("password").getValue()))) {
                            Toast.makeText(getBaseContext(), "You successfully login!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Admin_Login.this, Admin_Info.class);
                            //intent.putExtra("Voter_ID", voter_id);
                            startActivity(intent);

                            Admin_UID.setText("");
                            Password.setText("");
                        } else {
                            counter--;
                            String s = "Admin UID or password incorrect\nAttempts left : "+counter;
                            Toast.makeText( Admin_Login.this, s , Toast.LENGTH_SHORT).show();
                            if(counter==0)
                            {
                                Login.setEnabled(false);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }

}