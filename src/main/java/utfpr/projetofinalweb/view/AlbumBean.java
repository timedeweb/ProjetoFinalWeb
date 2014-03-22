/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import utfpr.projetofinalweb.dao.AlbumDAO;
import utfpr.projetofinalweb.dao.ArtistaDAO;
import utfpr.projetofinalweb.dao.FaixaDAO;
import utfpr.projetofinalweb.entity.Album;
import utfpr.projetofinalweb.entity.Artista;
import utfpr.projetofinalweb.support.PageBean;

/**
 *
 * @author Samsung
 */
@ManagedBean
@SessionScoped
public class AlbumBean extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Album album = new Album();

    private AlbumDAO albumDAO = new AlbumDAO();
    
    private ArtistaDAO artistaDAO = new ArtistaDAO();
    
    private FaixaDAO faixaDAO = new FaixaDAO();
    
    private List<Album> albuns = albumDAO.listar();
    
    private List<Artista> artistas = artistaDAO.listar();
    
    private List<SelectItem> listaArtistas = new ArrayList<>();

    private FaixaBean faixaBean = (FaixaBean) getBean("faixaBean");

    private String nomePesquisa = "";
    
    private boolean editar = false;
    
    private UsuarioBean usuarioBean = (UsuarioBean) getBean("usuarioBean");

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<SelectItem> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<SelectItem> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public AlbumDAO getAlbumDAO() {
        return albumDAO;
    }

    public void setAlbumDAO(AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    public ArtistaDAO getArtistaDAO() {
        return artistaDAO;
    }

    public void setArtistaDAO(ArtistaDAO artistaDAO) {
        this.artistaDAO = artistaDAO;
    }

    public FaixaBean getFaixaBean() {
        return faixaBean;
    }

    public void setFaixaBean(FaixaBean faixaBean) {
        this.faixaBean = faixaBean;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public FaixaDAO getFaixaDAO() {
        return faixaDAO;
    }

    public void setFaixaDAO(FaixaDAO faixaDAO) {
        this.faixaDAO = faixaDAO;
    }

    public String pesquisarPorNome() {
        albuns = albumDAO.pesquisarPorNome(nomePesquisa);
        return "";
    }

    public String excluir() {
        return "";
    }

    public String cadastrar() {
        return "";
    }

    public String alterar() {
        return "";
    }

    public String listarFaixas() {
        faixaBean.setFaixas(faixaDAO.pesquisarPorAlbum(album.getCodigo()));
        return "faixas";
    }
    public String listar(){
        albuns = albumDAO.listar();
        return "";
    }
}
