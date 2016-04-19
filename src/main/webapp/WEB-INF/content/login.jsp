<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>中大噪声投诉中心 - 登录</title>

    <%--CSS files--%>
    <link href="${pageContext.request.contextPath}/res/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/res/css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/res/include/javascript.jsp"/>
<div class="container">
    <s:form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">中大噪声投诉中心</h2>

        <%--Username input--%>
        <label for="username" class="sr-only">用户名</label>
        <input class="form-control" id="username" name="username" type="text" placeholder="用户名" required autofocus>

        <%--Password input--%>
        <label for="password" class="sr-only">密码</label>
        <input class="form-control" id="password" name="password" type="password" placeholder="密码" required>

        <p>测试账号 admin 123456</p>

        <%--Login Button--%>
        <input type="hidden" name="submit" value="true">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </s:form>
</div>
<jsp:include page="/res/include/modal.jsp"/>
</body>
</html>
