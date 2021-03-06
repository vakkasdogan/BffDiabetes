// Generated by view binder compiler. Do not edit!
package com.example.bffdiabetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.example.bffdiabetes.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityForgotpasswordBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final AppCompatButton appCompatButtonConfirm;

  @NonNull
  public final NestedScrollView nestedScrollView;

  @NonNull
  public final TextInputEditText textInputEditTextEmail;

  @NonNull
  public final TextInputLayout textInputLayoutEmail;

  private ActivityForgotpasswordBinding(@NonNull NestedScrollView rootView,
      @NonNull AppCompatButton appCompatButtonConfirm, @NonNull NestedScrollView nestedScrollView,
      @NonNull TextInputEditText textInputEditTextEmail,
      @NonNull TextInputLayout textInputLayoutEmail) {
    this.rootView = rootView;
    this.appCompatButtonConfirm = appCompatButtonConfirm;
    this.nestedScrollView = nestedScrollView;
    this.textInputEditTextEmail = textInputEditTextEmail;
    this.textInputLayoutEmail = textInputLayoutEmail;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityForgotpasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityForgotpasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_forgotpassword, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityForgotpasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      AppCompatButton appCompatButtonConfirm = rootView.findViewById(R.id.appCompatButtonConfirm);
      if (appCompatButtonConfirm == null) {
        missingId = "appCompatButtonConfirm";
        break missingId;
      }
      NestedScrollView nestedScrollView = rootView.findViewById(R.id.nestedScrollView);
      if (nestedScrollView == null) {
        missingId = "nestedScrollView";
        break missingId;
      }
      TextInputEditText textInputEditTextEmail = rootView.findViewById(R.id.textInputEditTextEmail);
      if (textInputEditTextEmail == null) {
        missingId = "textInputEditTextEmail";
        break missingId;
      }
      TextInputLayout textInputLayoutEmail = rootView.findViewById(R.id.textInputLayoutEmail);
      if (textInputLayoutEmail == null) {
        missingId = "textInputLayoutEmail";
        break missingId;
      }
      return new ActivityForgotpasswordBinding((NestedScrollView) rootView, appCompatButtonConfirm,
          nestedScrollView, textInputEditTextEmail, textInputLayoutEmail);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
