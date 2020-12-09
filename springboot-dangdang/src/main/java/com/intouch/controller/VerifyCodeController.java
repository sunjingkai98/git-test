package com.intouch.controller;

import com.intouch.util.ValidatacodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/code")
public class VerifyCodeController {

    @GetMapping("/showCode")
    public void showCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidatacodeUtil.showcodeImage(ValidatacodeUtil.getCode(),request,response);
    }

    @GetMapping("/verifyCode")
    @ResponseBody
    public Boolean verifyCode(@RequestParam("codeVal") String code, HttpServletRequest request){
        String code1 = (String) request.getSession().getAttribute("code");
        if(code1.equalsIgnoreCase(code)){
            return true;
        }
        return false;
    }
}
