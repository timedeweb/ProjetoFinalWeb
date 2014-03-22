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
    
    public List<Artista> pesquisarPorNome(String nome){
        em = getEntityManager();
        Query q = em.createNamedQuery("SELECT a FROM Artista a WHERE a.nome LIKE " + nome, Artista.class);
        return q.getResultList();
    }
    public List<Artista> pesquisarPorUsuario(long codUsuario){
        em = getEntityManager();
        Query q = em.createNamedQuery("SELECT a FROM Artista a WHERE a.usuario = " + codUsuario, Artista.class);
        return q.getResultList();
    }
    public List<Artista> listar(){
        em = getEntityManager();
        Query q = em.createNamedQuery("Artista.findAll");
        return q.getResultList();
    }
}
