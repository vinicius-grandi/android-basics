package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // numbers
        EditText firstNum = (EditText) findViewById(R.id.first_num);
        EditText secondNum = (EditText) findViewById(R.id.second_num);

        // buttons
        Button sum = (Button) findViewById(R.id.sum);
        Button sub = (Button) findViewById(R.id.sub);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button division = (Button) findViewById(R.id.div);

        // output
        TextView result = (TextView) findViewById(R.id.result);

        // listeners
        sum.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                + Double.parseDouble(secondNum.getText().toString()))
        ));
        sub.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        - Double.parseDouble(secondNum.getText().toString()))
        ));
        multiply.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        * Double.parseDouble(secondNum.getText().toString()))
        ));
        division.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        / Double.parseDouble(secondNum.getText().toString()))
        ));
    }
}