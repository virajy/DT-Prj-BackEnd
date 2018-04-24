package com.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDetailsDao;
import com.config.HibernateConfig;
import com.model.UserDetails;

public class UserDetailsDaoImpl implements UserDetailsDao
{
	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional
	public boolean addUser(UserDetails ud) {
		try
		{
			/*HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();*/
			Session s=sessionfactory.openSession();
			s.beginTransaction();
			s.save(ud);
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
	public boolean deleteUser(UserDetails ud) 
	{
		try
		{
			HibernateConfig hc=new HibernateConfig();
			sessionfactory=hc.getSessionFactory();
			Session s=sessionfactory.openSession();
			s.beginTransaction();
			s.delete(ud);
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

	



}
