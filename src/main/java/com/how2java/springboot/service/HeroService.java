package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Hero;

import java.util.List;

/**
 * Created by LXX on 2019/1/23.
 */
public interface HeroService {
    int add(Hero hero);

    void delete(int id);

    Hero get(int id);

    int update(Hero hero);

    List<Hero> list();
}
