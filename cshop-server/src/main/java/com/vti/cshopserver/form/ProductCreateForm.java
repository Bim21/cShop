package com.vti.cshopserver.form;

import com.vti.cshopserver.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreateForm {
    private String name;
    private double price;
    private double salePrice;
    private String thumbnailUrl;
    private Product.Ram ram;
    private String description;
    private int categoryId;
}
