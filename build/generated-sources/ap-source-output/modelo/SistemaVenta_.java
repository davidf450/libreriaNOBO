package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SistemaVenta.class)
public abstract class SistemaVenta_ {

	public static volatile ListAttribute<SistemaVenta, Factura> facturas;
	public static volatile ListAttribute<SistemaVenta, String> categorias;
	public static volatile ListAttribute<SistemaVenta, Recibo> recibos;
	public static volatile ListAttribute<SistemaVenta, Usuario> usuarios;
	public static volatile SingularAttribute<SistemaVenta, String> nombre;
	public static volatile SingularAttribute<SistemaVenta, String> condicionIva;
	public static volatile ListAttribute<SistemaVenta, Proveedor> proveedores;
	public static volatile SingularAttribute<SistemaVenta, String> domicilio;
	public static volatile SingularAttribute<SistemaVenta, String> cuit;
	public static volatile SingularAttribute<SistemaVenta, Date> fechaInicio;
	public static volatile ListAttribute<SistemaVenta, Remito> remitos;
	public static volatile SingularAttribute<SistemaVenta, Long> puntoVenta;
	public static volatile ListAttribute<SistemaVenta, Venta> ventas;
	public static volatile SingularAttribute<SistemaVenta, Long> id;
	public static volatile ListAttribute<SistemaVenta, Cliente> clientes;
	public static volatile ListAttribute<SistemaVenta, Producto> productos;

}

