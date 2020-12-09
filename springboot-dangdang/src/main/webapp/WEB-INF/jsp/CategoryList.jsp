<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="left_info">
    <div id="left_head">分类浏览</div>

    <c:forEach var="cat" items="${catList}">
        <div id="left_middle">
        <h3><a href="/book/${cat.id}" id="lista">[${cat.name}]</a></h3>
        <ul>
            <c:forEach var="subCats" items="${cat.subCats}">
                <li id="li"><a href="/book/${cat.id}" id="list_a">${subCats.name}</a>|</li>
            </c:forEach>
        </ul>
        </div>
    </c:forEach>
</div>

