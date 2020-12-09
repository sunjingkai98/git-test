<%@page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>登录 - 当当网</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="Create By JingKaiSun">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles2.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript">
        $(function(){
            /*点击图片切换验证码*/
            $("#code_img").click(function(){
                $(this).attr("src","/code/showCode?data="+new Date().getTime());
            });
            /*点击文字切换验证码*/
            $("#code_a").click(function(){
                $("#code_img").attr("src","/code/showCode?data="+new Date().getTime());
            });
            /*定义一个变量，记录验证码的状态*/
            var verifyCode = false;
            /*通过ajax校验验证码*/
            $("#code_input").blur(function () {
                var val = $(this).val();
                $.get("/code/verifyCode",{codeVal:val},function (data) {
                    if(data){
                        $("#code_span").css("color","black");
                        $("#code_span").css("font-weight","normal");
                        verifyCode = true;
                    }else{
                        $("#code_span").css("font-weight","bold");
                        $("#code_span").css("color","red");
                    }
                });
            });
            /*对表单提交按钮进行事件控制,当验证码非空并且正确时，提交表单*/
            $("#form1").submit(function () {
                /*记录验证码非空状态*/
                var codeRequired = false;
                var val = $("#code_input").val();
                if(val.length != 0){
                    codeRequired = true;
                }else{
                    $("#code_span").css("font-weight","bold");
                    $("#code_span").css("color","red");
                }
                return codeRequired && verifyCode;
            });
        });
    </script>
</head>
    <div id="head">
        <img src="${pageContext.request.contextPath}/images/DDlogoNEW.gif"
                width="300px" height="70px">
    </div>
    <div id="content">
        <%--左侧大图片--%>
        <div id="img">
        <img src="${pageContext.request.contextPath}/images/loginphoto.png"
                    width="700px" height="500px">
        </div>
        <%--右侧表单--%>
        <div id="form">
            <div id="form_title">
                会员登陆
            </div>
            <form:form modelAttribute="user" action="/login/verify" method="post" id="form1">
                <div id="email">
                <img src="${pageContext.request.contextPath}/images/user.png" id="user"/>
                <form:input path="email" placeholder="邮箱" id="email_input"/>
                </div>
                <div id="email_error">
                    ${msg}
                    <form:errors path="email" id="email_error1"/>
                </div>
                <div id="pwd">
                <img src="${pageContext.request.contextPath}/images/pwd.png" id="pwd_img"/>
                <form:password path="password" placeholder="密码" id="pwd_input"/>
                </div>
                <div id="pwd_error">
                        ${msg}
                    <form:errors path="password" id="pwd_error1"/>
                </div>
                <div id="code">
                    <span id="code_span">请输入正确的验证码:</span>
                    <a href="javascript:" id="code_a">看不清，换一张</a>
                    <input type="text" placeholder="验证码" id="code_input">
                    <img src="/code/showCode" id="code_img"></br>
                </div>
                <div id="button">
                    <input type="submit" id="submit" value="登&nbsp;录"/>
                </div>
                <div id="gotoRe">
                    <a href="#" id="reg">立即注册</a>
                </div>
            </form:form>

        </div>
    </div>
<body>

</body>
</html>
