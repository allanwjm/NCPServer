<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <%--Navigation header--%>
        <div class="navbar-header">
            <s:a class="navbar-brand" href="main">中大噪声投诉中心</s:a>
        </div>

        <%--Navigation bar--%>
        <div class="navbar-collapse collapse" id="navbar" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a onclick="window.location.reload(true)">刷新 <span class="glyphicon glyphicon-refresh"></span></a>
                </li>
                <li>
                    <a onclick="showAboutModal()">关于 <span class="glyphicon glyphicon-info-sign"></span></a>
                </li>
                <li>
                    <a onclick="showLogoutModal()">登出 <span class="glyphicon glyphicon-off"></span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>