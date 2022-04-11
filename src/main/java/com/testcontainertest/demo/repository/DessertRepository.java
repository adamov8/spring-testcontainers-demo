package com.testcontainertest.demo.repository;

import com.testcontainertest.demo.model.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {

}
