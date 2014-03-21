/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import utfpr.projetofinalweb.entity.Artista;

/**
 *
 * @author Samsung
 */
public class ArtistaDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Artista> pesquisarPorNome(String nome){
        return null;
    }
    public List<Artista> pesquisarPorUsuario(long codUsuario){
        return null;
    }
    public List<Artista> listar(){
        return null;
    }
}
