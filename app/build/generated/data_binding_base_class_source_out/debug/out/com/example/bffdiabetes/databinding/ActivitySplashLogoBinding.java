// Generated by view binder compiler. Do not edit!
package com.example.bffdiabetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.bffdiabetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashLogoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView bff;

  @NonNull
  public final ImageButton logoGiris;

  private ActivitySplashLogoBinding(@NonNull RelativeLayout rootView, @NonNull TextView bff,
      @NonNull ImageButton logoGiris) {
    this.rootView = rootView;
    this.bff = bff;
    this.logoGiris = logoGiris;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashLogoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashLogoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash_logo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashLogoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView bff = rootView.findViewById(R.id.bff);
      if (bff == null) {
        missingId = "bff";
        break missingId;
      }
      ImageButton logoGiris = rootView.findViewById(R.id.logo_giris);
      if (logoGiris == null) {
        missingId = "logoGiris";
        break missingId;
      }
      return new ActivitySplashLogoBinding((RelativeLayout) rootView, bff, logoGiris);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
