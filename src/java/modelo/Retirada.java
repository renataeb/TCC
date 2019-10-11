/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Aluno
 */
@Entity
public class Retirada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String usuario;
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date datareserva;
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date dataentrega;
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDatareserva() {
        return datareserva;
    }

    public void setDatareserva(Date datareserva) {
        this.datareserva = datareserva;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

 
    }


   