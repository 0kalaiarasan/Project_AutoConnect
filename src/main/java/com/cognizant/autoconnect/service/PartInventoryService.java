package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.PartInventory;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.PartInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartInventoryService {

    private final PartInventoryRepository inventoryRepository;

    public PartInventory addInventory(PartInventory partInventory) {
        return inventoryRepository.save(partInventory);
    }

    public PartInventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part Inventory not found with id: " + id));
    }

    public List<PartInventory> getInventoryByLocation(Long locationId) {
        return inventoryRepository.findByLocationId(locationId);
    }

    public List<PartInventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public PartInventory updateInventory(Long id, PartInventory inventoryDetails) {
        PartInventory inventory = getInventoryById(id);
        inventory.setPartId(inventoryDetails.getPartId());
        inventory.setLocationId(inventoryDetails.getLocationId());
        inventory.setQuantityOnHand(inventoryDetails.getQuantityOnHand());
        inventory.setQuantityReserved(inventoryDetails.getQuantityReserved());
        inventory.setReorderPoint(inventoryDetails.getReorderPoint());
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        PartInventory inventory = getInventoryById(id);
        inventoryRepository.delete(inventory);
    }
}
