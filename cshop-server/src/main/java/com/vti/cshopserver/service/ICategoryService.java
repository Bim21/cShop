package com.vti.cshopserver.service;

import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.form.CategoryCreateForm;
import com.vti.cshopserver.form.CategoryFilterForm;
import com.vti.cshopserver.form.CategoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable, CategoryFilterForm form);

    Category findById(int id);

    void create(CategoryCreateForm form);

    void update(CategoryUpdateForm form);

    void deleteById(int id);
}
