package mx.dva.ortiz.jsf.controller.Service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import mx.dva.ortiz.jsf.controller.entity.Categoria;
import mx.dva.ortiz.jsf.controller.entity.Producto;
import mx.dva.ortiz.jsf.repository.CategoriaRepository;
import mx.dva.ortiz.jsf.repository.IGenericRepository;

@Stateless
public class ProductoServiceImp implements IProductoService {

    
    @Inject
    private IGenericRepository<Producto> productpRepository;
    
    @Inject
    private IGenericRepository<Categoria> categoriaRepository;
    
    @Override
    public List<Producto> getProducto() {
        return productpRepository.getAll();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.of(productpRepository.getById(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Producto producto) {
        productpRepository.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        productpRepository.eliminar(id);
    }

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.getAll();
    }

    @Override
    public Categoria categoriaPorId(Long id) {
        return categoriaRepository.getById(id);
    }
    
    
    
    
}
