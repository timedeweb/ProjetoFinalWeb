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
import utfpr.projetofinalweb.dao.ArtistaDAO;
import utfpr.projetofinalweb.entity.Artista;
import utfpr.projetofinalweb.support.PageBean;

/**
 *
 * @author Samsung
 */
@ManagedBean
@SessionScoped
public class ArtistaBean extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArtistaDAO artistaDAO = new ArtistaDAO();

    private AlbumDAO albumDAO = new AlbumDAO();

    private List<Artista> artistas = artistaDAO.listar();

    private String nomePesquisa = "";

    private Artista artista = new Artista();

    private AlbumBean albumBean = (AlbumBean) getBean("albumBean");

    private UsuarioBean usuarioBean = (UsuarioBean) getBean("usuarioBean");

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    private boolean editar = false;

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public ArtistaDAO getArtistaDAO() {
        return artistaDAO;
    }

    public void setArtistaDAO(ArtistaDAO artistaDAO) {
        this.artistaDAO = artistaDAO;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public AlbumDAO getAlbumDAO() {
        return albumDAO;
    }

    public void setAlbumDAO(AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    public AlbumBean getAlbumBean() {
        return albumBean;
    }

    public void setAlbumBean(AlbumBean albumBean) {
        this.albumBean = albumBean;
    }

    public String pesquisarPorNome() {
        artistas = artistaDAO.pesquisarPorNome(nomePesquisa);
        return "";
    }

    public String pesquisarPorNomeColaborador() {
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        artistas = artistaDAO.pesquisarPorNomeUsuario(nomePesquisa, usuarioBean.getUsuarioLogado().getCodigo());
        return "";
    }

    public String excluir(long codArtista, String idPagina) {
        try {
            if (usuarioBean.getUsuarioLogado() == null) {
                usuarioBean.setarUsuarioLogado();
            }
            artistaDAO.remover(Artista.class, codArtista);
            albumBean.setArtistas(artistaDAO.listar());
            albumBean.setListaArtistas(albumBean.popularSelectItem());
            if (idPagina.equals("colaborador")) {
                artistas = artistaDAO.pesquisarPorUsuario(usuarioBean.getUsuarioLogado().getCodigo());
            } else {
                artistas = artistaDAO.listar();
            }
        } catch (Exception e) {

        }
        return "";
    }

    public String cadastrar() {
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        artista.setUsuario(usuarioBean.getUsuarioLogado());
        artistaDAO.inserir(artista);
        artista = new Artista();
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        albumBean.setArtistas(artistaDAO.listar());
        albumBean.setListaArtistas(albumBean.popularSelectItem());
        if (usuarioBean.getUsuarioLogado().getPerfil().getCodigo() == 1) {
            listarColaborador();
            return "artistas?faces-redirect=true";
        } else {
            artistas = artistaDAO.listar();
            return "/admin/artistas?faces-redirect=true";
        }
    }

    public String alterar() {
        editar = false;
        artistaDAO.alterar(artista);
        artista = new Artista();
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        albumBean.setArtistas(artistaDAO.listar());
        albumBean.setListaArtistas(albumBean.popularSelectItem());
        if (usuarioBean.getUsuarioLogado().getPerfil().getCodigo() == 1) {
            listarColaborador();
            return "artistas?faces-redirect=true";
        } else {
            artistas = artistaDAO.listar();
            return "/admin/artistas?faces-redirect=true";
        }
    }

    public String listarAlbuns(long codArtista) {
        albumBean.setAlbuns(albumDAO.pesquisarPorArtista(codArtista));
        return "albuns";
    }

    public String listarColaborador() {
        if (usuarioBean.getUsuarioLogado() == null) {
            usuarioBean.setarUsuarioLogado();
        }
        artistas = artistaDAO.pesquisarPorUsuario(usuarioBean.getUsuarioLogado().getCodigo());
        return "artistas?faces-redirect=true";
    }

    public String listar() {
        artistas = artistaDAO.listar();
        return "";
    }

    public String inserirNovo() {
        this.editar = false;
        this.artista = new Artista();
        return "/colaborador/cadastroArtista?faces-redirect=true";
    }

    public String alterarCadastro(long codArtista) {
        this.editar = true;
        artista = (Artista) artistaDAO.pesquisar(Artista.class, codArtista);
        return "/colaborador/cadastroArtista?faces-redirect=true";
    }

}
