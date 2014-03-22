/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.view;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utfpr.projetofinalweb.dao.AlbumDAO;
import utfpr.projetofinalweb.dao.FaixaDAO;
import utfpr.projetofinalweb.entity.Album;
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
        if (usuarioBean.getUsuarioLogado() == null){
            usuarioBean.setarUsuarioLogado();
        }
        faixa.setUsuario(usuarioBean.getUsuarioLogado());
        faixaDAO.inserir(faixa);
        return "";
    }

    public String alterar() {
        return "";
    }
    public String listar(){
        faixas = faixaDAO.listar();
        return "";
    }
}
