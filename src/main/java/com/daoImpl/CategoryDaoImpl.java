package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDao;
import com.config.HibernateConfig;
import com.model.Category;
import com.model.Product;

public class CategoryDaoImpl implements CategoryDao
{
@Autowired
SessionFactory sessionfactory;

@Transactional
public boolean addCategory(Category c) 
{
	try
	{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.save(c);
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
public boolean deleteCategory(Category c)
{
	try
	{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.delete(c);;
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
public boolean updateCategory(Category c) 
{
	
	try
	{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.update(c);;
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

public List<Category> displayAll(Category c) 
{
	try
	{
	HibernateConfig hc=new HibernateConfig();
	sessionfactory=hc.getSessionFactory();
	Session s=sessionfactory.openSession();
	List<Category> l=s.createQuery("from com.model.Category").list();
	for (Category c1 : l)
	{
		System.out.println("Category Id:"+c1.getC_id());
		System.out.println("Category name:"+c1.getC_name());
		System.out.println("Category Discription:"+c1.getC_discription());
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
