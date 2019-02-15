package com.women.sosburla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class password_checker extends AppCompatActivity {
    private String password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_checker);
        Button b= findViewById(R.id.button);
        Button b1=findViewById(R.id.button2);
        Button b2=findViewById(R.id.button4);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button5);
        Button b5=findViewById(R.id.button6);
        Button b6=findViewById(R.id.button7);
        Button b7=findViewById(R.id.bu8);
        Button b8=findViewById(R.id.button9);
        Button b9=findViewById(R.id.button10);

        b.setOnClickListener(mCorkyListener);
        b1.setOnClickListener(mCorkyListener);
        b2.setOnClickListener(mCorkyListener);
        b3.setOnClickListener(mCorkyListener);
        b4.setOnClickListener(mCorkyListener);
        b5.setOnClickListener(mCorkyListener);
        b6.setOnClickListener(mCorkyListener);
        b7.setOnClickListener(mCorkyListener);
        b8.setOnClickListener(mCorkyListener);
        b9.setOnClickListener(mCorkyListener);
    }
    private View.OnClickListener mCorkyListener = new View.OnClickListener(){
        public void onClick(View v) {
            Button b=(Button) v;
            password+=b.getText().toString();
            Log.e(":::",password);
            if(password.contains("12")){
                Intent i=new Intent(password_checker.this,severity.class);
                startActivity(i);
                finish();
            }
        }
    };

}
