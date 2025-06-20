package com.example.multischema.repository.userrepo;

import com.example.multischema.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}