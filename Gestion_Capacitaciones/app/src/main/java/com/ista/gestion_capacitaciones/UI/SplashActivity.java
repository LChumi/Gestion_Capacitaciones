package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.ista.gestion_capacitaciones.MainActivity;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.db.SqlConexion;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SqlConexion concexion =new SqlConexion(SplashActivity.this);
        SQLiteDatabase db = concexion.getWritableDatabase();
        if (db!=null){
            Toast.makeText(SplashActivity.this," BASE DE DATOS CREADA ",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(SplashActivity.this," NO SE PUDO CREAR ",Toast.LENGTH_LONG).show();
        }

        final Intent i = new Intent(SplashActivity.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        }, 1000);
    }
}