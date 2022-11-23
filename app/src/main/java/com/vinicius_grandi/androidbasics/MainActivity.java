package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textOutput = (TextView) findViewById(R.id.text_view_output);

        TextInputEditText textInput = (TextInputEditText) findViewById(R.id.text_view_input);
        Intent myIntent = new Intent(this, CalculatorActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Button surpriseBtn = (Button) findViewById(R.id.surprise_btn);
        surpriseBtn.setOnClickListener(view -> startActivity(myIntent));
    }
}