package com.vukihai.soft.bigiconlauncher.list_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vukihai.soft.bigiconlauncher.R;

public class ListActivity extends AppCompatActivity {

    RecyclerView listAppRecyclerView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listAppRecyclerView = findViewById(R.id.recycle_view_list_app);
        adapter = new ListAppAdapter(this);
        listAppRecyclerView.setAdapter(adapter);
        listAppRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
