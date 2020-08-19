package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView myListview;
    ArrayList<String> myFamily = new ArrayList<String>();
    /* Another way to add items to the list, this may save lines of code
    ArrayList<String> myFamily=new ArrayList<String>(asList("Joey","Chandler","Ross")); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListview = findViewById(R.id.list_view);
        myFamily.add("Joey");
        myFamily.add("Chandler");
        myFamily.add("Ross");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily);
        myListview.setAdapter(arrayAdapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Person Tapped:", myFamily.get(i));
                Toast.makeText(MainActivity.this, myFamily.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}