package com.testcontainertest.demo.repository;

import com.testcontainertest.demo.DbTestBase;
import com.testcontainertest.demo.model.Dessert;
import java.util.List;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.AfterTransaction;

@Transactional
public class DessertRepositoryTest extends DbTestBase {

  private static List<Dessert> desserts;

  @Inject
  private DessertRepository dessertRepository;

  @BeforeAll
  static void beforeAll() {
    Dessert cheeseCake = new Dessert();
    cheeseCake.setName("Strawberry cheese cake");
    Dessert glazedDonut = new Dessert();
    glazedDonut.setName("Glazed donut");

    desserts = List.of(cheeseCake, glazedDonut);
  }

  @BeforeEach
  void setUp() {
    dessertRepository.saveAll(desserts);
  }

  @AfterTransaction
  void afterTransaction() {
    Assertions.assertEquals(dessertRepository.count(), 0, "Eat your desserts");
  }

  @Test
  void whenFindAllDesserts_thenShouldReturnDesertsInDb() {
    Assertions.assertIterableEquals(desserts, dessertRepository.findAll());
  }

  @Test
  void whenAddNewDessert_thenDessertsInRepoShouldContainNewDessert() {
    Dessert caramelMuffin = new Dessert();
    caramelMuffin.setName("Caramel muffin");
    Supplier<Boolean> gotMuffin = () -> dessertRepository.findAll().contains(caramelMuffin);

    Assertions.assertFalse(gotMuffin.get());

    dessertRepository.save(caramelMuffin);

    Assertions.assertTrue(gotMuffin.get());
  }
}
