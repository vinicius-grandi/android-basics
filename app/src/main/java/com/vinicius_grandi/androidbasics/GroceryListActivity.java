package com.vinicius_grandi.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class GroceryListActivity extends AppCompatActivity {
    Resources res;
    int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        CheckBox cupCheckbox = findViewById(R.id.cup);
        CheckBox plateCheckbox = findViewById(R.id.plate);
        CheckBox forkCheckbox = findViewById(R.id.fork);
        CheckBox knifeCheckbox = findViewById(R.id.knife);
        EditText cupAmount = findViewById(R.id.cup_amount);
        EditText plateAmount = findViewById(R.id.plate_amount);
        EditText forkAmount = findViewById(R.id.fork_amount);
        EditText knifeAmount = findViewById(R.id.knife_amount);

        CheckBox[] checkboxes = {cupCheckbox, plateCheckbox, forkCheckbox, knifeCheckbox};
        EditText[] amounts = {cupAmount, plateAmount, forkAmount, knifeAmount};

        Button calculateBtn = findViewById(R.id.grocery_calculate);
        TextView result = findViewById(R.id.grocery_result);

        res = getResources();

        for (int i = 0; i < checkboxes.length; i++) {
            toggleEnabled(checkboxes[i], amounts[i]);
            setItemPrice(checkboxes[i], amounts[i]);
        }

        calculateBtn.setOnClickListener(view -> {
            @SuppressLint("DefaultLocale")
            String text = String.format("Result: $%d", totalPrice);
            result.setText(text);
        });
    }

    private void toggleEnabled(CheckBox checkbox, EditText amount) {
        checkbox.setOnClickListener(view -> {
            if (!checkbox.isChecked()) {
                int price = Integer.parseInt(
                        amount.getText().toString()) * getItemPrice(checkbox.getId()
                );
                totalPrice -= price;
                amount.setText("");
            }
            amount.setEnabled(checkbox.isChecked());
        });
    }

    private int getItemPrice(int itemId) {
        switch (itemId) {
            case (R.id.cup):
                return 3;
            case (R.id.plate):
                return 10;
            case (R.id.fork):
                return 2;
            case (R.id.knife):
                return 5;
            default:
                return 0;
        }
    }

    private void setItemPrice(CheckBox checkbox, EditText amount) {
        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (amount.getText().toString().length() < 1) {
                    amount.setText("0");
                }
                int price = Integer.parseInt(
                        amount.getText().toString()) * getItemPrice(checkbox.getId()
                );
                String text = String.format(
                        res.getString(R.string.current_item_price),
                        checkbox.getText().toString().replaceAll(" ?\\$[0-9]*", ""),
                        price
                );
                totalPrice += price;
                checkbox.setText(text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}