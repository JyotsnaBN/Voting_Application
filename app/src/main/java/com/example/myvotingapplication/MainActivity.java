package com.example.myvotingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button admin_login, voter_login, view_result;

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    Date currDate = (new Date());
    Date endDate = sdf.parse("28.04.2021 12:12:00");

    public MainActivity() throws ParseException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin_login = (Button) findViewById(R.id.btn1);
        voter_login = (Button) findViewById(R.id.btn2);
        view_result = (Button) findViewById(R.id.btn3);

        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Admin_Login.class);
                startActivity(intent);
            }
        });

        voter_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currDate.after(endDate))
                {
                    Toast.makeText(getBaseContext(), "Voting closed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, Voter_Login.class);
                    startActivity(intent);
                }
            }
        });

        view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(endDate.after(currDate))
                {
                    Toast.makeText(getBaseContext(), "Election in progress", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, View_Result.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}