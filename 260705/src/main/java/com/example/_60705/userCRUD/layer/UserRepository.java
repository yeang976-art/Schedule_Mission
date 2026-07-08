package com.example._60705.userCRUD.layer;

import com.example._60705.userCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
