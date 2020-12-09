<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="middle1_big">
    <div id="middle1_head"><span>推荐图书</span><span style="float: right"><a href="#" id="middle1_head_a">更多>></a></span></div>
    <c:forEach items="${list}" var="pro">
        <div id="middle1_text">
            <img src="${pageContext.request.contextPath}/images/${pro.productPic}"
                 height="100px" width="70px" align="left" style="margin:10px" id="img"/>
            <div style="height: 99%;width: 100%;">
                <div style="font-size: 20px;font-family: Consolas;margin-bottom: 5px"><a href="#" id="proName">${pro.productName}</a></div>
                <div style="font-size: 15px">&nbsp;&nbsp;&nbsp;顾客评分:100</br>
                <c:forEach items="${pro.books}" var="book">
                     &nbsp;&nbsp;作者: ${book.author}</br>
                            &nbsp;&nbsp;出版社:${book.publishing}&nbsp; 出版时间:
                        <span id="time">
                            <jsp:useBean id="myDate" class="java.util.Date"/>
                            <c:set target="${myDate}" property="time" value="${book.publishTime}"/>
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${myDate}" type="both"/>
                        </span>
                </div>
                </c:forEach>
                <div style="font-size: 10px;padding-left: 20px;margin-top: 5px">${pro.description}</div>
                <div style="width: 100%;height: 10%;margin-right:10px; ">  <%--底部--%>
                    <span style="text-decoration: line-through;">原价:${pro.fixedPrice}</span> &nbsp;现价:${pro.dangPrice}
                    </hr>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

