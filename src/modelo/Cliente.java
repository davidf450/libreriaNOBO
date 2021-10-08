/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
})
public class Cliente implements Serializable {
    // <editor-fold defaultstate="collapsed" desc=" DESCRIPTION ">
    @Id
    @GeneratedValue
    private Long codigoCliente;
    
    //DATOS PERSONALES
    private String email; //
    private String calle; //
    private Integer numeroCalle; //
    private Integer piso; //
    private String departamento; //
    private String provincia; //
    private String localidad; //
    private Integer codigoPostal; //
    private String nombre_comercial; 
    private String nombre; //
    private Long telefono1; //
    private Long telefono2; //
    private char sexo; //
    private String tipoDocumento; //
    private Long dni;
    
    //FINANCIERA
    private Long cuit; //
    private Long cuil; //
    private String condicionIVA; //
    private Boolean habilitado;
    
    //DATOS PERSONALES;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento; //
    
    private String observaciones;
    private Boolean sobreElMaximo=false;
    @OneToOne(cascade = CascadeType.MERGE)
    private CuentaCorriente cuentaCorriente;

// </editor-fold>
public Cliente(){
    this.habilitado=true;
}
    //<editor-fold defaultstate="collapsed" desc="comment">
  public Long getCodigoCliente() {
        return codigoCliente;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numero) {
        this.numeroCalle = numero;
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

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }



    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public Long getCuil() {
        return cuil;
    }

    public void setCuil(Long cuil) {
        this.cuil = cuil;
    }

    public String getCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(String condicionIVA) {
        this.condicionIVA = condicionIVA;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getSobreElMaximo() {
        return sobreElMaximo;
    }

    public void setSobreElMaximo(Boolean estaSobreElMaximo) {
        this.sobreElMaximo = estaSobreElMaximo;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
    
    public void sumarACuentaCorriente(Double monto){
        this.cuentaCorriente.aumentarMontoAcumulado(monto);
    }
    public void restarACuentaCorriente(Double monto){
        this.cuentaCorriente.reducirMontoAcumulado(monto);
    }
    public boolean cuentaExcedida(Double monto){
        return this.cuentaCorriente.sePasaDelMaximo(monto);
    }
   
//</editor-fold>

   

   
    
   
    
    
}
