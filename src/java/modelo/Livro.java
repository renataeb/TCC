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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findFilter", query = "SELECT l FROM Livro l WHERE l.titulo like :filtro")
})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String titulo;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Genero genero;
    
    @ManyToOne
    private Editora editora;

    public String getEndFoto1() {
        return endFoto1;
    }

    public void setEndFoto1(String endFoto1) {
        this.endFoto1 = endFoto1;
    }

    public String getEndFoto2() {
        return endFoto2;
    }

    public void setEndFoto2(String endFoto2) {
        this.endFoto2 = endFoto2;
    }
    
    private String endFoto1;
    private String endFoto2;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

   
}

    
   