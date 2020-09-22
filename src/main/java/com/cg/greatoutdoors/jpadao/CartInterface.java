package com.cg.greatoutdoors.jpadao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.greatoutdoors.entity.Cart;

public interface CartInterface extends JpaRepository<Cart, Long> {

}
