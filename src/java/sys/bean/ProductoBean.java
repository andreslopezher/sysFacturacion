/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.ProductoDao;
import sys.imp.ProductoDaoImp;
import sys.model.Producto;

/**
 *
 * @author AndresLopez
 */
@Named(value = "productoBean")
@ViewScoped
public class ProductoBean {

    private List<Producto> listaProductos;
    private Producto producto;
    
    public ProductoBean() {
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        ProductoDao pDao = new ProductoDaoImp();
        listaProductos = pDao.listarProductos();
        return listaProductos;
    }
    
    public void prepararNuevoProducto() {
        producto = new Producto();
    }

    public void nuevoProducto() {
        ProductoDao pDao = new ProductoDaoImp();
        pDao.newProducto(producto);
    }

    public void modificarProducto() {
        ProductoDao pDao = new ProductoDaoImp();
        pDao.updateProducto(producto);
        producto = new Producto();
    }

    public void eliminarProducto() {
        ProductoDao pDao = new ProductoDaoImp();
        pDao.deleteProducto(producto);
        producto = new Producto();
    }

}
