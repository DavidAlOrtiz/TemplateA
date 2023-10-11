package mx.dva.ortiz.jsf.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;
import mx.dva.ortiz.jsf.controller.entity.Categoria;

@RequestScoped
public class CategoriaRepository implements IGenericRepository<Categoria> {
    
    @Inject
    private EntityManager em;
    
    @Override
    public List<Categoria> getAll() {
        return em.createQuery("SELECT c FROM Categoria c")
                    .getResultList();
    }

    @Override
    public Categoria getById(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void save(Categoria categoria) {
        if(categoria.getId() != null && categoria.getId() > 0){
            em.merge(categoria);
        }else{
            em.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) {
        Categoria c = this.getById(id);
        em.remove(c);
    }
    
}
