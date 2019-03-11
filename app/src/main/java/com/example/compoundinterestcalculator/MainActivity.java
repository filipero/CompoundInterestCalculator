package com.example.compoundinterestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    EditText edtPrincipal, edtRate, edtCompoundPerYear, edtYears;
    TextView txtAnswer;
    Button btnClear, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonLogic();
    }

    private void buttonLogic(){
        btnCalculate = findViewById(R.id.buttonCalculate);
        btnClear = findViewById(R.id.buttonClear);
        txtAnswer = findViewById(R.id.textViewAnswers);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogic();
                dismissKeyboard();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearLogic();
                dismissKeyboard();
            }
        });

        txtAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             dismissKeyboard();
            }
        });
    }

    private void calculateLogic(){

        edtPrincipal = findViewById(R.id.editTextPrincipal);
        edtCompoundPerYear = findViewById(R.id.editTextCompoundPerYear);
        edtRate = findViewById(R.id.editTextRate);
        edtYears = findViewById(R.id.editTextYears);

        txtAnswer = findViewById(R.id.textViewAnswers);

        Double principal = Double.parseDouble(edtPrincipal.getText().toString());
        Double rate = Double.parseDouble(edtRate.getText().toString());
        Double compoundPerYear = Double.parseDouble(edtCompoundPerYear.getText().toString());
        Double years = Double.parseDouble(edtYears.getText().toString());
        Double answer = principal * Math.pow(1 +((rate*0.01)/ compoundPerYear), compoundPerYear * years);

        String formatAnswer = String.format("%1.2f", answer);

        txtAnswer.setText("$" + formatAnswer);
    }

    private void clearLogic(){
        edtPrincipal = findViewById(R.id.editTextPrincipal);
        edtCompoundPerYear = findViewById(R.id.editTextCompoundPerYear);
        edtRate = findViewById(R.id.editTextRate);
        edtYears = findViewById(R.id.editTextYears);

        txtAnswer = findViewById(R.id.textViewAnswers);

        edtPrincipal.setText("");
        edtCompoundPerYear.setText("");
        edtRate.setText("");
        edtYears.setText("");

        txtAnswer.setText("Answer");
    }

    private void dismissKeyboard(){
        edtPrincipal = findViewById(R.id.editTextPrincipal);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtPrincipal.getWindowToken(),0);
    }

    public void onClick(){
        dismissKeyboard();
    }

}
