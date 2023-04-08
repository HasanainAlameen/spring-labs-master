package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Cart cart;

    @OneToOne
    private Payment payment;


}
