// Generated by view binder compiler. Do not edit!
package com.ista.gestion_capacitaciones.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ista.gestion_capacitaciones.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashBinding implements ViewBinding {
  @NonNull
  private final MotionLayout rootView;

  @NonNull
  public final TextView appCopyright;

  @NonNull
  public final ConstraintLayout backgroundLayout;

  @NonNull
  public final ImageView logo;

  @NonNull
  public final ImageView whiteLogo;

  private ActivitySplashBinding(@NonNull MotionLayout rootView, @NonNull TextView appCopyright,
      @NonNull ConstraintLayout backgroundLayout, @NonNull ImageView logo,
      @NonNull ImageView whiteLogo) {
    this.rootView = rootView;
    this.appCopyright = appCopyright;
    this.backgroundLayout = backgroundLayout;
    this.logo = logo;
    this.whiteLogo = whiteLogo;
  }

  @Override
  @NonNull
  public MotionLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_copyright;
      TextView appCopyright = ViewBindings.findChildViewById(rootView, id);
      if (appCopyright == null) {
        break missingId;
      }

      id = R.id.backgroundLayout;
      ConstraintLayout backgroundLayout = ViewBindings.findChildViewById(rootView, id);
      if (backgroundLayout == null) {
        break missingId;
      }

      id = R.id.logo;
      ImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.white_logo;
      ImageView whiteLogo = ViewBindings.findChildViewById(rootView, id);
      if (whiteLogo == null) {
        break missingId;
      }

      return new ActivitySplashBinding((MotionLayout) rootView, appCopyright, backgroundLayout,
          logo, whiteLogo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
