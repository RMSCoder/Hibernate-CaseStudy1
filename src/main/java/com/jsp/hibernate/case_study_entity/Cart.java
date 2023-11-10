package com.jsp.hibernate.case_study_entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
private int cartid;
@OneToMany
private List<Product>lprod;
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public List<Product> getLprod() {
	return lprod;
}
public void setLprod(List<Product> lprod) {
	this.lprod = lprod;
}
@Override
public String toString() {
	return "Cart [cartid=" + cartid + ", lprod=" + lprod + "]";
}

}
