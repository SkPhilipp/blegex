package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}