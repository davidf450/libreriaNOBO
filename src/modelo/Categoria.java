/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorCategoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c"),
@NamedQuery(name="Categoria.findPrincipales", query="SELECT c FROM Categoria c WHERE c.esPrincipal=true"),
@NamedQuery(name="Categoria.findSubcategorias", query="SELECT sc FROM Categoria sc WHERE sc.superCategoria.codigoCategoria=:codigoCategoriaPrincipal"),
@NamedQuery(name="Categoria.findPorNombre", query="SELECT c FROM Categoria c WHERE c.nombreCategoria=:nombreCategoriaPrincipal")
})
public class Categoria implements Serializable{
    @Id
    @GeneratedValue
    private Long codigoCategoria;
    private String nombreCategoria;
    private Boolean esPrincipal = false;
    
    @OneToMany(cascade = CascadeType.REMOVE , fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Categoria> subCategorias = new ArrayList<>();

    @ManyToOne
    Categoria superCategoria;
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public List<Categoria> getSubCategorias() {
        return this.subCategorias;
        /*try {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("codigoCategoriaPrincipal", this.codigoCategoria);
            ControladorCategoria ctrcat = new ControladorCategoria();
            return ctrcat.buscarConConsultaNombrada("Categoria.findSubcategorias",mapa);
            //return subCategorias;
        } catch (Exception ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;*/
    }

    public void setSubCategorias(List<Categoria> subCategorias) {
        this.subCategorias = subCategorias;
    }
    @Override
    public String toString(){
        return this.nombreCategoria;
    }
    
    public void agregarSubCategoria(Categoria nueva){
        this.subCategorias.add(nueva);
        actualizarCategoria();
        System.out.println("paso el agregar sub categoria sigue en actualizar empresa");
    }
    public void actualizarCategoria(){
        try {
            ControladorCategoria ctrcat = new ControladorCategoria();
            ctrcat.actualizar(this);
        } catch (Exception ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public Categoria getSuperCategoria() {
        return superCategoria;
    }

    public void setSuperCategoria(Categoria superCategoria) {
        this.superCategoria = superCategoria;
        actualizarCategoria();
    }
    
}
