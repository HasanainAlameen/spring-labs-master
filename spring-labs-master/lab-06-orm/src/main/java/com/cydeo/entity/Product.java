package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @ManyToMany
    @JoinTable(name = "productCategoryRel",
    joinColumns = @JoinColumn(name = "p_id"),
    inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> category;


}
