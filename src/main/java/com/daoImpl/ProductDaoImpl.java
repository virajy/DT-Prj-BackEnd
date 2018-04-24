package com.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.config.HibernateConfig;
import com.model.Category;
import com.model.Product;

public  class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionfactory;

	@Transactional
	public boolean addProduct(Product p) 
	{
		try
		{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		
	}

	@Transactional
	public boolean deleteProduct(Product p) {
	try{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.delete(p);;
		s.getTransaction().commit();
		s.close();
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
	}

	@Transactional
	public boolean updateProduct(Product p) 
	{
		try
		{
			HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();
			Session s=sessionfactory.openSession();
			s.beginTransaction();
			s.update(p);;
			s.getTransaction().commit();
			s.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	public List<Product> displayAll() 
	{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		List<Product> l=s.createQuery("from com.model.Product").list();
		for (Product product : l) 
		{
			System.out.println("Product Id:"+product.getP_id());
			System.out.println("Product Brand:"+product.getP_brand());
			System.out.println("Product Price:"+product.getP_price());
			System.out.println("Product Discription:"+product.getP_discription());
			System.out.println("Product Quantity:"+product.getP_quantity());
			System.out.println("Category Id:"+product.getCategory().getC_id());
			System.out.println("Supplier Id:"+product.getSupplier().getS_id());
			System.out.println();
		}
		s.close();
		return l;
	}
//get product by id return product object
	public void getProductById(Product p)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		int a=sc.nextInt();
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
	Query q=s.createQuery("from com.model.Product p where p.p_id= :id");
	q.setParameter("id", a);
	List<Product> product=q.list();
	for (Product product2 : product) 
	{
		System.out.println(product2.getP_brand());
		System.out.println(product2.getP_discription());
		System.out.println(product2.getP_price());
		System.out.println(product2.getP_quantity());
		System.out.println(product2.getCategory().getC_id());
		System.out.println(product2.getSupplier().getS_id());
		
	}
		
	}

	public List<Product> getproductbyCategory(Product p) 
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter category id");
		int a=sc.nextInt();
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		Query q=s.createQuery("from com.model.Product p where category.c_id= :id");
		q.setParameter("id", a);
		List<Product> l=q.list();
		for (Product product : l) 
		{
			System.out.println("Producd id:"+product.getP_id());
			System.out.println("Product Brand:"+product.getP_brand());
			System.out.println("Product Discription:"+product.getP_discription());
			System.out.println("Product Quantity:"+product.getP_quantity());
			System.out.println("Product Price:"+product.getP_price());
			System.out.println("Supplier Id:"+product.getSupplier().getS_id());
		}
		return l;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}

	public List<Product> getproductbySupplier(Product p) 
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter supplier id");
		int a=sc.nextInt();
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		Query q=s.createQuery("from com.model.Product p where supplier.s_id= :id");
		q.setParameter("id", a);
		List<Product> l=q.list();
		for (Product product : l) 
		{
			System.out.println("Producd id:"+product.getP_id());
			System.out.println("Product Brand:"+product.getP_brand());
			System.out.println("Product Discription:"+product.getP_discription());
			System.out.println("Product Quantity:"+product.getP_quantity());
			System.out.println("Product Price:"+product.getP_price());
			System.out.println("Category Id:"+product.getCategory().getC_id());
		}
		return l;
		}
		
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}

	
	

	

	

}
