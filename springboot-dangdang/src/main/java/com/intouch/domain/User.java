package com.intouch.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer id;

    @NotBlank(message = "邮箱不能为空!")
    @Email(message = "用户邮箱格式不正确，重新填写!")
    private String email;

    private String nickname;

    @NotBlank(message = "密码不能为空!")
    @Length(max = 18,min = 6,message = "密码长度必须在6-18位之间!")
    private String password;

    private Integer userIntegral;

    private String isEmailVerify;

    private String emailVerifyCode;

    private Long lastLoginTime;

    private String lastLoginIp;

    //关联属性 当前用户的购物车信息
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getIsEmailVerify() {
        return isEmailVerify;
    }

    public void setIsEmailVerify(String isEmailVerify) {
        this.isEmailVerify = isEmailVerify == null ? null : isEmailVerify.trim();
    }

    public String getEmailVerifyCode() {
        return emailVerifyCode;
    }

    public void setEmailVerifyCode(String emailVerifyCode) {
        this.emailVerifyCode = emailVerifyCode == null ? null : emailVerifyCode.trim();
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }
}