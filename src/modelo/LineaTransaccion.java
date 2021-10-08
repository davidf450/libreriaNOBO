/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author Analía Santomé
 */
@Entity
public class LineaTransaccion implements Serializable {
    
    @Id
    @GeneratedValue
    private Long codigoLineaTransaccion;
    
    
    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioUnitario;
    private Integer cantidad;
    private Double total;
    private float valorIva;
    
    private Double ultimoCosto;
    private Double nuevoCosto;

    public float getValorIva() {
        return valorIva;
    }

    public void setValorIva(float valorIva) {
        this.valorIva = valorIva;
    }
    
    
    public Double getUltimoCosto() {
        return ultimoCosto;
    }

    public void setUltimoCosto(Double ultimoCosto) {
        this.ultimoCosto = ultimoCosto;
    }

    public Double getNuevoCosto() {
        return nuevoCosto;
    }

    // <editor-fold defaultstate="collapsed" desc=" getters y setters ">
    /* public void setTransaccionPadre(Transaccion transaccionPadre) {
    this.transaccionPadre = transaccionPadre;
    }
    public Transaccion getTransaccionPadre(){
    return transaccionPadre;
    } */
    public void setNuevoCosto(Double nuevoCosto) {
        this.nuevoCosto = nuevoCosto;
    }

    public void setCodigoLineaTransaccion(Long codigo) {
        this.codigoLineaTransaccion = codigo;
    }
    public Long getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
   
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }

// </editor-fold>

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idProducto);
        hash = 61 * hash + Objects.hashCode(this.nombreProducto);
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
        final LineaTransaccion other = (LineaTransaccion) obj;
        if (!Objects.equals(this.nombreProducto, other.nombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }
    
    
}
