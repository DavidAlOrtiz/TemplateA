package mx.dva.ortiz.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import mx.dva.ortiz.jsf.controller.Service.IProductoService;
import mx.dva.ortiz.jsf.controller.entity.Categoria;
import mx.dva.ortiz.jsf.controller.entity.Producto;

@Model
public class ProductoController {
    
    private Producto product;
    private Long id;
    
    @Inject
    private IProductoService productoService;
    
    
    
    @Produces
    @Model
    public String titulo(){
        return "Hola mundo desde EJF 3";
    }
    
    @Produces
    @RequestScoped
    @Named("listProductos")
    public List<Producto> getProductos(){
      //        return Arrays.asList(new Producto("Cocacola"), new Producto("jarritos") );
      return productoService.getProducto();
    }
    
    @Produces
    @Model
    public Producto producto(){
        product = new Producto();
        if(id != null && id > 0);{
            productoService.porId(id).ifPresent(p ->{
                product = p;
            });
        }
        return product;
    }
    
    @Produces
    @Model
    public List<Categoria> categoria(){
        return productoService.getCategorias();
    }
    
    public String editar(Long id){
        this.id = id;
        return "form.xhtml";
    }
    
    public String eliminar(Long id){
        this.id = id;
        System.out.println("Id para Eliminar  ---->" + id);
        productoService.eliminar(id);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String crear(){
        System.err.println(product);
        productoService.save(product);
        return "index.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
