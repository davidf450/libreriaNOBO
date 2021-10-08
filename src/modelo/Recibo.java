/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author guti_
 */
@Entity
public class Recibo implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    private long nroRecibo;
    private long nroPuntoRecibo;
    private float importeEfectivo;
    private String nroCheque;
    private float importeCheque;
    @OneToOne(cascade = CascadeType.ALL)
    private Factura factura;

    public Recibo() {
    }

    public Recibo(Date fechaEmision, long nroRecibo, long nroPuntoRecibo, float importeEfectivo, String nroCheque, float importeCheque, Factura factura) {
        this.fechaEmision = fechaEmision;
        this.nroRecibo = nroRecibo;
        this.nroPuntoRecibo = nroPuntoRecibo;
        this.importeEfectivo = importeEfectivo;
        this.nroCheque = nroCheque;
        this.importeCheque = importeCheque;
        this.factura = factura;
    }

    public String getFechaEmision() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fechaEmision);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void sumarImporteCliente(float importe){
        String importeNuevo = String.valueOf(importe);
        Double importeDefinitivo = Double.valueOf(importeNuevo);
        factura.getVenta().getCliente().getCuentaCorriente().aumentarMontoAcumulado(importeDefinitivo);
    }
    
    public void confirmarPago(Factura factura){
        factura.getVenta().setEstadoPago(true);
    }
    
    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public float getImporteCheque() {
        return importeCheque;
    }

    public void setImporteCheque(float importeCheque) {
        this.importeCheque = importeCheque;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(long nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public long getNroPuntoRecibo() {
        return nroPuntoRecibo;
    }

    public void setNroPuntoRecibo(long nroPuntoRecibo) {
        this.nroPuntoRecibo = nroPuntoRecibo;
    }

    public float getImporteEfectivo() {
        return importeEfectivo;
    }

    public void setImporteEfectivo(float importeEfectivo) {
        this.importeEfectivo = importeEfectivo;
    }

    public float getImporteTotalRecibo(){
        return importeCheque + importeEfectivo;
    }
    
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
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
