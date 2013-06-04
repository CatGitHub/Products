////package by.bsu.products.commands;
//
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.transform.Source;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.transform.stream.StreamSource;
//
//import by.bsu.products.constants.ParameterName;
//import by.bsu.products.constants.PathName;
//import by.bsu.products.exceptions.LogicException;
//import by.bsu.products.form.ProductsForm;
//import by.bsu.products.util.xslt.StylesheetCache;
//
//public final class Login extends AbstractCommand {
//
//
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, LogicException {
//
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//      //  String subcategory = request.getParameter(ParameterName.SUBCATEGORY);
//       // String category = request.getParameter(ParameterName.CATEGORY);
//      
//      
//        PrintWriter out;
//        try {
//            out = response.getWriter();
//            String ctx = request.getSession().getServletContext().getRealPath(PathName.EMPTY_PATH);
//          
//            //  ctx = ctx.replace("\\build", "");
//            lock.readLock().lock();
//            Source xmlSource = new StreamSource(ctx + PathName.XML_PRODUCTS);
//            Transformer transformer = StylesheetCache.newTransformer(ctx + PathName.XSL_ADD_PRODUCTS);
//           // transformer.setParameter(ParameterName.NAME_SUBCATEGORY, subcategory);
//          //  transformer.setParameter(ParameterName.NAME_CATEGORY, category);
//           // transformer.setParameter(ParameterName.PRODUCT, product);
//            transformer.transform(xmlSource, new StreamResult(out));
//
//        } catch (Exception e) {
//            throw new LogicException(e);
//        } finally {
//             lock.readLock().unlock();
//        }
//        return null;
//    }
//
//}
