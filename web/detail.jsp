<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/4
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entiy.Photos,dao.Photosdao" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="photolist" class="java.util.ArrayList" scope="session"/>
<html>
<head>
    <title>details</title>
</head>
<body>
<h1>详细信息</h1>
<hr>
<center>
    <table width="750" height="60" cellpadding="20" cellspacing="20" border="0">
        <tr>
                <td width="70%" valign = "top">
                    <table>
                        <tr>
                            <td rowspan="4"><img src="images/${photolist[0].picturepath}"width="400" height="300"></td>
                        </tr>
                        <tr>
                            <td><B>作者：${photolist[0].authorname}</B></td>
                        </tr>
                        <tr>
                            <td>类型：${photolist[0].type}</td>
                        </tr>
                    </table>

                </td>


            </tr>

        </table>
    </center>


</body>
</html>
