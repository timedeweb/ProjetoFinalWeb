/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import utfpr.projetofinalweb.entity.Faixa;

/**
 *
 * @author Samsung
 */
public class FaixaDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Faixa> pesquisarPorNome(String nome){
        return null;
    }
    public List<Faixa> pesquisarPorUsuario(long codUsuario){
        return null;
    }
    public List<Faixa> pesquisarPorAlbum(long codAlbum) {
        return null;
    }
    public List<Faixa> listar() {
        return null;
    }

}
