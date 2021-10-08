package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LineaTransaccion.class)
public abstract class LineaTransaccion_ {

	public static volatile SingularAttribute<LineaTransaccion, Double> ultimoCosto;
	public static volatile SingularAttribute<LineaTransaccion, Long> codigoLineaTransaccion;
	public static volatile SingularAttribute<LineaTransaccion, Double> total;
	public static volatile SingularAttribute<LineaTransaccion, Double> nuevoCosto;
	public static volatile SingularAttribute<LineaTransaccion, Double> precioUnitario;
	public static volatile SingularAttribute<LineaTransaccion, Float> valorIva;
	public static volatile SingularAttribute<LineaTransaccion, String> descripcionProducto;
	public static volatile SingularAttribute<LineaTransaccion, Long> idProducto;
	public static volatile SingularAttribute<LineaTransaccion, Integer> cantidad;
	public static volatile SingularAttribute<LineaTransaccion, String> nombreProducto;

}

