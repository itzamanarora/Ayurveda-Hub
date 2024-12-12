package com.ayur.Service;

import com.ayur.Model.User_Cart;


public interface User_CartService {

	public User_Cart addToCart(User_Cart user_Cart);
	
	public User_Cart updateCartItem(User_Cart userCart);
	
	public User_Cart findByUserIdAndProductId(Long userId, Long productId);
	
	public Long getCartItemCount(Long userId);
}
