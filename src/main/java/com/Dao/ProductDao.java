package com.Dao;

import java.util.List;

import com.model.Category;
import com.model.Product;

public interface ProductDao 
{
public boolean addProduct(Product p);
public boolean deleteProduct(Product p);
public boolean updateProduct(Product p);
public void getProductById(Product p);
public List<Product> displayAll();
public List<Product> getproductbyCategory(Product p);
public List<Product> getproductbySupplier(Product p);
	


}
