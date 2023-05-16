package com.ista.gestion_capacitaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ista.gestion_capacitaciones.UI.LoginActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro;
    Button btnLoguin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoguin=findViewById(R.id.btnLoguin);
        btnRegistro=findViewById(R.id.btnRegistro);

        btnLoguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loguin();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    public void Loguin(){
        Intent loguin=new Intent(this, LoginActivity.class);
        startActivity(loguin);
    }

    @Override
    public void onBackPressed(){
        new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE).setTitleText("Deseas Salir")
                .setContentText("Quieres cerrar la aplicacion ?")
                .setCancelText("No, Cancelar!").setConfirmText("Si, Cerrar")
                .showCancelButton(true).setCancelClickListener(sDialog ->{
                    sDialog.dismissWithAnimation();
                    new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE).setTitleText("Operacion cancelada")
                            .setContentText("No saliste de la app")
                            .show();
                }).setConfirmClickListener(sweetAlertDialog -> {
                    sweetAlertDialog.dismissWithAnimation();
                    System.exit(0);
                }).show();
    }


}