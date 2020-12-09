<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>当当网图书_小说传记_青春文学_成功励志_投资理财_各品类图书畅销榜</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
</head>

<body>
    <div id="head_login">
        <c:if test="${loginUser == null}">
            <span>欢迎光临当当，请<a href="/login/loginForm" id="login">登陆</a>&nbsp;<a href="#" id="vip">成为会员</a></span>
        </c:if>
        <c:if test="${loginUser != null}">
            <span><span style="color: red">${loginUser.nickname}</span>,欢迎光临当当网!<a href="/login/logout" id="logout">[退出]</a></span>
        </c:if>
        <span>
            <a href="/item/showItem"><img src="${pageContext.request.contextPath}/images/buycar.png"
                            id="head_img"></a>
            <a href="/item/showItem" id="buy1">购物车</a>
        </span>
    </div>
    <div id="head">
        <img src="${pageContext.request.contextPath}/images/DDlogoNEW.gif">
    </div>
    <div id="middle">
        <div id="left">
            <c:import url="/category/1/subcats"/>
        </div>
        <div id="middle1">
            <c:import url="/product/recommend"/>
            <c:import url="/product/sales"/>
            <c:import url="/product/newest"/>
        </div>
        <div id="right"></div>
    </div>
    <div id="foot">页脚</div>

</body>
</html>
