/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import utfpr.projetofinalweb.entity.Artista;

/**
 *
 * @author Samsung
 */
public class ArtistaDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Artista> pesquisarPorNome(String nome) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT a FROM Artista a WHERE a.nome LIKE :nome", Artista.class);
            q.setParameter("nome", nome);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artista> pesquisarPorUsuario(long codUsuario) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT a FROM Artista a WHERE a.usuario.codigo = :codigo", Artista.class);
            q.setParameter("codigo", codUsuario);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artista> listar() {
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Artista.findAll");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
