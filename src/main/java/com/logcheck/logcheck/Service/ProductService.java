package com.logcheck.logcheck.Service;

import com.logcheck.logcheck.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByCategory(String category);

    List<Product> findAll();

}
