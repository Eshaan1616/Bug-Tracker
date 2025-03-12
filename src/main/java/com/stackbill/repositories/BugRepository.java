package com.stackbill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stackbill.entitys.BugEntity;
@Repository
public interface BugRepository extends  JpaRepository<BugEntity,Integer>  {

}
