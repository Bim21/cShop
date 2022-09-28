package com.vti.cshopserver.service;

import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.entity.Product;
import com.vti.cshopserver.form.*;
import com.vti.cshopserver.repository.ICategoryRepository;
import com.vti.cshopserver.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Product> findAll(Pageable pageable, ProductFilterForm form) {
        // TODO: 28/09/2022 thêm filter vào findAll 
        return null;
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(ProductCreateForm form) {
        repository.save(mapper.map(form, Product.class));
    }

    @Override
    public void update(ProductUpdateForm form) {
        repository.save(mapper.map(form, Product.class));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
