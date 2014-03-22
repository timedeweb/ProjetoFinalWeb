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
        try {
            em = getEntityManager();
            Query q = em.createQuery("select u from Usuario u where u.nome like :nome", Usuario.class);
            q.setParameter("nome", nome);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> listar() {
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Usuario.findAll");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Usuario pesquisarPorEmail(String email) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
            q.setParameter("email", email);
            return (Usuario) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
