package com.jsp.hibernate.case_study_dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.case_study_entity.Cart;
import com.jsp.hibernate.case_study_entity.Product;

import service_layer.ProductServices;


public class ProductDAO{
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public String addProduct(Product product) {
		
         ProductServices ps=new ProductServices();
         
		return "Product successfully added";
	}

	public String getProductById(int productId) {
		
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		
		s.save(productId);
		trn.commit();
		s.close();
		
		return "Details of product fetched !";
		
	}

	public String getallProducts() {
		
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		
	    trn.commit();
		s.close();
		return "all products fetched successfully";
	}

	public String updateProduct() {
		
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		 trn.commit();
			s.close();
			return "product updated !!";
	}

	public String deleteProduct() {
		
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		 trn.commit();
			s.close();
			return "product deleted";
	}

}
