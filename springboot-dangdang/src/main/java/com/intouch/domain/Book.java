package com.intouch.domain;


import java.io.Serializable;

public class Book implements Serializable {
    private Integer id;

    private String author;

    private String publishing;

    private Long publishTime;

    private String wordNumber;

    private String whichEdtion;

    private String totalPage;

    private Integer printTime;

    private String printNumber;

    private String isbn;

    //某图书销量
    private Integer sales;

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing == null ? null : publishing.trim();
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(String wordNumber) {
        this.wordNumber = wordNumber == null ? null : wordNumber.trim();
    }

    public String getWhichEdtion() {
        return whichEdtion;
    }

    public void setWhichEdtion(String whichEdtion) {
        this.whichEdtion = whichEdtion == null ? null : whichEdtion.trim();
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage == null ? null : totalPage.trim();
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    public String getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(String printNumber) {
        this.printNumber = printNumber == null ? null : printNumber.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }
}