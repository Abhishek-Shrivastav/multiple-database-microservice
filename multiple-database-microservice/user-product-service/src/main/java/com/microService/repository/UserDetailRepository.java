package com.microService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microService.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {

}
