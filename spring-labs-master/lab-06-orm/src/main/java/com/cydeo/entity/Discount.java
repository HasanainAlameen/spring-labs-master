package com.cydeo.entity;

import com.cydeo.enums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;


}
