package com.vti.cshopserver.controller;

import com.vti.cshopserver.dto.CategoryDTO;
import com.vti.cshopserver.dto.ProductDTO;
import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.entity.Product;
import com.vti.cshopserver.form.*;
import com.vti.cshopserver.service.IProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    IProductService service;

    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable, ProductFilterForm form){
        Page<Product> page = service.findAll(pageable, form);
        List<ProductDTO> dtos = mapper.map(
                page.getContent(),
                new TypeToken<List<ProductDTO>>() {}.getType()

        );
        return new PageImpl<>(dtos,pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") int id){
        return mapper.map(service.findById(id), ProductDTO.class);
    }

    @PostMapping
    public void create(@RequestBody ProductCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody ProductUpdateForm form){
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }

}


