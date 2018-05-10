package com.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;

import com.daoImpl.CategoryDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.daoImpl.SupplierDaoImpl;

import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;


@Configuration
@ComponentScan(basePackages={"com"})
@EnableTransactionManagement
public class HibernateConfig 
{
public static SessionFactory sessionfactory=null;
@Bean(name="datasource")
public DriverManagerDataSource datasource()
{
	DriverManagerDataSource dmds=new DriverManagerDataSource();
	dmds.setDriverClassName("org.h2.Driver");
	dmds.setUrl("jdbc:h2:tcp://localhost/~/shoesmart");
	dmds.setUsername("viraj");
	dmds.setPassword("");
	return dmds;
}


@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder ls=null;


	
	Properties hp=new Properties();
	hp.put("hibernate.temp.use_jdbc_metadata_defaults","false");
	hp.setProperty("hibernate.hbm2ddl.auto","update");
	//hp.setProperty("hibernate.hbm2ddl.auto","none");
	hp.put("hibernate.show_sql", "true");
	hp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	
	ls=new LocalSessionFactoryBuilder(datasource());
	ls.addProperties(hp);

	ls.addAnnotatedClass(Category.class);
	ls.addAnnotatedClass(Supplier.class);
	ls.addAnnotatedClass(Product.class);
	ls.addAnnotatedClass(User.class);
	
	
	sessionfactory=ls.buildSessionFactory();
	System.out.println("Session Factory Object Created");
	return sessionfactory;
	
	}


@Bean(name="gethibernatemanager")
public  HibernateTransactionManager gethibernatemanager(SessionFactory sf)
{
	HibernateTransactionManager htm=new HibernateTransactionManager();
	htm.setSessionFactory(sf);
	return htm;
	
	
}




}

