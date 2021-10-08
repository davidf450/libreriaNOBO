package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Integer> piso;
	public static volatile SingularAttribute<Cliente, Integer> codigoPostal;
	public static volatile SingularAttribute<Cliente, Date> fechaNacimiento;
	public static volatile SingularAttribute<Cliente, String> calle;
	public static volatile SingularAttribute<Cliente, String> nombre_comercial;
	public static volatile SingularAttribute<Cliente, CuentaCorriente> cuentaCorriente;
	public static volatile SingularAttribute<Cliente, String> provincia;
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, String> condicionIVA;
	public static volatile SingularAttribute<Cliente, Boolean> sobreElMaximo;
	public static volatile SingularAttribute<Cliente, String> tipoDocumento;
	public static volatile SingularAttribute<Cliente, Long> cuit;
	public static volatile SingularAttribute<Cliente, Integer> numeroCalle;
	public static volatile SingularAttribute<Cliente, Long> codigoCliente;
	public static volatile SingularAttribute<Cliente, String> observaciones;
	public static volatile SingularAttribute<Cliente, String> departamento;
	public static volatile SingularAttribute<Cliente, Long> telefono1;
	public static volatile SingularAttribute<Cliente, String> localidad;
	public static volatile SingularAttribute<Cliente, Long> telefono2;
	public static volatile SingularAttribute<Cliente, Long> cuil;
	public static volatile SingularAttribute<Cliente, Boolean> habilitado;
	public static volatile SingularAttribute<Cliente, Character> sexo;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, Long> dni;

}

