package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recibo.class)
public abstract class Recibo_ {

	public static volatile SingularAttribute<Recibo, String> nroCheque;
	public static volatile SingularAttribute<Recibo, Factura> factura;
	public static volatile SingularAttribute<Recibo, Float> importeEfectivo;
	public static volatile SingularAttribute<Recibo, Date> fechaEmision;
	public static volatile SingularAttribute<Recibo, Long> id;
	public static volatile SingularAttribute<Recibo, Long> nroPuntoRecibo;
	public static volatile SingularAttribute<Recibo, Long> nroRecibo;
	public static volatile SingularAttribute<Recibo, Float> importeCheque;

}

