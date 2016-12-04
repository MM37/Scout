package com.ftcscouting.kandarp.ftcscouting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class TeamInfo extends AppCompatActivity {
    Button btnBack, btnSave, btnViewInfo;
    CheckBox cb7;
    EditText textTeamName, textTeamNumber, autoBeaconClaim;
    Firebase Ref;
    String text1,text2, text7;
    Spinner parkSpinner, parkTypeSpinner;
    ArrayAdapter<CharSequence> parkAdapter, parkTypeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teaminfo);

        Ref = new Firebase("https://ftc-scouting-ad605.firebaseio.com/Information");

        btnSave = (Button) findViewById(R.id.buttonSave);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnViewInfo = (Button) findViewById(R.id.viewInfoButton);
        textTeamName = (EditText) findViewById(R.id.editTeamName);
        textTeamNumber = (EditText) findViewById(R.id.editTeamNumber);
        autoBeaconClaim = (EditText) findViewById(R.id.aBeaconNumber);

        cb7 = (CheckBox) findViewById(R.id.checkBox7);

        parkSpinner = (Spinner) findViewById(R.id.parkSpinnerMenu);
        parkTypeSpinner = (Spinner) findViewById(R.id.parkTypeMenu);
        parkAdapter = ArrayAdapter.createFromResource(this, R.array.park_options, android.R.layout.simple_spinner_item);
        parkAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkTypeAdapter = ArrayAdapter.createFromResource(this, R.array.park_types, android.R.layout.simple_spinner_item);
        parkTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkSpinner.setAdapter(parkAdapter);
        parkTypeSpinner.setAdapter(parkTypeAdapter);
        parkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text1 = parent.getItemAtPosition(position).toString();          }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        parkTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textTeamName.getText().toString();
                String number = textTeamNumber.getText().toString();
                String aBeaconNumb = "Numer of Beacon claimed = " + autoBeaconClaim.getText().toString();

                if(cb7.isChecked()){
                    text7 = cb7.getText().toString();
                }

                Ref.push().setValue(number);
                Ref.push().setValue(name);
                Ref.push().setValue(text1);
                Ref.push().setValue(text2);
                Ref.push().setValue(text7);
                Ref.push().setValue(aBeaconNumb);
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
}


