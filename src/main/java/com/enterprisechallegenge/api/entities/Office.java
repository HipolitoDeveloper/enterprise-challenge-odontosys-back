package com.enterprisechallegenge.api.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_clinica")
public class Office implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column
    private String nm_rua;
    @Column
    private String nm_bairro;

    @Column
    private String nr_local;

    public Office(Long id, String nm_rua, String nm_bairro, String nr_local) {
        this.id = id;
        this.nm_rua = nm_rua;
        this.nm_bairro = nm_bairro;
        this.nr_local = nr_local;
    }

    public Office() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNm_rua() {
        return nm_rua;
    }

    public void setNm_rua(String nm_rua) {
        this.nm_rua = nm_rua;
    }

    public String getNm_bairro() {
        return nm_bairro;
    }

    public void setNm_bairro(String nm_bairro) {
        this.nm_bairro = nm_bairro;
    }

    public String getNr_local() {
        return nr_local;
    }

    public void setNr_local(String nr_local) {
        this.nr_local = nr_local;
    }


}
