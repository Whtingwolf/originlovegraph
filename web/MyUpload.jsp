<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/3/14
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyUpload</title>
</head>
<body>
    <form action="/MyUploadServlet" enctype = "multipart/form-data" method="post" >
        文件1：<input type="file" name="file1"/><br>
        <input type="submit" name="upload" value="上传">
    </form>
</body>
</html>
