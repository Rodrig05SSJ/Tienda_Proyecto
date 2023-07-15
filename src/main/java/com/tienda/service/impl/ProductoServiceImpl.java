package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional (readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Transactional(readOnly = true)
    @Override
    public Producto getProducto (Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto getProducto(boolean activos) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
     @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
     @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }

}