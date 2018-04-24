package com.niit.backendproject.backend;

import java.util.HashSet;
import java.util.Set;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDetailsDao;
import com.daoImpl.CategoryDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.daoImpl.SupplierDaoImpl;
import com.daoImpl.UserDetailsDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.UserDetails;


public class App 
{

	
    public static void main( String[] args )
    {
Supplier s=new Supplier();
SupplierDaoImpl sdi=new SupplierDaoImpl();
sdi.displayAll();

    	
    	
    	
    	
    }
    	
    
}
