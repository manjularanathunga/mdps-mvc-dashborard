package com.mdps.service;

import com.mdps.model.dao.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingServices extends JpaRepository<Building, Long> {

}
