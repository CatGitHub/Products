/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.products.commandmap;


import by.bsu.products.commands.AbstractCommand;

import by.bsu.products.commands.MakeOrder;
import by.bsu.products.commands.NoCommand;
import by.bsu.products.commands.ReturnCommand;

import by.bsu.products.commands.SaveOrder;
import by.bsu.products.commands.ViewCategory;
import by.bsu.products.commands.ViewOrders;
import by.bsu.products.commands.ViewProducts;
import by.bsu.products.commands.ViewSubCategory;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;


public final class RequestHelper {

    private final static RequestHelper instance = new RequestHelper();
    private HashMap<String, AbstractCommand> commands = new HashMap<String, AbstractCommand>();

    private RequestHelper() {
        commands.put("viewCategory", new ViewCategory());
        commands.put("viewSubCategory", new ViewSubCategory());
        commands.put("viewProducts", new ViewProducts());
     
        commands.put("return", new ReturnCommand());
        commands.put("makeOrder", new MakeOrder());
        commands.put("saveOrder", new SaveOrder());
        commands.put("viewOrders", new ViewOrders());
    }

    public static RequestHelper getInstance() {
        return instance;
    }

    public AbstractCommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        AbstractCommand command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }
}