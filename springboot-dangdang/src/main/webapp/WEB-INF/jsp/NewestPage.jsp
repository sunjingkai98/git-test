<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="middle1_middle1">
    <div id="middle1_head1">最新上架图书 <span style="float: right"><a href="#" id="middle1_head_a">更多>></a></span></div>


    <c:forEach items="${list}" var="pro">
        <div id="middle1_text2">
            <br>
            <img src="${pageContext.request.contextPath}/images/${pro.productPic}"
                 height="90px" width="60px"id="img" /></br>
            <a href="#" id="proName" style="font-size: 14px">${pro.productName}</a></br>
            <div style="font-size: 9px">
                <span style="text-decoration: line-through;">原价: ${pro.fixedPrice}</span></br>
                现价: ${pro.dangPrice}</div>
        </div>
    </c:forEach>

</div>