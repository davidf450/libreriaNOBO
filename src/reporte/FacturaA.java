/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

/**
 *
 * @author guti_
 */
public class FacturaA {
    private String codigo;
    private String nombre;
    private String cantidad;
    private String precioUnidad;
    private String subtotal;
    private String valorIVA;
    private String subtotalConIVA;

    public FacturaA(String codigo, String nombre, String cantidad, String precioUnidad, String subtotal, String valorIVA, String subtotalConIVA) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
        this.valorIVA = valorIVA;
        this.subtotalConIVA = subtotalConIVA;
    }

    public FacturaA() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(String precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getValorIVA() {
        return valorIVA;
    }

    public void setValorIVA(String valorIVA) {
        this.valorIVA = valorIVA;
    }

    public String getSubtotalConIVA() {
        return subtotalConIVA;
    }

    public void setSubtotalConIVA(String subtotalConIVA) {
        this.subtotalConIVA = subtotalConIVA;
    }
    
}
