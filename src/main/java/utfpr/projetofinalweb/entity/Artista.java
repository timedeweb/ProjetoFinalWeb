/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utfpr.projetofinalweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Samsung
 */
@Entity
@NamedQueries({ 
 @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a")}) 
public class Artista implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private long codigo;
    
    private String nome;
    
    @OneToMany
    @JoinColumn(name="cod_artista")
    private List<Album> albuns;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
    
    
    
}
