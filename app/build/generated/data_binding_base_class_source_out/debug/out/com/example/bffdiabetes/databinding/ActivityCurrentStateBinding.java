// Generated by view binder compiler. Do not edit!
package com.example.bffdiabetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.bffdiabetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCurrentStateBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button alarmButon;

  @NonNull
  public final TextView currentTextWrite;

  @NonNull
  public final TextView currentTextview;

  @NonNull
  public final TextView mesaj;

  @NonNull
  public final TextView state;

  @NonNull
  public final TextView stateText;

  @NonNull
  public final TextView tips;

  private ActivityCurrentStateBinding(@NonNull RelativeLayout rootView, @NonNull Button alarmButon,
      @NonNull TextView currentTextWrite, @NonNull TextView currentTextview,
      @NonNull TextView mesaj, @NonNull TextView state, @NonNull TextView stateText,
      @NonNull TextView tips) {
    this.rootView = rootView;
    this.alarmButon = alarmButon;
    this.currentTextWrite = currentTextWrite;
    this.currentTextview = currentTextview;
    this.mesaj = mesaj;
    this.state = state;
    this.stateText = stateText;
    this.tips = tips;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCurrentStateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCurrentStateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_current_state, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCurrentStateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      Button alarmButon = rootView.findViewById(R.id.alarm_buton);
      if (alarmButon == null) {
        missingId = "alarmButon";
        break missingId;
      }
      TextView currentTextWrite = rootView.findViewById(R.id.current_text_write);
      if (currentTextWrite == null) {
        missingId = "currentTextWrite";
        break missingId;
      }
      TextView currentTextview = rootView.findViewById(R.id.current_textview);
      if (currentTextview == null) {
        missingId = "currentTextview";
        break missingId;
      }
      TextView mesaj = rootView.findViewById(R.id.mesaj);
      if (mesaj == null) {
        missingId = "mesaj";
        break missingId;
      }
      TextView state = rootView.findViewById(R.id.state);
      if (state == null) {
        missingId = "state";
        break missingId;
      }
      TextView stateText = rootView.findViewById(R.id.state_text);
      if (stateText == null) {
        missingId = "stateText";
        break missingId;
      }
      TextView tips = rootView.findViewById(R.id.tips);
      if (tips == null) {
        missingId = "tips";
        break missingId;
      }
      return new ActivityCurrentStateBinding((RelativeLayout) rootView, alarmButon,
          currentTextWrite, currentTextview, mesaj, state, stateText, tips);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
