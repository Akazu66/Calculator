package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        resultText = findViewById(R.id.resultText);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1, num2;
                try {
                    num1 = Double.parseDouble(number1.getText().toString());
                    num2 = Double.parseDouble(number2.getText().toString());
                } catch (NumberFormatException e) {
                    resultText.setText("숫자를 정확히 입력하세요.");
                    return;
                }

                double result = 0;
                if (v.getId() == R.id.btnAdd) {
                    result = num1 + num2;
                } else if (v.getId() == R.id.btnSub) {
                    result = num1 - num2;
                } else if (v.getId() == R.id.btnMul) {
                    result = num1 * num2;
                } else if (v.getId() == R.id.btnDiv) {
                    if (num2 == 0) {
                        resultText.setText("0으로 나눌 수 없습니다.");
                        return;
                    }
                    result = num1 / num2;
                }

                resultText.setText("Result: " + result);
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }
}