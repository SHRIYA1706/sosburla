package com.women.sosburla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class startact extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
    }

    public void submit(View view){
        EditText t1=findViewById(R.id.editText);
        String n=t1.getText().toString();
        EditText t2=findViewById(R.id.editText3);
        String ph=t2.getText().toString();
        EditText t3=findViewById(R.id.editText2);
        String aa=t3.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("name", n);
        editor.putString("phone", ph);
        editor.putString("aadhar", aa);
        editor.putBoolean("first",true);
        editor.commit();

        
        Intent w=new Intent(this,Main2Activity.class);
        startActivity(w);

    }
}
