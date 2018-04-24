package com.niit.backendproject.backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.model.*;
import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.config.HibernateConfig;
import com.daoImpl.CategoryDaoImpl;

public class ProductTest 
{
	//private static Hibernateconfig hc;
	
	private static ProductDao Productdao;
	private static CategoryDao Categorydao;
	private static SupplierDao Supplierdao;

	
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext();
		acac.scan("com.niit");
		acac.refresh();
		Productdao=(ProductDao)acac.getBean("getproductdao");
		Categorydao=(CategoryDao)acac.getBean("getcategorydao");
		Supplierdao=(SupplierDao)acac.getBean("getsupplierdao");
		
	}
	@Test
	public void addproducttestcase()
	{
		Category c=new Category();
		c.setC_id(102);
		c.setC_name("asc");
		c.setC_discription("sca");
		org.junit.Assert.assertTrue("test success",Categorydao.addCategory(c));
		Supplier s=new Supplier();
		s.setS_id(111);
		s.setS_email("fgsg");
		s.setS_name("rfgr");
		s.setS_phone("12345");
		s.setS_pincode(400101);
		s.setS_stateid(12);
		org.junit.Assert.assertTrue("test success",Supplierdao.addSupplier(s));
		Product p =new Product();
		p.setP_id(5);
		p.setP_brand("adidas");
		p.setP_discription("running");
		p.setP_quantity(2);
		p.setP_id(2000);
		Category c1=new Category();
		c1.setC_id(102);
		Supplier s1=new Supplier();
		s1.setS_id(111);
		org.junit.Assert.assertTrue("test success",Productdao.addProduct(p));
	
		
	}
	

}
