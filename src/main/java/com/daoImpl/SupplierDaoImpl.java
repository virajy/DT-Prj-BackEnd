package com.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.Dao.SupplierDao;
import com.config.HibernateConfig;
import com.model.Product;
import com.model.Supplier;

public class SupplierDaoImpl implements SupplierDao
{
@Autowired
SessionFactory sessionfactory;

	@Transactional
	public boolean addSupplier(Supplier s)
	{
		try
		{
			HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();
			Session s1=sessionfactory.openSession();
			s1.beginTransaction();
			s1.save(s);
			s1.getTransaction().commit();
			s1.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Transactional
	public boolean deleteSupplier(Supplier s) 
	{
		try
		{
			
			HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();
			Session s1=sessionfactory.openSession();
			s1.beginTransaction();
			s1.delete(s);;
			s1.getTransaction().commit();
			s1.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Transactional
	public boolean updateSupplier(Supplier s) 
	{
		try
		{
			
			HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();
			Session s1=sessionfactory.openSession();
			s1.beginTransaction();
			s1.update(s);;;
			s1.getTransaction().commit();
			s1.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	public void getSupplier(Supplier s)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		int a=sc.nextInt();
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s1=sessionfactory.openSession();
		Query q=s1.createQuery("from com.model.Supplier p where p.p_id= :id");
		q.setParameter("id", a);
		List<Supplier> product=q.list();
		for (Supplier supplier : product) 
		{
			System.out.println(supplier.getS_email());
			System.out.println(supplier.getS_name());
			System.out.println(supplier.getS_phone());
			System.out.println(supplier.getS_pincode());
			System.out.println(supplier.getS_stateid());
		}
		
	}

	public  List<Supplier> displayAll() 
	{
		try
		{
		HibernateConfig hc=new HibernateConfig();
		sessionfactory=hc.getSessionFactory();
		Session s1=sessionfactory.openSession();
		List<Supplier> su=s1.createQuery("from com.model.Supplier").list();
		return su;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
