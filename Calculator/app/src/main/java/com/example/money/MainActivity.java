
package com.example.money;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentNumber = "0";
    private String previousNumber = "";
    private String operation = "";
    private boolean isNewOperation = true;

    // Ключи для сохранения состояния
    private static final String KEY_CURRENT_NUMBER = "currentNumber";
    private static final String KEY_PREVIOUS_NUMBER = "previousNumber";
    private static final String KEY_OPERATION = "operation";
    private static final String KEY_IS_NEW_OPERATION = "isNewOperation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Восстанавливаем состояние если есть
        if (savedInstanceState != null) {
            currentNumber = savedInstanceState.getString(KEY_CURRENT_NUMBER, "0");
            previousNumber = savedInstanceState.getString(KEY_PREVIOUS_NUMBER, "");
            operation = savedInstanceState.getString(KEY_OPERATION, "");
            isNewOperation = savedInstanceState.getBoolean(KEY_IS_NEW_OPERATION, true);
        }

        initViews();
        updateDisplay();
    }

    // Сохраняем состояние перед уничтожением Activity
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CURRENT_NUMBER, currentNumber);
        outState.putString(KEY_PREVIOUS_NUMBER, previousNumber);
        outState.putString(KEY_OPERATION, operation);
        outState.putBoolean(KEY_IS_NEW_OPERATION, isNewOperation);
    }

    private void initViews() {
        tvDisplay = findViewById(R.id.tvDisplay);

        // Назначаем обработчики для цифровых кнопок
        setNumberButtonClick(R.id.btnZero, "0");
        setNumberButtonClick(R.id.btnOne, "1");
        setNumberButtonClick(R.id.btnTwo, "2");
        setNumberButtonClick(R.id.btnThree, "3");
        setNumberButtonClick(R.id.btnFour, "4");
        setNumberButtonClick(R.id.btnFive, "5");
        setNumberButtonClick(R.id.btnSix, "6");
        setNumberButtonClick(R.id.btnSeven, "7");
        setNumberButtonClick(R.id.btnEight, "8");
        setNumberButtonClick(R.id.btnNine, "9");

        // Обработчики для операций
        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperation("+"));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> setOperation("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperation("×"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperation("÷"));
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());
        findViewById(R.id.btnDecimal).setOnClickListener(v -> addDecimal());
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());
        findViewById(R.id.btnPercent).setOnClickListener(v -> calculatePercent());
        findViewById(R.id.btnPlusMinus).setOnClickListener(v -> toggleSign());
    }

    private void setNumberButtonClick(int buttonId, String number) {
        findViewById(buttonId).setOnClickListener(v -> appendNumber(number));
    }

    private void appendNumber(String number) {
        if (isNewOperation) {
            currentNumber = number;
            isNewOperation = false;
        } else {
            if (currentNumber.equals("0")) {
                currentNumber = number;
            } else {
                currentNumber += number;
            }
        }
        updateDisplay();
    }

    private void addDecimal() {
        if (!currentNumber.contains(".")) {
            currentNumber += ".";
            updateDisplay();
        }
    }

    private void setOperation(String op) {
        if (!previousNumber.isEmpty() && !isNewOperation) {
            calculateResult();
        }
        operation = op;


        previousNumber = currentNumber;
        isNewOperation = true;
    }

    private void calculateResult() {
        if (previousNumber.isEmpty() || operation.isEmpty()) return;

        double result = 0;
        double prev = Double.parseDouble(previousNumber);
        double current = Double.parseDouble(currentNumber);

        switch (operation) {
            case "+":
                result = prev + current;
                break;
            case "-":
                result = prev - current;
                break;
            case "×":
                result = prev * current;
                break;
            case "÷":
                if (current != 0) {
                    result = prev / current;
                } else {
                    tvDisplay.setText("Error");
                    return;
                }
                break;
        }

        currentNumber = String.valueOf(result);
        // Убираем .0 у целых чисел
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }

        operation = "";
        previousNumber = "";
        isNewOperation = true;
        updateDisplay();
    }

    private void clear() {
        currentNumber = "0";
        previousNumber = "";
        operation = "";
        isNewOperation = true;
        updateDisplay();
    }

    private void calculatePercent() {
        double number = Double.parseDouble(currentNumber);
        currentNumber = String.valueOf(number / 100);
        updateDisplay();
    }

    private void toggleSign() {
        if (!currentNumber.equals("0")) {
            if (currentNumber.startsWith("-")) {
                currentNumber = currentNumber.substring(1);
            } else {
                currentNumber = "-" + currentNumber;
            }
            updateDisplay();
        }
    }

    private void updateDisplay() {
        tvDisplay.setText(currentNumber);
    }
}