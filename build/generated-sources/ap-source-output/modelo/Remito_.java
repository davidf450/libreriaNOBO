package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Remito.class)
public abstract class Remito_ {

	public static volatile SingularAttribute<Remito, Venta> venta;
	public static volatile SingularAttribute<Remito, Long> nroRemito;
	public static volatile SingularAttribute<Remito, Date> fechaEmision;
	public static volatile SingularAttribute<Remito, Long> id;
	public static volatile SingularAttribute<Remito, Long> nroPuntoRemito;

}

