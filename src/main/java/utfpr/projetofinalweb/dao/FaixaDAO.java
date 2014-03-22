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
import utfpr.projetofinalweb.entity.Faixa;

/**
 *
 * @author Samsung
 */
public class FaixaDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Faixa> pesquisarPorNome(String nome){
        em = getEntityManager();
        Query q = em.createNamedQuery("SELECT f FROM Faixa f WHERE f.titulo LIKE " + nome, Faixa.class);
        return q.getResultList();
    }
    public List<Faixa> pesquisarPorUsuario(long codUsuario){
        em = getEntityManager();
        Query q = em.createNamedQuery("SELECT f FROM Faixa f WHERE f.usuario = " + codUsuario, Faixa.class);
        return q.getResultList();
    }
    public List<Faixa> pesquisarPorAlbum(long codAlbum) {
        em = getEntityManager();
        Query q = em.createNamedQuery("SELECT f FROM Faixa f WHERE f.album = " + codAlbum, Faixa.class);
        return q.getResultList();
    }
    public List<Faixa> listar() {
        em = getEntityManager();
        Query q = em.createNamedQuery("Faixa.findAll");
        return q.getResultList();
    }

}
