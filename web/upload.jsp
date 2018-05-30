<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'upload.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<center>
    <h3>文件上传</h3>
  <!--  <font color="red"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %> </font>-->
    <form enctype="multipart/form-data" method="post" action="servlet/FileUploadServlet">
        类型：<input type="text" name = "typename" value= ""><br/>
        选择文件：<input type="file" name="file1" /><br/>
        选择文件：<input type="file" name="file2" /><br/>
        选择文件：<input type="file" name="file3" /><br/>
        选择文件：<input type="file" name="file4" /><br/>
        选择文件：<input type="file" name="file5" /><br/>
        <input type="submit" value="上传" />
    </form>
</center>
</body>>
</html>
