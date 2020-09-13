package com.example.bffdiabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {

    String vals, name, name_1, vals_1, stringstatus, name_2, file, name_3, vals_2, vals_3;
    private DatabaseReference rDatabase, sDatabase, xDatabase, yDatabase, mDatabase, aDatabase, bDatabase, cDatabase, dDatabase;
    public String TAG = "DIABETES";
    int progressStatus;
    int i = 0;
    Button detail_button, alarmbtn;
    ProgressBar pro_bar,pro_bar_1;
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;
    ArrayList<Entry> dataVals;
    ArrayList<Entry> dataVals_1;

    int checker1 = 0;
    int checker = 0;
    LineDataSet lineDataSet;

    float floatStatus, floatStatus_1, floatStatus_2, floatStatus_3;
    private FirebaseUser currentUser;
    private FirebaseAuth auth;
    private TextView tv, tv_1, firsttriangle, secondtriangle, thirdtriangle,tView2,tView3;

    private Handler mHandler = new Handler();
    int stat = 0;
    float stat2 = 0;
    int stat4 = 0;
    float stat3 = 0;
    public void init() {
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        //tv = (TextView) findViewById(R.id.textView);
        //tv_1 = (TextView) findViewById(R.id.textView_1);

        firsttriangle = (TextView) findViewById(R.id.firstucgen);
        secondtriangle = (TextView) findViewById(R.id.seconducgen);
        thirdtriangle = (TextView) findViewById(R.id.thirdducgen);

        pro_bar = findViewById(R.id.progres_barr);
        pro_bar_1 = findViewById(R.id.progres_barr_1);
        detail_button = findViewById(R.id.detail_btn);
        alarmbtn = findViewById(R.id.alarm_buton);

        tView2 = findViewById(R.id.writeData);
        tView3 = findViewById(R.id.writeData_1);

        dataVals = new ArrayList<>();
        dataVals_1 = new ArrayList<>();

        rDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData");
        aDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData_1");
        cDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData_2");
        xDatabase = FirebaseDatabase.getInstance().getReference().child("realData");


        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoGraphActivity();
            }

            private void gotoGraphActivity() {
                Intent registerIntent = new Intent(WelcomeActivity.this, GraphViewActivity.class);
                startActivity(registerIntent);
            }
        });



        new getVals().execute();
        init();
    }


    @SuppressLint("StaticFieldLeak")
    private class getVals extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {

                rDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name = ds.getKey(); }
                        sDatabase = rDatabase.child(name);
                        sDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus = dataSnapshot.getValue(Float.class);
                                //tv_1.setText(vals);
                                firsttriangle.setText(vals);


                                new Thread(new Runnable() {
                                    public void run() {
                                        while (stat3 < floatStatus) {
                                            stat3 += 0.1;
                                            checker += 1;
                                            if (checker == 10){
                                                stat4 += 1;
                                                checker = 0;
                                            }
                                            mHandler.post(new Runnable() {
                                                public void run() {
                                                    pro_bar_1.setProgress(stat4);
                                                    settingProgressColor_1();
                                                    if(floatStatus<1){
                                                        tView3.setText(stat3+"");
                                                    } else{
                                                        tView3.setText(stat4+"");
                                                    }

                                                }
                                            });
                                            try {
                                                // Sleep for 200 milliseconds.
                                                Thread.sleep(5);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
//                                        if (stat>=100){
//                                            tView3.setText("100 ppm");
//                                        } else {
//                                            tView3.setText(vals+" ppm");
//                                        }
                                        tView3.setText(floatStatus+"");

                                    }
                                }).start();

                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.w(TAG, "Failed to read value.", databaseError.toException());
                            }
                        });
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });




                aDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_2 = ds.getKey(); }
                        bDatabase = aDatabase.child(name_2);
                        bDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals_2 = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus_2 = dataSnapshot.getValue(Float.class);
//                                tv_1.setText(vals_2);
                                secondtriangle.setText(vals_2);

                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.w(TAG, "Failed to read value.", databaseError.toException());
                            }
                        });
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });


                cDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_3 = ds.getKey(); }
                        dDatabase = cDatabase.child(name_3);
                        dDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals_3 = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus_3 = dataSnapshot.getValue(Float.class);
                                //tv_1.setText(vals);
                                thirdtriangle.setText(vals_3);
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.w(TAG, "Failed to read value.", databaseError.toException());
                            }
                        });
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });








                xDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_1 = ds.getKey(); }
                        yDatabase = xDatabase.child(name_1);
                        yDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals_1 = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus_1 = dataSnapshot.getValue(Float.class);
                                //tv.setText(vals_1);

                                new Thread(new Runnable() {
                                    @SuppressLint("SetTextI18n")
                                    public void run() {
                                        while (stat2 < floatStatus_1) {
                                            stat2 += 0.1;
                                            checker1 += 1;
                                            if (checker1 == 10){
                                                stat += 1;
                                                checker1 = 0;
                                            }
                                            mHandler.post(new Runnable() {
                                                public void run() {
                                                    pro_bar.setProgress(stat);
                                                    settingProgressColor();
                                                    if(floatStatus_1<1){
                                                        tView2.setText(stat2+"");
                                                    } else{
                                                        tView2.setText(stat+"");
                                                    }

                                                }
                                            });
                                            try {
                                                // Sleep for 200 milliseconds.
                                                Thread.sleep(5);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
//                                        if (stat>=100){
////                                            tView2.setText("100 mg/dl");
////                                        } else {
////                                            tView2.setText(vals+" mg/dl");
////                                        }

                                        tView2.setText(floatStatus_1+"");
                                    }

                                }).start();

                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.w(TAG, "Failed to read value.", databaseError.toException());
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle options menu item clicks here.
//        switch (item.getItemId()) {
//            case R.id.action_language:
//                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
//                startActivity(languageIntent);
//                return true;
//            default:
//                // Do nothing
//        }
//        return super.onOptionsItemSelected(item);
//    }
    public void settingProgressColor(){

        if (stat>=200){
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(220, 0, 0)));
        }
        else if (stat>=170) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(199, 0, 57)));
        }
        else if (stat>=150) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 195, 0)));
        }
        else if (stat>=140) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 87, 51)));
        }
        else if (stat>=100) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(27, 94, 32)));
        }
        else if (stat>=90) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(100, 221, 23)));
        }
        else if (stat>=70) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 87, 51)));
        }
        else if (stat>=40) {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 111, 0)));
        }

        else {
            pro_bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 255, 0)));
        }
    }

    public void settingProgressColor_1(){

        if (stat4>=200){
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(220, 0, 0)));
        }
        else if (stat4>=170) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(199, 0, 57)));
        }
        else if (stat4>=150) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 195, 0)));
        }
        else if (stat4>=140) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 87, 51)));
        }
        else if (stat4>=100) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(27, 94, 32)));
        }
        else if (stat4>=90) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(100, 221, 23)));
        }
        else if (stat4>=70) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 87, 51)));
        }
        else if (stat4>=40) {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 111, 0)));
        }

        else {
            pro_bar_1.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 255, 0)));
        }
    }
}
