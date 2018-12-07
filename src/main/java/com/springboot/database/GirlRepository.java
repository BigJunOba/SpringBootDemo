package com.springboot.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer> {

}
