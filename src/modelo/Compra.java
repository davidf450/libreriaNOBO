/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Analía Santomé
 */
@Entity
@NamedQueries({
   @NamedQuery(name="Compra.findAll",query="SELECT c FROM Compra c")
})
@DiscriminatorValue("C")
public class Compra extends Transaccion implements Serializable {
    @ManyToOne
    private Proveedor proveedor;
    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
