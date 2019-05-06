package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv = null;
    WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.out);
    }

    public void onClick(View btn){
        String expr = ((Button) btn).getText().toString();
        switch(expr){
            default:
                tv.setText(tv.getText()+expr);break;
            case "<-":
                int length = tv.getText().length();
                if(length>0) {
                    int end = length - 1;
                    tv.setText(tv.getText().subSequence(0, end));
                }
                break;
            case "c":
                tv.setText("");break;
            case "=":
                Double result = Calculator.conversion(tv.getText().toString());
                tv.setText(result.toString());break;
        }
    }
}
