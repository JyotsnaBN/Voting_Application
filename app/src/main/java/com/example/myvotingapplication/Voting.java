package com.example.myvotingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Voting extends AppCompatActivity {
    private Button vote1;
    private Button vote2;
    private Button vote3;
    private Button vote4;
    boolean x = false;
    private int count = 0;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbReference, dbReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        firebaseDatabase = FirebaseDatabase.getInstance("https://my-voting-application-fcaf1-default-rtdb.firebaseio.com/");
        dbReference = firebaseDatabase.getReference();
        dbReference1 = firebaseDatabase.getReference();

        String voterID = getIntent().getStringExtra("Voter_ID");

        vote1 = (Button) findViewById(R.id.btn1);
        vote2 = (Button) findViewById(R.id.btn2);
        vote3 = (Button) findViewById(R.id.btn3);
        vote4 = (Button) findViewById(R.id.btn4);

        vote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = true;

                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("Voter_List").hasChild(voterID) && (dataSnapshot.child("Voter_List").child(voterID).child("voted").getValue().toString()).equals("no"))
                        {
                            Toast.makeText(getBaseContext(), "You have cast your vote successfully", Toast.LENGTH_SHORT).show();
                            dbReference.child("Voter_List").child(voterID).child("voted").setValue("yes");

                            ValueEventListener postListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // Get Post object and use the values to update the UI
                                    count = Integer.valueOf(dataSnapshot.child("Party_List").child("Party1").child("no_votes").getValue().toString());
                                    if(x)
                                    {
                                        x = false;
                                        count++;
                                        dbReference1.child("Party_List").child("Party1").child("no_votes").setValue(count);
                                    }
                                    // ..
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            };
                            dbReference.addValueEventListener(postListener);

                        } else {
                            Toast.makeText( Voting.this, "You have already cast your vote" , Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(Voting.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = true;

                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("Voter_List").hasChild(voterID) && (dataSnapshot.child("Voter_List").child(voterID).child("voted").getValue().toString()).equals("no"))
                        {
                            Toast.makeText(getBaseContext(), "You have cast your vote successfully", Toast.LENGTH_SHORT).show();
                            dbReference.child("Voter_List").child(voterID).child("voted").setValue("yes");

                            ValueEventListener postListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // Get Post object and use the values to update the UI
                                    count = Integer.valueOf(dataSnapshot.child("Party_List").child("Party2").child("no_votes").getValue().toString());
                                    if(x)
                                    {
                                        x = false;
                                        count++;
                                        dbReference1.child("Party_List").child("Party2").child("no_votes").setValue(count);
                                    }
                                    // ..
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            };
                            dbReference.addValueEventListener(postListener);

                        } else {
                            Toast.makeText( Voting.this, "You have already cast your vote" , Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(Voting.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


        vote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = true;

                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("Voter_List").hasChild(voterID) && (dataSnapshot.child("Voter_List").child(voterID).child("voted").getValue().toString()).equals("no"))
                        {
                            Toast.makeText(getBaseContext(), "You have cast your vote successfully", Toast.LENGTH_SHORT).show();
                            dbReference.child("Voter_List").child(voterID).child("voted").setValue("yes");

                            ValueEventListener postListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // Get Post object and use the values to update the UI
                                    count = Integer.valueOf(dataSnapshot.child("Party_List").child("Party3").child("no_votes").getValue().toString());
                                    if(x)
                                    {
                                        x = false;
                                        count++;
                                        dbReference1.child("Party_List").child("Party3").child("no_votes").setValue(count);
                                    }
                                    // ..
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            };
                            dbReference.addValueEventListener(postListener);

                        } else {
                            Toast.makeText( Voting.this, "You have already cast your vote" , Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(Voting.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });



        vote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = true;

                dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("Voter_List").hasChild(voterID) && (dataSnapshot.child("Voter_List").child(voterID).child("voted").getValue().toString()).equals("no"))
                        {
                            Toast.makeText(getBaseContext(), "You have cast your vote successfully", Toast.LENGTH_SHORT).show();
                            dbReference.child("Voter_List").child(voterID).child("voted").setValue("yes");

                            ValueEventListener postListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // Get Post object and use the values to update the UI
                                    count = Integer.valueOf(dataSnapshot.child("Party_List").child("NOTA").child("no_votes").getValue().toString());
                                    if(x)
                                    {
                                        x = false;
                                        count++;
                                        dbReference1.child("Party_List").child("NOTA").child("no_votes").setValue(count);
                                    }
                                    // ..
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            };
                            dbReference.addValueEventListener(postListener);

                        } else {
                            Toast.makeText( Voting.this, "You have already cast your vote" , Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(Voting.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });




        /*private void updateData() {
            database = FirebaseDatabase.getInstance();
            myref = database.getReference();
            myref.child("myDb").child("awais@gmailcom").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    dataSnapshot.getRef().child("leftSpace").setValue(newValue);
                    dialog.dismiss();

                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("User", databaseError.getMessage());
                }
            });
        }*/

    }
}
