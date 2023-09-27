package com.enterprisechallegenge.api.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_paciente")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column
    private String ds_sexo;
    @Column
    private Integer nm_paciente;

    @Column
    private String dt_nascimento;

    @Column
    private Integer ds_peso;

    @Column
    private Integer ds_altura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinica_id", referencedColumnName = "id")
    private Office office;

    public Patient(Long id, String ds_sexo, Integer nm_paciente, String dt_nascimento, Integer ds_peso, Integer ds_altura, Office office) {
        this.id = id;
        this.ds_sexo = ds_sexo;
        this.nm_paciente = nm_paciente;
        this.dt_nascimento = dt_nascimento;
        this.ds_peso = ds_peso;
        this.ds_altura = ds_altura;
        this.office = office;
    }

    public Patient() {

    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
