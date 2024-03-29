package com.vti.cshopserver.form;

import com.vti.cshopserver.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProductFilterForm {
    private String search;
    private Integer categoryId;
    private Double minSalePrice;
    private Double maxSalePrice;
    private Product.Ram minRam;
    private Product.Ram maxRam;
    private Product.Ram ram;
    private Integer minYear;
    private Integer maxYear;
    private LocalDate minCreatedDate;
    private LocalDate maxCreatedDate;
}
