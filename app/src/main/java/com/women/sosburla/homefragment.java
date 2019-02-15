package com.women.sosburla;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class homefragment extends Fragment {
    SharedPreferences det ;
    EditText t1;
    EditText t2;
    EditText t3;



    View ph,v1,v2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ph= inflater.inflate(R.layout.fragment_home ,null);
        det= this.getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        t1= ph.findViewById(R.id.textView);
        t2=ph.findViewById(R.id.textView2);
        t3=ph.findViewById(R.id.textView3);
        v1=ph.findViewById(R.id.floatingActionButton);
        v2=ph.findViewById(R.id.button6);
        t1.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);
        t1.setText(det.getString("name","ERROR 1"));
        t2.setText(det.getString("aadhar","ERROR 2"));
        t3.setText(det.getString("phone","ERROR 3"));

        final View  b1= ph.findViewById(R.id.floatingActionButton);
        final Button b2=ph.findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setVisibility(View.VISIBLE);
                v.setVisibility(View.INVISIBLE);
                t1.setEnabled(true);
                t2.setEnabled(true);
                t3.setEnabled(true);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.VISIBLE);
                t1.setEnabled(false);
                t2.setEnabled(false);
                t3.setEnabled(false);
                SharedPreferences.Editor ed=det.edit();
                ed.putString("name", t1.getText().toString());
                ed.putString("phone", t3.getText().toString());
                ed.putString("aadhar", t2.getText().toString());
                ed.putBoolean("first",true);
                ed.commit();

            }
        });


        return ph;
    }



}
