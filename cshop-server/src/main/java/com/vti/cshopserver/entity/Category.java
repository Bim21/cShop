package com.vti.cshopserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "createdDate", nullable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "updatedDate", nullable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
