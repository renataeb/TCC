/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long>{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }

}

        
   