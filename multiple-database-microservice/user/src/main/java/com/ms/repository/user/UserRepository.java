package com.ms.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
