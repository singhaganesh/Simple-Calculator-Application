package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView input,answer;
    Button btn_00,remainder,delete,division,one,two,three,four,five,six,seven,eight,nine,zero,all_clear,dot,equals,multiplication,subtraction,addition;
    String CurrentInput = "";
    String finalAnswer = "";
    boolean equal = false;
    String operation = "";
    String preAnswer = "";
    double finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        input = findViewById(R.id.txt_input);
        answer = findViewById(R.id.txt_answer);


        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        zero = findViewById(R.id.btn_zero);
        btn_00 = findViewById(R.id.btn_00);
        all_clear = findViewById(R.id.btn_all_clear);
        equals = findViewById(R.id.btn_equals);
        delete = findViewById(R.id.btn_delete);
        addition = findViewById(R.id.btn_addition);
        subtraction = findViewById(R.id.btn_subtraction);
        multiplication = findViewById(R.id.btn_multiplication);
        remainder = findViewById(R.id.btn_remainder);
        division = findViewById(R.id.btn_division);
        dot = findViewById(R.id.btn_dot);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("0");
            }
        });

        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realTimeCalculate("00");
            }
        });

        all_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentInput = "";
                input.setText(CurrentInput);
                answer.setText("0");
                operation = "";
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                    answer.setText("0");
                    operation = "";
                }
                else {
                    if (CurrentInput.substring(0,CurrentInput.length()-1).equals("")){
                        CurrentInput = "";
                        input.setText(CurrentInput);
                        answer.setText("0");
                        operation = "";
                    }
                    else {
                        CurrentInput = CurrentInput.substring(0, CurrentInput.length() - 1);
                        input.setText(CurrentInput);
                        finalResult = calculate(CurrentInput, CurrentInput.length() - 1, "", 'g');
                        checkAnswer("" + finalResult);

                    }
                }
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "+";
                Button button = (Button) view;
                String btn_Text = button.getText().toString();
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.charAt(CurrentInput.length()-1) == '+'){
                    input.setText(CurrentInput);
                }
                else {
                    CurrentInput +="+";
                    input.setText(CurrentInput);
                }

            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "-";
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.charAt(CurrentInput.length()-1) == '-'){
                    input.setText(CurrentInput);
                }
                else {
                    CurrentInput +="-";
                    input.setText(CurrentInput);
                }
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "*";
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.charAt(CurrentInput.length()-1) == '*'){
                    input.setText(CurrentInput);
                }
                else {
                    CurrentInput +="*";
                    input.setText(CurrentInput);
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "/";
                Button button = (Button) view;
                String btn_Text = button.getText().toString();
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.charAt(CurrentInput.length()-1) == '/'){
                    input.setText(CurrentInput);
                }
                else {
                    CurrentInput +="/";
                    input.setText(CurrentInput);
                }
            }
        });
        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "%";
                Button button = (Button) view;
                String btn_Text = button.getText().toString();
                if (CurrentInput.equals("")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.charAt(CurrentInput.length()-1) == '%'){
                    input.setText(CurrentInput);
                }
                else {
                    CurrentInput +="%";
                    input.setText(CurrentInput);
                    String moduloAnswer = answer.getText().toString();
                    double calculate = Double.parseDouble(moduloAnswer)/100;
                    checkAnswer(""+calculate);
                    preAnswer = answer.getText().toString();
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subString = "";
                for (int i = CurrentInput.length()-1;i>=0;i--){
                    if (CurrentInput.charAt(i) == '+' || CurrentInput.charAt(i) == '-' || CurrentInput.charAt(i) == '*' || CurrentInput.charAt(i) == '/' || CurrentInput.charAt(i) == '%'){
                        break;
                    }
                    subString += CurrentInput.charAt(i);
                }
                if (CurrentInput.equals("")){
                    CurrentInput += "0.";
                    input.setText(CurrentInput);
                }
                else if (subString.contains(".")){
                    input.setText(CurrentInput);
                }
                else if (CurrentInput.substring(CurrentInput.length()-1).equals("+") || CurrentInput.substring(CurrentInput.length()-1).equals("-") || CurrentInput.substring(CurrentInput.length()-1).equals("*") || CurrentInput.substring(CurrentInput.length()-1).equals("/") || CurrentInput.substring(CurrentInput.length()-1).equals("%")){
                    CurrentInput += "0.";
                    input.setText(CurrentInput);
                    equal = false;
                }
                else if (equal == true){
                    CurrentInput += "0.";
                    input.setText(CurrentInput);
                    equal = false;
                }
                else {
                    CurrentInput += ".";
                    input.setText(CurrentInput);
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal = true;
                CurrentInput = answer.getText().toString();
                input.setText(CurrentInput);
                operation = "";
            }
        });
    }
    public String revers(String number){
        String num = "";
        for (int i = number.length()-1;i>=0;i--){
            num += number.charAt(i);
        }
        return num;
    }
    public double calculate(String input,int index,String preSubInput,char operator){
        String num = "";
        double result = 0;
        int i;
        for (i = index;i>=0;i--){
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '%'){
                operator = input.charAt(i);
                result =  calculate(input,i-1,revers(num),operator);
                break;
            }
            else {
                num += input.charAt(i);
            }
        }
            if (i == 0-1){
                result = Double.parseDouble(revers(num));
                System.out.println("Num "+num);
            }
            else {
                if (operator == '+') {
                    if (num.equals("")){
                        num = "0";
                    }
                    result = result + Double.parseDouble(revers(num));
                } else if (operator == '-') {
                    if (num.equals("")){
                        num = "0";
                    }
                    result = result - Double.parseDouble(revers(num));
                } else if (operator == '*') {
                    if (num.equals("")){
                        num = "1";
                    }
                    result = result * Double.parseDouble(revers(num));
                } else if (operator == '/') {
                    if (num.equals("")){
                        num = "1";
                    }
                    result = result / Double.parseDouble(revers(num));
                }
                else if (operator == '%'){
                    if (num.equals("")){
                        num = "1";
                    }
                    result = Double.parseDouble(preAnswer) * Double.parseDouble(revers(num));
                }
            }
        return result;
    }
    public void checkAnswer(String checkAnswer){
        finalAnswer = checkAnswer;
        if (Double.isInfinite(Double.parseDouble(checkAnswer))){
            answer.setText("");
        }else {
            if (finalAnswer.endsWith(".0")) {
                finalAnswer = finalAnswer.substring(0, finalAnswer.length() - 2);
                answer.setText(finalAnswer);
            } else {
                answer.setText(finalAnswer);
            }
        }
    }
    public void checkEqual(String operator,String number){
        if (operation == "+"){
            double d = Double.parseDouble(answer.getText().toString()) + Double.parseDouble(number);
            checkAnswer(""+d);
        }
        else if (operation == "-"){
            double d = Double.parseDouble(answer.getText().toString()) - Double.parseDouble(number);
            checkAnswer(""+d);
        }
        else if (operation == "*"){
            double d = Double.parseDouble(answer.getText().toString()) * Double.parseDouble(number);
            checkAnswer(""+d);
        }
        else if (operation == "/"){
            double d = Double.parseDouble(answer.getText().toString()) / Double.parseDouble(number);
            checkAnswer(""+d);
        }
        else if (operation == "%"){
            double d = Double.parseDouble(answer.getText().toString()) * Double.parseDouble(number);
            checkAnswer(""+d);
        }
    }
    public void realTimeCalculate(String number){
        if (equal == true){
            if (!operation.equals("")){
                CurrentInput += number;
                input.setText(CurrentInput);
                checkEqual(operation,number);
            }
            else {
                CurrentInput = number;
                input.setText(CurrentInput);
                finalResult = calculate(CurrentInput, CurrentInput.length() - 1, "", 'g');
                checkAnswer("" + finalResult);
            }
            equal = false;
        }
        else {
            CurrentInput += number;
            System.out.println(CurrentInput);
            input.setText(CurrentInput);
            finalResult = calculate(CurrentInput, CurrentInput.length() - 1, "", 'g');
            System.out.println(finalResult);
            checkAnswer("" + finalResult);
        }
    }

}

