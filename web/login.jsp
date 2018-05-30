<%--
  Created by IntelliJ IDEA.
  User: 菱
  Date: 2018/1/3
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.net.*" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.status!=null && sessionScope.status eq 'true'}">
    <c:out value="${sessionScope.status}"></c:out>
    <jsp:forward page="index.jsp"></jsp:forward>
</c:if>

<html>
  <head>
    <title>oto乐拍平台</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
  </head>
  <body >
  <div>
      <form action="servlet/LoginServlet" method="post">
     <table>
       <tr>
         <td>用户名：</td>
         <td><input type="text" name = "username" id="username" value= "${cookie.username}"></td>
       </tr>
       <tr>
         <td>密码：</td>
         <td><input type="password" name="password" id="password"value= ""></td>
       </tr>
       <tr>
         <td colspan="2"><input type="submit" value="登录" style="cursor: pointer" onclick=""></td>
           <td colspan="2"><a href="register.jsp"><input type="button" value="注册"></a></td>
       </tr>
      </table>
          <div>
              <label>
                  <input type="checkbox" name ="remenberMe" id="remenberMe" onclick="remenber();"/>
                  remenber me
              </label>
          </div>
      </form>
  </div>
  </body>
</html>
<script>/*
    function setCookie(name,value) {
        var Days = 30;
        var exp =  new Date();
        exp.setTime(exp.getTime()+Days*24*60*60*1000);
        document.cookie = name + "="+escape(value)+";expiers=" + exp.toGMTString();
    }
    $(document).ready(function(){
        //记住密码功能
        var username  = getCookie("username");
        var password = getCookie("password");
        //自动填充用户名和密码1
        $("#username").val(username);
        $("#password").val(password);
        if(str!=null && str!=""){
            $("input[type='checkbox']").attr("checked", true);
        }
    });
    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
        }
        return "";
    }
    //记住账号和密码的事件
    function remenber() {
        var remFlag = $("input[type = 'checkbox']").is(':checked');
        if(remFlag==true){
            var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
            if(conFlag==true){
                $("#remFlag").val(true);
            }else {
                $("input[type = 'checkbox']").removeAttri('checked');
                $("#remFlag").val(false);
            }
        }
        else {
            $("#remFlag").val(false);
        }
    }*/
</script>
<c:if test="${requestScope.loginstatus eq 'fail'}">
    <c:out value="账号密码错误"></c:out>
</c:if>

