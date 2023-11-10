package com.jsp.hibernate.case_study_dao;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.case_study_entity.Cart;
import com.jsp.hibernate.case_study_entity.Product;

public class CartDAO {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Cart.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Scanner sc = new Scanner(System.in);

	public void createCart() {
		Session s = sf.openSession();
		Transaction trn = s.beginTransaction();
		System.out.println("enter a cartid");
		int cid = sc.nextInt();

		Cart c = new Cart();
		c.setCartid(cid);
		s.save(c);
		trn.commit();
		s.close();

	}

	public void addProductToCart(int productId,int cartId) {
		Session s = sf.openSession();
		Transaction trn = s.beginTransaction();
			Product product = s.get(Product.class, productId);
			Cart cart = s.get(Cart.class, cartId);
			
			cart.getLprod().add(product);
		  s.save(cart);
		trn.commit();
		s.close();
	}

	public void removeProductFromCart() {
		
		Session s = sf.openSession();
		Transaction trn = s.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an id to remove");
		int id = sc.nextInt();

		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaDelete<Cart> criteriaquery = builder.createCriteriaDelete(Cart.class);
		Root<Cart> root = criteriaquery.from(Cart.class);
		criteriaquery.where(builder.equal(root.get("cartid"), id));
		Query<Cart> q = s.createQuery(criteriaquery);

		int i = q.executeUpdate();
		System.out.println(i + " records got removed from cart");

		trn.commit();
		s.close();
	}

}
