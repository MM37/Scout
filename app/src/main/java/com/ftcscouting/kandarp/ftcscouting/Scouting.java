package com.ftcscouting.kandarp.ftcscouting;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.Button;


public class Scouting extends Activity {
    Button btnAdd;
    Button btnViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);
        btnAdd = (Button) findViewById(R.id.ButtonAdd);
        btnViewInfo = (Button) findViewById(R.id.viewInfoButton);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                Intent intent = new Intent(Scouting.this, TeamInfo.class);
                startActivity(intent);

            }
        });

        btnViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Scouting.this, GetInfo.class);
                startActivity(intent2);
            }
        });
    }
}

