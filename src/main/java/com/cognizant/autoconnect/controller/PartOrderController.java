package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.PartOrder;
import com.cognizant.autoconnect.service.PartOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/part-orders")
@RequiredArgsConstructor
public class PartOrderController {

    private final PartOrderService orderService;

    @PostMapping
    public ResponseEntity<PartOrder> createOrder(@RequestBody PartOrder order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartOrder> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<PartOrder>> getOrdersByVendor(@PathVariable Long vendorId) {
        return ResponseEntity.ok(orderService.getOrdersByVendor(vendorId));
    }

    @GetMapping
    public ResponseEntity<List<PartOrder>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartOrder> updateOrder(@PathVariable Long id, @RequestBody PartOrder order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
