package com.logcheck.logcheck.Repository;

import com.logcheck.logcheck.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductJpa extends JpaRepository<Product ,Integer> {
    List<Product> findByCategory(String category);
}
