package com.testcontainertest.demo.service;

import com.testcontainertest.demo.model.Dessert;
import java.util.List;
import lombok.NonNull;

public interface DessertService {

  List<Dessert> list();

  void add(@NonNull Dessert dessert);
}
