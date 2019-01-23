package com.how2java.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by LXX on 2019/1/23.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception{
        categoryMapper.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c){
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c){
        categoryMapper.update(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String listCategory(int id, Model m){
        Category c = categoryMapper.get(id);
        m.addAttribute("c",c);
        return "editCategory";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m,
                               @RequestParam(value = "start",defaultValue = "0")int start,
                               @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start,size,"id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page",page);
        return "listCategory";
    }
}
