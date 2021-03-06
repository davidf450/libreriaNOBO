/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.ListarProductos.*;
import controlador.ControladorProducto;
import java.awt.Frame;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.Producto;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Hibernate;
import modelo.Usuario;
/**
 *
 * @author Analía Santomé
 */
public class VentanaListadoModificarProducto extends javax.swing.JFrame {
    ControladorProducto ctrpro = new ControladorProducto();
    Usuario usuarioActual = new Usuario();
    /**
     * Creates new form VentanaListadoCuentas
     */
    public VentanaListadoModificarProducto(java.awt.Frame parent, boolean modal,Usuario usuarioLogueado) throws Exception {
        //super(parent, false);
        this.usuarioActual = usuarioLogueado;
        initComponents();
        cargarTabla();
        setLocationRelativeTo(null);
        
        formWindowOpened();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Stock actual", "Stock minimo", "Precio venta", "Ultimo costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/borrar.png"))); // NOI18N
        jButton3.setToolTipText("Eliminar el producto");
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/borrarSinTapa.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/modificar.png"))); // NOI18N
        jButton2.setToolTipText("Modificar el producto");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Eliminar");

        jLabel2.setText("Modificar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Long codigoSeleccionado = (Long) tablaProductos.getValueAt(tablaProductos.getSelectedRow(),0);
        //String nombreSeleccionado = (String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1);
        try{
            Producto prod = ctrpro.buscar(Producto.class, codigoSeleccionado);
            
            //Window parentWindow = SwingUtilities.windowForComponent(jButton2);
            
            //ModificarProducto2 mp = new ModificarProducto((Frame) parentWindow, true,prod);
            ModificarProducto mp = new ModificarProducto(this, true,prod);
            mp.setVisible(true);
            System.out.println("SE CERRO LA MODIFICACION");
            cargarTabla();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    public void cargarTabla(){
        try {
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
            
            model.setRowCount(0);
            Object rowData[] = new Object[7];
            for(Producto c : ctrpro.buscarConConsultaNombrada("Producto.findProductos")){
                rowData[0] = c.getCodigoProducto();
                rowData[1] = c.getNombre();
                rowData[2] = c.getMarca();
                rowData[3] = c.getStockActual();
                rowData[4] = c.getStockMinimo();
                rowData[5] = c.getPrecioVenta();
                rowData[6] = c.getUltimoCosto();
                model.addRow(rowData);
                
            }
            tablaProductos.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Boolean validarAdmin(Usuario u){
        String passAdmin = JOptionPane.showInputDialog("Por favor reingrese la clave de Administrador");
        return u.getPassword().equals(passAdmin);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Long codigoSeleccionado = (Long) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0);
        
        
        try {
            if(validarAdmin(usuarioActual)){
            Producto aBorrar;
            DefaultTableModel tableModel = (DefaultTableModel) tablaProductos.getModel();
            aBorrar = ctrpro.buscar(Producto.class, codigoSeleccionado);
            int respuesta=JOptionPane.showConfirmDialog(this,
                        "Esta seguro de que desea borrar el producto '"+aBorrar.getCodigoProducto()+"-"+aBorrar.getNombre()+"?\n"+
                        "Esta accion no puede deshacerse!",
                        "Atencion!",
                        JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){
                    try{
                        ctrpro.borrar(aBorrar);
                        JOptionPane.showMessageDialog(this, 
                                "Se borro con exito el producto",
                                "Exito!",
                                JOptionPane.INFORMATION_MESSAGE);
                        tableModel.removeRow(tablaProductos.getSelectedRow());
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, 
                                "Ocurrio un problema al eliminar el producto",
                                "Error1",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                   super.dispose(); 
                }
            }else{
                JOptionPane.showMessageDialog(this, 
                                "Error de autentificacion",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    private void formWindowOpened() throws Exception {                                  
        /*DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        Object rowData[] = new Object[7];
        for(Producto c : ctrpro.buscarConConsultaNombrada("Producto.findProductos")){
           rowData[0] = c.getCodigoProducto();
           rowData[1] = c.getNombre();
           rowData[2] = c.getMarca();
           rowData[3] = c.getStockActual();
           rowData[4] = c.getStockMinimo();
           rowData[5] = c.getPrecioVenta();
           rowData[6] = c.getUltimoCosto();
           model.addRow(rowData);
        
       }
       tablaProductos.setModel(model);*/
   
    }   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaListadoModificarProducto dialog;
                try {
                    dialog = new VentanaListadoModificarProducto(new javax.swing.JFrame(), true,null);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaListadoModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
