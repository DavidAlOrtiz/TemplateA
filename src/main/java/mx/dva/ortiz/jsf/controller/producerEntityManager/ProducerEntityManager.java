package mx.dva.ortiz.jsf.controller.producerEntityManager;


import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RequestScoped
public class ProducerEntityManager {
      
      @PersistenceContext(name = "emploJta")
      private EntityManager em;
      
      @Produces
      @RequestScoped
      public EntityManager beanEntityManager(){
          return em;
      }
      
}
