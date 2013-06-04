package by.bsu.products.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsu.products.commandmap.RequestHelper;
import by.bsu.products.commands.AbstractCommand;
import by.bsu.products.constants.PageName;
import by.bsu.products.constants.PathName;
import by.bsu.products.exceptions.LogicException;

/**
 * Servlet implementation class ProductsServlet
 */
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    private RequestHelper requestHelper = RequestHelper.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page;
        try {

            AbstractCommand command = requestHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (LogicException ex) {
           
          //  ProductsLogger.getInstance(this.getClass())
          //          .writeError(ex.toString());
            page = PageName.ERR_PAGE;
        } catch (ServletException e) {
           
        //    ProductsLogger.getInstance(this.getClass())
        //            .writeError(e.toString());
            page = PageName.ERR_PAGE;
        }
        if (page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
            
            dispatcher.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	PathName.PATH=getServletContext().getRealPath(PathName.EMPTY_PATH);
    }
}
