/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import controlador.ControladorGenerico;
import controlador.ControladorProducto;
import controlador.ControladorProveedor;
import controlador.ControladorVenta;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vista.login.LogoInicial;
import vista.VentanaPrincipal;
import vista.login.VentanaLogin;





/**
 *
 * @author Analía Santomé
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            
            VentanaLogin vl = new VentanaLogin();        
            vl.setVisible(true);
            
            
            
           /* VentanaPrincipal vp = new VentanaPrincipal();
            
            vp.setVisible(true);*/
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
