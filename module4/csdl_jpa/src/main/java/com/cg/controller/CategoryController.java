package com.cg.controller;

import com.cg.model.Category;
import com.cg.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cp/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping()
    public String showList(Model model){
        model.addAttribute("categories" ,categoryService.findAll());
        return "cp/category/list";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "cp/category/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Category category, Model model){
        categoryService.save(category);
        model.addAttribute("success", true);
        model.addAttribute("message", "Thêm sản phẩm thành công");
        model.addAttribute("category", new Category());
        return "cp/category/create";
    }

}
