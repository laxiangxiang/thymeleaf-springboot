package com.how2java.springboot.pojo;

/**
 * Created by LXX on 2019/1/23.
 */
public class Hero {
    private int id;

    private String name;
    private int hp;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Hero [id=" + id + ", name=" + name + ", hp=" + hp + "]";
    }
}
