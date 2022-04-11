package com.testcontainertest.demo.service;

import com.testcontainertest.demo.DbTestBase;
import com.testcontainertest.demo.model.Dessert;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.AfterTransaction;

@Transactional
public class DessertServiceTest extends DbTestBase {

  @Inject
  private DessertService dessertService;

  @AfterTransaction
  void afterTransaction() {
    Assertions.assertTrue(dessertService.list().isEmpty(), "Eat your desserts");
  }

  @Test
  void whenAddDesert_thenShouldAddDesertToExistingOnes() {
    Dessert stroopwafel = new Dessert();
    stroopwafel.setName("Stroopwafel");

    dessertService.add(stroopwafel);

    Assertions.assertTrue(dessertService.list().contains(stroopwafel));
  }
}
