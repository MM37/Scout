package com.ftcscouting.kandarp.ftcscouting;

import android.app.Application;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by Kandarp on 11/27/2016.
 */

public class GetInfo extends AppCompatActivity {

    private Firebase gRef;
    private ListView listView;
    private ArrayList<String> userNames = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getinfo);

        listView = (ListView) findViewById(R.id.listViewList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, userNames);
        listView.setAdapter(adapter);
        gRef = new Firebase("URL Here");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userNames);
        listView.setAdapter(arrayAdapter);
        gRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String val = dataSnapshot.getValue(String.class);
                userNames.add(val);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {



            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {



            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}