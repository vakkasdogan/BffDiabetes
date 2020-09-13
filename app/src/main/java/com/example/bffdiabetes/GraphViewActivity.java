package com.example.bffdiabetes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class GraphViewActivity extends AppCompatActivity {

    String vals, name, name_1, vals_1, stringstatus, name_2, file;
    private DatabaseReference rDatabase, sDatabase, xDatabase, yDatabase ;
    public String TAG = "DIABETES";
    int i = 0,f=0;
    float floatStatus, floatStatus_1;

    ArrayList<Entry> dataVals;
    ArrayList<Entry> dataVals_1;
    LineChart lineChart,lineChart_1;
    ImageButton imageButton,imageButton_1;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_graph);

        rDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData");
        xDatabase = FirebaseDatabase.getInstance().getReference().child("realData");
        lineChart = findViewById(R.id.lineChart_predicted);
        lineChart_1 = findViewById(R.id.lineChart_real);

        imageButton = findViewById(R.id.play_circle);
        imageButton_1 = findViewById(R.id.play_circle_1);


        dataVals = new ArrayList<>();
        dataVals_1 = new ArrayList<>();

        new getVals().execute();
    }

    public void imagebutton(View view) {
        Intent intentLogin = new Intent(GraphViewActivity.this, CurrentStateActivity.class);
        startActivity(intentLogin);
        Toast.makeText(getApplicationContext(), R.string.butonisclicked, Toast.LENGTH_SHORT).show();
    }

    public void imagebutton_1(View view) {
        Intent intentLogin_1 = new Intent(GraphViewActivity.this,PredictStateActivity.class);
        startActivity(intentLogin_1);
        Toast.makeText(getApplicationContext(),R.string.butonisclicked, Toast.LENGTH_SHORT).show();
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


                                {
                                    ArrayList<Entry> dataVals_1 = new ArrayList<Entry>();
                                    float values = Objects.requireNonNull(dataSnapshot.getValue(Float.class));
                                    dataVals_1.add(new Entry(i + 1, 201));
                                    dataVals_1.add(new Entry(i + 2, 178));
                                    dataVals_1.add(new Entry(i + 3, 146));
                                    dataVals_1.add(new Entry(i + 4, 65));
                                    dataVals_1.add(new Entry(i + 5, 125));
                                    dataVals_1.add(new Entry(i + 6, 132));
                                    dataVals_1.add(new Entry(i + 7, values));

                                    {
                                        LineDataSet set1;
                                        set1 = new LineDataSet(dataVals_1, getString(R.string.glucose_prediction));
                                        set1.setColor(Color.rgb(65, 168, 121));
                                        set1.setValueTextColor(Color.rgb(55, 70, 73));
                                        set1.setValueTextSize(10f);
                                        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                                        set1.setDrawValues(true);
                                        set1.setLineWidth(3f);
                                        set1.setDrawCircles(true);
                                        set1.setCubicIntensity(0.2f);
                                        set1.setDrawFilled(true);
                                        set1.setFillColor(Color.CYAN);
                                        set1.setFillAlpha(50);

//                                        Drawable drawable= ContextCompat.getDrawable(GraphViewActivity.this,R.drawable.gradient);
//                                        set1.setFillDrawable(drawable);

                                        LineData data = new LineData(set1);
                                        lineChart.setData(data);
                                        lineChart.setTouchEnabled(true);
                                        lineChart.setDragEnabled(true);
                                        lineChart.setScaleEnabled(true);
                                        lineChart.setPinchZoom(false);
                                        lineChart.setDrawGridBackground(true);
                                        lineChart.setExtraLeftOffset(15);
                                        lineChart.setExtraRightOffset(15);
                                        lineChart.setData(data);
                                        lineChart.animateX(2000);
                                        //lineChart.invalidate();
                                        lineChart.getLegend().setEnabled(true);
                                        lineChart.getDescription().setEnabled(false);
                                        //lineChart.notifyDataSetChanged();

                                        LimitLine ll1 = new LimitLine(150f, "hyperglycemia");
                                        ll1.setLineWidth(6f);
                                        ll1.enableDashedLine(10f, 10f, 0f);
                                        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                                        ll1.setTextSize(10f);

                                        LimitLine ll2 = new LimitLine(70f, "hypoglycemia");
                                        ll2.setLineWidth(6f);
                                        ll2.enableDashedLine(10f, 10f, 0f);
                                        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll2.setTextSize(10f);

                                        LimitLine ll3 = new LimitLine(90f, "normal");
                                        ll3.setLineWidth(4f);
                                        ll3.enableDashedLine(10f, 10f, 0f);
                                        ll3.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll3.setTextSize(10f);
                                        ll3.setLineColor(Color.GREEN);


                                        LimitLine ll4 = new LimitLine(120f, "normal");
                                        ll4.setLineWidth(4f);
                                        ll4.enableDashedLine(10f, 10f, 0f);
                                        ll4.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll4.setTextSize(10f);
                                        ll4.setLineColor(Color.GREEN);




                                        YAxis leftAxis = lineChart.getAxisLeft();
                                        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
                                        leftAxis.addLimitLine(ll1);
                                        leftAxis.addLimitLine(ll2);
                                        leftAxis.addLimitLine(ll3);
                                        leftAxis.addLimitLine(ll4);
                                        leftAxis.setAxisMaximum(250f);
                                        leftAxis.setAxisMinimum(50f);
                                        leftAxis.enableGridDashedLine(10f, 10f, 10f);
                                        leftAxis.setDrawLimitLinesBehindData(true);
                                    }
                                    i++;
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
                xDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_1 = ds.getKey();
//                            Log.e("names: ", name);
                        }

                        yDatabase = xDatabase.child(name_1);
                        yDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals_1 = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus_1 = dataSnapshot.getValue(Float.class);

                                {
                                    ArrayList<Entry> dataVals = new ArrayList<Entry>();
                                    float values_1 = Objects.requireNonNull(dataSnapshot.getValue(Float.class));
                                    dataVals.add(new Entry( f, 205));
                                    dataVals.add(new Entry( f+ 1, 175));
                                    dataVals.add(new Entry( f+ 2 , 144));
                                    dataVals.add(new Entry( f+ 3, 124));
                                    dataVals.add(new Entry( f+ 4, 78));
                                    dataVals.add(new Entry( f+ 5, 138));
                                    dataVals.add(new Entry( f+6 , values_1));

                                    {
                                        LineDataSet set2;
                                        set2 = new LineDataSet(dataVals, getString(R.string.glucose_real));
                                        set2.setColor(Color.rgb(65, 168, 121));
                                        set2.setValueTextColor(Color.rgb(55, 70, 73));
                                        set2.setValueTextSize(10f);
                                        set2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                                        set2.setDrawValues(true);
                                        set2.setDrawCircles(true);
                                        set2.setLineWidth(3f);
                                        set2.setCubicIntensity(0.4f);
                                        set2.setDrawFilled(true);
                                        set2.setFillColor(Color.CYAN);
                                        set2.setFillAlpha(50);

                                        LineData data = new LineData(set2);
                                        lineChart_1.setData(data);
                                        lineChart_1.setTouchEnabled(true);
                                        lineChart_1.setDragEnabled(true);
                                        lineChart_1.setScaleEnabled(true);
                                        lineChart_1.setPinchZoom(false);
                                        lineChart_1.setDrawGridBackground(true);
                                        lineChart_1.setExtraLeftOffset(15);
                                        lineChart_1.setExtraRightOffset(15);
                                        lineChart_1.setData(data);
                                        lineChart_1.animateX(2000);
                                        //lineChart.invalidate();
                                        lineChart_1.getLegend().setEnabled(true);
                                        lineChart_1.getDescription().setEnabled(false);
                                        //lineChart.notifyDataSetChanged();

                                        LimitLine ll1 = new LimitLine(150f, "hyperglycemia");
                                        ll1.setLineWidth(6f);
                                        ll1.enableDashedLine(10f, 10f, 0f);
                                        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                                        ll1.setTextSize(10f);

                                        LimitLine ll2 = new LimitLine(70f, "hypoglycemia");
                                        ll2.setLineWidth(6f);
                                        ll2.enableDashedLine(10f, 10f, 0f);
                                        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll2.setTextSize(10f);

                                        LimitLine ll3 = new LimitLine(90f, "normal");
                                        ll3.setLineWidth(4f);
                                        ll3.enableDashedLine(10f, 10f, 0f);
                                        ll3.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll3.setTextSize(10f);
                                        ll3.setLineColor(Color.GREEN);


                                        LimitLine ll4 = new LimitLine(120f, "normal");
                                        ll4.setLineWidth(4f);
                                        ll4.enableDashedLine(10f, 10f, 0f);
                                        ll4.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                                        ll4.setTextSize(10f);
                                        ll4.setLineColor(Color.GREEN);




                                        YAxis leftAxis = lineChart_1.getAxisLeft();
                                        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
                                        leftAxis.addLimitLine(ll1);
                                        leftAxis.addLimitLine(ll2);
                                        leftAxis.addLimitLine(ll3);
                                        leftAxis.addLimitLine(ll4);
                                        leftAxis.setAxisMaximum(250f);
                                        leftAxis.setAxisMinimum(50f);
                                        leftAxis.enableGridDashedLine(10f, 10f, 10f);
                                        leftAxis.setDrawLimitLinesBehindData(true);
                                    }
                                    i++;
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


