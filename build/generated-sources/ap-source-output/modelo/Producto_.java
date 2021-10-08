package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, String> descripcion;
	public static volatile SingularAttribute<Producto, Double> ultimoCosto;
	public static volatile SingularAttribute<Producto, Categoria> subCategoria;
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	public static volatile SingularAttribute<Producto, Boolean> vieneEnCaja;
	public static volatile SingularAttribute<Producto, String> nombre;
	public static volatile SingularAttribute<Producto, Integer> stockMaximo;
	public static volatile SingularAttribute<Producto, String> codigoDeProveedor;
	public static volatile SingularAttribute<Producto, Integer> stockMinimo;
	public static volatile SingularAttribute<Producto, String> marca;
	public static volatile ListAttribute<Producto, Proveedor> proveedores;
	public static volatile SingularAttribute<Producto, Boolean> faltante;
	public static volatile SingularAttribute<Producto, Boolean> habilitadoVenta;
	public static volatile SingularAttribute<Producto, Float> valorIva;
	public static volatile SingularAttribute<Producto, Integer> cantidadPorCaja;
	public static volatile SingularAttribute<Producto, Integer> stockActual;
	public static volatile SingularAttribute<Producto, Long> codigoProducto;
	public static volatile SingularAttribute<Producto, Double> precioVenta;
	public static volatile SingularAttribute<Producto, Long> codigoBarras;

}

