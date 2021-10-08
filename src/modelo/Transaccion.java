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
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import javax.persistence.*;


/**
 *
 * @author Analía Santomé
 */


@NamedQueries({
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t"),
@NamedQuery(name="Transaccion.findVentas", query="SELECT v from Venta v"),
@NamedQuery(name="Transaccion.findCompras", query="SELECT c from Compra c")
})
@Entity
@Inheritance
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("T")
public abstract class Transaccion implements Serializable,Comparable<Transaccion> {
    @Id
    @GeneratedValue
    private Long codigoTransaccion;
    
    @OneToMany(fetch=FetchType.EAGER)
    private List<LineaTransaccion> lineas = new ArrayList<>();
    
    public void agregarLinea(LineaTransaccion linea){
        this.lineas.add(linea);
    }
        
    private String formaDePago;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Double subTotal;
    private Double descuento;
    private Double total;
    private char tipo_factura;
    private String numero_factura;
    private Double montoPago;
    
    private Boolean anulada = false;
    private Boolean remitada = false;
    private Boolean estaFacturada = false;
    private Boolean estadoPago = false;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFacturacion;
    
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    
    private float precioIva;

    @Override
    public int compareTo(Transaccion t) {
      if (getFecha()== null || t.getFecha() == null)
        return 0;
      return getFecha().compareTo(t.getFecha());
    }
    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public Boolean getRemitada() {
        return remitada;
    }

    public void setRemitada(Boolean remitada) {
        this.remitada = remitada;
    }
    
    
    
    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    
    public Boolean getEstaFacturada() {
        return estaFacturada;
    }

    public void setEstaFacturada(Boolean estaFacturada) {
        this.estaFacturada = estaFacturada;
    }

    public float getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(float precioIva) {
        this.precioIva = precioIva;
    }
    
    
    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    
    public float getImporteTotalConIVA(){
        return (float) (precioIva + total);
    }
    
    
    public List<LineaTransaccion> getLineas() {
        Set<LineaTransaccion> lineasSet = new HashSet<>(this.lineas);
        List<LineaTransaccion> devolver = new ArrayList<>();
        for(LineaTransaccion lt : this.lineas){
            lineasSet.add(lt);
        }
        
        for(LineaTransaccion lt2 : lineasSet){
            devolver.add(lt2);
        }
        
        return devolver;
    }

    public void setLineas(List<LineaTransaccion> lineas) {
        this.lineas = lineas;
    }
    
    public float getIva27 (){
        Iterator<LineaTransaccion> it = lineas.iterator();
        LineaTransaccion producto;
        float valorIVA = 0.0f;
        while(it.hasNext()){
            producto = it.next();
            if(producto.getValorIva() == 0.270f)
                valorIVA += producto.getPrecioUnitario() * 0.270f * producto.getCantidad();
        }
        return valorIVA;
    }
    
    public float getIva21 (){
        Iterator<LineaTransaccion> it = lineas.iterator();
        LineaTransaccion producto;
        float valorIVA = 0.0f;
        while(it.hasNext()){
            producto = it.next();
            if(producto.getValorIva() == 0.210f)
                valorIVA += producto.getPrecioUnitario() * 0.210f * producto.getCantidad();
        }
        return valorIVA;
    }
    
    public float getIva10 (){
        Iterator<LineaTransaccion> it = lineas.iterator();
        LineaTransaccion producto;
        float valorIVA = 0.0f;
        while(it.hasNext()){
            producto = it.next();
            if(producto.getValorIva() == 0.105f)
                valorIVA += producto.getPrecioUnitario() * 0.105f * producto.getCantidad();
        }
        return valorIVA;
    }
    
    public float getIva05 (){
        Iterator<LineaTransaccion> it = lineas.iterator();
        LineaTransaccion producto;
        float valorIVA = 0.0f;
        while(it.hasNext()){
            producto = it.next();
            if(producto.getValorIva() == 0.050f)
                valorIVA += producto.getPrecioUnitario() * 0.050f * producto.getCantidad();
        }
        return valorIVA;
    }
    
    
    
    public char getTipo_factura() {
        return tipo_factura;
    }

    public void setTipo_factura(char tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    /*public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }*/

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(Long codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigoTransaccion);
        hash = 71 * hash + Objects.hashCode(this.total);
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
        final Transaccion other = (Transaccion) obj;
        if (!Objects.equals(this.codigoTransaccion, other.codigoTransaccion)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    
}
