package com.ista.gestion_capacitaciones.model;

public class EntornoAprendizaje {

    private Long eapId;
    private String eapInstalaciones;
    private String eapRecursos;
    private String eapFaseteorica;
    private String eapFasepractica;
    private Boolean eapEstado;

    private DisenoCurricular eapDiseno;

    public Long getEapId() {
        return eapId;
    }

    public void setEapId(Long eapId) {
        this.eapId = eapId;
    }

    public String getEapInstalaciones() {
        return eapInstalaciones;
    }

    public void setEapInstalaciones(String eapInstalaciones) {
        this.eapInstalaciones = eapInstalaciones;
    }

    public String getEapRecursos() {
        return eapRecursos;
    }

    public void setEapRecursos(String eapRecursos) {
        this.eapRecursos = eapRecursos;
    }

    public String getEapFaseteorica() {
        return eapFaseteorica;
    }

    public void setEapFaseteorica(String eapFaseteorica) {
        this.eapFaseteorica = eapFaseteorica;
    }

    public String getEapFasepractica() {
        return eapFasepractica;
    }

    public void setEapFasepractica(String eapFasepractica) {
        this.eapFasepractica = eapFasepractica;
    }

    public Boolean getEapEstado() {
        return eapEstado;
    }

    public void setEapEstado(Boolean eapEstado) {
        this.eapEstado = eapEstado;
    }

    public DisenoCurricular getEapDiseno() {
        return eapDiseno;
    }

    public void setEapDiseno(DisenoCurricular eapDiseno) {
        this.eapDiseno = eapDiseno;
    }
}
