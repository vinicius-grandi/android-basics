package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    EditText firstNum;
    EditText secondNum;
    TextView result;


    public void sum(View view) {
        result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        + Double.parseDouble(secondNum.getText().toString()))
        );
        hideKeyboard();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // numbers

        firstNum = findViewById(R.id.first_num);
        secondNum = findViewById(R.id.second_num);
        result = findViewById(R.id.result);

        // buttons
        Button subBtn = findViewById(R.id.sub);
        Button multiplyBtn = findViewById(R.id.multiply);
        Button divisionBtn = findViewById(R.id.div);

        // listeners
        subBtn.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        - Double.parseDouble(secondNum.getText().toString()))
        ));
        multiplyBtn.setOnClickListener(view -> result.setText(
                String.valueOf(Double.parseDouble(firstNum.getText().toString())
                        * Double.parseDouble(secondNum.getText().toString()))
        ));
        divisionBtn.setOnClickListener(view -> result.setText(
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