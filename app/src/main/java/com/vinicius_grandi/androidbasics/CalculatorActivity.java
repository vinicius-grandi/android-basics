package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        sum.setOnClickListener(view -> {
            result.setText(
                    String.valueOf(Double.parseDouble(firstNum.getText().toString())
                            + Double.parseDouble(secondNum.getText().toString()))
            );
            hideKeyboard();
        });
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

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        }
    }
}