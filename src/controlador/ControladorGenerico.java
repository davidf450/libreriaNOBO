/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.*;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import modelo.SistemaVenta;


/**
 *
 * @author Analía Santomé
 * @param <T>
 * @param <K>
 */
public class ControladorGenerico <T, K> implements Serializable {

    private static EntityManagerFactory emf = null;
	
   // private  EntityManager em;
    
	private static EntityManagerFactory getEMF(){
		 if (emf == null)
	        	emf = Persistence.createEntityManagerFactory("LibreriaNoboPU_nuevo",System.getProperties());
	     return emf;
	}
        
        private  EntityManager getEM() throws Exception {	
          // if(em == null)
              return  getEMF().createEntityManager();
           
           //return em;
        }
        
       	public void crear(T entidad) throws Exception {	
                    EntityManager em = getEM();
                    EntityTransaction et=em.getTransaction();
		try{	
                        System.out.println("entro al try");
			et.begin();
			System.out.println("paso el begin");
                        em.persist(entidad);
                        System.out.println("paso el persist");
			et.commit();
                        System.out.println("paso el commit");
			} catch (Exception e) {
                                e.printStackTrace();
				et.rollback();
				throw new RuntimeException(e);
		} finally {
			em.close();
			
	    }
	}

	
	public T buscar(Class<T> clazz, K clave) throws Exception {
		EntityManager em = getEM();
		
		try {
			return em.find(clazz, clave);
			
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
	    }
	}

	
	public T actualizar(T entidad) throws Exception {
		EntityManager em = getEM();
		
                T nuevo = null;
		try {
                        
			em.getTransaction().begin();
                        System.out.println("entro al try");
			nuevo = em.merge(entidad);
			em.getTransaction().commit();
			
 		} catch (Exception e) {
                        e.printStackTrace();
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
                        return nuevo;
	    }
	}

	
	public void borrar(T entidad) throws Exception{
		
                    EntityManager em = getEM();
                    
                    try {
                        em.getTransaction().begin();
                        em.remove(em.merge(entidad));
                        
                        em.getTransaction().commit();
                    } catch (Exception e) {
                        em.getTransaction().rollback();
                        throw new RuntimeException(e);
                    } finally {
                        em.close();
                    }
                }
	

	
	public List<T> buscarConConsultaNombrada(String consulta) throws Exception {
                EntityManager em = getEM();
		
		@SuppressWarnings("unchecked")
		List<T> resultado = em.createNamedQuery(consulta).getResultList();
		
		em.close();
		
		return resultado;
	}

	
	public List<T> buscarConConsultaNombrada(String consulta, int limite) throws Exception {
		EntityManager em = getEM();
		
		@SuppressWarnings("unchecked")
		List<T> resultado = em.createNamedQuery(consulta)
				.setMaxResults(limite).getResultList();
		 
		em.close();
		
		return resultado;

	}

	
	public List<T> buscarConConsultaNombrada(String consulta, Map<String, Object> parametros) throws Exception {
		return buscarConConsultaNombrada(consulta, parametros, 0);
	}
        
        

	
	@SuppressWarnings("unchecked")
	public List<T> buscarConConsultaNombrada(String consulta, Map<String, Object> parametros, int limite) throws Exception {
		EntityManager em = getEM();
		
		Set<Entry<String, Object>> params = parametros.entrySet();
		  
		Query query = em.createNamedQuery(consulta);
	    
		if(limite > 0)
			query.setMaxResults(limite);
	      
		for (Entry<String, Object> entry : params) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.getResultList();
	}
        
         public List<SistemaVenta> findSistemaVentaEntities() {
        try {
            return findSistemaVentaEntities(true, -1, -1);
        } catch (Exception ex) {
            Logger.getLogger(ControladorGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }

        public List<SistemaVenta> findSistemaVentaEntities(int maxResults, int firstResult) throws Exception {
            return findSistemaVentaEntities(false, maxResults, firstResult);
        }

        private List<SistemaVenta> findSistemaVentaEntities(boolean all, int maxResults, int firstResult) throws Exception {
            EntityManager em = getEM();
            try {
                CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
                cq.select(cq.from(SistemaVenta.class));
                Query q = em.createQuery(cq);
                if (!all) {
                    q.setMaxResults(maxResults);
                    q.setFirstResult(firstResult);
                }
                return q.getResultList();
            } finally {
                em.close();
            }
        }
}
