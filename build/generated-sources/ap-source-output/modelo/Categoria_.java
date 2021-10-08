package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile ListAttribute<Categoria, Categoria> subCategorias;
	public static volatile SingularAttribute<Categoria, Long> codigoCategoria;
	public static volatile SingularAttribute<Categoria, Boolean> esPrincipal;
	public static volatile SingularAttribute<Categoria, Categoria> superCategoria;
	public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}

