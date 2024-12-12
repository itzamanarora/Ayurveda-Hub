package com.ayur.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_cart")
public class User_Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartid;
	
	@Column(name = "userid")
	private Long  userId;
	
	@Column(name = "Producttype")
	private String productType;
	
	@Column(name = "productid")
	private Long  productId;
	
	@Column(name = "quantity")
	private int Quantity;

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProducttype() {
		return productType;
	}

	public void setProducttype(String producttype) {
		productType = producttype;
	}

	public Long getProductID() {
		return productId;
	}

	public void setProductID(Long productID) {
		this.productId = productID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public User_Cart(Long cartid, Long userId, String producttype, Long productID, int quantity) {
		super();
		this.cartid = cartid;
		this.userId = userId;
		productType = producttype;
		this.productId = productID;
		Quantity = quantity;
	}

	public User_Cart() {
		super();
	}

	
}
