/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
@NamedQuery(name="Proveedor.findAll",query="SELECT prov FROM Proveedor prov")
})
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue
    private Long codigoProveedor;
    
    //CONTACTO
    private String email;
    private String calle;
    private Integer numero;
    private Integer piso;
    private String departamento;
    private String provincia;
    private String localidad;
    private Integer codigoPostal;
    private String nombre_comercial;
    private String nombre_contacto;
    private Long telefono1;
    private Long telefono2;
    private String paginaWeb;
    
    private Boolean habilitadoParaComprar;
    
    //FINANCIERA
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> bancos = new ArrayList<>();
    private Long cbu;
    private Long cuit;
    private String condicionIVA;
    private String rubro;
    
    @ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
    private List<String> formas_de_pago;

    public Long getCodigoProveedor() {
        return codigoProveedor;
    }

    /*public void setCodigoProveedor(Long codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }*/

    public Boolean getHabilitadoParaComprar() {
        return habilitadoParaComprar;
    }

    public void setHabilitadoParaComprar(Boolean habilitadoParaComprar) {
        this.habilitadoParaComprar = habilitadoParaComprar;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

   

    public List<String> getFormas_de_pago() {
        return formas_de_pago;
    }

    public void setFormas_de_pago(List<String> formas_de_pago) {
        this.formas_de_pago = formas_de_pago;
    }
    
    
    public void agregarFormaDePago(String formaDePago){
        this.formas_de_pago.add(formaDePago);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(Long telefono1) {
        this.telefono1 = telefono1;
    }

    public Long getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(Long telefono2) {
        this.telefono2 = telefono2;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public List<String> getBancos() {
        return bancos;
    }

    public void setBancos(List<String> bancos) {
        this.bancos = bancos;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(String condicionIVA) {
        this.condicionIVA = condicionIVA;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codigoProveedor);
        hash = 89 * hash + Objects.hashCode(this.nombre_comercial);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.nombre_comercial, other.nombre_comercial)) {
            return false;
        }
        if (!Objects.equals(this.codigoProveedor, other.codigoProveedor)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
