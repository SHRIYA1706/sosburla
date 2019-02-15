package com.women.sosburla;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class severity extends AppCompatActivity implements LocationListener {

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    static Double lati=0.0;
    static Double longi=0.0;

    String userid="1234";
    String tososf = "";
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    final int[] i = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_severity);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setProgress(i[0]);

        View view = findViewById(R.id.main);
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                mProgressBar.setProgress(0);
                i[0]=0;
                return true;

            }
        });


        mCountDownTimer=new CountDownTimer(20000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i[0] + millisUntilFinished);
                i[0]++;
                mProgressBar.setProgress((int) i[0] *100/(5000/1000));

            }

            @Override
            public void onFinish() {

                //Do what you want
                i[0]++;
                mProgressBar.setProgress(100);

            }
        };
        mCountDownTimer.start();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(severity.this, "Permission accepted~", Toast.LENGTH_SHORT).show();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(severity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        mProgressBar.setProgress(0);
        i[0]=0;
        return false;
    }
*/
    @Override
    public void onLocationChanged(Location location) {
        lati=location.getLatitude();
        longi=location.getLongitude();
        Log.e(":::",String.valueOf(lati)+":"+String.valueOf(longi));
        txtLat = (TextView) findViewById(R.id.textview1);
        txtLat.setText("Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude());

    }
    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

    public void sosac(){
     SeekBar s=findViewById(R.id.seekBar);
     String chk="";
     CheckBox c1=findViewById(R.id.checkBox);
        CheckBox c2=findViewById(R.id.checkBox3);
        CheckBox c3=findViewById(R.id.checkBox4);
        CheckBox c4=findViewById(R.id.checkBox5);
        CheckBox c5=findViewById(R.id.checkBox6);
     if(c1.isChecked()) chk+="1"; else chk+="0" ;
        if(c2.isChecked()) chk+="1"; else chk+="0" ;
        if(c2.isChecked()) chk+="1"; else chk+="0" ;
        if(c3.isChecked()) chk+="1"; else chk+="0" ;
        if(c4.isChecked()) chk+="1"; else chk+="0" ;
     tososf=userid+"/"+String.valueOf(lat)+"/"+String.valueOf(longi)+"/"+String.valueOf(panel_system.typep)+"/"+String.valueOf(s.getProgress())+"/"+chk;


    }
    public void done(View v){
        Double ze=new Double(0.0);
    while(lat.equals(ze)){
         for(int i=0;i<=1000;i++);
     }
        for(int i=0;i<=3000;i++);
        sosac();
        if(panel_system.typep==0){
            Toast.makeText(this, "WARN -SOS Started", Toast.LENGTH_SHORT).show();
        startService(new Intent(severity.this, floatact.class));}
        finish();





    }

    public void fcan(View v){
        finish();

    }
}
