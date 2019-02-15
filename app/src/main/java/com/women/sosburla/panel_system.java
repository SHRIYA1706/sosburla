package com.women.sosburla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//////////////////WAKELOCK..............................
public class panel_system extends AppCompatActivity {
    static int typep=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_system);
    }

    public void warn(View v){
        typep=0;
        Intent i =new Intent(panel_system.this,password_checker.class);
        startActivity(i);

    }

    public void sos(View v){
        typep=2;
        Intent i =new Intent(panel_system.this,password_checker.class);
        startActivity(i);

    }
    public void help(View v){
        typep=1;
        Intent i =new Intent(panel_system.this,password_checker.class);
        startActivity(i);
    }



}
