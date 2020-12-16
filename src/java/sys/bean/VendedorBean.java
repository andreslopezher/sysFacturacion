/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.VendedorDao;
import sys.imp.VendedorDaoImp;
import sys.model.Vendedor;

/**
 *
 * @author AndresLopez
 */
@Named(value = "vendedorBean")
@ViewScoped
public class VendedorBean {

    private List<Vendedor> listaVendedores;
    private Vendedor vendedor;
 
    public VendedorBean() {
        vendedor = new Vendedor();
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getListaVendedores() {
        VendedorDao vDao = new VendedorDaoImp();
        listaVendedores = vDao.listarVendedores();
        return listaVendedores;
    }

    public void prepararNuevoVendedor() {
        vendedor = new Vendedor();
    }

    public void nuevoVendedor() {
        VendedorDao vDao = new VendedorDaoImp();
        vDao.newVendedor(vendedor);
    }

    public void modificarVendedor() {
        VendedorDao cDao = new VendedorDaoImp();
        cDao.updateVendedor(vendedor);
        vendedor = new Vendedor();
    }

    public void eliminarVendedor() {
        VendedorDao cDao = new VendedorDaoImp();
        cDao.deleteVendedor(vendedor);
        vendedor = new Vendedor();
    }

}
