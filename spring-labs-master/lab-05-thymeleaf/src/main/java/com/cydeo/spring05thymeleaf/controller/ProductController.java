package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String retrieveList(Model model){

        //I need list of product so that I can come up with the logic of showing
        //No Product yet? or Product list.

        model.addAttribute("productList", productService.listProduct());


        return "/product/list";
    }

    //navigate the create-form endpoint when user clicks Create Product Button
    //return create-product page
    //update the html to get the information form browser (end user)
    //update controller and print info on the console.
    //navigate back to list endpoint


    @GetMapping("/create-form")
    public String getCreatForm(Model model){


        model.addAttribute("product", new Product());

        //model.addAttribute("product", productService.listProduct());

        return "/product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product){

       productService.productCreate(product);

        return "redirect:/list";
    }



}
