/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.dao;

import java.util.List;
import utfpr.projetofinalweb.entity.Album;
import utfpr.projetofinalweb.entity.Artista;
import utfpr.projetofinalweb.entity.Faixa;
import utfpr.projetofinalweb.entity.Usuario;

/**
 *
 * @author Samsung
 */
public class UsuarioDAO extends GenericDAO {
    
    public List<Usuario> pesquisarPorNome(String nome){
        return null;
    }
    public List<Faixa> encontrarFaixas(Usuario usuario){
        return null;
    }
    public List<Artista> encontrarArtistas(Usuario usuario){
        return null;
    }
    public List<Album> encontrarAlbuns(Usuario usuario){
        return null;
    }

}
