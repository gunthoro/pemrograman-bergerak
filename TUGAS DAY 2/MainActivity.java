package com.example.latihan1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private String input = "";
    private double value1, value2;
    private char operator;
    private boolean hasDot = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        Button subtractButton = findViewById(R.id.button_subtract);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        Button multiplyButton = findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        Button divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    private void performOperation(char operator) {
        EditText val1EditText = findViewById(R.id.val1);
        EditText val2EditText = findViewById(R.id.val2);

        // Periksa apakah kedua EditText berisi angka yang valid
        if (val1EditText.getText().toString().isEmpty() || val2EditText.getText().toString().isEmpty()) {
            // Jika salah satu EditText kosong, beri tahu pengguna
            Toast.makeText(this, "Masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
            return; // Hentikan proses perhitungan
        }
        double val1 = Double.parseDouble(val1EditText.getText().toString());
        double val2 = Double.parseDouble(val2EditText.getText().toString());

        double result = calculate(val1, val2, operator);

        TextView hasilTextView = findViewById(R.id.tvhasil);
        hasilTextView.setText(String.valueOf(result));
    }

    private double calculate(double val1, double val2, char operator) {
        switch (operator) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                if (val2 != 0)
                    return val1 / val2;
                else
                    return Double.NaN;
            default:
                return Double.NaN;
        }
    }
}
