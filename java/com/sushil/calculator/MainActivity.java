package com.sushil.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btnClear;
    Button btnEqual;
    Button btnDot;
    Button btnPercent;
    Button btnBracket;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.number0);
        btn1=findViewById(R.id.number1);
        btn2=findViewById(R.id.number2);
        btn3=findViewById(R.id.number3);
        btn4=findViewById(R.id.number4);
        btn5=findViewById(R.id.number5);
        btn6=findViewById(R.id.number6);
        btn7=findViewById(R.id.number7);
        btn8=findViewById(R.id.number8);
        btn9=findViewById(R.id.number9);

        btnPlus=findViewById(R.id.addition);
        btnSub=findViewById(R.id.subtraction);
        btnMul=findViewById(R.id.multiplication);
        btnDiv=findViewById(R.id.division);
        btnClear=findViewById(R.id.clear);
        btnEqual=findViewById(R.id.equal);
        btnDot=findViewById(R.id.dot);
        btnPercent=findViewById(R.id.percentage);
        btnBracket=findViewById(R.id.bracket);

        tvInput=findViewById(R.id.data);
        tvOutput=findViewById(R.id.answer);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"8");
            }
        });


        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"/");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();
                tvInput.setText(process +"%");
            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBracket){
                    process=tvInput.getText().toString();
                    tvInput.setText(process +")");
                    checkBracket=false;
                }else{
                    process=tvInput.getText().toString();
                    tvInput.setText(process +"(");
                    checkBracket=true;
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=tvInput.getText().toString();

                process=process.replaceAll("x","*");
                process=process.replaceAll("%","/100");
                process=process.replaceAll("","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult="";

                try{
                    Scriptable scriptable=rhino.initStandardObjects();
                    finalResult=rhino.evaluateString(scriptable,process,"Javascript",1,null).toString();

                }catch (Exception e){
                    finalResult="0";
                }
                tvOutput.setText(finalResult);

            }
        });
    }
}
