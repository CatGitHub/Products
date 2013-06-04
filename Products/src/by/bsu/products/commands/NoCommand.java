/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.products.commands;

import by.bsu.products.constants.PageName;
import by.bsu.products.exceptions.LogicException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public final class NoCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, LogicException {
    	
        String page = PageName.INDEX;
        return page;

    }
}
