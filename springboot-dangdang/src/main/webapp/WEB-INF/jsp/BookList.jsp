<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>图书信息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles1.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("[name='list']").click(function () {
                var val = $(this).attr("param");
                $.get("${pageContext.request.contextPath}/product/related/"+val+"/1",function (data) {
                    $("#middle1").html(data);
                });
            });

            $("#title").click(function () {
                var val = $(this).attr("param");
                $.get("${pageContext.request.contextPath}/product/"+val+"/1",function (data) {
                    $("#middle1").html(data);
                });
            });

            
        });
    </script>
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
                <a href="/item/showItem"><img src="${pageContext.request.contextPath}/images/buycar.png" id="head_img"></a>
                <a href="/item/showItem" id="buy1">购物车</a>
            </span>
    </div>
    <div id="head"><a href="/dangdang/main"><img src="${pageContext.request.contextPath}/images/DDlogoNEW.gif"></a></div>
    <div id="middle">
        <div id="content">您当前的位置:&nbsp;<a href="/dangdang/main" id="content2">当当网</a> >> <span id="content1">图书详情</span></div>
        <div id="left">
            <c:import url="/category/${catId}"/>
        </div>
        <div id="middle1">
            <c:import url="/product/${catId}/1"/>
        </div>
    </div>
    <div id="foot">页脚</div>

</body>
</html>
