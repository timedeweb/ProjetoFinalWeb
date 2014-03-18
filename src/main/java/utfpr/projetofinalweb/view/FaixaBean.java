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
import utfpr.projetofinalweb.dao.FaixaDAO;
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

    private List<Faixa> faixas = new ArrayList<>();

    private FaixaDAO faixaDAO = new FaixaDAO();

    private String nomePesquisa = "";

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

    public FaixaDAO getFaixaDAO() {
        return faixaDAO;
    }

    public void setFaixaDAO(FaixaDAO faixaDAO) {
        this.faixaDAO = faixaDAO;
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
        return "";
    }

    public String alterar() {
        return "";
    }
}
