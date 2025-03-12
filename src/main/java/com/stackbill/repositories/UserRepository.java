package com.stackbill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackbill.entitys.UserEntity;
@Repository
public interface UserRepository extends  JpaRepository<UserEntity,Integer>  {

    @Query("SELECT user FROM UserEntity user WHERE user.username = :username")
    UserEntity getUserDetails(String username);

}

