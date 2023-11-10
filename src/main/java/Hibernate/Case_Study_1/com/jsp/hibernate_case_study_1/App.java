package Hibernate.Case_Study_1.com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import com.jsp.hibernate.case_study_dao.CartDAO;
import com.jsp.hibernate.case_study_dao.ProductDAO;

import service_layer.CartServices;
import service_layer.ProductServices;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ProductDAO p = new ProductDAO();
//		-------------------------------------------
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose any Number from 1-5 to perform a function");
		System.out.println("------------------------------------------------");
		System.out.println("->1:addProduct()\n2:getProductById()\n3:getAllProduct()\n4:updateProduct()\n5:deleteProduct()");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
		ProductServices.addProduct();
			break;
		case 2:
			ProductServices.getProductById();
			break;
		case 3:
			ProductServices.getAllProduct();;
			break;
		case 4:
			ProductServices.updateProduct();
			break;
		case 5:
			ProductServices.deleteProduct();
		default:
			if(choice<1||choice>5) {
			System.out.println("Invalid choice, please enter a number from 1-5 ");
			}
//			-----------------------------------------------------
		}
////		CartDAO cd=new CartDAO();
////		cd.createCart();
////		cd.addProductToCart();
////		cd.removeProductFromCart();
//		CartServices cs=new CartServices();
//		cs.addProductToCart();
		
		
	}
}
