package com.tts.TechTalentEcommerce1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.TechTalentEcommerce1.model.Product;
import com.tts.TechTalentEcommerce1.service.ProductService;

@Controller
public class ProductController {
    @Autowired
   private ProductService productService;

    @GetMapping("/product/{id}")
    public String show(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "product";
    }

    

    @GetMapping("/product")
    public String getproduct(Model model) {
    	List<Product> product = new ArrayList<>();  
    	product = productService.findAll();
    	 model.addAttribute("p",product);// As we have given a new name, so we had to write"p",product/ it can be written as (product) as well.
    	 // in html it will ${p.name}as the new variable is already named as "p".
        return "product";
    }
    
    
    
    // TODO: Either implement admin controls or remove these methods.

    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public String createOrUpdate(@Valid Product product) {
        productService.save(product);
        return "redirect:/product/" + product.getId();
    }
}

