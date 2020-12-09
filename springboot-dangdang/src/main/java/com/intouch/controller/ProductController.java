package com.intouch.controller;

import com.intouch.domain.Product;
import com.intouch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    private static final int pageSize = 5;//定义每页显示数据


    @GetMapping("/{id}/{pageId}")//前台传来二级目录id和页数，初始页数是1
    public String showCurrectPageProducts(@PathVariable("id") Integer id,@PathVariable("pageId") Integer pageId,
                                          Model model){
        //调用service组件中方法，查出详情图书信息
        List<Product> list = service.selectAllProductsByParentId(id,pageId,pageSize);
        //将图书信息集合传到前端
        model.addAttribute("productList",list);
        //计算出总页数
        int totalPage = service.totalPages(id,pageSize);
        //将总页数传到前端
        model.addAttribute("totalPage",new Integer(totalPage));
        //将当前页码id传到前端
        model.addAttribute("currectPage",pageId);
        //将当前二级目录id传到前端
        model.addAttribute("sId",id);
        return "CurrectPage";
    }

    @GetMapping("/related/{id}/{pageId}")//前台传来三级目录id和页数，初始页数是1
    public String showRelatedCurrectPageProducts(@PathVariable("id") Integer id,@PathVariable("pageId") Integer pageId,
                                          Model model){
        //调用service组件中方法，查出详情图书信息
        List<Product> list = service.selectAllProductsByRelatedId(id,pageId,pageSize);
        //将图书信息集合传到前端
        model.addAttribute("productList",list);
        //计算出总页数
        int totalPage = service.totalRelatedPages(id,pageSize);
        //将总页数传到前端
        model.addAttribute("totalPage",new Integer(totalPage));
        //将当前页码id传到前端
        model.addAttribute("currectPage",pageId);
        //将当前三级目录id传到前端
        model.addAttribute("sId",id);
        return "RelatedPage";
    }

    /*主页显示推荐图书 第二栏第一部分*/
    @GetMapping("/recommend")
    public String showRecommend(Model model){
        List<Product> list = service.selectProductsByPublishing("清华大学出版社");
        model.addAttribute("list",list);
        return "RecommendPage";
    }

    /*主页显示 销量前6图书 第二栏第二部分*/
    @GetMapping("/sales")
    public String showSales(Model model){
        List<Product> list = service.selectTopSalesBooks(6);
        model.addAttribute("list",list);
        return "SalesPage";
    }

    /*主页显示 最新出版的八本图书*/
    @GetMapping("newest")
    public String showNewest(Model model){
        List<Product> list = service.sellectNewestBooks(8);
        model.addAttribute("list",list);
        return "NewestPage";
    }
}
