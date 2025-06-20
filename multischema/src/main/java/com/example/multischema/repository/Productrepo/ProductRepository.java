package com.example.multischema.repository.Productrepo;

import com.example.multischema.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
