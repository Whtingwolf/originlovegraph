<%@ page import="dao.DealDisplay" %>
<%@ page import="entiy.Deal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.Photosdao" %>
<%@ page import="entiy.Photos" %>
<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/5
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="DealList" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="photoMap" type="java.util.Map" class="java.util.HashMap" scope="session"/>
<html>
<head>

</head>
<body>
<h1>我的约拍展示</h1>
<hr>
<center>
    <table width="500" height="60" cellpadding="20" cellspacing="20" border = "0" >
        <c:forEach items="${DealList}" varStatus="DealStatus" var="Deal">
        <tr>
            <c:set var="num" value="${'numbers'}${DealStatus.count-1}"></c:set>
            <c:forEach items="${photoMap[num]}" varStatus="MapStatus" var="photo">
            <td>
                <!--照片循环开始-->
                <div>
                    <dl>
                        <dt>
                            <img src="images/${photo.picturepath}"width="300" height="200">
                        </dt>
                    </dl>
                </div>
                <!--商品循环结束-->
            </td>
            </c:forEach>
        </tr>
        <tr>
            <td>
                <dd> 发起者：${Deal.originator}   </dd>
                <dd> 类型:${Deal.typename}     </dd>
                <dd> 价格:${Deal.price}       </dd>
                <dd> 描述:${Deal.description}</dd>
                <a href="servlet/DealServlet?id=${Deal.id}" >约拍他</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</center>
</body>

