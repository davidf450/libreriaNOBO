/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
@NamedQuery(name="Producto.findBarCode", query="SELECT p FROM Producto p WHERE p.codigoBarras=:codBarra"),
@NamedQuery(name="Producto.findProductos", query="SELECT p FROM Producto p"),
@NamedQuery(name="Producto.findFaltantes",query="SELECT p FROM Producto p WHERE p.faltante=true")
})
public class Producto implements Serializable {
// <editor-fold defaultstate="collapsed" desc=" DESCRIPTION ">
    @Id
    @GeneratedValue
    private Long codigoProducto;
    
    private Long codigoBarras;
    private String marca;
    
    @OneToOne
    private Categoria categoria;
    private String descripcion;
    @OneToOne
    private Categoria subCategoria;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Integer stockActual;
    private String nombre;
    private String codigoDeProveedor;
    private Double ultimoCosto;
    
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Proveedor> proveedores = new ArrayList<>();
    
    private Boolean vieneEnCaja=false;
    private Integer cantidadPorCaja;
    
    private Double precioVenta;
    private Boolean habilitadoVenta=true;
    private Boolean faltante=false;

    private float valorIva;
    
    public Double getUltimoCosto() {
        return ultimoCosto;
    }
    
    public float getValorIva() {
        return valorIva;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" DESCRIPTION ">
    public void setValorIva(float valorIva) {    
        this.valorIva = valorIva;
    }

    public Boolean getVieneEnCaja() {
        return vieneEnCaja;
    }

    public void setVieneEnCaja(Boolean vieneEnCaja) {
        this.vieneEnCaja = vieneEnCaja;
    }

    public Integer getCantidadPorCaja() {
        return cantidadPorCaja;
    }

    public void setCantidadPorCaja(Integer cantidadPorCaja) {
        this.cantidadPorCaja = cantidadPorCaja;
    }
    
    
    
    public void setUltimoCosto(Double ultimoCosto) {
        this.ultimoCosto = ultimoCosto;
    }

    public String getCodigoDeProveedor() {
        return codigoDeProveedor;
    }

    public void setCodigoDeProveedor(String codigoDeProveedor) {
        this.codigoDeProveedor = codigoDeProveedor;
    }
    
    
    
    public Long getCodigoProducto() {
        return codigoProducto;
    }

    public Boolean getFaltante() {
        return faltante;
    }

    public void setFaltante(Boolean faltante) {
        this.faltante = faltante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public Long getCodigoBarras() {
        return codigoBarras;
    }
    
    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
      
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public Categoria getSubCategoria() {
        return subCategoria;
    }
    
    public void setSubCategoria(Categoria subCategoria) {
        this.subCategoria = subCategoria;
    }
    
    public Integer getStockMinimo() {
        return stockMinimo;
    }
    
    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    
    public Integer getStockMaximo() {
        return stockMaximo;
    }
    
    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }
    
    public Integer getStockActual() {
        return stockActual;
    }
    
    public void setStockActual(Integer stockActual) {
        System.out.println(stockActual);
        this.stockActual = stockActual;
        /*if(stockActual!=null && stockActual>stockMinimo){
            this.habilitadoVenta=true;
            this.faltante = false;
        }*/
    }
    public void aumentarStock(Integer stock){
        this.stockActual +=stock;
        if(stockActual+stock > stockMinimo){
            this.faltante = false;
        }
        if(stockActual-stock > (stockMinimo*20)/100){
            this.habilitadoVenta=true;
        }
    }
    public void disminuirStock(Integer stock){
        if(stockActual-stock < stockMinimo){
            
            this.faltante = true; //ESTABA EN FALSE ACA, NO LO IBA A CAMBIAR NUNCA
        }
        if(stockActual-stock <= (stockMinimo*20)/100){
            this.habilitadoVenta=false;
        }
        this.stockActual -=stock;
        
    }
    
 
    
   
    
    public List<Proveedor> getProveedores() {
        Set<Proveedor> proveedores = new HashSet<Proveedor>(this.proveedores);
        ArrayList<Proveedor> paraDevolver = new ArrayList<>();
        for(Proveedor p : proveedores){
            
            paraDevolver.add(p);
        }
        return paraDevolver;
    }
    
    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
  
    
    public Double getPrecioVenta() {
        return precioVenta;
    }
    
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public Boolean getHabilitadoVenta() {
        return habilitadoVenta;
    }
    
    public void setHabilitadoVenta(Boolean habilitadoVenta) {
        this.habilitadoVenta = habilitadoVenta;
    }
    
   

// </editor-fold>
    public Producto(){};
    public Producto(Long codigoBarras, String marca, Categoria categoria, String descripcion, Categoria subCategoria, Integer stockMinimo, Integer stockMaximo, Integer stockActual, Double descuentoTarjeta, Double descuentoEfectivo, String nombre, Double precioVenta, Boolean habilitadoVenta, Boolean venderDebajoDelCosto) {
        
        this.codigoBarras = codigoBarras;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.subCategoria = subCategoria;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.stockActual = stockActual;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.habilitadoVenta = habilitadoVenta;
        this.proveedores = new ArrayList<Proveedor>();
        
    }
    
    
    public void agregarProveedor(Proveedor proveedor){
        System.out.println(proveedor.getEmail());
        proveedores.add(proveedor);
    }

    
    
   /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        if (!Objects.equals(this.codigoBarras, other.codigoBarras)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigoProducto);
        hash = 41 * hash + Objects.hashCode(this.codigoBarras);
        return hash;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigoProducto);
        hash = 53 * hash + Objects.hashCode(this.codigoBarras);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        if (!Objects.equals(this.codigoBarras, other.codigoBarras)) {
            return false;
        }
        return true;
    }

    

    
    
}
