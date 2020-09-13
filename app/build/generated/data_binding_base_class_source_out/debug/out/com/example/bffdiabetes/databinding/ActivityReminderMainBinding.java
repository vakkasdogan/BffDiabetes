// Generated by view binder compiler. Do not edit!
package com.example.bffdiabetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

public final class ActivityReminderMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout emptyView;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final ListView list;

  @NonNull
  public final TextView noReminderText;

  @NonNull
  public final TextView reminderText;

  @NonNull
  public final Toolbar toolbar;

  private ActivityReminderMainBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout emptyView, @NonNull FloatingActionButton fab, @NonNull ListView list,
      @NonNull TextView noReminderText, @NonNull TextView reminderText, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.emptyView = emptyView;
    this.fab = fab;
    this.list = list;
    this.noReminderText = noReminderText;
    this.reminderText = reminderText;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityReminderMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityReminderMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_reminder_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityReminderMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      RelativeLayout emptyView = rootView.findViewById(R.id.empty_view);
      if (emptyView == null) {
        missingId = "emptyView";
        break missingId;
      }
      FloatingActionButton fab = rootView.findViewById(R.id.fab);
      if (fab == null) {
        missingId = "fab";
        break missingId;
      }
      ListView list = rootView.findViewById(R.id.list);
      if (list == null) {
        missingId = "list";
        break missingId;
      }
      TextView noReminderText = rootView.findViewById(R.id.no_reminder_text);
      if (noReminderText == null) {
        missingId = "noReminderText";
        break missingId;
      }
      TextView reminderText = rootView.findViewById(R.id.reminderText);
      if (reminderText == null) {
        missingId = "reminderText";
        break missingId;
      }
      Toolbar toolbar = rootView.findViewById(R.id.toolbar);
      if (toolbar == null) {
        missingId = "toolbar";
        break missingId;
      }
      return new ActivityReminderMainBinding((RelativeLayout) rootView, emptyView, fab, list,
          noReminderText, reminderText, toolbar);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}