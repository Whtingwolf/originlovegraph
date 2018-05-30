<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>oto乐拍平台</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body background="MEDA-INF/background.jpg">
<font color="red">当前登录人数：${applicationScope["OnlineCount"]}<br/></font>
<font color="red">历史登录人数：${applicationScope["RecordCount"]}<br/></font>
<font color="red">保存路径：${initParam["CounterFilePath"]}<br/></font>

<div id="navigation">
    <ul class="navigation-ul">
        <li class="navigation-li"><a href="/servlet/GetPhotoServlet?requestType=showDeal">首页</a></li>
        <li class="navigation-li"><a href="/servlet/GetPhotoServlet?requestType=myPhoto">我的作品</a></li>
        <li class="navigation-li"><a href="/servlet/GetPhotoServlet?requestType=mydeal">我的</a></li>
        <li class="navigation-li"><a href="servlet/LogoutServlet">注销</a> </li>
        <li class="navigation-li"><a href="/PDFServlet">PDF</a> </li>

    </ul>
</div>
<form action=""></form>
</body>
</html>
