<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/3/9
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="test" scope="request" class="entiy.User"></jsp:useBean>
<html>
<head>

</head>
<body>
    ${sessionScope.username}<br>
    ${sessionScope.status}
</body>
</html>
