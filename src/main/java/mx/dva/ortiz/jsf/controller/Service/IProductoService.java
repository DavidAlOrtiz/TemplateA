package mx.dva.ortiz.jsf.controller.Service;

import jakarta.ejb.Local;
import java.util.List;
import java.util.Optional;
import mx.dva.ortiz.jsf.controller.entity.Categoria;
import mx.dva.ortiz.jsf.controller.entity.Producto;

@Local
public interface IProductoService {
    List<Producto> getProducto();
    Optional<Producto> porId(Long id);
    void save(Producto producto);
    void eliminar(Long id);
    
    List<Categoria> getCategorias();
    Categoria categoriaPorId(Long id);
}
