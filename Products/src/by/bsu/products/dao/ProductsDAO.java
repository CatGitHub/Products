package by.bsu.products.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import by.bsu.products.constants.ParameterName;
import by.bsu.products.constants.PathName;
import by.bsu.products.exceptions.LogicException;
import by.bsu.products.form.Order;
import by.bsu.products.util.xslt.StylesheetCache;

public final class ProductsDAO implements IProductsDAO {

	private ProductsDAO() {

	}

	private final static ProductsDAO instance = new ProductsDAO();

	public static ProductsDAO getInstance() {
		return instance;
	}

	@Override
	public void saveOrder(Order order) throws LogicException {
		try {
			StringWriter out;
			File xmlFile;
			// long xmlLastModified;
			Transformer transformer;

			out = new StringWriter();

			xmlFile = new File(PathName.PATH + PathName.XML_ORDER);

			Source xmlSource = new StreamSource(PathName.PATH
					+ PathName.XML_ORDER);
			transformer = StylesheetCache.newTransformer(PathName.PATH
					+ PathName.XSL_SAVE_ORDER);

			transformer.setParameter("order", order);

			transformer.transform(xmlSource, new StreamResult(out));

			FileWriter fw = new FileWriter(xmlFile);
			fw.write(out.toString());
			fw.close();
		} catch (Exception e) {

			throw new LogicException(e);
		}

	}

}
