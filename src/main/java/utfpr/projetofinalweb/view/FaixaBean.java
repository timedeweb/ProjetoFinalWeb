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
import utfpr.projetofinalweb.dao.FaixaDAO;
import utfpr.projetofinalweb.entity.Album;
import utfpr.projetofinalweb.entity.Artista;
import utfpr.projetofinalweb.entity.Faixa;
import utfpr.projetofinalweb.support.PageBean;

/**
 *
 * @author Samsung
 */
@ManagedBean
@SessionScoped
public class FaixaBean extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Faixa faixa = new Faixa();

    private FaixaDAO faixaDAO = new FaixaDAO();

    private AlbumDAO albumDAO = new AlbumDAO();

    private List<Faixa> faixas = faixaDAO.listar();

    private List<Album> albuns = albumDAO.listar();
    
    private List<SelectItem> listaAlbuns = popularSelectItem();
    
    private long albumSelecionado;

    private String nomePesquisa = "";
    
    private boolean editar = false;
    
    private UsuarioBean usuarioBean = (UsuarioBean) getBean("usuarioBean");

    public long getAlbumSelecionado() {
        return albumSelecionado;
    }

    public void setAlbumSelecionado(long albumSelecionado) {
        this.albumSelecionado = albumSelecionado;
    }

    public List<SelectItem> getListaAlbuns() {
        return listaAlbuns;
    }

    public void setListaAlbuns(List<SelectItem> listaAlbuns) {
        this.listaAlbuns = listaAlbuns;
    }

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

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public FaixaDAO getFaixaDAO() {
        return faixaDAO;
    }

    public void setFaixaDAO(FaixaDAO faixaDAO) {
        this.faixaDAO = faixaDAO;
    }

    public AlbumDAO getAlbumDAO() {
        return albumDAO;
    }

    public void setAlbumDAO(AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public String pesquisarPorNome() {
        faixas = faixaDAO.pesquisarPorNome(nomePesquisa);
        return "";
    }

    public String excluir() {
        return "";
    }

    public String cadastrar() {
        faixa.setAlbum(encontrarAlbum(albumSelecionado));
        if (usuarioBean.getUsuarioLogado() == null){
            usuarioBean.setarUsuarioLogado();
        }
        faixa.setUsuario(usuarioBean.getUsuarioLogado());
        faixaDAO.inserir(faixa);
        faixa = new Faixa();
        albumSelecionado = 0;
        return "";
    }

    public String alterar() {
        return "";
    }
    public String listar(){
        faixas = faixaDAO.listar();
        return "";
    }
    public List<SelectItem> popularSelectItem() {
        List<SelectItem> lista = new ArrayList<>();
        for (Album album : albuns) {
            lista.add(new SelectItem(album.getCodigo(), album.getTitulo()));
        }
        return lista;
    }
    
    public Album encontrarAlbum(long codAlbum){
        for (Album album : albuns) {
            if (album.getCodigo() == codAlbum){
                return album;
            }
        }
        return null;
    }
}
