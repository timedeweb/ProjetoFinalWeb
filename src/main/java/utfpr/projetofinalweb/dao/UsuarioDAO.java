/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import utfpr.projetofinalweb.entity.Usuario;

/**
 *
 * @author Samsung
 */
public class UsuarioDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Usuario> pesquisarPorNome(String nome) {
        return null;
    }

    public List<Usuario> listar() {
        em = getEntityManager();
        Query q = em.createNamedQuery("Usuario.findAll");
        return q.getResultList();
    }
    public Usuario pesquisarPorEmail(String email){
        return null;
    }

}
