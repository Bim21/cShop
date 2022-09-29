package com.vti.cshopserver.service;

import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.form.CategoryCreateForm;
import com.vti.cshopserver.form.CategoryFilterForm;
import com.vti.cshopserver.form.CategoryUpdateForm;
import com.vti.cshopserver.repository.ICategoryRepository;
import com.vti.cshopserver.specification.CategorySpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Category> findAll(Pageable pageable, CategoryFilterForm form) {
        // TODO: 28/09/2022 Thêm filter vào findAll
        return repository.findAll(CategorySpecification.buildWhere(form), pageable);
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(CategoryCreateForm form) {
        repository.save(mapper.map(form, Category.class));
    }

    @Override
    public void update(CategoryUpdateForm form) {
        repository.save(mapper.map(form, Category.class));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
