// Generated by view binder compiler. Do not edit!
package com.ista.gestion_capacitaciones.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ista.gestion_capacitaciones.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ElemenstosProgramaCursosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private ElemenstosProgramaCursosBinding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ElemenstosProgramaCursosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ElemenstosProgramaCursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.elemenstos_programa_cursos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ElemenstosProgramaCursosBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ElemenstosProgramaCursosBinding((ConstraintLayout) rootView);
  }
}
