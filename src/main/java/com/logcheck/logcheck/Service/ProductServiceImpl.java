package com.logcheck.logcheck.Service;
import com.logcheck.logcheck.LogcheckApplication;
import com.logcheck.logcheck.Repository.ProductJpa;
import com.logcheck.logcheck.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService  {

    @Autowired
    ProductJpa  productJpa;
    @Override
    public List<Product> findByCategory(String category) {
        return productJpa.findByCategory(category);

    }

    @Override
    public List<Product> findAll() {
        return productJpa.findAll();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LogcheckApplication.class, args);
        // Correct: get Spring-managed bean with autowired dependencies
        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);
        List<Product> all = productService.findAll();
        System.out.println("Products found: " + all);
        List<Product> byCategory = productService.findByCategory("Personal Care");
        System.out.println("byCategory found: " + byCategory);
    };
}
