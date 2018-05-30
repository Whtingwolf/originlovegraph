<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entiy.Photos,dao.Photosdao" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="photolist" class="java.util.ArrayList" scope="session">
</jsp:useBean>
<html>

<head>
    <c:import url="importIndex.jsp"/>
    <div>
    <title>oto乐拍平台</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
    </div>
</head>
<body background="MEDA-INF/background.jpg">
<div>
    <a class="navigation-li" href="upload.jsp">上传图片</a>
    <h1>照片展示</h1>
    <hr>
    <center>
        <table width="750" height="60" cellpadding="20" cellspacing="20" border="0">
            <tr>
                <c:forEach var="photo" items="${photolist}" varStatus="photoLoop">
                <td>
                    <!--照片循环开始-->
                    <div>
                        <dl>
                            <dt>
                                <a href="detail.jsp?id=${photo.id}&requestType=detail"><img
                                        src="images/${photo.picturepath}" width="300" height="200"></a>
                            </dt>
                            <dd> 作者：${photo.authorname}</dd>
                            <dd> 类型:${photo.type}</dd>
                        </dl>
                    </div>
                    <!--商品循环结束-->
                    <c:if test="${photoLoop.count%3==0}">
            </tr>
            <tr>
                </c:if>
                </c:forEach>
            </tr>
        </table>
    </center>
</div>
</body>
</html>