package com.vti.cshopserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {
    private int id;
    private String name;
    private double price;
    private double salePrice;
    private String description;
    private String ram;
    private String thumbnailUrl;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private CategoryDTO categories;
    
    @Getter
    @Setter
    @NoArgsConstructor
    public static class CategoryDTO {
        private int id;
        private String name;
        private LocalDate createdDate;
        private LocalDate updatedDate;
    }

}
