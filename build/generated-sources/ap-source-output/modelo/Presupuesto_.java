package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Presupuesto.class)
public abstract class Presupuesto_ {

	public static volatile SingularAttribute<Presupuesto, Date> fecha_emision;
	public static volatile SingularAttribute<Presupuesto, Long> codigo_presupuesto;
	public static volatile ListAttribute<Presupuesto, Producto> productos;
	public static volatile SingularAttribute<Presupuesto, Double> montoTotal;
	public static volatile SingularAttribute<Presupuesto, String> nombre_cliente;
	public static volatile SingularAttribute<Presupuesto, Date> valido_hasta;

}

