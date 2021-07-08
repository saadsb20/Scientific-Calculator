package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input, signbox;
    String sign, value1, value2, SpecialFunction;
    Double num1, num2, result;
    boolean hasDot, IsSpecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextView) findViewById(R.id.input);
        signbox = (TextView) findViewById(R.id.sign);
    }

    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
    }

    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
    }

    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
    }

    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
    }

    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
    }

    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
    }

    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
    }

    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
    }

    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
    }

    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
    }

    public void btnClick_C(View view) {
        input.setText(null);
        signbox.setText(null);
        hasDot = false;
    }

    public void btnClick_Sum(View view) {
        sign = "+";
        value1 = input.getText().toString();
        hasDot = false;
        input.setText(null);
        signbox.setText("+");
    }

    public void btnClick_subs(View view) {
        sign = "-";
        hasDot = false;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("-");
    }

    public void btnClick_div(View view) {
        sign = "/";
        hasDot = false;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("/");
    }

    public void btnClick_mul(View view) {
        sign = "*";
        hasDot = false;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("*");
    }

    public void btnClick_equals(View view) {
        if ((SpecialFunction == null && sign == null) || input.getText().equals("")) {
            signbox.setText("Error!");
        }
        else if (SpecialFunction != null) {
            switch (SpecialFunction) {
                case "1/x":
                    num1 = Double.parseDouble(value1);
                    if(num1!=0.0){
                        input.setText(1/num1 + "");
                        SpecialFunction = null;
                        IsSpecial = false;
                        signbox.setText(null);
                        break;
                    }else{
                        input.setText("Error!");
                        break;
                    }

                case "Cos":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.cos(num1) + "");
                    SpecialFunction = null;
                    IsSpecial = false;
                    signbox.setText(null);
                    break;
                case "Sin":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.sin(num1) + "");
                    SpecialFunction = null;
                    IsSpecial = false;
                    signbox.setText(null);
                    break;
                case "Tan":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.tan(num1) + "");
                    SpecialFunction = null;
                    IsSpecial = false;
                    signbox.setText(null);
                    break;

            }
        }
        else if (sign != null) {
            value2 = input.getText().toString();
            num1 = Double.parseDouble(value1);
            num2 = Double.parseDouble(value2);
            input.setText(null);
            switch (sign) {
                default:
                    break;
                case "+":
                    result = num1 + num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "-":
                    result = num1 - num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "/":
                    if (num2 == 0) {
                        input.setText("Error!");
                        break;
                    } else {
                        result = num1 / num2;
                        input.setText(result + "");
                        sign = null;
                        signbox.setText(null);
                        break;
                    }
                case "*":
                    result = num1 * num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
            }

        }
        else input.setText(null);
    }

    /*public void btnClick_dot(View view) {
        if (!hasDot) {
            if (input.getText().equals("")) {
                input.setText("0.");
            } else {
                input.setText(input.getText() + ".");
            }
            hasDot = true;
        }
    }*/

    /*public void btnClick_Delete(View view) {
        if (input.getText().equals("")) {
            input.setText(null);
        } else {
            int len = input.getText().length();
            String s = input.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }

        }
    }*/

    /*public void btnClick_log(View view) {
        SpecialFunction = "log";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("log");
    }

    public void btnClick_ln(View view) {
        SpecialFunction = "ln";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("ln");
    }

    public void btnClick_sqrt(View view) {
        SpecialFunction = "sqrt";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("√");
    }

    public void btnClick_xn(View view) {
        SpecialFunction = "x^n";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1+"ⁿ");
    }

    public void btnClick_fact(View view) {
        SpecialFunction = "!";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(value1 + "");
        signbox.setText(value1+"!");
    }*/

    public void btnClick_Sin(View view) {
        SpecialFunction = "Sin";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("Sin");
    }

    public void btnClick_Cos(View view) {
        SpecialFunction = "Cos";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("Cos");
    }

    public void btnClick_Tan(View view) {
        SpecialFunction = "Tan";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("Tan");
    }

    public void btnClick_inverse_x(View view) {
        SpecialFunction = "1/x";
        hasDot = false;
        IsSpecial = true;
        value1 = input.getText().toString();
        signbox.setText("1/"+value1);
    }

}