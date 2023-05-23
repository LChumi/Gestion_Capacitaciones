/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 17/5/23 1:11
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ista.gestion_capacitaciones.UI.LoginActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Button btnLoguin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoguin=findViewById(R.id.btnLoguin);


        btnLoguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loguin();
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