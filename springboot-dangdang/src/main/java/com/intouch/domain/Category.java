package com.intouch.domain;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private Integer id;

    private Integer turn;

    private String enName;

    private String name;

    private String description;

    private Integer parentId;

    /*图书子目录所属图书总数量*/
    private Integer amount;

    /*定义关联属性 一对多 当前目录包含多个子目录*/
    private List<Category> subCats;

    /*定义关联属性 多对一  当前目录输入他的父目录*/
    private Category parent;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Category> getSubCats() {
        return subCats;
    }

    public void setSubCats(List<Category> subCats) {
        this.subCats = subCats;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}