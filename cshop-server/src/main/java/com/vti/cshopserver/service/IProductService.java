package com.vti.cshopserver.service;

import com.vti.cshopserver.entity.Product;
import com.vti.cshopserver.form.ProductCreateForm;
import com.vti.cshopserver.form.ProductFilterForm;
import com.vti.cshopserver.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, ProductFilterForm form);

    Product findById(int id);

    void create(ProductCreateForm form);

    void update(ProductUpdateForm form);

    void deleteById(int id);
}
