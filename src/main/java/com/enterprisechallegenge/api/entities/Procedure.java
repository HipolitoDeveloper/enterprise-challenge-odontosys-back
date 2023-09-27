package com.enterprisechallegenge.api.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_procedimento")
public class Procedure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column
    private String nm_procedimento;

    public Procedure(Long id, String nm_procedimento) {
        this.id = id;
        this.nm_procedimento = nm_procedimento;
    }

    public Procedure() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNm_procedimento() {
        return nm_procedimento;
    }

    public void setNm_procedimento(String nm_procedimento) {
        this.nm_procedimento = nm_procedimento;
    }


}
