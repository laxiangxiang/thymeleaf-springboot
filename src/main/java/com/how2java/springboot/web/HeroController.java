package com.how2java.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.pojo.Hero;
import com.how2java.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by LXX on 2019/1/23.
 */
@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

//    restful部分
    @GetMapping("/heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start",defaultValue = "0")int start,
                               @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start,size,"id desc");
        List<Hero> hs = heroService.list();
        System.out.println(hs.size());
//        5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        PageInfo<Hero> page = new PageInfo<>(hs,5);
        return page;
    }

    @GetMapping("/heroes/{id}")
    public Hero get(@PathVariable("id")int id){
        System.out.println(id);
        Hero hero = heroService.get(id);
        System.out.println(hero);
        return hero;
    }

    @PostMapping("/heroes")
    public String add(@RequestBody Hero hero){
        heroService.add(hero);
        return "success";
    }

    @DeleteMapping("/heroes/{id}")
    public String delete(Hero hero){
        heroService.delete(hero.getId());
        return "success";
    }

    @PutMapping("/heroes/{id}")
    public String update(@RequestBody Hero hero){
        heroService.update(hero);
        return "success";
    }

//    页面跳转部分
    @RequestMapping(value = "/listHero",method = RequestMethod.GET)
    public ModelAndView listHero(){
        ModelAndView mv = new ModelAndView("listHero");
        return mv;
    }

    @RequestMapping(value = "/editHero",method = RequestMethod.GET)
    public ModelAndView editHero(){
        ModelAndView mv = new ModelAndView("editHero");
        return mv;
    }
}
