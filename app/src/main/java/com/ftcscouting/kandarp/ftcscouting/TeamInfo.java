package com.ftcscouting.kandarp.ftcscouting;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class TeamInfo extends AppCompatActivity {
    private Button btnsave;
    Button btnBack;
    Button btnViewInfo;
    CheckBox appCB;
    private EditText textTeamName, textTeamNumber;
    TextView teamName, teamNumber;
    private Firebase nameRef, numRef, aoneRef;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teaminfo);

        nameRef = new Firebase("https://ftc-scouting-ad605.firebaseio.com/Information");
        numRef = new Firebase("https://ftc-scouting-ad605.firebaseio.com/Information");
        aoneRef = new Firebase("https://ftc-scouting-ad605.firebaseio.com/Information");


        btnsave = (Button) findViewById(R.id.buttonSave);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnViewInfo = (Button) findViewById(R.id.viewInfoButton);
        textTeamName = (EditText) findViewById(R.id.editTeamName);
        textTeamNumber = (EditText) findViewById(R.id.editTeamNumber);
        appCB = (CheckBox) findViewById(R.id.aPartParkcheckBox);

        btnsave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textTeamName.getText().toString();
                String number = textTeamNumber.getText().toString();
                StringBuffer OUTPUT = new StringBuffer();


                numRef.push().setValue(number);
                nameRef.push().setValue(name);


            }
        });


        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen1 = new Intent(TeamInfo.this, Scouting.class);
                startActivity(screen1);
            }
        });
    }

        public void OnCheckBoxClicked(View view){

        boolean checked = ((CheckBox) view).isChecked();
            switch(view.getId()){
                case R.id.aPartParkcheckBox:
                    if(checked) {
                        aoneRef.push().setValue("Robot Partially Park in Center");
                    }
                    else
                        return;
            }
    }

    }
