package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent currIntent = getIntent();
        String newText = currIntent.getStringExtra("new_text");

        TextView about = findViewById(R.id.about_text);
        about.setText(newText);

        Button backToGrocery = findViewById(R.id.back_to_grocery_list_btn);
        backToGrocery.setOnClickListener(v -> this.finish());
    }
}