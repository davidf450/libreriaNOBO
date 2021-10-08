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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import reporte.DatoRemito;
import javax.persistence.*;
/**
 *
 * @author guti_
 */
@Entity
@NamedQueries({
   @NamedQuery(name="Remito.findAll",query="SELECT r FROM Remito r")
})
public class Remito implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    private long nroRemito;
    private long nroPuntoRemito;
    @OneToOne(fetch = FetchType.EAGER)
    private Venta venta;

    public Remito() {
    }

    public Remito(Date fechaEmision, long nroRemito, long nroPuntoRemito, Venta venta) {
        this.fechaEmision = fechaEmision;
        this.nroRemito = nroRemito;
        this.nroPuntoRemito = nroPuntoRemito;
        this.venta = venta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNroPuntoRemito() {
        return nroPuntoRemito;
    }

    public void setNroPuntoRemito(long nroPuntoRemito) {
        this.nroPuntoRemito = nroPuntoRemito;
    }

    public List<DatoRemito> getListaRemito(){
        List<DatoRemito> listaRemito = new ArrayList<>();
        if(venta == null)
            return null;
        else{
            Iterator<LineaTransaccion> it = venta.getLineas().iterator();
            LineaTransaccion producto;
            while(it.hasNext()){
                producto = it.next();
                DatoRemito itemRemito = new DatoRemito();
                itemRemito.setCodigo(String.valueOf(producto.getIdProducto()));
                itemRemito.setNombre(producto.getNombreProducto());
                itemRemito.setCantidad(String.valueOf(producto.getCantidad()));
                listaRemito.add(itemRemito);
            }
            return listaRemito;
        }
    }
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getNroRemito() {
        return nroRemito;
    }

    public void setNroRemito(long nroRemito) {
        this.nroRemito = nroRemito;
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
