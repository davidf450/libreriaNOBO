package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CuentaCorriente.class)
public abstract class CuentaCorriente_ {

	public static volatile SingularAttribute<CuentaCorriente, Double> monto_maximo;
	public static volatile SingularAttribute<CuentaCorriente, Date> fecha_alta;
	public static volatile SingularAttribute<CuentaCorriente, Double> monto_acumulado;
	public static volatile SingularAttribute<CuentaCorriente, Long> codigo_cuenta;

}

