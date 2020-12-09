<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>购物车-当当网</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles3.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript">
        $(function () {
            //全选/取消
            $("#check_father").click(function(){
                $("input[name='check_son']").prop("checked",this.checked);
            });

            //当子复选框取消选中，全选框取消选中
            $("#content").find("[name='check_son']").click(function () {
                var flag = $(this).prop("checked");
                if(!flag){
                    $("#check_father").prop("checked",false);
                }else{
                    var length = $("#content").find("[name='check_son']:checkbox:not(:checked)").length;
                    if(length === 0){
                       $("#check_father").prop("checked",true);
                   }
                 }
            });


            //计算选择商品和总金额
            $("#content").find(":checkbox").click(function () {
                var quantity = 0;
                var price = 0;
                $("input[name='check_son']").each(function () {
                    var val = $(this).val();
                    //判断当前的复选框是否被选中
                    if ($(this).prop("checked")) {
                        quantity += parseFloat($(this).attr("param1"));
                        price += parseFloat($(this).attr("param2"));
                    }
                })
                $("#select").html(quantity);
                $("#payamount").html(price);
            });

            //批量删除
            $("#pidel").click(function () {
                var ids = "";
                $("input[name='check_son']").each(function(){
                    //判断当前的复选框是否被选中
                    if($(this).prop("checked")){
                        ids += $(this).attr("param3")+",";
                    }
                });
                var idss=ids.substring(1);
                if(idss != null){
                    $.get("${pageContext.request.contextPath}/proItem/deletemany/"+ids,function (data) {
                        if(data == 1){
                            location.href=location;
                        }else{
                            alert("删除失败!");
                        }
                    });
                }

            });

            //修改指定商品数量
            $("[name='quaninp']").blur(function () {
                var amount = $(this).val();
                var id = $(this).attr("param");
                $.get("${pageContext.request.contextPath}/proItem/update/"+id+"/"+amount,function (data) {
                    if(data == 1){
                        location.href=location;
                    }else{
                        alert("修改失败!");
                    }
                });
            });



            });
    </script>

</head>

<body>
    <div id="head1">
        <img src="${pageContext.request.contextPath}/images/itemads.png" id="head_ads"/>
    </div>
    <div id="head2">
        <div id="head2_1">
        <div id="head_logodiv">
            <a href="/dangdang/main" ><img src="${pageContext.request.contextPath}/images/logobuy.jpg" id="head_logo"/></a>
            <div id="lead">当前位置:<a href="/dangdang/main" id="head_a">当当网</a>>><span id="head_span">我的购物车</span></div>
        </div>
        <div id="shopping_procedure">
            <span id="current">我的购物车</span>
            <span>填写订单</span>
            <span>完成订单</span>
        </div>
        </div>
    </div>
    <div id="content">
        <table id="table">
            <tr>
                <th><input type="checkbox" id="check_father"/>&nbsp;全选</th>
                <th>商品信息</th>
                <th>单价(元)</th>
                <th>数量</th>
                <th>金额(元)</th>
                <th>操作</th>
            </tr>



                <c:forEach items="${list}" var="product">
            <tr>
                <td id="check"><input type="checkbox" name="check_son" param1="${product.quantity}"
                                            param2="${product.dangPrice * product.quantity}"
                                            param3="${product.id}"/></td>
                <td id="name">
                    <img src="${pageContext.request.contextPath}/images/${product.productPic}"
                            width="70px" height="100px" id="name_img">
                    <span id="name1">${product.productName}</span> </br>
                       <span id="des">${product.description}</span>
                </td>
                <td id="price">￥${product.dangPrice}</td>
                <td id="quan"><input id="quaninp" name="quaninp" type="text" param="${product.id}" value="${product.quantity}"/></td>
                <td id="am">￥${product.dangPrice * product.quantity}</td>
                <td id="del"><a href="/proItem/delete/${product.id}" onclick="return confirm('确认要删除吗?')" id="del1" >删除</a></br><span id="delmsg">${msg}</span></td>
            </tr>
                </c:forEach>



        </table>
        <div id="content_foot">
            <div id="foot1">
                <div id="foot1_a"><a href="javascript:" id="pidel">批量删除</a><span id="foot1_span">已选择<span id="select">0</span>件商品</span></div>

            </div>
            <div id="foot2">
                总计:<span style="color:#ff2832">￥</span><span id="payamount">0</span>
                <a href="javascript:"  id="total_btn">结&nbsp;&nbsp;算</a>
            </div>
        </div>
    </div>

</body>
</html>
