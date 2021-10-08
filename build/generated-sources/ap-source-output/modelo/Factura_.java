package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Venta> venta;
	public static volatile SingularAttribute<Factura, Long> nroFactura;
	public static volatile SingularAttribute<Factura, String> tipoFactura;
	public static volatile SingularAttribute<Factura, Long> nroPuntoFactura;
	public static volatile SingularAttribute<Factura, Float> importeTotal;
	public static volatile SingularAttribute<Factura, Date> fechaEmision;
	public static volatile SingularAttribute<Factura, Long> id;

}

