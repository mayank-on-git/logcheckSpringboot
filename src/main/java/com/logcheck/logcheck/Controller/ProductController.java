package com.logcheck.logcheck.Controller;

import com.logcheck.logcheck.Service.ProductService;
import com.logcheck.logcheck.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @QueryMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @QueryMapping
    public List<Product> findByCategory(@Argument String category){
        return productService.findByCategory(category);
    }
}
