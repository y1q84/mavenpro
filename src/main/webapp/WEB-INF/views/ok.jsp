<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\7\27 0027
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--添加el表达式的内容--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //alert(100)
            var params = '{"id": 1,"username": "测试商品","password": "123456","role": "role2","regIp": "123456.jpg"}';

            $.ajax({
                url : "http://localhost:8080/user/json.action",
                data : params,
                contentType : "application/json;charset=UTF-8",//发送数据的格式
                type : "post",
                dataType : "json",//回调
                success : function(data){
                    alert("后台发送过来的email为："+data.email);
                    document.getElementById("content").innerHTML = data.email;
                }

            });
        });
    </script>
</head>
<body>
    <h1>你是不是傻</h1>
    <c:forEach items = "${itemList}" var = "item">
        <p>${item}</p>
    </c:forEach>
    <c:forEach items="${itemMap}" var="map">
        <p>${map.key},${map.value}</p>
    </c:forEach>
    <h1 id="content"></h1>
</body>
</html>
