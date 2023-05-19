// Generated by view binder compiler. Do not edit!
package com.ista.gestion_capacitaciones.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.ista.gestion_capacitaciones.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityListaEstudianteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppBarLayout bar;

  @NonNull
  public final Button button;

  @NonNull
  public final RecyclerView listaEstudiantes;

  @NonNull
  public final TextView nombreCurso;

  @NonNull
  public final Toolbar toolbar;

  private ActivityListaEstudianteBinding(@NonNull LinearLayout rootView, @NonNull AppBarLayout bar,
      @NonNull Button button, @NonNull RecyclerView listaEstudiantes, @NonNull TextView nombreCurso,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.bar = bar;
    this.button = button;
    this.listaEstudiantes = listaEstudiantes;
    this.nombreCurso = nombreCurso;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityListaEstudianteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityListaEstudianteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lista_estudiante, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityListaEstudianteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bar;
      AppBarLayout bar = ViewBindings.findChildViewById(rootView, id);
      if (bar == null) {
        break missingId;
      }

      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.lista_estudiantes;
      RecyclerView listaEstudiantes = ViewBindings.findChildViewById(rootView, id);
      if (listaEstudiantes == null) {
        break missingId;
      }

      id = R.id.nombre_curso;
      TextView nombreCurso = ViewBindings.findChildViewById(rootView, id);
      if (nombreCurso == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityListaEstudianteBinding((LinearLayout) rootView, bar, button,
          listaEstudiantes, nombreCurso, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
