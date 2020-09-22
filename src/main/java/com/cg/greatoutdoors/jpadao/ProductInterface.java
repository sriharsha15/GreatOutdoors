package com.cg.greatoutdoors.jpadao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.greatoutdoors.entity.Product;

public interface ProductInterface extends JpaRepository<Product, Integer> {

}
