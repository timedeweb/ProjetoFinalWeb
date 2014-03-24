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

    protected EntityManager em;

    public void inserir(Object objeto) {
        em = this.getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Class classe, long codigo) {
        em = this.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(classe, codigo));
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

    public Object pesquisar(Class classe, long codigo) {
        try {
            em = this.getEntityManager();
            return em.find(classe, codigo);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
