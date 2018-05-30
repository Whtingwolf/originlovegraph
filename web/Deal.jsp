<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/5
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="entiy.Deal,dao.DealDisplay,java.util.*" %>
<%@ page import="dao.Photosdao" %>
<%@ page import="entiy.Photos" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dealList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="photosMap" scope="session" type="java.util.Map" class="java.util.HashMap"/>
<html>
<head>
</head>
<body>
<h1>约拍展示</h1>
<a href="servlet/GetPhotoServlet?requestType=createDeal"><h1>发布约拍</h1></a>
<hr>

<center>
    <table width="500" height="60" cellpadding="20" cellspacing="20" border = "0" >
        <c:forEach items="${dealList}" var="deal" varStatus="dealStatus">
        <tr>
            <c:set value="${'Photos'}${dealStatus.count}" var="num"/>
            <c:forEach items="${photosMap[num]}" var="photos" varStatus="photosLoop">
            <td>
                <!--照片循环开始-->
                <div>
                    <dl>
                        <dt>
                            <img src="images/${photos.picturepath}"width="300" height="200">
                        </dt>
                    </dl>
                </div>
                <!--商品循环结束-->
            </td>
            </c:forEach>
        </tr>
        <tr>
            <td>
                <dd> 发起者：${deal.originator}</dd>
                <dd> 类型:${deal.typename}     </dd>
                <dd> 价格:${deal.price}       </dd>
                <dd> 描述:${deal.description}</dd>
                <a href="servlet/DealServlet?id=${deal.id}" >约拍他</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
