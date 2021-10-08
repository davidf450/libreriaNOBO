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
public class FacturaBC {
    private String codigo;
    private String nombre;
    private String cantidad;
    private String precioUnidad;
    private String subtotal;

    public FacturaBC() {
    }

    public FacturaBC(String codigo, String nombre, String cantidad, String precioUnidad, String subtotal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
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

}
