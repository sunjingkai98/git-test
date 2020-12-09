package com.intouch.controller;

import com.intouch.domain.Product;
import com.intouch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.intouch.domain.User;

import java.util.List;

@Controller
@RequestMapping("/item")
public class UserItemController {

    @Autowired
    ProductService service;

    @GetMapping("/showItem")
    public String showUserItem(Model model,@CookieValue("userId") Integer id){
        //拿到登陆用户的购物车信息 存放在user对象中
       List<Product> list = service.selectBooksAccordingToUser(id);
        model.addAttribute("list",list);
        return "UserItem";
    }
}
