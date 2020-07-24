package com.bawei.repository;

import com.bawei.entity.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.PrivateKey;

public interface DepartRepository extends JpaRepository<Depart,Integer> {

}
