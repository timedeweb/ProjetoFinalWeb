/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import utfpr.projetofinalweb.entity.Album;

/**
 *
 * @author Samsung
 */
public class AlbumDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Album> pesquisarPorNome(String nome) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("select a from Album a where a.titulo like :titulo", Album.class);
            q.setParameter("titulo", "%" + nome + "%");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Album> pesquisarPorNomeUsuario(String nome, long codUsuario) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("select a from Album a where a.titulo like :titulo and a.usuario.codigo = :codigo", Album.class);
            q.setParameter("titulo", "%" + nome + "%");
            q.setParameter("codigo", codUsuario);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Album> pesquisarPorUsuario(long codUsuario) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("select a from Album a where a.usuario.codigo = :codigo", Album.class);
            q.setParameter("codigo", codUsuario);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Album> pesquisarPorArtista(long codArtista) {
        try {
            em = getEntityManager();
            Query q = em.createQuery("select a from Album a where a.artista.codigo = :codigo", Album.class);
            q.setParameter("codigo", codArtista);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Album> listar() {
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Album.findAll");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
