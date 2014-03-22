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
        em = getEntityManager();
        Query q = em.createNamedQuery("select a from Album a where a.titulo like " + nome, Album.class);
        return q.getResultList();
    }

    public List<Album> pesquisarPorUsuario(long codUsuario) {
        em = getEntityManager();
        Query q = em.createNamedQuery("select a from Album a where a.usuario = " + codUsuario, Album.class);
        return q.getResultList();
    }

    public List<Album> pesquisarPorArtista(long codArtista) {
        em = getEntityManager();
        Query q = em.createNamedQuery("select a from Album a where a.artista = " + codArtista, Album.class);
        return q.getResultList();
    }
    public List<Album> listar(){
        em = getEntityManager();
        Query q = em.createNamedQuery("Album.findAll");
        return q.getResultList();
    }

}
