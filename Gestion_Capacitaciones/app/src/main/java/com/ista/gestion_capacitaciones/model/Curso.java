/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 18:48
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;
import java.util.List;

public class Curso {

    private Long curId;
    private String curCodigo;
    private String curNombre;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date curFechainicio;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date curFechafin;
    private Integer curNumhoras;
    private String curProceso;
    private transient byte[] curFoto;
    private Boolean curEstado;
    private ProgramaCapacitacion programaCapacitacion;

    private List<HorarioCurso> horarioCursos;

    private Especialidad ecursos;

    private ModalidadCurso mcursos;

    private TipoCurso tipoCurso;

    private DatosSilabo datosSilabo;

    private NecesidadCurso necesidadCurso;

    private DisenoCurricular disenoCurricular;

    private List<RegistroFotografico> registroFotograficos;

    private List<AsistenciaCurso> asistenciaCursos;

    private List<FichaInscripcion> fichaIncripcions;

    private List<Participante> participantes;

    private List<InformeFinal> informeFinals;

    private List<FichaEvaluacion> fichaEvaluacions;

    private Persona pcurso;
    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public Date getCurFechainicio() {
        return curFechainicio;
    }

    public void setCurFechainicio(Date curFechainicio) {
        this.curFechainicio = curFechainicio;
    }

    public Date getCurFechafin() {
        return curFechafin;
    }

    public void setCurFechafin(Date curFechafin) {
        this.curFechafin = curFechafin;
    }

    public Integer getCurNumhoras() {
        return curNumhoras;
    }

    public void setCurNumhoras(Integer curNumhoras) {
        this.curNumhoras = curNumhoras;
    }

    public String getCurProceso() {
        return curProceso;
    }

    public void setCurProceso(String curProceso) {
        this.curProceso = curProceso;
    }

    public Boolean getCurEstado() {
        return curEstado;
    }

    public void setCurEstado(Boolean curEstado) {
        this.curEstado = curEstado;
    }

    public ProgramaCapacitacion getProgramaCapacitacion() {
        return programaCapacitacion;
    }

    public void setProgramaCapacitacion(ProgramaCapacitacion programaCapacitacion) {
        this.programaCapacitacion = programaCapacitacion;
    }

    public List<HorarioCurso> getHorarioCursos() {
        return horarioCursos;
    }

    public void setHorarioCursos(List<HorarioCurso> horarioCursos) {
        this.horarioCursos = horarioCursos;
    }

    public Especialidad getEcursos() {
        return ecursos;
    }

    public void setEcursos(Especialidad ecursos) {
        this.ecursos = ecursos;
    }

    public ModalidadCurso getMcursos() {
        return mcursos;
    }

    public void setMcursos(ModalidadCurso mcursos) {
        this.mcursos = mcursos;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public DatosSilabo getDatosSilabo() {
        return datosSilabo;
    }

    public void setDatosSilabo(DatosSilabo datosSilabo) {
        this.datosSilabo = datosSilabo;
    }

    public NecesidadCurso getNecesidadCurso() {
        return necesidadCurso;
    }

    public void setNecesidadCurso(NecesidadCurso necesidadCurso) {
        this.necesidadCurso = necesidadCurso;
    }

    public DisenoCurricular getDisenoCurricular() {
        return disenoCurricular;
    }

    public void setDisenoCurricular(DisenoCurricular disenoCurricular) {
        this.disenoCurricular = disenoCurricular;
    }

    public List<RegistroFotografico> getRegistroFotograficos() {
        return registroFotograficos;
    }

    public void setRegistroFotograficos(List<RegistroFotografico> registroFotograficos) {
        this.registroFotograficos = registroFotograficos;
    }

    public List<AsistenciaCurso> getAsistenciaCursos() {
        return asistenciaCursos;
    }

    public void setAsistenciaCursos(List<AsistenciaCurso> asistenciaCursos) {
        this.asistenciaCursos = asistenciaCursos;
    }

    public List<FichaInscripcion> getFichaIncripcions() {
        return fichaIncripcions;
    }

    public void setFichaIncripcions(List<FichaInscripcion> fichaIncripcions) {
        this.fichaIncripcions = fichaIncripcions;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<InformeFinal> getInformeFinals() {
        return informeFinals;
    }

    public void setInformeFinals(List<InformeFinal> informeFinals) {
        this.informeFinals = informeFinals;
    }

    public List<FichaEvaluacion> getFichaEvaluacions() {
        return fichaEvaluacions;
    }

    public void setFichaEvaluacions(List<FichaEvaluacion> fichaEvaluacions) {
        this.fichaEvaluacions = fichaEvaluacions;
    }

    public Persona getPcurso() {
        return pcurso;
    }

    public void setPcurso(Persona pcurso) {
        this.pcurso = pcurso;
    }
}
