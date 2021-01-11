package com.thamil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String videoHomePage(Model model) {
        List<Product> prod = productService.listAll();
        model.addAttribute("listProduct", prod);
        return "index";
    }

    @RequestMapping("/new")
    public String showForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product)
    {
        productService.save(product);
        System.out.println(product);
        return "redirect:/";
    }
}
