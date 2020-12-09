<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <div id="left_head">分类浏览</div>

    <h3><a href="javascript:" param="${category.id}" id="title">${category.name}(${amount})</a></h3>
    <ul id="ul1">
        <c:forEach items="${category.subCats}" var="cat">
                   <li id="li1"><a href="javascript:" param="${cat.id}" id="cat" name="list">${cat.name}(${cat.amount})<a/></li>
        </c:forEach>
    </ul>
</div>




