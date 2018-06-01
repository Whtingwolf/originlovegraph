<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>oto乐拍平台</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="CSS/bootstrap-theme.min.css"></script>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body background="MEDA-INF/blueOcean.jpg">
<!--font color="red">当前登录人数：${applicationScope["OnlineCount"]}<br/></font-->
<!--font color="red">历史登录人数：${applicationScope["RecordCount"]}<br/></font-->
<!--font color="red">保存路径：${initParam["CounterFilePath"]}<br/></font-->
<div class="container">
    <nav class="navbar navbar-default">
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example
            -navbar-collapse-1" aria-expanded="false">
                <spanc class = "sr-only">Toggle navigation</spanc>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/servlet/GetPhotoServlet?requestType=showDeal">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">作品 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">约拍</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/servlet/GetPhotoServlet?requestType=myPhoto">我的作品</a></li>
                        <li><a href="/servlet/GetPhotoServlet?requestType=mydeal">我的约拍</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">我的信息</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" action="#" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a> </li>
            </ul>
        </div>
        <!--div class="col-md-3"style="height: 50px;font-size: large"><a href="/servlet/GetPhotoServlet?requestType=myPhoto">我的作品</a></div-->
        <!--div class="col-md-3"style="height: 50px;font-size: large"><a href="/servlet/GetPhotoServlet?requestType=mydeal">我的</a></div-->
        <!--div class="col-md-3"style="height: 50px;font-size: large"><a href="servlet/LogoutServlet">注销</a> </div-->
    </div>
    </nav>
</div>

<form action=""></form>
</body>
</html>
