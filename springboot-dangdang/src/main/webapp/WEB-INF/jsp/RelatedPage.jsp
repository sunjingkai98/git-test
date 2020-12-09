<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript">

        $(function () {
            /*上一页超链接*/
            $("#last").click(function () {

                $.get("${pageContext.request.contextPath}/product/related/${sId}/${currectPage-1}",function (data) {
                    $("#middle1").html(data);
                });
            });
            /*下一页超链接*/
            $("#next").click(function () {
                $.get("${pageContext.request.contextPath}/product/related/${sId}/${currectPage+1}",function (data) {
                    $("#middle1").html(data);
                });
            });

            /*点击加入购物车按钮*/
            $("[name='addBook']").click(function () {
                    var val = $(this).attr("param");
                    $.get("${pageContext.request.contextPath}/proItem/insert/"+val,function (data) {
                        if(data[1] == 1){
                            alert("添加成功,您已添加本款商品"+data[0]+"件!");
                        }else{
                            alert("添加失败,请先登录!");

                        }

                    });
                }
            );

        });



    </script>
</head>
<body>
<div style="margin:10px auto;height:4% ;width:100%;text-align: center;background-color:rgb(255,50,40);;padding-top: 5px;color: white;">
    <c:choose>
        <c:when test="${currectPage <= 1}">上一页</c:when>
        <c:otherwise><a href="javascript:" id="last">上一页</a></c:otherwise>
    </c:choose>
    &nbsp;&nbsp;
    第${currectPage}页|共${totalPage}页&nbsp;&nbsp;

    <c:choose>
        <c:when test="${currectPage >= totalPage}">下一页</c:when>
        <c:otherwise><a href="javascript:" id="next">下一页</a></c:otherwise>
    </c:choose>
</div>
<c:forEach items="${productList}" var="pro">
    <div style="border:2px solid chartreuse ;margin-bottom: 5px;">
        <img src="${pageContext.request.contextPath}/images/${pro.productPic}"
             height="100px" width="70px" align="left" style="margin:10px"/>
        <div style="height: 99%;width: 100%;">
            <div style="font-size: 20px;font-family: Consolas;margin-bottom: 5px"><a href="#" id="proName">${pro.productName}</a></div>
            &nbsp;&nbsp;&nbsp;顾客评分:100</br>
            <c:forEach items="${pro.books}" var="book">
                &nbsp;&nbsp;作者: ${book.author}</br>
                &nbsp;&nbsp;出版社:${book.publishing}&nbsp; 出版时间:<span id="time">
                <jsp:useBean id="myDate" class="java.util.Date"/>
                <c:set target="${myDate}" property="time" value="${book.publishTime}"/>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${myDate}" type="both"/>
                </span></br>
            </c:forEach>
            <div style="font-size: 10px;padding-left: 20px;margin-top: 5px">${pro.description}</div>
            <div style="width: 100%;height: 10%;text-align: right;margin-right:10px; ">  <%--底部--%>
                <span style="text-decoration: line-through;">原价:${pro.fixedPrice}</span> &nbsp;现价:${pro.dangPrice}
                <a href="#"><img src="${pageContext.request.contextPath}/images/buy.png" width="120" height="30"
                                 style="margin-right: 10px" param="${pro.id}" name="addBook"></a>
            </div>
        </div>

    </div>

</c:forEach>
</body>
