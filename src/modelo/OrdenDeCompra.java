/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Analía Santomé
 */
@Entity
public class OrdenDeCompra implements Serializable {
    @Id
    @GeneratedValue
    private Long codigo_orden;
    private Proveedor proveedor;
    @OneToMany(fetch=FetchType.EAGER)
    private List<Producto> productos;

    public Long getCodigo_orden() {
        return codigo_orden;
    }

    public void setCodigo_orden(Long codigo_orden) {
        this.codigo_orden = codigo_orden;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
