package com.example.myvotingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myvotingapplication.adapters.customAdapter;
import com.example.myvotingapplication.model.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Voter_Login extends AppCompatActivity {

    private EditText VoterID;
    private EditText Password;
    private Button Login;
    private int counter = 5;
    String voter_id, password;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbReference;

    Data data;
    int count = 0;

    ListView lv;
    ArrayList<Data> dataArrayList;
    com.example.myvotingapplication.adapters.customAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter__login);
        firebaseDatabase = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference = firebaseDatabase.getReference().child("Voter_List");

        VoterID = (EditText)findViewById(R.id.etVoterID);
        Password = (EditText)findViewById(R.id.etVoterPass);
        Login = (Button)findViewById(R.id.btnVoterLogin);
        dataArrayList = new ArrayList<Data>();
        customAdapter = new customAdapter(getApplicationContext(), dataArrayList);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                voter_id = VoterID.getText().toString().trim();
                password = Password.getText().toString().trim();
                /*if(password.equals(dataArrayList.get(dataArrayList.indexOf(voter_id)).getPassword()))
                {
                    Intent intent = new Intent(Voter_Login.this, Voting.class);
                    intent.putExtra("Voter_ID", voter_id);
                    startActivity(intent);
                }
                else
                {
                    counter--;
                    String s = "Attempts left : "+counter;
                    Toast.makeText( Voter_Login.this, s , Toast.LENGTH_SHORT).show();
                    if(counter==0)
                    {
                        Login.setEnabled(false);
                    }
                }*/


                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(voter_id) && (password.equals(dataSnapshot.child(voter_id).child("password").getValue()))) {
                            Toast.makeText(getBaseContext(), "You successfully login!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Voter_Login.this, Voting.class);
                            intent.putExtra("Voter_ID", voter_id);
                            startActivity(intent);

                            VoterID.setText("");
                            Password.setText("");
                        } else {
                            counter--;
                            String s = "Voter ID or password incorrect\nAttempts left : "+counter;
                            Toast.makeText( Voter_Login.this, s , Toast.LENGTH_SHORT).show();
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


    public void func(){

        if (count != 0){
            customAdapter = new customAdapter(getApplicationContext(), dataArrayList);
            dataArrayList.indexOf(voter_id);

            lv.setAdapter(customAdapter);
        }else {
            Toast.makeText(this, "The list is empty", Toast.LENGTH_SHORT).show();
            lv.setVisibility(View.GONE);
        }

    }

    /*@Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Voter_Login.this, MainActivity.class);
        intent.putExtra("Voter_ID", voter_id);
    }*/
    /*private void validate(String Voter_ID,String userPassword)
    {
        if((Voter_ID.equals("Admin")) && (userPassword.equals("1234")))
        {
            Intent intent = new Intent(Voter_Login.this, Voting.class);
            intent.putExtra("Voter_ID", Voter_ID);
            startActivity(intent);
        }
        else
        {
            counter--;
            String s = "Attempts left : "+counter;
            Toast.makeText( Voter_Login.this, s , Toast.LENGTH_SHORT).show();
            if(counter==0)
            {
                Login.setEnabled(false);
            }
        }
    }*/
}