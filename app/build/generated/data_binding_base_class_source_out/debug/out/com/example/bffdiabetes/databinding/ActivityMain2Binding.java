// Generated by view binder compiler. Do not edit!
package com.example.bffdiabetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.example.bffdiabetes.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout RepeatNo;

  @NonNull
  public final RelativeLayout RepeatType;

  @NonNull
  public final LinearLayout addReminderLayoutTop;

  @NonNull
  public final RelativeLayout date;

  @NonNull
  public final TextView dateText;

  @NonNull
  public final ImageView date�con;

  @NonNull
  public final TextView details;

  @NonNull
  public final EditText reminderTitle;

  @NonNull
  public final RelativeLayout repeat;

  @NonNull
  public final LinearLayout repeatLl;

  @NonNull
  public final TextView repeatNoText;

  @NonNull
  public final ImageView repeatNo�con;

  @NonNull
  public final Switch repeatSwitch;

  @NonNull
  public final TextView repeatText;

  @NonNull
  public final TextView repeatTypeText;

  @NonNull
  public final ImageView repeatType�con;

  @NonNull
  public final ImageView repeat�con;

  @NonNull
  public final TextView setDate;

  @NonNull
  public final TextView setRepeat;

  @NonNull
  public final TextView setRepeatNo;

  @NonNull
  public final TextView setRepeatType;

  @NonNull
  public final TextView setTime;

  @NonNull
  public final FloatingActionButton starred1;

  @NonNull
  public final FloatingActionButton starred2;

  @NonNull
  public final RelativeLayout time;

  @NonNull
  public final TextView timeText;

  @NonNull
  public final ImageView time�con;

  @NonNull
  public final Toolbar toolbar;

  private ActivityMain2Binding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout RepeatNo,
      @NonNull RelativeLayout RepeatType, @NonNull LinearLayout addReminderLayoutTop,
      @NonNull RelativeLayout date, @NonNull TextView dateText, @NonNull ImageView date�con,
      @NonNull TextView details, @NonNull EditText reminderTitle, @NonNull RelativeLayout repeat,
      @NonNull LinearLayout repeatLl, @NonNull TextView repeatNoText,
      @NonNull ImageView repeatNo�con, @NonNull Switch repeatSwitch, @NonNull TextView repeatText,
      @NonNull TextView repeatTypeText, @NonNull ImageView repeatType�con,
      @NonNull ImageView repeat�con, @NonNull TextView setDate, @NonNull TextView setRepeat,
      @NonNull TextView setRepeatNo, @NonNull TextView setRepeatType, @NonNull TextView setTime,
      @NonNull FloatingActionButton starred1, @NonNull FloatingActionButton starred2,
      @NonNull RelativeLayout time, @NonNull TextView timeText, @NonNull ImageView time�con,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.RepeatNo = RepeatNo;
    this.RepeatType = RepeatType;
    this.addReminderLayoutTop = addReminderLayoutTop;
    this.date = date;
    this.dateText = dateText;
    this.date�con = date�con;
    this.details = details;
    this.reminderTitle = reminderTitle;
    this.repeat = repeat;
    this.repeatLl = repeatLl;
    this.repeatNoText = repeatNoText;
    this.repeatNo�con = repeatNo�con;
    this.repeatSwitch = repeatSwitch;
    this.repeatText = repeatText;
    this.repeatTypeText = repeatTypeText;
    this.repeatType�con = repeatType�con;
    this.repeat�con = repeat�con;
    this.setDate = setDate;
    this.setRepeat = setRepeat;
    this.setRepeatNo = setRepeatNo;
    this.setRepeatType = setRepeatType;
    this.setTime = setTime;
    this.starred1 = starred1;
    this.starred2 = starred2;
    this.time = time;
    this.timeText = timeText;
    this.time�con = time�con;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      RelativeLayout RepeatNo = rootView.findViewById(R.id.RepeatNo);
      if (RepeatNo == null) {
        missingId = "RepeatNo";
        break missingId;
      }
      RelativeLayout RepeatType = rootView.findViewById(R.id.RepeatType);
      if (RepeatType == null) {
        missingId = "RepeatType";
        break missingId;
      }
      LinearLayout addReminderLayoutTop = rootView.findViewById(R.id.add_reminder_layout_top);
      if (addReminderLayoutTop == null) {
        missingId = "addReminderLayoutTop";
        break missingId;
      }
      RelativeLayout date = rootView.findViewById(R.id.date);
      if (date == null) {
        missingId = "date";
        break missingId;
      }
      TextView dateText = rootView.findViewById(R.id.date_text);
      if (dateText == null) {
        missingId = "dateText";
        break missingId;
      }
      ImageView date�con = rootView.findViewById(R.id.date_icon);
      if (date�con == null) {
        missingId = "date�con";
        break missingId;
      }
      TextView details = rootView.findViewById(R.id.details);
      if (details == null) {
        missingId = "details";
        break missingId;
      }
      EditText reminderTitle = rootView.findViewById(R.id.reminder_title);
      if (reminderTitle == null) {
        missingId = "reminderTitle";
        break missingId;
      }
      RelativeLayout repeat = rootView.findViewById(R.id.repeat);
      if (repeat == null) {
        missingId = "repeat";
        break missingId;
      }
      LinearLayout repeatLl = rootView.findViewById(R.id.repeat_ll);
      if (repeatLl == null) {
        missingId = "repeatLl";
        break missingId;
      }
      TextView repeatNoText = rootView.findViewById(R.id.repeat_no_text);
      if (repeatNoText == null) {
        missingId = "repeatNoText";
        break missingId;
      }
      ImageView repeatNo�con = rootView.findViewById(R.id.repeat_no_icon);
      if (repeatNo�con == null) {
        missingId = "repeatNo�con";
        break missingId;
      }
      Switch repeatSwitch = rootView.findViewById(R.id.repeat_switch);
      if (repeatSwitch == null) {
        missingId = "repeatSwitch";
        break missingId;
      }
      TextView repeatText = rootView.findViewById(R.id.repeat_text);
      if (repeatText == null) {
        missingId = "repeatText";
        break missingId;
      }
      TextView repeatTypeText = rootView.findViewById(R.id.repeat_type_text);
      if (repeatTypeText == null) {
        missingId = "repeatTypeText";
        break missingId;
      }
      ImageView repeatType�con = rootView.findViewById(R.id.repeat_type_icon);
      if (repeatType�con == null) {
        missingId = "repeatType�con";
        break missingId;
      }
      ImageView repeat�con = rootView.findViewById(R.id.repeat_icon);
      if (repeat�con == null) {
        missingId = "repeat�con";
        break missingId;
      }
      TextView setDate = rootView.findViewById(R.id.set_date);
      if (setDate == null) {
        missingId = "setDate";
        break missingId;
      }
      TextView setRepeat = rootView.findViewById(R.id.set_repeat);
      if (setRepeat == null) {
        missingId = "setRepeat";
        break missingId;
      }
      TextView setRepeatNo = rootView.findViewById(R.id.set_repeat_no);
      if (setRepeatNo == null) {
        missingId = "setRepeatNo";
        break missingId;
      }
      TextView setRepeatType = rootView.findViewById(R.id.set_repeat_type);
      if (setRepeatType == null) {
        missingId = "setRepeatType";
        break missingId;
      }
      TextView setTime = rootView.findViewById(R.id.set_time);
      if (setTime == null) {
        missingId = "setTime";
        break missingId;
      }
      FloatingActionButton starred1 = rootView.findViewById(R.id.starred1);
      if (starred1 == null) {
        missingId = "starred1";
        break missingId;
      }
      FloatingActionButton starred2 = rootView.findViewById(R.id.starred2);
      if (starred2 == null) {
        missingId = "starred2";
        break missingId;
      }
      RelativeLayout time = rootView.findViewById(R.id.time);
      if (time == null) {
        missingId = "time";
        break missingId;
      }
      TextView timeText = rootView.findViewById(R.id.time_text);
      if (timeText == null) {
        missingId = "timeText";
        break missingId;
      }
      ImageView time�con = rootView.findViewById(R.id.time_icon);
      if (time�con == null) {
        missingId = "time�con";
        break missingId;
      }
      Toolbar toolbar = rootView.findViewById(R.id.toolbar);
      if (toolbar == null) {
        missingId = "toolbar";
        break missingId;
      }
      return new ActivityMain2Binding((RelativeLayout) rootView, RepeatNo, RepeatType,
          addReminderLayoutTop, date, dateText, date�con, details, reminderTitle, repeat, repeatLl,
          repeatNoText, repeatNo�con, repeatSwitch, repeatText, repeatTypeText, repeatType�con,
          repeat�con, setDate, setRepeat, setRepeatNo, setRepeatType, setTime, starred1, starred2,
          time, timeText, time�con, toolbar);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}