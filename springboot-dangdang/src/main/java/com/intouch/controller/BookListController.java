package com.intouch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/book")
public class BookListController {

    /*根据点击二级目录超链接跳转到分类图书详情页*/
    @GetMapping("/{id}")
    public String showBookList(@PathVariable("id") int catId, Model model){
        model.addAttribute("catId",catId);
        return "BookList";
    }

}
