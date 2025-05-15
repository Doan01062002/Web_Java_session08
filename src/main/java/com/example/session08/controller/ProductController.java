package com.example.session08.controller;

import com.example.session08.model.Product;
import com.example.session08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("list", service.getAll());
        return "home";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        service.save(product);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("id") int id, Model model){
        model.addAttribute("product", service.getById(id));
        return "product-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        service.update(product);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") int id, Model model){
        model.addAttribute("product", service.getById(id));
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        model.addAttribute("list", service.search(name));
        return "home";
    }
}
