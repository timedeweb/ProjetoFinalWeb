/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utfpr.projetofinalweb.dao;

import java.io.Serializable;
import java.util.List;
import utfpr.projetofinalweb.entity.Album;
import utfpr.projetofinalweb.entity.Faixa;

/**
 *
 * @author Samsung
 */
public class AlbumDAO extends GenericDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Album> pesquisarPorNome(String nome){
        return null;
    }
    public List<Faixa> encontrarFaixas(Album album){
        return null;
    }
    public List<Album> pesquisarPorUsuario(int codUsuario){
        return null;
    }
    
}
