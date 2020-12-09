package com.intouch.controller;


import com.intouch.domain.Product;
import com.intouch.domain.ProductItem;
import com.intouch.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proItem")
public class ProductItemController {

    @Autowired
    private ProductItemService service;

    @GetMapping("/insert/{bId}")
    @ResponseBody
    public int[] addBook(@CookieValue("userId") Integer uId, @PathVariable("bId")Integer bId){
        //查询本类商品在数据库中是否已经存在
        ProductItem item = service.selectBookByBookId(uId,bId);
        if(item != null){//说明该商品已经存在，只需将数量+1
            int amount = service.selectBookAmountByBookId(uId,bId);
            int n = service.updateBookInfoByBookId(uId,bId,amount+1);
            int[] arr = {amount+1,n};
            return arr;
        }else{//说明商品不存在，增加一条记录
           int n = service.insertOneBookToItemByBookId(uId,bId);
            int amount = service.selectBookAmountByBookId(uId,bId);
            int[] arr = {amount,n};
            return arr;
        }
    }

    @GetMapping("/delete/{bId}")
    public String delBook(@CookieValue("userId") Integer uId, @PathVariable("bId")Integer bId, Model model){
        int n = service.deleteBookByBookId(uId,bId);
        if(n == 1){
            return "redirect:/item/showItem";
        }else{
            model.addAttribute("msg","删除失败!");
            return "redirect:/item/showItem";
        }
    }

    @GetMapping("/deletemany/{ids}")
    @ResponseBody
    public int delBooks(@CookieValue("userId") Integer uId, @PathVariable("ids") String ids){
        int n = service.deleteBooksByBookIdList(uId,ids);
        if(n >= 0){
            return 1;
        }else{
            return -1;
        }
    }

    @GetMapping("/update/{id}/{amount}")
    @ResponseBody
    public int updateBooksByBookid(@CookieValue("userId") Integer uId,@PathVariable("id") Integer id
                                    ,@PathVariable("amount")Integer amount){
        int n = service.updateBookInfoByBookId(uId,id,amount);
        if(n >= 0){
            return 1;
        }else{
            return -1;
        }
    }

}
