package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntity {

    private String cartState;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Customer customer;
}
