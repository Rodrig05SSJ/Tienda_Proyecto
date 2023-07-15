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

    public Producto getProducto(Producto producto);
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
      //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
     //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
}