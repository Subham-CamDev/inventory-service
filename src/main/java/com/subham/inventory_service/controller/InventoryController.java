package com.subham.inventory_service.controller;

import com.subham.inventory_service.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService service;

  @Operation(description = "Check if a product is in stock by providing the SKU code as a query parameter.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Inventory check successful, returns true if in stock, false otherwise"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping("/check")
  public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode) {
    try {
      boolean inStock = service.isInStock(skuCode);
      log.info("Inventory check for SKU: {}, In Stock: {}", skuCode, inStock);
      return ResponseEntity.ok(inStock);
    } catch (Exception e) {
      log.error("Exception occurred while checking inventory for SKU: {}", skuCode, e);
      return ResponseEntity.internalServerError().body(false);
    }
  }
}
