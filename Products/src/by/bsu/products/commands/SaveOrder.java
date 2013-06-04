package by.bsu.products.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import by.bsu.products.constants.ParameterName;
import by.bsu.products.constants.PathName;
import by.bsu.products.exceptions.LogicException;
import by.bsu.products.form.Order;
import by.bsu.products.form.ProductsForm;
import by.bsu.products.util.xslt.StylesheetCache;

public final class SaveOrder extends AbstractCommand {

   
    private final String MODEL = "model";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, LogicException {
        String subcategory = request.getParameter(ParameterName.SUBCATEGORY);
        String category = request.getParameter(ParameterName.CATEGORY);
        Order order=new Order();


     
        order.setModel(request.getParameter(MODEL).trim());
        order.setFirstName(request.getParameter(FIRST_NAME).trim());
        order.setLastName(request.getParameter(LAST_NAME).trim());


        try {
        	 lock.writeLock().lock();


        	 productsDAO.saveOrder(order);
                response.sendRedirect("post?command=viewOrders&category=" + category + "&subCategory=" + subcategory+"&lastName=" + order.getLastName()+"&firstName=" + order.getFirstName());
            
        } catch (Exception e) {
            throw new LogicException(e);
        }
        finally {
        	lock.writeLock().unlock();
        }
        return null;
    }

}
