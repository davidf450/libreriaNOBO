/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
   @NamedQuery(name="Venta.findAll",query="SELECT v FROM Venta v")
})
@DiscriminatorValue("V")
public class Venta extends Transaccion implements Comparable<Transaccion>{
    
    @ManyToOne
    private Cliente cliente;
    private long nroVenta;
    
    //@Override
    public int compareTo(Venta v) {
      if (getFecha()== null || v.getFecha() == null)
        return 0;
      return getFecha().compareTo(v.getFecha());
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(long nroVenta) {
        this.nroVenta = nroVenta;
    }
    
    

    

   
    
    
}
