package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.Privilege;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{

}
