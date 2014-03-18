/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Samsung
 */
public class GenericDAO extends JpaController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EntityManager em;

    public void inserir(Object objeto) {
        em = this.getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Object objeto) {
        em = this.getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Object objeto) {
        em = this.getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        em.close();
    }
        
}
