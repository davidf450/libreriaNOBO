package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venta.class)
public abstract class Venta_ extends modelo.Transaccion_ {

	public static volatile SingularAttribute<Venta, Cliente> cliente;
	public static volatile SingularAttribute<Venta, Long> nroVenta;

}

