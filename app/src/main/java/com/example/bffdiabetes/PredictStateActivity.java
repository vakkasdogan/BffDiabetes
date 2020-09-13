package com.example.bffdiabetes;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressLint("Registered")
public class PredictStateActivity extends AppCompatActivity {
    public float values_1;
    String vals, name, name_1, vals_1, stringstatus, name_2, file,name_3,vals_2,vals_3,name_4,vals_4;
    private DatabaseReference rDatabase, sDatabase, aDatabase, bDatabase,cDatabase,dDatabase,eDatabase,fDatabase ;
    public String TAG = "DIABETES";
    int i = 0,f=0;
    float floatStatus, floatStatus_1,floatStatus_2,floatStatus_3;

    ArrayList<Entry> dataVals;
    ArrayList<Entry> dataVals_1;
    LineChart lineChart,lineChart_1;
    TextView textView1,textView2,textView3,textView4,textView5,textView1_1,textView1_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_predict_state);

        rDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData");
        aDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData_1");
        cDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData_2");
        eDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData_3");

        lineChart = findViewById(R.id.lineChart_predicted);
        lineChart_1 = findViewById(R.id.lineChart_real);

        textView1 = findViewById(R.id.current_text_write);
        textView1_1 = findViewById(R.id.current_text_write_1);
        textView1_2 = findViewById(R.id.current_text_write_2);
        textView2 = findViewById(R.id.state_predict);
        textView3 = findViewById(R.id.state_text_predict);
        textView4 = findViewById(R.id.tips_predict);
        textView5 = findViewById(R.id.mesaj_predict);


        dataVals = new ArrayList<>();
        dataVals_1 = new ArrayList<>();

        new getVals().execute();

    }
    @SuppressLint("StaticFieldLeak")
    private class getVals extends AsyncTask<Void, Void, Void> {
        @SuppressLint({"WrongThread", "SetTextI18n"})
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                rDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            name = ds.getKey();
                        }
                        sDatabase = rDatabase.child(name);
                        sDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus = dataSnapshot.getValue(Float.class);
                                textView1.setText(vals);
                                values_1 = Objects.requireNonNull(dataSnapshot.getValue(Float.class));

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
                                textView1_1.setText(vals_2);
                                float values_2 = Objects.requireNonNull(dataSnapshot.getValue(Float.class));

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
                                textView1_2.setText(vals_3);
//                                float values_3 = Objects.requireNonNull(dataSnapshot.getValue(Float.class));

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

                eDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_4 = ds.getKey(); }
                        fDatabase = eDatabase.child(name_4);
                        fDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                 float vals_4 = Objects.requireNonNull(dataSnapshot.getValue(Float.class));
                                floatStatus_3 = dataSnapshot.getValue(Float.class);

                                if (vals_4 == 1){
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_trending_up_black_48dp, 0, 0, 0);
                                    textView3.setText("HYPERGLYCEMIA");
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.angry,0,0,0);
                                    textView5.setText(R.string.increasing );

                                }
                                else{
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_trending_down_black_48dp, 0, 0, 0);
                                    textView3.setText("HYPOGLYCEMIA");
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.yellowsurat,0,0,0);
                                    textView5.setText(R.string.dereasing );
                                }

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


}
