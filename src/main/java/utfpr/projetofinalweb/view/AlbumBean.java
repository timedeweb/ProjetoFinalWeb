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

    private List<SelectItem> listaArtistas = popularSelectItem();

    private FaixaBean faixaBean = (FaixaBean) getBean("faixaBean");

    private long artistaSelecionado;

    private String nomePesquisa = "";

    private boolean editar = false;

    private UsuarioBean usuarioBean = (UsuarioBean) getBean("usuarioBean");

    public long getArtistaSelecionado() {
        return artistaSelecionado;
    }

    public void setArtistaSelecionado(long artistaSelecionado) {
        this.artistaSelecionado = artistaSelecionado;
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
        album.setArtista(encontrarArtista(artistaSelecionado));
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        album.setUsuario(usuarioBean.getUsuarioLogado());
        albumDAO.inserir(album);
        album = new Album();
        artistaSelecionado = 0;
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        if (usuarioBean.getUsuarioLogado().getPerfil().getCodigo() == 1) {
            listarColaborador();
            return "albuns?faces-redirect=true";
        } else {
            albuns = albumDAO.listar();
            return "/admin/albuns?faces-redirect=true";
        }
    }

    public String alterar() {
        editar = false;
        albumDAO.alterar(album);
        album = new Album();
        artistaSelecionado = 0;
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        if (usuarioBean.getUsuarioLogado().getPerfil().getCodigo() == 1) {
            listarColaborador();
            return "albuns?faces-redirect=true";
        } else {
            albuns = albumDAO.listar();
            return "/admin/albuns?faces-redirect=true";
        }
    }

    public String listarFaixas(int codAlbum) {
        faixaBean.setFaixas(faixaDAO.pesquisarPorAlbum(codAlbum));
        return "faixas";
    }

    public String listar() {
        albuns = albumDAO.listar();
        return "";
    }

    public List<SelectItem> popularSelectItem() {
        List<SelectItem> lista = new ArrayList<>();
        for (Artista artista : artistas) {
            lista.add(new SelectItem(artista.getCodigo(), artista.getNome()));
        }
        return lista;
    }

    public Artista encontrarArtista(long codArtista) {
        for (Artista artista : artistas) {
            if (artista.getCodigo() == codArtista) {
                return artista;
            }
        }
        return null;
    }

    public String inserirNovo() {
        this.editar = false;
        this.album = new Album();
        return "/colaborador/cadastroAlbum?faces-redirect=true";
    }

    public String listarColaborador() {
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        albuns = albumDAO.pesquisarPorUsuario(usuarioBean.getUsuarioLogado().getCodigo());
        return "albuns?faces-redirect=true";
    }

    public String alterarCadastro(long codAlbum) {
        this.editar = true;
        album = (Album) albumDAO.pesquisar(Album.class, codAlbum);
        return "/colaborador/cadastroAlbum?faces-redirect=true";
    }
}
