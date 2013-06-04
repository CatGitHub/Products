/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.products.commands;


import by.bsu.products.constants.ParameterName;
import by.bsu.products.constants.PathName;
import by.bsu.products.exceptions.LogicException;
import by.bsu.products.util.xslt.StylesheetCache;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Katsiaryna_Homyakova
 */
public final class ViewProducts extends  AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, LogicException {
        String subcategory = request.getParameter(ParameterName.SUBCATEGORY);
        String category = request.getParameter(ParameterName.CATEGORY);
        PrintWriter out;
        try {
            out = response.getWriter();

            lock.readLock().lock();
            Source xmlSource = new StreamSource(PathName.PATH + PathName.XML_PRODUCTS);
            Transformer transformer = StylesheetCache.newTransformer(PathName.PATH + PathName.XSL_PRODUCTS);
            transformer.setParameter(ParameterName.NAME_SUBCATEGORY, subcategory);
            transformer.setParameter(ParameterName.NAME_CATEGORY, category);
            transformer.transform(xmlSource, new StreamResult(out));
         
        } catch (Exception e) {
            throw new LogicException(e);
        } finally {
            lock.readLock().unlock();
           
        }
        return null;
    }
}
