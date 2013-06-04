/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.products.commands;

import by.bsu.products.dao.IProductsDAO;
import by.bsu.products.dao.ProductsDAO;
import by.bsu.products.exceptions.LogicException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;



public abstract class AbstractCommand {
    /**
     *
     */
   protected static ReadWriteLock lock=new ReentrantReadWriteLock();
    protected IProductsDAO productsDAO=ProductsDAO.getInstance();
    public abstract String execute(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, LogicException;
}
