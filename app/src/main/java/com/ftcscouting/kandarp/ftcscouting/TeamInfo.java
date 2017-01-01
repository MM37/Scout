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
    EditText textTeamName, textTeamNumber;
    Firebase Ref;
    String text1,text2, text3, text4, text5, text6, text7, text8, text9, text10, text11;
    Spinner autoParkSpinner, autoParkTypeSpinner, autoParticleScoreSpinner, autoBeaconSpinner, teleOPParticleScoreSpinner, teleOPBeaconClaimedSpinner, teleOPCapBallSpinner;
    ArrayAdapter<CharSequence> autoParkAdapterSpinner, autoParkTypeAdapter, autoParticleScoreAdapter, autoBeaconAdapter, teleOPParticleScoreAdapter, teleOPBeaconAdapter, teleOPCapBallAdapter;
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


        cb7 = (CheckBox) findViewById(R.id.checkBox7);

        autoParkSpinner = (Spinner) findViewById(R.id.parkSpinnerMenu);
        autoParkTypeSpinner = (Spinner) findViewById(R.id.parkTypeMenu);
        autoParticleScoreSpinner = (Spinner) findViewById(R.id.particleScoreSpinnerMenu);
        autoBeaconSpinner = (Spinner) findViewById(R.id.autoBeaconSpinnerMenu);
        teleOPBeaconClaimedSpinner = (Spinner) findViewById(R.id.teleOPBeaconMenu);
        teleOPParticleScoreSpinner = (Spinner) findViewById(R.id.teleOPParticleSpinnerMenu);
        teleOPCapBallSpinner = (Spinner) findViewById(R.id.teleOPCapBallSpinnerMenu);
        
        autoParkAdapterSpinner = ArrayAdapter.createFromResource(this, R.array.park_options, android.R.layout.simple_spinner_item);
        autoParkAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        autoParkTypeAdapter = ArrayAdapter.createFromResource(this, R.array.park_types, android.R.layout.simple_spinner_item);
        autoParkTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        autoParticleScoreAdapter = ArrayAdapter.createFromResource(this, R.array.particle_scoring, android.R.layout.simple_spinner_item);
        autoParticleScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        autoBeaconAdapter = ArrayAdapter.createFromResource(this, R.array.beacon_claimed, android.R.layout.simple_spinner_item);
        autoBeaconAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        teleOPParticleScoreAdapter = ArrayAdapter.createFromResource(this, R.array.teleopparticle_scoring, android.R.layout.simple_spinner_item);
        teleOPParticleScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        teleOPBeaconAdapter = ArrayAdapter.createFromResource(this, R.array.teleopbeacon_claimed, android.R.layout.simple_spinner_item);
        teleOPBeaconAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        teleOPCapBallAdapter = ArrayAdapter.createFromResource(this, R.array.cap_ball, android.R.layout.simple_spinner_item);
        teleOPCapBallAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        autoParkSpinner.setAdapter(autoParkAdapterSpinner);
        autoParkTypeSpinner.setAdapter(autoParkTypeAdapter);
        autoParticleScoreSpinner.setAdapter(autoParticleScoreAdapter);
        autoBeaconSpinner.setAdapter(autoBeaconAdapter);
        teleOPBeaconClaimedSpinner.setAdapter(teleOPBeaconAdapter);
        teleOPParticleScoreSpinner.setAdapter(teleOPParticleScoreAdapter);
        teleOPCapBallSpinner.setAdapter(teleOPCapBallAdapter);
        
        autoParkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text1 = parent.getItemAtPosition(position).toString();
                if(text1.equalsIgnoreCase("Cannot park"))
                {
                    autoParkTypeSpinner.getSelectedView().setEnabled(false);
                    autoParkTypeSpinner.setEnabled(false);
                    text2 = "Robot" + parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        autoParkTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text2 = "Autonomous/n Robot can be parked " + parent.getItemAtPosition(position).toString() + " on " + text1;
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        autoParticleScoreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            text3 = "Particle can be scored in the " + parent.getItemAtPosition(position).toString() + " vortex";

           }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

     autoBeaconSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             text4 = parent.getItemAtPosition(position).toString() + "Beacons can be claimed";
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });

        teleOPParticleScoreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text5 = "Particle can be scored in" + parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        teleOPBeaconClaimedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text6 = parent.getItemAtPosition(position).toString() + "Beacons can be claimed";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        teleOPCapBallSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text8 = "Cap ball" + parent.getItemAtPosition(position).toString();
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


                if(cb7.isChecked()){
                    text7 = cb7.getText().toString();
                }

                text9 = "AUTONOMOUS";
                text10 = "TELE OP";
                text11 = "-------------------------------------------------------------------------------------";
                Ref.push().setValue(number);
                Ref.push().setValue(name);
                Ref.push().setValue(text9);
                Ref.push().setValue(text2);
                Ref.push().setValue(text3);
                Ref.push().setValue(text7);
                Ref.push().setValue(text4);
                Ref.push().setValue(text10);
                Ref.push().setValue(text5);
                Ref.push().setValue(text6);
                Ref.push().setValue(text8);
                Ref.push().setValue(text11);

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


