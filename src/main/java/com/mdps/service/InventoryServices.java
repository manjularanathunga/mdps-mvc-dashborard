package com.mdps.service;

import com.mdps.model.dao.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryServices extends JpaRepository<Inventory, Long> {

}
