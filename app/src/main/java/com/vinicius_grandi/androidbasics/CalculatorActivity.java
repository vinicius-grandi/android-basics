package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

interface ResultSetter {
    void set(Double n);
}

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

    public String getStringFromEditText(EditText et) {
        return et.getText().toString();
    }

    public void calculate(View v) throws Exception {
        Double a = Double.parseDouble(getStringFromEditText(firstNum));
        Double b = Double.parseDouble(getStringFromEditText(secondNum));
        ResultSetter res = num -> result.setText(String.valueOf(num));

        switch (v.getId()) {
            case (R.id.sum):
                res.set(a + b);
                break;
            case (R.id.sub):
                res.set(a - b);
                break;
            case (R.id.multiply):
                res.set(a * b);
                break;
            case (R.id.div):
                res.set(a / b);
                break;
            default:
                throw new Exception("lmao");
        }
    }
}