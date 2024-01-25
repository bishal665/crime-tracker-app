package com.example.project_6thsem;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AdminPanel extends AppCompatActivity

{
    MainAdapter mainAdapter;
@Override
protected void onCreate(Bundle b){
    super.onCreate(b);
    setContentView(R.layout.adminpage);
    RecyclerView recyclerView = findViewById(R.id.rv);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    FirebaseRecyclerOptions<MainModel> options=new FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(FirebaseDatabase.getInstance().getReference().child("crime"),MainModel.class)
            .build();
     mainAdapter=new MainAdapter(options);
    recyclerView.setAdapter(mainAdapter);
}

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();

    }

    @Override
    protected void onStop() {
    mainAdapter.stopListening();
        super.onStop();
    }
}
