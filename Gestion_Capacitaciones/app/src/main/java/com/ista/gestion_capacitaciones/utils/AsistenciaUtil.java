package com.ista.gestion_capacitaciones.utils;

import com.ista.gestion_capacitaciones.api.clients.AsistenciaApiClient;
import com.ista.gestion_capacitaciones.db.DbAsistencias;
import com.ista.gestion_capacitaciones.model.Asistencia;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsistenciaUtil {

    private static final ArrayList<Participante> detalleAsistencia = new ArrayList<>();

    public  String agregarAsistencias(List<Participante> participantes, List<Integer> numFaltas, AsistenciaApiClient apiClient, DbAsistencias dbAsistencia) {
        for (Participante participante : participantes) {
            for (Integer num:numFaltas){
                Asistencia asistencia = new Asistencia();
                asistencia.setAsiParticipante(participante);
                asistencia.setAsiFecha(new Date());
                asistencia.setAsiNumfaltas(num);
                asistencia.setAsiEstado(true);
                // Agregar asistencia a la lista
                participante.getAsistencias().add(asistencia);
                // Guardar asistencia en la API
                guardarAsistenciaEnApi(asistencia, apiClient);
                // Guardar asistencia en la base de datos local
                // guardarAsistenciaEnBaseDeDatos(asistencia, dbAsistencia);
            }

        }

        return "Asistencias guardadas";
    }

    private static void guardarAsistenciaEnApi(Asistencia asistencia, AsistenciaApiClient apiClient) {
        Call<Asistencia> call = apiClient.crear(asistencia);
        call.enqueue(new Callback<Asistencia>() {
            @Override
            public void onResponse(Call<Asistencia> call, Response<Asistencia> response) {
                if (response.isSuccessful()) {
                    // Asistencia guardada en la API correctamente
                } else {
                    // Error al guardar la asistencia en la API
                }
            }

            @Override
            public void onFailure(Call<Asistencia> call, Throwable t) {
                // Error de conexión o fallo en la llamada a la API
            }
        });
    }

    private static void guardarAsistenciaEnBaseDeDatos(Asistencia asistencia, DbAsistencias dbAsistencia) {
        long result = dbAsistencia.insertarAsistencia(asistencia.getAsiNumfaltas(), asistencia.getAsiFecha(), asistencia.getAsiParticipante().getParId());
        if (result > 0) {
            // Asistencia guardada en la base de datos local correctamente
        } else {
            // Error al guardar la asistencia en la base de datos local
        }
    }
}

