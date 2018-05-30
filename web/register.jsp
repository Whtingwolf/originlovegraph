<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.net.*" pageEncoding="UTF-8" %>

<html>
  <head>
    <title>oto乐拍平台</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
  </head>

  <body>
  <div>
      <form action="servlet/register_servlet" method="post">
     <table>
       <tr>
         <td>用户名：</td>
         <td><input type="text" name = "username" value= ""></td>
       </tr>
       <tr>
         <td>密码：</td>
         <td><input type="password" name="password" value= ""></td>
       </tr>
         <tr>
             <td>再输一次密码:</td>
             <td><input type="password" name="confirmpassword"value=""></td>
         </tr>
         <tr>
             <td>手机号：</td>
             <td><input name="phonenumber" type="text"value=""></td>
         </tr>
       <tr>
           <td colspan="2"><input type="submit" value="提交"></td>
       </tr>
      </table>
      </form>
  </div>
  </body>
</html>
<%
    if("false".equals(session.getAttribute("status"))){
        out.println("请验证输入信息");
    }
%>
<%
    if("exist".equals(session.getAttribute("status"))){
        out.println("账户名已经存在");
    }
%>
