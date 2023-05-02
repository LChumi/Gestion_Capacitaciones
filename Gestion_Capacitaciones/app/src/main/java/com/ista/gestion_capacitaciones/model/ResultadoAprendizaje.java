package com.ista.gestion_capacitaciones.model;

public class ResultadoAprendizaje {

    private Long rapId;
    private String rapUnidadcompe;
    private String rapElementoscompe;
    private String rapResultadosaprenactiv;
    private String rapFormaevidenciar;
    private Boolean rapEstado;

    private DatosSilabo rapSilabo;

    public Long getRapId() {
        return rapId;
    }

    public void setRapId(Long rapId) {
        this.rapId = rapId;
    }

    public String getRapUnidadcompe() {
        return rapUnidadcompe;
    }

    public void setRapUnidadcompe(String rapUnidadcompe) {
        this.rapUnidadcompe = rapUnidadcompe;
    }

    public String getRapElementoscompe() {
        return rapElementoscompe;
    }

    public void setRapElementoscompe(String rapElementoscompe) {
        this.rapElementoscompe = rapElementoscompe;
    }

    public String getRapResultadosaprenactiv() {
        return rapResultadosaprenactiv;
    }

    public void setRapResultadosaprenactiv(String rapResultadosaprenactiv) {
        this.rapResultadosaprenactiv = rapResultadosaprenactiv;
    }

    public String getRapFormaevidenciar() {
        return rapFormaevidenciar;
    }

    public void setRapFormaevidenciar(String rapFormaevidenciar) {
        this.rapFormaevidenciar = rapFormaevidenciar;
    }

    public Boolean getRapEstado() {
        return rapEstado;
    }

    public void setRapEstado(Boolean rapEstado) {
        this.rapEstado = rapEstado;
    }

    public DatosSilabo getRapSilabo() {
        return rapSilabo;
    }

    public void setRapSilabo(DatosSilabo rapSilabo) {
        this.rapSilabo = rapSilabo;
    }
}
