/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.ControladorSistemaVentas;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

/**
 *
 * @author guti_
 */
@Entity
public class SistemaVenta implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private String nombre = "Libreria Nobo";
    private String domicilio = "Pueyrredon 578";
    private String condicionIva = "Responsable Inscripto";
    private String cuit = "20135880675";
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio = new Date();
    private long puntoVenta;
    
    @ElementCollection
    private List<String> categorias = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Proveedor> proveedores = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();//era ARTICULO
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Venta> ventas = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Cliente> clientes = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Factura> facturas = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Remito> remitos = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Recibo> recibos = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();
    
    
    private static SistemaVenta sistemaVenta;

    public SistemaVenta() {
    }
    public int getNumeroVenta(){
        if(this.ventas.isEmpty()){
            return 1;
        }else{
            return this.ventas.size()+1;
        }
    }
    public SistemaVenta getSistemaVentaRAM() {
        return sistemaVenta;
    }
    
    /*public  static SistemaVenta getSistemaVenta() {
        if (sistemaVenta == null) 
            sistemaVenta = new SistemaVenta();
        return sistemaVenta;
    }*/
    
    public  static SistemaVenta getSistemaVenta() {
        ControladorSistemaVentas svDao = new ControladorSistemaVentas();
        if(!svDao.findSistemaVentaEntities().isEmpty())
            sistemaVenta = svDao.findSistemaVentaEntities().get(0);
        else
            sistemaVenta = new SistemaVenta();
        return sistemaVenta;
    }
    
    public List<Producto> getArticulosFaltantes(){
        Iterator<Producto> it = productos.iterator();
        List<Producto> listaFaltante = new ArrayList<>();
        Producto articulo2;
        while(it.hasNext()){
            articulo2 = it.next();
            if(articulo2.getFaltante())
                listaFaltante.add(articulo2);
        }
        return listaFaltante;
    }
    
    public void guardarDatos(){
        ControladorSistemaVentas svDao = new ControladorSistemaVentas();
        try {
            svDao.actualizar(sistemaVenta);
        } catch (Exception ex) {
            Logger.getLogger(SistemaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int cantidadArticulosFaltantes(){
        Iterator<Producto> it = productos.iterator();
        int cont = 0;
        Producto articulo2;
        while(it.hasNext()){
            articulo2 = it.next();
            if(articulo2.getFaltante())
                cont++;
        }
        return cont;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    
    
    public boolean datoSistema(){
        return nombre != null && cuit != null;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getNroRemito(Venta venta){
        try {
            Iterator<Remito> it = remitos.iterator();
            Remito remito = new Remito();
            while(it.hasNext()){
                remito = it.next();
                if(remito.getVenta().getNroVenta() == venta.getNroVenta()){
                    String nroPunto = String.format("%04d", remito.getNroPuntoRemito());
                    String nroRemito = String.format("%08d", remito.getNroRemito());
                    return nroPunto + " - " + nroRemito;
                }
            }
            return "-";
        } catch (Exception e) {
            return "-";
        }
    }
    
    public Remito getRemito(long nro){
        for(Remito rem : remitos){
            if(rem.getNroRemito() == nro)
                return rem;
        }
        return null;
    }
    
    public Recibo getRecibo(long nro){
        for(Recibo rec : recibos){
            if(rec.getNroRecibo()== nro)
                return rec;
        }
        return null;
    }
    
    public Factura getFactura(long nro){
        for(Factura fac : facturas){
            if(fac.getNroFactura()== nro)
                return fac;
        }
        return null;
    }
    
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
// <editor-fold defaultstate="collapsed" desc=" login de agus ">
    /*public boolean login(Usuario usuarioNuevo){
        try {
            Iterator<Usuario> it = usuarios.iterator();
            Usuario usuario = new Usuario();
            while(it.hasNext()){
                usuario = it.next();
                if(usuario.getNombre().equalsIgnoreCase(usuarioNuevo.getNombre()) 
                        && usuario.getPw().equalsIgnoreCase(usuarioNuevo.getPw())){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        } 
    }*/
// </editor-fold>
    
    public void addRemito(Remito remito){
        remitos.add(remito);
    }
    
    public List<Remito> getRemitos() {
        return remitos;
    }

    public void setRemitos(List<Remito> remitos) {
        this.remitos = remitos;
    }

    
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addRecibo(Recibo recibo){
        recibos.add(recibo);
    }
    
    public List<Recibo> getRecibos() {
        return recibos;
    }

    public Recibo generarRecibo(long nroVenta){
        try {
            Iterator<Factura> it = facturas.iterator();
            Factura factura = new Factura();
            Recibo recibo = new Recibo();
            while(it.hasNext()){
                factura = it.next();
                if(factura.getVenta().getNroVenta() == nroVenta){
                    recibo.setFactura(factura);
                    recibo.setFechaEmision(new Date());
                    recibo.setNroPuntoRecibo(this.getPuntoVenta());
                    recibo.setNroRecibo(recibos.size() + 1);
                    return recibo;
                }
            }
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Primero debe Facturarse la Venta!");
            return null;
        }

    }
    
    public void setRecibos(List<Recibo> recibos) {
        this.recibos = recibos;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    public int getPosicionArticulo(Producto articulo){
        Iterator<Producto> it = productos.iterator();
        Producto articulo2;
        int posicion = 0;
        while(it.hasNext()){
            articulo2 = it.next();
            if(articulo2.getCodigoProducto().equals(articulo.getCodigoProducto()))
                return posicion;
            posicion++;
        }
        return -1;
    }

    public int getPosicionCliente(Cliente cliente){
        Iterator<Cliente> it = clientes.iterator();
        Cliente cliente2;
        int posicion = 0;
        while(it.hasNext()){
            cliente2 = it.next();
            if(cliente2.getCuit().equals(cliente.getCuit()))
                return posicion;
            posicion++;
        }
        return -1;
    }
    
    public void setArticuloFaltante(Producto articulo){
        Iterator<Producto> it = productos.iterator();
        Producto articulo2;
        while(it.hasNext()){
            articulo2 = it.next();
            if(articulo2.getCodigoProducto().equals(articulo.getCodigoProducto()))
                articulo2.setFaltante(true);
        }
    }
    
    public Producto buscarArticulo(String codigo){
        Iterator<Producto> it = productos.iterator();
        Producto articulo;
        while(it.hasNext()){
            articulo = it.next();
            if(articulo.getCodigoProducto().equals(codigo))
                return articulo;
        }
        return null;
    }
    
    public Cliente buscarCliente(String cuit){
        Iterator<Cliente> it = clientes.iterator();
        Cliente cliente;
        while(it.hasNext()){
            cliente = it.next();
            if(cliente.getCuit().equals(cuit))
                return cliente;
        }
        return null;
    }
    
    public boolean addVenta(Venta venta){
        try {
            ventas.add(venta);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    public boolean isFacturada(Venta venta){
        Iterator<Factura> it = facturas.iterator();
        Factura factura;
        while(it.hasNext()){
            factura = it.next();
            if(factura.getVenta().getNroVenta() == venta.getNroVenta()){
                return true;
            }
        }
        return false;
    }
    
    public Venta dameVenta(long nroVenta){
        Iterator<Venta> it = ventas.iterator();
        Venta venta;
        while(it.hasNext()){
            venta = it.next();
            if(venta.getNroVenta() == nroVenta){
                return venta;
            }    
        }
        return null;
    }
    
    public boolean registrarCobro(long nroVenta){
        Iterator<Venta> it = ventas.iterator();
        Venta venta;
        while(it.hasNext()){
            venta = it.next();
            if(venta.getNroVenta() == nroVenta && !venta.getEstadoPago()){
                venta.setEstadoPago(true);
                return true;
            }    
        }
        return false;
    }
    
    public int getNumeroFactura(String tipo){
        Iterator<Factura> it = facturas.iterator();
        Factura factura;
        int numero = 1;
        while(it.hasNext()){
            factura = it.next();
            if(factura.getTipoFactura().equalsIgnoreCase(tipo)){
                numero++;
            }    
        }
        return numero;
    }
    
    public void addFactura(Factura factura){
        facturas.add(factura);
    }
    
    public int getNroVenta(){
        return ventas.size() + 1;
    }
    
    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
    public boolean addCategoria(String categoriaNueva){
        if(categoriaNueva.isEmpty())
            return false;
        Iterator<String> it = categorias.iterator();
        String categoria;
        while(it.hasNext()){
            categoria = it.next();
            if(categoria.equalsIgnoreCase(categoriaNueva)){
                JOptionPane.showMessageDialog(null, "Categoría repetida!");
                return false;
            }
        }
        categorias.add(categoriaNueva);
        guardarDatos();
        return true;
    }
    
    public void addArticulo(Producto articulo){
        productos.add(articulo);
    }
    
    public void modificarArticulo(Producto articulo, int posicion){
        productos.set(posicion, articulo);
    }
    
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public void modificarCliente(Cliente cliente, int posicion){
        clientes.set(posicion, cliente);
    }
    
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Producto> getArticulos() {
        return productos;
    }

    public List<Producto> getArticulosActivos(){
        Iterator<Producto> it = productos.iterator();
        Producto articulo;
        List<Producto> articulosActivos = new ArrayList();
        while(it.hasNext()){
            articulo = it.next();
            if(articulo.getHabilitadoVenta()){
                articulosActivos.add(articulo); 
            }
        }
        return articulosActivos;
    }
    
    public void setArticulos(List<Producto> articulos) {
        this.productos = articulos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(String condicionIva) {
        this.condicionIva = condicionIva;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getFechaInicio() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fechaInicio);
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public long getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(long puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public float hayOtroRecibo(Venta venta) {
        Iterator<Recibo> it = recibos.iterator();
        Recibo recibo;
        float importe = 0;
        while(it.hasNext()){
            recibo = it.next();
            if(recibo.getFactura().getVenta().getNroVenta() == venta.getNroVenta()){
                importe += recibo.getImporteTotalRecibo();
            }
        }
        return importe;
    }
}