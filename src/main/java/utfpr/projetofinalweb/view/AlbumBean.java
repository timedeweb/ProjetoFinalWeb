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
import utfpr.projetofinalweb.dao.AlbumDAO;
import utfpr.projetofinalweb.entity.Album;
import utfpr.projetofinalweb.support.PageBean;

/**
 *
 * @author Samsung
 */
@ManagedBean
@SessionScoped
public class AlbumBean extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Album> albuns = new ArrayList<>();

    private Album album = new Album();

    private AlbumDAO albumDAO = new AlbumDAO();

    private FaixaBean faixaBean = (FaixaBean) getBean("faixaBean");

    private String nomePesquisa = "";

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
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
        faixaBean.setFaixas(albumDAO.encontrarFaixas(album));
        return "faixas";
    }
}
