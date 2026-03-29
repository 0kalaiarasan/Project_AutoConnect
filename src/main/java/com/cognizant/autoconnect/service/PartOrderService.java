package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.PartOrder;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PartOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartOrderService {

    private final PartOrderRepository orderRepository;

    public PartOrder createOrder(PartOrder order) {
        return orderRepository.save(order);
    }

    public PartOrder getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part Order not found with id: " + id));
    }

    public List<PartOrder> getOrdersByVendor(Long vendorId) {
        return orderRepository.findByVendorId(vendorId);
    }

    public List<PartOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public PartOrder updateOrder(Long id, PartOrder orderDetails) {
        PartOrder order = getOrderById(id);
        order.setVendorId(orderDetails.getVendorId());
        order.setItemsJson(orderDetails.getItemsJson());
        order.setExpectedAt(orderDetails.getExpectedAt());
        order.setReceivedAt(orderDetails.getReceivedAt());
        order.setStatus(orderDetails.getStatus());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        PartOrder order = getOrderById(id);
        orderRepository.delete(order);
    }
}
