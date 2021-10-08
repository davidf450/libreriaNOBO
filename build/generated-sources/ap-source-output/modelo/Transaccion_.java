package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaccion.class)
public abstract class Transaccion_ {

	public static volatile ListAttribute<Transaccion, LineaTransaccion> lineas;
	public static volatile SingularAttribute<Transaccion, Boolean> remitada;
	public static volatile SingularAttribute<Transaccion, Date> fechaFacturacion;
	public static volatile SingularAttribute<Transaccion, Double> descuento;
	public static volatile SingularAttribute<Transaccion, Double> montoPago;
	public static volatile SingularAttribute<Transaccion, Boolean> estaFacturada;
	public static volatile SingularAttribute<Transaccion, Long> codigoTransaccion;
	public static volatile SingularAttribute<Transaccion, Double> subTotal;
	public static volatile SingularAttribute<Transaccion, Boolean> anulada;
	public static volatile SingularAttribute<Transaccion, Date> fecha;
	public static volatile SingularAttribute<Transaccion, Double> total;
	public static volatile SingularAttribute<Transaccion, String> numero_factura;
	public static volatile SingularAttribute<Transaccion, Float> precioIva;
	public static volatile SingularAttribute<Transaccion, Character> tipo_factura;
	public static volatile SingularAttribute<Transaccion, String> formaDePago;
	public static volatile SingularAttribute<Transaccion, Boolean> estadoPago;
	public static volatile SingularAttribute<Transaccion, Date> fechaCobro;

}

