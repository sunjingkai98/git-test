package com.intouch.controller;

import com.intouch.domain.Category;
import com.intouch.service.CategoryService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    /*根据已知二级目录，查询子目录以及每个目录对应的图书数量*/
    @GetMapping("/{id}")
    public String showCurrentCategory(@PathVariable("id") int catId, Model model){
        //通过service组件查出二级目录及其子目录
       Category category =  service.selectCateAndRelatedByPrimaryKey(catId);
       //通过service组件查出二级目录总图书数量并传给前端
       model.addAttribute("amount",service.getCatCountsById(catId));
       //将查出的categroy二级目录对象传到前端
       model.addAttribute("category",category);
       return "CategoryShow";
    }




    /*已知父目录，查询二级目录及其子目录*/
    @GetMapping("/{id}/subcats")
    public String listCategories(@PathVariable("id") int parentId,Model model){
        List<Category> categoryList = service.selectAllCatesAndRelated(parentId);
        model.addAttribute("catList",categoryList);
        return "CategoryList";
    }
}
