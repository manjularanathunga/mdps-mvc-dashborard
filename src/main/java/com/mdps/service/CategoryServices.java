package com.mdps.service;

import com.mdps.model.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryServices extends JpaRepository<Category, Long> {

}
