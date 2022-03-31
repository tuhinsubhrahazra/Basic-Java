package com.tuhin.basicjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    EditText num;
    Button okButton;
    public static BlankFragment dilog;
    public static ArrayList<custom> arrayList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.num);
        okButton = findViewById(R.id.okButton);
        recycleView = findViewById(R.id.recycleView);

        setRecycleView();
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(String.valueOf(num.getText()));
                Toast.makeText(MainActivity.this, ""+n, Toast.LENGTH_SHORT).show();
                for (int i =0;i<n;i++){
                    dilog = new BlankFragment();
                    dilog.show(getSupportFragmentManager(),"Dialog");
                }
                setRecycleView();
            }
        });
    }

    public void setRecycleView(){
        listAdapter listAdapter = new listAdapter(getApplicationContext(),arrayList);
        recycleView.setAdapter(listAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                RecyclerView.VERTICAL,false));
    }
}