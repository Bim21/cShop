package com.vti.cshopserver.controller;

import com.vti.cshopserver.dto.CategoryDTO;
import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.form.CategoryCreateForm;
import com.vti.cshopserver.form.CategoryFilterForm;
import com.vti.cshopserver.form.CategoryUpdateForm;
import com.vti.cshopserver.repository.ICategoryRepository;
import com.vti.cshopserver.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private ICategoryService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<CategoryDTO> findAll(Pageable pageable, CategoryFilterForm form){
        Page<Category> page = service.findAll(pageable, form);
        List<CategoryDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<CategoryDTO>>() {}.getType()

        );
        return new PageImpl<>(dtos,pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") int id){
        return mapper.map(service.findById(id), CategoryDTO.class);
    }

    @PostMapping
    public void create(@RequestBody CategoryCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody CategoryUpdateForm form){
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }

}
