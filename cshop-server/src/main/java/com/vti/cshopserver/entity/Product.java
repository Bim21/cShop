package com.vti.cshopserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "salePrice", nullable = false)
    private double salePrice;

    @Column(name = "thumbnailUrl", nullable = false)
    private String thumbnailUrl;

    @Column(name = "ram", length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Ram ram;

    @Column(name = "description", length = 1023, nullable = false)
    private String description;

    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "updatedDate", nullable = false, updatable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;
    public enum Ram {
        _8GB, _16GB, _32GB, _64GB, _128GB, _256GB
    }

}
