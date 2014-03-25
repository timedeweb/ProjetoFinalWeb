/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import utfpr.projetofinalweb.entity.Faixa;

/**
 *
 * @author Samsung
 */
public class FaixaDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Faixa> pesquisarPorNome(String nome) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT f FROM Faixa f WHERE f.titulo like :titulo", Faixa.class);
            q.setParameter("titulo", "%" + nome + "%");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public List<Faixa> pesquisarPorNomeUsuario(String nome, long codUsuario) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT f FROM Faixa f WHERE f.titulo like :titulo and f.usuario.codigo = :codigo", Faixa.class);
            q.setParameter("titulo", "%" + nome + "%");
            q.setParameter("codigo", codUsuario);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public List<Faixa> pesquisarPorUsuario(long codUsuario) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT f FROM Faixa f WHERE f.usuario.codigo = :codigo", Faixa.class);
            q.setParameter("codigo", codUsuario);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Faixa> pesquisarPorAlbum(long codAlbum) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT f FROM Faixa f WHERE f.album.codigo = :codigo", Faixa.class);
            q.setParameter("codigo", codAlbum);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Faixa> listar() {
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Faixa.findAll");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
