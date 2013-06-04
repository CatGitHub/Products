package by.bsu.products.dao;

import by.bsu.products.exceptions.LogicException;
import by.bsu.products.form.Order;

public interface IProductsDAO {

	public void saveOrder(Order order) throws LogicException;
}
