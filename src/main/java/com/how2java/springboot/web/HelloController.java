package com.how2java.springboot.web;
import com.how2java.springboot.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
 
    @RequestMapping("/hello")
    public String hello(Model m) {
    	m.addAttribute("name", "thymeleaf");
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model model){
        String htmlContent = "<p style='color:red'>红色文字</p>";
        Product product = new Product(5,"product e",200);
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(product);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));
        model.addAttribute("ps", ps);
        model.addAttribute("name","thymeleaf");
        model.addAttribute("htmlContent",htmlContent);
        model.addAttribute("currentProduct",product);
        model.addAttribute("testBoolean",true);
        model.addAttribute("now",new Date());
        return "test";
    }
}