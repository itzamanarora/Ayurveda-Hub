package com.ayur.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ayur.Model.User_Cart;

public interface User_CartRepository extends JpaRepository<User_Cart, Long>{
	 User_Cart findByUserIdAndProductId(Long userId, Long productID);
	 int countByUserId(Long userId);
}
