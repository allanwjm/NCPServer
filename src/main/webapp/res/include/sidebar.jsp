<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--Left sidebar--%>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 0 ? "class=\"active\"" : ""}>
            <a href="main">
                <span class="glyphicon glyphicon-dashboard"></span>&nbsp; &nbsp;总览
            </a>
        </li>

    </ul>
    <hr>
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 1 ? "class=\"active\"" : ""}>
            <a href="query">
                <span class="glyphicon glyphicon-list-alt"></span>&nbsp; &nbsp;投诉列表
            </a>
        </li>

        <li ${param.activeRow == 2 ? "class=\"active\"" : ""}>
            <a href="#" onclick="showDevelopingModal()">
                <span class="glyphicon glyphicon-stats"></span>&nbsp; &nbsp;数据统计
            </a>
        </li>

        <li ${param.activeRow == 3 ? "class=\"active\"" : ""}>
            <a href="heat-map">
                <span class="glyphicon glyphicon-map-marker"></span>&nbsp; &nbsp;黑点地图
            </a>

        </li>
    </ul>
    <hr>
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 4 ? "class=\"active\"" : ""}>
            <a href="#" onclick="showDevelopingModal()">
                <span class="glyphicon glyphicon-check"></span>&nbsp; &nbsp;投诉受理
            </a>
        </li>
    </ul>
    <hr>
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 5 ? "class=\"active\"" : ""}>
            <a href="#" onclick="showDevelopingModal()">
                <span class="glyphicon glyphicon-cog"></span>&nbsp; &nbsp;系统设置
            </a>
        </li>
    </ul>
</div>