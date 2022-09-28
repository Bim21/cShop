package com.vti.cshopserver.repository;

import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
}
