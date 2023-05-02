// Generated by view binder compiler. Do not edit!
package com.ista.gestion_capacitaciones.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ista.gestion_capacitaciones.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText editTextText3;

  @NonNull
  public final EditText editTextText4;

  @NonNull
  public final EditText editTextText5;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText editTextText3, @NonNull EditText editTextText4,
      @NonNull EditText editTextText5, @NonNull ImageView imageView11,
      @NonNull ImageView imageView7, @NonNull TextView textView10, @NonNull TextView textView11,
      @NonNull TextView textView12, @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.editTextText3 = editTextText3;
    this.editTextText4 = editTextText4;
    this.editTextText5 = editTextText5;
    this.imageView11 = imageView11;
    this.imageView7 = imageView7;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editTextText3;
      EditText editTextText3 = ViewBindings.findChildViewById(rootView, id);
      if (editTextText3 == null) {
        break missingId;
      }

      id = R.id.editTextText4;
      EditText editTextText4 = ViewBindings.findChildViewById(rootView, id);
      if (editTextText4 == null) {
        break missingId;
      }

      id = R.id.editTextText5;
      EditText editTextText5 = ViewBindings.findChildViewById(rootView, id);
      if (editTextText5 == null) {
        break missingId;
      }

      id = R.id.imageView11;
      ImageView imageView11 = ViewBindings.findChildViewById(rootView, id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, editTextText3, editTextText4,
          editTextText5, imageView11, imageView7, textView10, textView11, textView12, textView8,
          textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
