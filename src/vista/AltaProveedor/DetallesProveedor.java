/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.AltaProveedor;


import controlador.ControladorProveedor;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import modelo.Proveedor;

/**
 *
 * @author Analía Santomé
 */
public class DetallesProveedor extends javax.swing.JDialog {
    ControladorProveedor ctrprov = new ControladorProveedor();
    DefaultListModel modeloLista = new DefaultListModel();
    Integer numeroCalle,piso,codigoPostal;
    Long cbu,cuit;
    List<String>BancosAPoblar= new ArrayList<>(Arrays.asList("ABN AMRO Bank", "Banco de Galicia", "Banco Nación", "Banco de la Provincia de Bs. As.", "Industrial and Commercial Bank of China S.A.", "Citibank S.A.", "BBVA Banco Francés", "The Bank of Tokyo-Mitsubishi", "Banco de Córdoba", "Banco Supervielle S.A.", "Banco Ciudad", "Banco Patagonia S.A.", "Banco Hipotecario S.A.", "Banco de San Juan S.A.", "Banco do Brasil S.A.", "Banco de Tucumán", "Banco Municipal de Rosario", "Banco Santander Río S.A.", "Banco del Chubut", "Banco de Santa Cruz S.A.", "Banco de La Pampa", "Banco de Corrientes S.A.", "Banco Provincia del Neuquén", "HSBC Bank Argentina S.A.", "Banco Credicoop", "Banco Itau Buen Ayre S.A.", "Banco Pcia. de Tierra del Fuego", "Banco Macro, Banco Comafi S.A.","Banco Finansur S.A.", "Nuevo Banco del Chaco S.A.", "MBA Banco De Inversiones S.A.", "Banco Formosa S.A.", "Banco CMF S.A.", "Nuevo Banco Industrial de Azul", "Deutsche Bank S.A.", "Nuevo Banco de Santa Fe", "Banco Santiago del Estero S.A.", "Banco Más Ventas", "Nuevo Banco de Entre Ríos S.A."));
    DefaultListModel <String> modeloSeleccionados = new DefaultListModel<String>();
    DefaultListModel <String> modeloDisponibles = new DefaultListModel<String>();
    Proveedor actual = new Proveedor();
    /**
     * Creates new form AltaProveedor
     */
    public DetallesProveedor(java.awt.Frame parent, boolean modal,Proveedor prov){
        super(parent,modal);
        this.actual = prov;
        initComponents();
        setLocationRelativeTo(null);
        cargarBancos();
        cargarCampos();
        
    }

    public Proveedor getActual() {
        return actual;
    }

    public void setActual(Proveedor actual) {
        this.actual = actual;
    }
    
    private void cargarBancos(){
        for(String banco : BancosAPoblar){
            modeloDisponibles.addElement(banco);
            
        }
        //listaBancosDisponibles.setModel(modeloDisponibles);
        Set<String> setBancosActuales = new HashSet<>(actual.getBancos());
        for(String banco : setBancosActuales){
            modeloSeleccionados.addElement(banco);
            
        }
        listaBancosSeleccionados.setModel(modeloSeleccionados);
    }
    /*public void activarTransferencias(){
        if(!checkTransferencia.isSelected() && !checkDeposito.isSelected()){
            campoCBU.setEnabled(false);
            listaBancosDisponibles.setEnabled(false);
            listaBancosSeleccionados.setEnabled(false);
        }
        if(checkTransferencia.isSelected() && checkDeposito.isSelected()){
            campoCBU.setEnabled(true);
            listaBancosDisponibles.setEnabled(true);
            listaBancosSeleccionados.setEnabled(true);
        }
        if(!checkTransferencia.isSelected() && checkDeposito.isSelected()){
            campoCBU.setEnabled(true);
            listaBancosDisponibles.setEnabled(true);
            listaBancosSeleccionados.setEnabled(true);
        }
        if(checkTransferencia.isSelected() && !checkDeposito.isSelected()){
            campoCBU.setEnabled(true);
            listaBancosDisponibles.setEnabled(true);
            listaBancosSeleccionados.setEnabled(true);
        }
    }*/

    public void ingresoIncorrectoNumero (Integer valorCampo,String nombreCulpable,Long valorCampo2){
        
        try{
        //Integer piso = Integer.parseInt(campo.getText());
            if(valorCampo!=null && valorCampo<0 || valorCampo2!=null && valorCampo2<0){
               JOptionPane.showMessageDialog(this,
                       "Valor incorrecto para el campo '"+nombreCulpable+"'",
                       "Error!",
                        JOptionPane.INFORMATION_MESSAGE);
                       return;
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(this,
                   "Solo se aceptan numeros enteros en el campo '"+nombreCulpable+"'",
                   "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
                   return;
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pestanaContacto = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNombreComercial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoNombreContacto = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        etiquetaNumeroCelular = new javax.swing.JLabel();
        campoNumeroCelular = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        etiquetaNumeroFijo = new javax.swing.JLabel();
        campoNumeroFijo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        campoCalle = new javax.swing.JTextField();
        etiquetaNumeroCalle = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoProvincia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campoLocalidad = new javax.swing.JTextField();
        etiquetaPiso = new javax.swing.JLabel();
        campoPiso = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoDepartamento = new javax.swing.JTextField();
        etiquetaCodigoPostal = new javax.swing.JLabel();
        campoCodigoPostal = new javax.swing.JTextField();
        campoNumeroCalle = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        campoPaginaWeb = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        checkEfectivo = new javax.swing.JCheckBox();
        checkTransferencia = new javax.swing.JCheckBox();
        checkDeposito = new javax.swing.JCheckBox();
        checkTarjeta = new javax.swing.JCheckBox();
        checkCheque = new javax.swing.JCheckBox();
        etiquetaCBU = new javax.swing.JLabel();
        campoCBU = new javax.swing.JTextField();
        etiquetaCUIT = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        campoRubro = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaBancosSeleccionados = new javax.swing.JList<>();
        boxIVA = new javax.swing.JComboBox<>();
        campoCUIT = new javax.swing.JFormattedTextField();
        botonSalir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre comercial");

        campoNombreComercial.setEditable(false);
        campoNombreComercial.setForeground(new java.awt.Color(0, 0, 255));

        jLabel2.setText("Nombre de contacto");

        campoNombreContacto.setEditable(false);
        campoNombreContacto.setForeground(new java.awt.Color(0, 0, 255));

        campoEmail.setEditable(false);
        campoEmail.setForeground(new java.awt.Color(0, 0, 255));

        jLabel14.setText("Email");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefonos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        etiquetaNumeroCelular.setText("Numero");

        campoNumeroCelular.setEditable(false);
        campoNumeroCelular.setForeground(new java.awt.Color(0, 0, 255));
        campoNumeroCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroCelularFocusLost(evt);
            }
        });
        campoNumeroCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroCelularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(etiquetaNumeroCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumeroCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNumeroCelular)
                    .addComponent(campoNumeroCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fijo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        etiquetaNumeroFijo.setText("Numero");

        campoNumeroFijo.setEditable(false);
        campoNumeroFijo.setForeground(new java.awt.Color(0, 0, 255));
        campoNumeroFijo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroFijoFocusLost(evt);
            }
        });
        campoNumeroFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroFijoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(etiquetaNumeroFijo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumeroFijo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNumeroFijo)
                    .addComponent(campoNumeroFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel7.setText("Calle");

        campoCalle.setEditable(false);
        campoCalle.setForeground(new java.awt.Color(0, 0, 255));

        etiquetaNumeroCalle.setText("Numero");

        jLabel9.setText("Provincia");

        campoProvincia.setEditable(false);
        campoProvincia.setForeground(new java.awt.Color(0, 0, 255));

        jLabel10.setText("Localidad");

        campoLocalidad.setEditable(false);
        campoLocalidad.setForeground(new java.awt.Color(0, 0, 255));

        etiquetaPiso.setText("Piso");

        campoPiso.setEditable(false);
        campoPiso.setForeground(new java.awt.Color(0, 0, 255));
        campoPiso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPisoFocusLost(evt);
            }
        });

        jLabel12.setText("Departamento");

        campoDepartamento.setEditable(false);
        campoDepartamento.setForeground(new java.awt.Color(0, 0, 255));

        etiquetaCodigoPostal.setText("Codigo Postal");

        campoCodigoPostal.setEditable(false);
        campoCodigoPostal.setForeground(new java.awt.Color(0, 0, 255));
        campoCodigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCodigoPostalFocusLost(evt);
            }
        });

        campoNumeroCalle.setEditable(false);
        campoNumeroCalle.setForeground(new java.awt.Color(0, 0, 255));
        campoNumeroCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroCalleFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(etiquetaNumeroCalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNumeroCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaPiso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPiso))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaCodigoPostal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {campoCodigoPostal, campoDepartamento});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNumeroCalle)
                    .addComponent(etiquetaPiso)
                    .addComponent(campoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumeroCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCodigoPostal)
                    .addComponent(campoCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setText("Pagina web");

        campoPaginaWeb.setEditable(false);
        campoPaginaWeb.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(campoNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(campoPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pestanaContacto.addTab("Contacto", jPanel7);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formas de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        checkEfectivo.setText("Efectivo");
        checkEfectivo.setEnabled(false);

        checkTransferencia.setText("Transferencia");
        checkTransferencia.setEnabled(false);
        checkTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTransferenciaActionPerformed(evt);
            }
        });

        checkDeposito.setText("Deposito");
        checkDeposito.setEnabled(false);
        checkDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDepositoActionPerformed(evt);
            }
        });

        checkTarjeta.setText("Tarjeta");
        checkTarjeta.setEnabled(false);

        checkCheque.setText("Cheque");
        checkCheque.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(checkEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDeposito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkCheque)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(checkEfectivo)
                .addComponent(checkTransferencia)
                .addComponent(checkDeposito)
                .addComponent(checkTarjeta)
                .addComponent(checkCheque))
        );

        etiquetaCBU.setText("CBU");

        campoCBU.setEditable(false);
        campoCBU.setForeground(new java.awt.Color(0, 0, 255));
        campoCBU.setEnabled(false);
        campoCBU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCBUFocusLost(evt);
            }
        });

        etiquetaCUIT.setText("CUIT");

        jLabel18.setText("Condicion IVA");

        jLabel19.setText("Rubro");

        campoRubro.setEditable(false);
        campoRubro.setForeground(new java.awt.Color(0, 0, 255));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bancos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aceptados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        listaBancosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        listaBancosSeleccionados.setForeground(new java.awt.Color(0, 0, 255));
        listaBancosSeleccionados.setModel(new javax.swing.DefaultListModel<String>() {});
        listaBancosSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaBancosSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaBancosSeleccionados);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        boxIVA.setForeground(new java.awt.Color(0, 0, 255));
        boxIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Responsable Inscripto\t", "Monotributista\t", "Exento" }));
        boxIVA.setEnabled(false);

        campoCUIT.setEditable(false);
        campoCUIT.setForeground(new java.awt.Color(0, 0, 255));
        try {
            campoCUIT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCUIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCUIT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCUITFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(etiquetaCBU)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoCBU, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(etiquetaCUIT))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCBU)
                    .addComponent(campoCBU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCUIT)
                    .addComponent(campoCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(campoRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pestanaContacto.addTab("Financiera", jPanel8);

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pestanaContacto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pestanaContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNumeroFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroFijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroFijoActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(this,
                        "Desea salir sin guardar?",                       
                        "Atencion!",
                        JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.NO_OPTION){
                    return;
                }else{
                   super.dispose(); 
                }
    }//GEN-LAST:event_botonSalirActionPerformed

    private void checkTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTransferenciaActionPerformed
        //activarTransferencias();
        
    }//GEN-LAST:event_checkTransferenciaActionPerformed

    private void checkDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDepositoActionPerformed
       //activarTransferencias();
        
    }//GEN-LAST:event_checkDepositoActionPerformed

    private void campoNumeroCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroCalleFocusLost
        String numeroCalle = campoNumeroCalle.getText();
        if(!numeroCalle.isEmpty()){
            try{
            ingresoIncorrectoNumero(Integer.parseInt(numeroCalle),"Numero de la calle",null);
            this.numeroCalle = Integer.parseInt(numeroCalle);
            }catch(Exception e){
                ingresoStringEnCampoNumerico(etiquetaNumeroCalle.getText());
            }
        }
       
    }//GEN-LAST:event_campoNumeroCalleFocusLost

    private void campoPisoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPisoFocusLost
        String numeroPiso = campoPiso.getText();
        if(!numeroPiso.isEmpty()){
        try{
            ingresoIncorrectoNumero(Integer.parseInt(numeroPiso),"Piso",null);
            piso = Integer.parseInt(numeroPiso);
            }catch (Exception e){
                ingresoStringEnCampoNumerico(etiquetaPiso.getText());
                }
    }//GEN-LAST:event_campoPisoFocusLost
    }
    private void campoCodigoPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCodigoPostalFocusLost
        String numeroCP = campoCodigoPostal.getText();
        if(!numeroCP.isEmpty()){
            try{
                ingresoIncorrectoNumero(Integer.parseInt(numeroCP),"Codigo postal",null);
                codigoPostal = Integer.parseInt(numeroCP);
            }catch (Exception e){
                ingresoStringEnCampoNumerico(etiquetaCodigoPostal.getText());
            }
    }//GEN-LAST:event_campoCodigoPostalFocusLost
   }    
    private void campoNumeroFijoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroFijoFocusLost
        String numeroFijo = campoNumeroFijo.getText();
        if(!numeroFijo.isEmpty()){
            try{
                ingresoIncorrectoNumero(Integer.parseInt(numeroFijo),"Telefono fijo",null);
                }catch (Exception e){
                    ingresoStringEnCampoNumerico(etiquetaNumeroFijo.getText());
                }
            }
    }//GEN-LAST:event_campoNumeroFijoFocusLost
        
    private void campoCBUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCBUFocusLost
        String numeroCBU = campoCBU.getText();
        if(!numeroCBU.isEmpty()){
            try{
                ingresoIncorrectoNumero(null,"CBU",Long.parseLong(numeroCBU));
                cbu = Long.parseLong(numeroCBU);
                }catch (Exception e){
                    ingresoStringEnCampoNumerico(etiquetaCBU.getText());
                    
                }
     
    }
    }//GEN-LAST:event_campoCBUFocusLost

    private void campoCUITFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCUITFocusLost
        String numeroCUIT = campoCUIT.getText().replace("-", "");
        
        if(!numeroCUIT.isEmpty()){
            if(numeroCUIT.length()>11){
                JOptionPane.showMessageDialog(this,
                   "El numero de CUIT no puede superar los 11 digitos",
                   "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
                   return;
            }
            try{
                ingresoIncorrectoNumero(null,"CUIT",Long.parseLong(numeroCUIT));
                cuit = Long.parseLong(numeroCUIT);;
                }catch (Exception e){
                    ingresoStringEnCampoNumerico(etiquetaCUIT.getText());
                }
     
    }
    }//GEN-LAST:event_campoCUITFocusLost

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        
        
        //----CONTACTO----\\
        actual.setNombre_comercial(campoNombreComercial.getText());
        actual.setNombre_contacto(campoNombreContacto.getText());
        actual.setEmail(campoEmail.getText());
        actual.setPaginaWeb(campoPaginaWeb.getText());
        actual.setTelefono1(Long.parseLong(campoNumeroCelular.getText()));
        actual.setTelefono2(Long.parseLong(campoNumeroFijo.getText()));
        
        //----DIRECCION----\\
        actual.setCalle(campoCalle.getText());
        actual.setDepartamento(campoDepartamento.getText());
        actual.setProvincia(campoProvincia.getText());
        actual.setLocalidad(campoLocalidad.getText());
        actual.setNumero(this.numeroCalle);
        actual.setPiso(this.piso);
        actual.setCodigoPostal(this.codigoPostal);
        
        //----FINANCIERA----\\
        actual.setFormas_de_pago(getMediosDePago());
        
        actual.setCuit(cuit);
        actual.setCondicionIVA((String)boxIVA.getSelectedItem());
        actual.setRubro(campoRubro.getText());
        
        if(checkDeposito.isSelected() || checkTransferencia.isSelected()){
            actual.setCbu(cbu);
            actual.setBancos(getBancos());
        }
        
        try {
            ctrprov.actualizar(actual);
            JOptionPane.showMessageDialog(this, "Se actualizo correctamente el proveedor");           
            super.dispose();                 
        } catch (Exception ex) {
            
        }
        
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void listaBancosSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaBancosSeleccionadosMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()){
            String seleccionado = listaBancosSeleccionados.getSelectedValue();
            if(!modeloDisponibles.contains(seleccionado)){
                modeloDisponibles.addElement(seleccionado);
            }
            modeloSeleccionados.remove(listaBancosSeleccionados.getSelectedIndex());
        }
    }//GEN-LAST:event_listaBancosSeleccionadosMouseClicked

    private void campoNumeroCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroCelularActionPerformed

    private void campoNumeroCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroCelularFocusLost
        String numeroCelular = campoNumeroCelular.getText();
        if(!numeroCelular.isEmpty()){
            try{
                ingresoIncorrectoNumero(null,"Telefono celular",Long.parseLong(numeroCelular));
            }catch (Exception e){
                ingresoStringEnCampoNumerico(etiquetaNumeroCelular.getText());
            }
        }
    }//GEN-LAST:event_campoNumeroCelularFocusLost
    
    
    
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
            java.util.logging.Logger.getLogger(DetallesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesProveedor dialog = new DetallesProveedor(new javax.swing.JFrame(), true,null);
                //new ModificarProveedor(parent, rootPaneCheckingEnabled, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<String> boxIVA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoCBU;
    private javax.swing.JFormattedTextField campoCUIT;
    private javax.swing.JTextField campoCalle;
    private javax.swing.JTextField campoCodigoPostal;
    private javax.swing.JTextField campoDepartamento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoLocalidad;
    private javax.swing.JTextField campoNombreComercial;
    private javax.swing.JTextField campoNombreContacto;
    private javax.swing.JFormattedTextField campoNumeroCalle;
    private javax.swing.JTextField campoNumeroCelular;
    private javax.swing.JTextField campoNumeroFijo;
    private javax.swing.JTextField campoPaginaWeb;
    private javax.swing.JTextField campoPiso;
    private javax.swing.JTextField campoProvincia;
    private javax.swing.JTextField campoRubro;
    private javax.swing.JCheckBox checkCheque;
    private javax.swing.JCheckBox checkDeposito;
    private javax.swing.JCheckBox checkEfectivo;
    private javax.swing.JCheckBox checkTarjeta;
    private javax.swing.JCheckBox checkTransferencia;
    private javax.swing.JLabel etiquetaCBU;
    private javax.swing.JLabel etiquetaCUIT;
    private javax.swing.JLabel etiquetaCodigoPostal;
    private javax.swing.JLabel etiquetaNumeroCalle;
    private javax.swing.JLabel etiquetaNumeroCelular;
    private javax.swing.JLabel etiquetaNumeroFijo;
    private javax.swing.JLabel etiquetaPiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaBancosSeleccionados;
    private javax.swing.JTabbedPane pestanaContacto;
    // End of variables declaration//GEN-END:variables

    private void ingresoStringEnCampoNumerico(String nombreCampo) {
        JOptionPane.showMessageDialog(this,
                   "Solo se aceptan caracteres numericos en el campo "+nombreCampo,
                   "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
                   return;
    }
    
    public List<String> getMediosDePago(){
        List<String> activados = new ArrayList<>();
        if(checkCheque.isSelected()){
            activados.add(checkCheque.getText());
        }
        if(checkDeposito.isSelected()){
            activados.add(checkDeposito.getText());
        }
        if(checkEfectivo.isSelected()){
            activados.add(checkEfectivo.getText());
        }
        if(checkTarjeta.isSelected()){
            activados.add(checkTarjeta.getText());
        }
        if(checkTransferencia.isSelected()){
            activados.add(checkTransferencia.getText());
        }
        return activados;
    }
    public List<String> getBancos(){
        List<String> bancosSeleccionados = new ArrayList<>();
        DefaultListModel modelo = (DefaultListModel) listaBancosSeleccionados.getModel();
        for(int i=0;i<modelo.size();i++){
            bancosSeleccionados.add((String)modelo.get(i));
        }
        
        return bancosSeleccionados;
    }
    public void cargarCampos(){
        if(actual.getCbu()!=null){
            campoCBU.setText(String.valueOf(actual.getCbu()));
        }else{
            campoCBU.setText("");
        }
        if(actual.getCuit()!=null){
            campoCUIT.setText(String.valueOf(actual.getCuit()));
        }else{
            campoCUIT.setText("");
        }
        campoCalle.setText(actual.getCalle());
        campoNumeroCelular.setText(String.valueOf(actual.getTelefono1()));
        campoNumeroFijo.setText(String.valueOf(actual.getTelefono2()));
        campoCodigoPostal.setText(String.valueOf(actual.getCodigoPostal()));
        campoDepartamento.setText(actual.getDepartamento());
        campoEmail.setText(actual.getEmail());
        campoLocalidad.setText(actual.getLocalidad());
        campoNombreComercial.setText(actual.getNombre_comercial());
        campoNombreContacto.setText(actual.getNombre_contacto());
        campoNumeroCalle.setText(String.valueOf(actual.getNumero()));
        
        campoPaginaWeb.setText(actual.getPaginaWeb());
        campoPiso.setText(String.valueOf(actual.getPiso()));
        campoProvincia.setText(actual.getProvincia());
        campoRubro.setText(actual.getRubro());
        checkCheque.setSelected(actual.getFormas_de_pago().contains(checkCheque.getText()));
        checkDeposito.setSelected(actual.getFormas_de_pago().contains(checkDeposito.getText()));
        checkEfectivo.setSelected(actual.getFormas_de_pago().contains(checkEfectivo.getText()));
        checkTarjeta.setSelected(actual.getFormas_de_pago().contains(checkTarjeta.getText()));
        checkTransferencia.setSelected(actual.getFormas_de_pago().contains(checkTransferencia.getText()));
        
        /*for(String banco : actual.getBancos()){
            System.out.println(banco);
            modeloSeleccionados.addElement(banco);
            
        }
        listaBancosSeleccionados.setModel(modeloSeleccionados);
        for(String banco2 : BancosAPoblar){
            modeloDisponibles.addElement(banco2);
            
        }
        listaBancosDisponibles.setModel(modeloDisponibles);*/
        
        
    }
    public void limpiarCampos(){
                    campoCBU.setText("");
                    campoCUIT.setText("");
                    campoCalle.setText("");
                    campoCodigoPostal.setText("");
                    campoDepartamento.setText("");
                    campoEmail.setText("");
                    campoLocalidad.setText("");
                    campoNombreComercial.setText("");
                    campoNombreContacto.setText("");
                    campoNumeroCalle.setText("");
                    campoNumeroCelular.setText("");
                    campoNumeroFijo.setText("");
                    campoPaginaWeb.setText("");
                    campoPiso.setText("");
                    campoProvincia.setText("");
                    campoRubro.setText("");
                    checkCheque.setSelected(false);
                    checkDeposito.setSelected(false);
                    checkEfectivo.setSelected(false);
                    checkTarjeta.setSelected(false);
                    checkTransferencia.setSelected(false);
                    DefaultListModel modelo = (DefaultListModel) listaBancosSeleccionados.getModel();
                    modelo.clear();
    }
    
}
