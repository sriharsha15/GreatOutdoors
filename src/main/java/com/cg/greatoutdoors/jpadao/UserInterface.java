package com.cg.greatoutdoors.jpadao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.greatoutdoors.entity.User;

public interface UserInterface extends JpaRepository<User, Integer> {

}
