package com.example.bffdiabetes;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Session2Command;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import static com.example.bffdiabetes.App.CHANNEL_1_ID;

import java.util.ArrayList;
import java.util.Objects;

public class CurrentStateActivity extends AppCompatActivity {
    String vals, name, name_1, vals_1;
    private DatabaseReference rDatabase, sDatabase, xDatabase, yDatabase ;
    public String TAG = "DIABETES";
    int i = 0,f=0;
    float floatStatus, floatStatus_1;
//    Button btn;

    ArrayList<Entry> dataVals;
    ArrayList<Entry> dataVals_1;
    LineChart lineChart,lineChart_1;
    TextView textView1,textView2,textView3,textView4,textView5;

    private NotificationManagerCompat notificationManager;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_current_state);

        rDatabase = FirebaseDatabase.getInstance().getReference().child("predictionData");
        xDatabase = FirebaseDatabase.getInstance().getReference().child("realData");

        lineChart = findViewById(R.id.lineChart_predicted);
        lineChart_1 = findViewById(R.id.lineChart_real);

        textView1 = findViewById(R.id.current_text_write);
        textView2 = findViewById(R.id.state);
        textView3 = findViewById(R.id.state_text);
        textView4 = findViewById(R.id.tips);
        textView5 = findViewById(R.id.mesaj);

//        btn =findViewById(R.id.notification);
        notificationManager = NotificationManagerCompat.from(this);

        dataVals = new ArrayList<>();
        dataVals_1 = new ArrayList<>();

        new getVals().execute();
    }
    public void alarm_btn(View v) {

        Intent intentLogin_1 = new Intent(CurrentStateActivity.this, MainAlarmActivity.class);
        Toast.makeText(getApplicationContext(),"Button is Clicked", Toast.LENGTH_SHORT).show();
        startActivity(intentLogin_1);

    }


    public void sendOnChannel(View view) {
        Intent activityIntent = new Intent(this, HomeActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

//        Intent broadcastIntent = new Intent(this, AlertReceiver.class);
//        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
//                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.message_sms_foreground)
                .setContentTitle("BffDiabetes")
                .setContentText("Be Carefull")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notificationManager.notify(1, notification);
    }
    @SuppressLint("StaticFieldLeak")
    private class getVals extends AsyncTask<Void, Void, Void> {
        private static final int NOTIFICATION_ID =100 ;
        private Context mContext;
        private Notification mNotification;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                xDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            name_1 = ds.getKey();
//                            Log.e("names: ", name);
                        }
                        yDatabase = xDatabase.child(name_1);
                        yDatabase.addValueEventListener(new ValueEventListener() {
                            @SuppressLint({"ResourceType", "SetTextI18n"})
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                vals_1 = Objects.requireNonNull(dataSnapshot.getValue(Float.class)).toString();
                                floatStatus_1 = dataSnapshot.getValue(Float.class);

                                float values = Objects.requireNonNull(dataSnapshot.getValue(Float.class));
                                textView1.setText(vals_1);

                                if (values <= 140 && values >= 90) {
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.twotone_arrow_forward_black_48dp, 0, 0, 0);
//                                     textView3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.normal, 0, 0, 0);
                                    textView3.setText(R.string.normal);
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.greensurat, 0, 0, 0);
                                    textView5.setText(R.string.normal_yazi);

                                } else if (values < 90) {
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_arrow_downward_black_48dp,0,0,0);
                                    textView3.setText("HYPOGLYCEMIA");
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.angry, 0, 0, 0);
                                    textView5.setText(R.string.dereasing);
                                } else if (values > 140 && values<200) {
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_arrow_upward_black_48dp,0,0,0);
                                    textView3.setText("HYPERGLYCEMIA");
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.yellowsurat, 0, 0, 0);
                                    textView5.setText(R.string.increasing);


                                } else if (values >= 200) {
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.twotone_warning_black_48dp,0,0,0);
                                    textView3.setText(R.string.diabetes);
                                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.angry, 0, 0, 0);
                                    textView5.setText(R.string.dangerous);

                                    Intent activityIntent = new Intent(CurrentStateActivity.this, HomeActivity.class);
                                    PendingIntent contentIntent = PendingIntent.getActivity(CurrentStateActivity.this,
                                            0, activityIntent, 0);

                                    Notification notification = new NotificationCompat.Builder(CurrentStateActivity.this, CHANNEL_1_ID)
                                            .setSmallIcon(R.drawable.twotone_warning_black_48dp)
                                            .setContentTitle(getString(R.string.dangerosly))
                                            .setContentText(getString(R.string.becareful))
                                            .setStyle(new NotificationCompat.BigTextStyle()
                                            .bigText(getString(R.string.inform))
                                            .setBigContentTitle(getString(R.string.buyukbaslik))
                                            .setSummaryText(getString(R.string.ozet)))
                                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                            .setColor(Color.BLUE)
                                            .setContentIntent(contentIntent)
                                            .setAutoCancel(true)
                                            .setOnlyAlertOnce(true)
                                            .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                                            .setDefaults(NotificationCompat.DEFAULT_SOUND)
                                            .build();


                                    notificationManager.notify(1, notification);


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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }

}






