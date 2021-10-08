/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Analía Santomé
 */
@Entity
public class Presupuesto implements Serializable {
    @Id
    @GeneratedValue
    private Long codigo_presupuesto;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Producto> productos;
    private String nombre_cliente;
    @Temporal(TemporalType.DATE)
    private Date fecha_emision;
    @Temporal(TemporalType.DATE)
    private Date valido_hasta;
    private Double montoTotal;

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getValido_hasta() {
        return valido_hasta;
    }

    public void setValido_hasta(Date valido_hasta) {
        this.valido_hasta = valido_hasta;
    }
    
    
    
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }
    
}
