package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proveedor.class)
public abstract class Proveedor_ {

	public static volatile SingularAttribute<Proveedor, Integer> piso;
	public static volatile SingularAttribute<Proveedor, String> rubro;
	public static volatile SingularAttribute<Proveedor, String> paginaWeb;
	public static volatile SingularAttribute<Proveedor, Integer> numero;
	public static volatile SingularAttribute<Proveedor, Integer> codigoPostal;
	public static volatile SingularAttribute<Proveedor, String> nombre_contacto;
	public static volatile SingularAttribute<Proveedor, Long> codigoProveedor;
	public static volatile SingularAttribute<Proveedor, String> calle;
	public static volatile SingularAttribute<Proveedor, String> nombre_comercial;
	public static volatile SingularAttribute<Proveedor, String> provincia;
	public static volatile ListAttribute<Proveedor, String> formas_de_pago;
	public static volatile SingularAttribute<Proveedor, String> condicionIVA;
	public static volatile SingularAttribute<Proveedor, Long> cuit;
	public static volatile SingularAttribute<Proveedor, Long> cbu;
	public static volatile SingularAttribute<Proveedor, String> departamento;
	public static volatile SingularAttribute<Proveedor, Long> telefono1;
	public static volatile SingularAttribute<Proveedor, String> localidad;
	public static volatile SingularAttribute<Proveedor, Long> telefono2;
	public static volatile SingularAttribute<Proveedor, Boolean> habilitadoParaComprar;
	public static volatile ListAttribute<Proveedor, String> bancos;
	public static volatile SingularAttribute<Proveedor, String> email;

}

