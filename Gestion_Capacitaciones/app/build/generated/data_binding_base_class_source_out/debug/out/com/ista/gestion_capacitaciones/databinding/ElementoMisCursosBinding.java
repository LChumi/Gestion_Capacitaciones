// Generated by view binder compiler. Do not edit!
package com.ista.gestion_capacitaciones.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ista.gestion_capacitaciones.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ElementoMisCursosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final Guideline guideline5;

  @NonNull
  public final Guideline guideline6;

  @NonNull
  public final Guideline guideline7;

  @NonNull
  public final ImageView ivImagen;

  @NonNull
  public final TextView tvDirector;

  @NonNull
  public final TextView tvTitulo;

  private ElementoMisCursosBinding(@NonNull ConstraintLayout rootView, @NonNull Guideline guideline,
      @NonNull Guideline guideline2, @NonNull Guideline guideline3, @NonNull Guideline guideline4,
      @NonNull Guideline guideline5, @NonNull Guideline guideline6, @NonNull Guideline guideline7,
      @NonNull ImageView ivImagen, @NonNull TextView tvDirector, @NonNull TextView tvTitulo) {
    this.rootView = rootView;
    this.guideline = guideline;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.guideline4 = guideline4;
    this.guideline5 = guideline5;
    this.guideline6 = guideline6;
    this.guideline7 = guideline7;
    this.ivImagen = ivImagen;
    this.tvDirector = tvDirector;
    this.tvTitulo = tvTitulo;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ElementoMisCursosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ElementoMisCursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.elemento_mis_cursos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ElementoMisCursosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline;
      Guideline guideline = ViewBindings.findChildViewById(rootView, id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.guideline4;
      Guideline guideline4 = ViewBindings.findChildViewById(rootView, id);
      if (guideline4 == null) {
        break missingId;
      }

      id = R.id.guideline5;
      Guideline guideline5 = ViewBindings.findChildViewById(rootView, id);
      if (guideline5 == null) {
        break missingId;
      }

      id = R.id.guideline6;
      Guideline guideline6 = ViewBindings.findChildViewById(rootView, id);
      if (guideline6 == null) {
        break missingId;
      }

      id = R.id.guideline7;
      Guideline guideline7 = ViewBindings.findChildViewById(rootView, id);
      if (guideline7 == null) {
        break missingId;
      }

      id = R.id.ivImagen;
      ImageView ivImagen = ViewBindings.findChildViewById(rootView, id);
      if (ivImagen == null) {
        break missingId;
      }

      id = R.id.tvDirector;
      TextView tvDirector = ViewBindings.findChildViewById(rootView, id);
      if (tvDirector == null) {
        break missingId;
      }

      id = R.id.tvTitulo;
      TextView tvTitulo = ViewBindings.findChildViewById(rootView, id);
      if (tvTitulo == null) {
        break missingId;
      }

      return new ElementoMisCursosBinding((ConstraintLayout) rootView, guideline, guideline2,
          guideline3, guideline4, guideline5, guideline6, guideline7, ivImagen, tvDirector,
          tvTitulo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
