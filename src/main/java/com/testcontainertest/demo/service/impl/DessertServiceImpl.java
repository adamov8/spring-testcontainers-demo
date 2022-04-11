package com.testcontainertest.demo.service.impl;

import com.testcontainertest.demo.model.Dessert;
import com.testcontainertest.demo.repository.DessertRepository;
import com.testcontainertest.demo.service.DessertService;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DessertServiceImpl implements DessertService {

  private final @NonNull DessertRepository dessertRepository;

  @Override
  public List<Dessert> list() {
    return dessertRepository.findAll();
  }

  @Override
  @Transactional
  public void add(@NonNull Dessert dessert) {
    dessertRepository.save(dessert);
  }
}
