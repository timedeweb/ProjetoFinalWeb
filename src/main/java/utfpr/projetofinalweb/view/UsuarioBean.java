/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.view;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import utfpr.projetofinalweb.dao.UsuarioDAO;
import utfpr.projetofinalweb.entity.Perfil;
import utfpr.projetofinalweb.entity.Usuario;
import utfpr.projetofinalweb.support.PageBean;

/**
 *
 * @author Samsung
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuarioLogado = null;

    private Usuario usuario = new Usuario();

    //${facesContext.externalContext.userPrincipal.name}
    //HttpServletRequest req = getRequest();
    //req.getUserPrincipal();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    private List<Usuario> usuarios = usuarioDAO.listar();

    private String nomePesquisa;
    
    private boolean editar = false;

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public String cadastrar() throws NoSuchAlgorithmException {
        Perfil perfil = new Perfil();
        perfil.setCodigo(1);
        perfil.setDescricao("colaborador");
        usuario.setPerfil(perfil);
        MessageDigest md = MessageDigest.getInstance("SHA");
        usuario.setSenha(DatatypeConverter.printHexBinary(md.digest(usuario.getSenha().getBytes())));
        usuarioDAO.inserir(usuario);
        return "";
    }
    
    public String pesquisarPorNome(){
        this.usuarios = usuarioDAO.pesquisarPorNome(nomePesquisa);
        return "";
    }
    public String listar(){
        usuarios = usuarioDAO.listar();
        return "";
    }
    public void setarUsuarioLogado(){
        HttpServletRequest req = getRequest();
        usuarioLogado = usuarioDAO.pesquisarPorEmail(req.getUserPrincipal().getName());
    }

}
