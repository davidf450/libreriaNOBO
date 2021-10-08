/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Analía Santomé
 */
@Entity
public class CuentaCorriente implements Serializable {
    @Id
    @GeneratedValue
    private Long codigo_cuenta;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    private Double monto_acumulado;
    private Double monto_maximo;

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Double getMonto_acumulado() {
        return monto_acumulado;
    }

    public void setMonto_acumulado(Double monto_acumulado) {
        this.monto_acumulado = monto_acumulado;
    }

    public Double getMonto_maximo() {
        return monto_maximo;
    }

    public void setMonto_maximo(Double monto_maximo) {
        this.monto_maximo = monto_maximo;
    }
    
    public void aumentarMontoAcumulado(Double monto){
        this.monto_acumulado+=monto;
    }
    public void reducirMontoAcumulado(Double monto){
        this.monto_acumulado-=monto;
    }
    public boolean sePasaDelMaximo(Double monto){
        return this.monto_acumulado+monto > this.monto_maximo;
        
    }
    
    
}
