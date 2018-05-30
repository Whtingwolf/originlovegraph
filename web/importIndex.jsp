<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/3/11
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="navigation">
    <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
    <ul class="navigation-ul">
        <li class="navigation-li"><a href="/servlet/GetPhotoServlet?requestType=showDeal">首页
        </a></li>
        <li class="navigation-li"><a href="/servlet/GetPhotoServlet?requestType=myPhoto">我的作品</a></li>
        <li class="navigation-li"><a href="myDeals.jsp">我的</a></li>
        <li class="navigation-li"><a href="servlet/LogoutServlet">注销</a> </li>
    </ul>
</div>
