package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(boolean activos);
    
    public void save (Producto producto);
    
    public void delete (Producto producto);

    public Categoria getCategoria(Categoria categoria);

}