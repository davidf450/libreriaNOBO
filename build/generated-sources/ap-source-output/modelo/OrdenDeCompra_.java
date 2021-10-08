package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrdenDeCompra.class)
public abstract class OrdenDeCompra_ {

	public static volatile SingularAttribute<OrdenDeCompra, Proveedor> proveedor;
	public static volatile SingularAttribute<OrdenDeCompra, Long> codigo_orden;
	public static volatile ListAttribute<OrdenDeCompra, Producto> productos;

}

