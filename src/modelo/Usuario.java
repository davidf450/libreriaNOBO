/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import controlador.ControladorUsuario;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
@NamedQuery(name="Usuario.findAll",query="SELECT u FROM Usuario u"),
@NamedQuery(name="Usuario.findPorNombre", query="SELECT u FROM Usuario u WHERE u.nombre=:nombreUsuario")
})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    private Long codigoUsuario;
    
    private String nombre;
    private String password;
    private Boolean esAdministrador = false;
    private Boolean nuncaEntro = true;

    public Boolean getNuncaEntro() {
        return nuncaEntro;
    }

    public void setNuncaEntro(Boolean nuncaEntro) {
        this.nuncaEntro = nuncaEntro;
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    public String getPassword(){
        return this.password;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setPassword(String pass){
        this.password=pass;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Boolean getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(Boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
    
    
   public Usuario(){};
   public Usuario(String nombre,String pass){
       this.nombre = nombre;
       this.password = pass;
   }
}
