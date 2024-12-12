package com.ayur.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayur.Model.User_Cart;
import com.ayur.Repository.User_CartRepository;
import com.ayur.Service.User_CartService;

@Service
public class User_CartServiceImpl implements User_CartService{

	@Autowired
	private User_CartRepository user_CartRepository;

	@Override
	public User_Cart addToCart(User_Cart user_Cart) {
		// TODO Auto-generated method stub
		return user_CartRepository.save(user_Cart);
	}

	@Override
	public User_Cart updateCartItem(User_Cart userCart) {
		// TODO Auto-generated method stub
		return user_CartRepository.save(userCart);
	}

	@Override
	public User_Cart findByUserIdAndProductId(Long userId, Long productId) {
		// TODO Auto-generated method stub
		return user_CartRepository.findByUserIdAndProductId(userId, productId);
	}

	@Override
	public Long getCartItemCount(Long userId) {
		// TODO Auto-generated method stub
		return (long) user_CartRepository.countByUserId(userId);
	}



}
