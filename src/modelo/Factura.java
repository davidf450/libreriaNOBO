/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import reporte.FacturaA;
import reporte.FacturaBC;

/**
 *
 * @author guti_
 */
@Entity
@NamedQueries({
   @NamedQuery(name="Factura.findAll",query="SELECT f FROM Factura f")
})
public class Factura implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    private long nroPuntoFactura;
    private long nroFactura;
    private String tipoFactura;
    private float importeTotal;
    
    @OneToOne//(cascade = CascadeType.ALL)
    private Venta venta;

    public Factura() {
    }

    public Factura(Date fechaEmision, long nroPuntoFactura, long nroFactura, String tipoFactura, float importeTotal, Venta venta) {
        this.fechaEmision = fechaEmision;
        this.nroPuntoFactura = nroPuntoFactura;
        this.nroFactura = nroFactura;
        this.tipoFactura = tipoFactura;
        this.importeTotal = importeTotal;
        this.venta = venta;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<FacturaA> getListaComprobanteA(){
        List<FacturaA> listaFactura = new ArrayList<>();
        if(venta == null)
            return null;
        else{
            Iterator<LineaTransaccion> it = venta.getLineas().iterator();
            LineaTransaccion producto;
            while(it.hasNext()){
                producto = it.next();
                FacturaA itemFactura = new FacturaA();
                itemFactura.setCodigo(String.valueOf(producto.getIdProducto()));
                itemFactura.setNombre(producto.getNombreProducto());
                itemFactura.setCantidad(String.valueOf(producto.getCantidad()));
                itemFactura.setPrecioUnidad(String.valueOf(producto.getPrecioUnitario()));
                itemFactura.setSubtotal(String.valueOf(producto.getTotal()));
                itemFactura.setValorIVA(String.valueOf(producto.getValorIva()));
                itemFactura.setSubtotalConIVA(String.valueOf(producto.getPrecioUnitario() + producto.getValorIva()));
                listaFactura.add(itemFactura);
            }
            return listaFactura;
        }
    }
    
    public List<FacturaBC> getListaComprobanteB(){
        List<FacturaBC> listaFactura = new ArrayList<>();
        if(venta == null)
            return null;
        else{
            Iterator<LineaTransaccion> it = venta.getLineas().iterator();
            LineaTransaccion producto;
            while(it.hasNext()){
                producto = it.next();
                FacturaBC itemFactura = new FacturaBC();
                itemFactura.setCodigo(String.valueOf(producto.getIdProducto()));
                itemFactura.setNombre(producto.getNombreProducto());
                itemFactura.setCantidad(String.valueOf(producto.getCantidad()));
                itemFactura.setPrecioUnidad(String.valueOf(producto.getPrecioUnitario() +
                        producto.getValorIva() * producto.getPrecioUnitario()));
                itemFactura.setSubtotal(String.valueOf(producto.getPrecioUnitario() + producto.getValorIva()));
                listaFactura.add(itemFactura);
            }
            return listaFactura;
        }
    }
   
    public List<FacturaBC> getListaComprobanteC(){
        List<FacturaBC> listaFactura = new ArrayList<>();
        if(venta == null)
            return null;
        else{
            Iterator<LineaTransaccion> it = venta.getLineas().iterator();
            LineaTransaccion producto;
            while(it.hasNext()){
                producto = it.next();
                FacturaBC itemFactura = new FacturaBC();
                itemFactura.setCodigo(String.valueOf(producto.getIdProducto()));
                itemFactura.setNombre(producto.getNombreProducto());
                itemFactura.setCantidad(String.valueOf(producto.getCantidad()));
                itemFactura.setPrecioUnidad(String.valueOf(producto.getPrecioUnitario()));
                itemFactura.setPrecioUnidad(String.valueOf(producto.getPrecioUnitario()));
                listaFactura.add(itemFactura);
            }
            return listaFactura;
        }
    }
    
    public String getFechaEmision() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fechaEmision);
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getNroPuntoFactura() {
        return nroPuntoFactura;
    }

    public void setNroPuntoFactura(long nroPuntoFactura) {
        this.nroPuntoFactura = nroPuntoFactura;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getFechaString(){
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MMM-yyyy");
            return formateador.format(fechaEmision);
        } catch (Exception e) {
            return null;
        }
    }
}