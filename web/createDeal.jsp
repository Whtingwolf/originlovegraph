<%@ page import="dao.Photosdao" %>
<%@ page import="entiy.Photos" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
User: 菱
  Date: 2018/1/5
  Time: 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="photolist" class="java.util.ArrayList" scope="session" ></jsp:useBean>
<html>
<head>
    <title>oto乐拍平台</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>

<body background="MEDA-INF/background.jpg">
<script>
    function $A(name){return document.getElementsByName(name);}
    window.onload=function(){
        /**
         * 复选框限制
         * @param {Object} name 复选框的name
         * @param {Object} maxck 最多复选个数
         */
        function checks(name,maxck){
            var cks = $A(name);
            function check(){
                var t=0;
                for(i=0;i<cks.length;i++){
                    if(cks[i].checked){t++;}
                    if(t>maxck){return false;}
                }
                return true;
            }
            for(i=0;i<cks.length;i++){
                cks[i].onclick=function(){
                    if(!check()){
                        alert("最多选择"+maxck+"个");
                        this.checked=false;
                    }
                }
            }

        }

        checks("ck",3);
        //这里如果加入对ck2的检测也可以避免6个以上
        //checks("ck2",6);
        document.form1.onsubmit=function(){
            var t=0;
            var maxck=6;
            var ck2=$A("ck2")
            for(i=0;i<ck2.length;i++){
                if(ck2[i].checked){t++;}
                if(t>maxck){
                    this.action="http://www.baidu.com";
                }
            }
            return true;
        }
    }
</script>


<h1>照片展示</h1>
<hr>
<center>
    <table width="750" height="60" cellpadding="20" cellspacing="20" border = "0" >
        <form name="form1" method="post" action="servlet/CreateDealServlet">
            <input type="submit" value="选择图片发布">
            <label>输入类型</label>
            <input type="text"value="" name="typename"><br>
            <label>输入价格</label>
            <input type="number" value="0" name="price"><br>
            <label>输入描述内容</label>
            <input type="text"value="" name="description"><br>
        <tr>
            <c:forEach items="${photolist}" var="photo" varStatus="LoopParam" >
            <td>
                <!--照片循环开始-->
                <div>
                    <dl>
                        <dt>
                            <a href="detail.jsp?id=${photo.id}"><img src="images/${photo.picturepath}"width="300" height="200"></a>
                        </dt>
                        <dd> 作者：${photo.authorname} </dd>
                        <dd> 类型: ${photo.type}     </dd>
                        <input type="CHECKBOX" name="ck" value="${photo.id}">选择
                    </dl>
                </div>
                <!--商品循环结束-->
            </td>
            <c:if test="${LoopParam.count eq 3}">
        </tr>
        <tr>
            </c:if>
            </c:forEach>
        </tr>
        </form>
    </table>
</center>


<!--<form name="form1" method="post" action="http://www.g.cn">
    对这个限制3个选择<br>
    <input type="CHECKBOX" name="ck" value="A">A
    <input type="CHECKBOX" name="ck" value="B">B
    <input type="CHECKBOX" name="ck" value="C">C
    <input type="CHECKBOX" name="ck" value="D">D
    <input type="CHECKBOX" name="ck" value="E">E
    <input type="CHECKBOX" name="ck" value="F">F
    <input type="CHECKBOX" name="ck" value="G">G
    <input type="CHECKBOX" name="ck" value="H">H
    <input type="CHECKBOX" name="ck" value="I">I
    <input type="CHECKBOX" name="ck" value="J">J
    <br>
    -->
</body>
</html>