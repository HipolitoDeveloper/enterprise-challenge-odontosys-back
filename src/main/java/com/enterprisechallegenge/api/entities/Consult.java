package com.enterprisechallegenge.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_consulta")
public class Consult implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "procedure_id", referencedColumnName = "id")
    private Procedure procedure;

    @Column
    private String dt_hr_consulta;
    @Column
    private Integer nr_consultorio;

    public Consult() {

    }

    public Consult(Long id, Doctor doctor, Patient patient, Procedure procedure, String dt_hr_consulta, Integer nr_consultorio) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.procedure = procedure;
        this.dt_hr_consulta = dt_hr_consulta;
        this.nr_consultorio = nr_consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDt_hr_consulta() {
        return dt_hr_consulta;
    }

    public void setDt_hr_consulta(String dt_hr_consulta) {
        this.dt_hr_consulta = dt_hr_consulta;
    }

    public Integer getNr_consultorio() {
        return nr_consultorio;
    }

    public void setNr_consultorio(Integer nr_consultorio) {
        this.nr_consultorio = nr_consultorio;
    }
}