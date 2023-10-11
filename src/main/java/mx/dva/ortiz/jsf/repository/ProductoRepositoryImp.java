package mx.dva.ortiz.jsf.repository;

import mx.dva.ortiz.jsf.controller.producerEntityManager.ProducerEntityManager;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;
import mx.dva.ortiz.jsf.controller.entity.Producto;

@RequestScoped
public class ProductoRepositoryImp implements IGenericRepository<Producto>{
    
    @Inject
    private EntityManager em;
    
    @Override
    public List<Producto> getAll() {
        return em.createQuery("SELECT p FROM Producto p").getResultList();
    }

    @Override
    public Producto getById(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void save(Producto producto) {
       if(producto.getId() != null && producto.getId() > 0){
           em.merge(producto);
       }else{
           em.persist(producto);
       }
    }

    @Override
    public void eliminar(Long id) {
        System.out.print(id);
//        em.createQuery("DELETE FROM Producto c WHERE c.id = :id")
//                .setParameter("id", id).executeUpdate();

       Producto p = this.getById(id);
       em.remove(p);
        
        
    }
    
    
    
}
