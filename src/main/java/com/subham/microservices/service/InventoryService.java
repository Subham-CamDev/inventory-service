package com.subham.microservices.service;

import com.subham.microservices.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

  private final InventoryRepository repository;

  public boolean isInStock(String skuCode) {
    log.info("Checking inventory for SKU: {}", skuCode);
    return repository.findBySkuCode(skuCode)
            .map( inventory -> inventory.getQuantity() > 0)
            .orElse(false);
  }
}
