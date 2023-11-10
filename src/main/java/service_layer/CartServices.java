package service_layer;

import java.util.Scanner;

import com.jsp.hibernate.case_study_dao.CartDAO;

public class CartServices {
	
	CartDAO cartDao;
	
	public void addProductToCart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the productId");
		int productId = sc.nextInt();
		
		System.out.println("Enter the productId");
		int cartId = sc.nextInt();
		
		cartDao.addProductToCart(productId, cartId);
	}

}
