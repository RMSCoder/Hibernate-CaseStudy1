package service_layer;

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

import com.jsp.hibernate.case_study_dao.ProductDAO;
import com.jsp.hibernate.case_study_entity.Product;

public class ProductServices {
	
	
	
	ProductDAO productDAO = new ProductDAO();
	
	

	public static  void addProduct() {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction trn = s.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the productname");
		String name = sc.nextLine();
		
		System.out.println("enter the Product Id");
		int id = sc.nextInt();
				
		System.out.println("enter the price");
		double price = sc.nextDouble();
		System.out.println("enter the Quantity");
		int quantity = sc.nextInt();

		Product p = new Product();
		p.setProductId(id);
		p.setProductName(name);
		p.setProductPrice(price);
		p.setProductQuantity(quantity);

//		ProductDAO productDAO = new ProductDAO();
//		String message = productDAO.addProduct(p);
//		System.out.println(message);
		
		s.save(p);
		trn.commit();
		s.close();
	}

	public static void getProductById() {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction trn = s.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the Id");
		int productId = sc.nextInt();
		Product p = s.get(Product.class,productId);
		if (p != null) {
			System.out.println("Product details:");
			System.out.println("Id: " + p.getProductId());
			System.out.println("Name: " + p.getProductName());
			System.out.println("Quantity: " + p.getProductQuantity());
		} else {
			System.out.println("Product not found with id: " + productId);

		}
		
		
		trn.commit();
		s.close();

	}
	public static void getAllProduct() {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		 Query<Product>query=s.createQuery(" from Product");
	    List<Product>lp=query.list();
	    for(Product p:lp) {
	 	   System.out.print(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getProductQuantity());
	 	   System.out.println();
	    }
	    ProductDAO productDAO = new ProductDAO();
		String message = productDAO.getallProducts();;
		System.out.println(message);
		
	    trn.commit();
		s.close();
	}
	public static void updateProduct() {
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		Scanner sc=new Scanner(System.in); 
		System.out.println("enter old id:");
		int oldid=sc.nextInt();
		System.out.println("enter new id:");
		int newid=sc.nextInt();
		
	CriteriaBuilder builder=s.getCriteriaBuilder();
   	 CriteriaUpdate<Product>criteriaquery=builder.createCriteriaUpdate(Product.class);
   	 Root<Product>root=criteriaquery.from(Product.class);
 	 criteriaquery.set(root.get("productId"),newid);
	 criteriaquery.where(builder.equal(root.get("productId"), oldid));
	 
   	 Query<Product>q=s.createQuery(criteriaquery);
   	 int i = q.executeUpdate();
   	 System.out.println(i+" records got updated");
   	 
   	 trn.commit();
		s.close();
	}
	
	public static void deleteProduct(){
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction trn=s.beginTransaction();
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter an id to delete");
		int id=sc.nextInt();
		
		CriteriaBuilder builder=s.getCriteriaBuilder();
	   	 CriteriaDelete<Product>criteriaquery=builder.createCriteriaDelete(Product.class);
	   	 Root<Product>root=criteriaquery.from(Product.class);	 	 
		 criteriaquery.where(builder.equal(root.get("productId"),id));
	   	 Query<Product>q=s.createQuery(criteriaquery);
	   	 
	   	 int i = q.executeUpdate();
	   	 System.out.println(i+" records got deleted");
	   	 
		 trn.commit();
			s.close();
	}
}
