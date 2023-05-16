package com.wallace.userderpt.repositories;

import com.wallace.userderpt.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
