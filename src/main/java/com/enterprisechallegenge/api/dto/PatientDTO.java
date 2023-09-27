package com.enterprisechallegenge.api.dto;

public class PatientDTO {

    private Long id;

    private Long clinica_id;
    private String ds_sexo;
    private Integer nm_paciente;
    private String dt_nascimento;
    private Integer ds_peso;
    private Integer ds_altura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClinica_id() {
        return clinica_id;
    }

    public void setClinica_id(Long clinica_id) {
        this.clinica_id = clinica_id;
    }

    public String getDs_sexo() {
        return ds_sexo;
    }

    public void setDs_sexo(String ds_sexo) {
        this.ds_sexo = ds_sexo;
    }

    public Integer getNm_paciente() {
        return nm_paciente;
    }

    public void setNm_paciente(Integer nm_paciente) {
        this.nm_paciente = nm_paciente;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Integer getDs_peso() {
        return ds_peso;
    }

    public void setDs_peso(Integer ds_peso) {
        this.ds_peso = ds_peso;
    }

    public Integer getDs_altura() {
        return ds_altura;
    }

    public void setDs_altura(Integer ds_altura) {
        this.ds_altura = ds_altura;
    }
}
