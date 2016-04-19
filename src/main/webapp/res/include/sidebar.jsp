<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--Left sidebar--%>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 0 ? "class=\"active\"" : ""}>
            <s:a href="main">
                <span class="glyphicon glyphicon-dashboard"></span>&nbsp; &nbsp;总览
            </s:a>
        </li>

    </ul>
    <hr>
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 1 ? "class=\"active\"" : ""}>
            <s:a href="query">
                <span class="glyphicon glyphicon-th-list"></span>&nbsp; &nbsp;投诉列表
            </s:a>
        </li>

        <li ${param.activeRow == 2 ? "class=\"active\"" : ""}>
            <s:a href="detail" onclick="showDevelopingModal()">
                <span class="glyphicon glyphicon-check"></span>&nbsp; &nbsp;投诉详情
            </s:a>
        </li>

        <li ${param.activeRow == 3 ? "class=\"active\"" : ""}>
            <s:a href="heat-map">
                <span class="glyphicon glyphicon-map-marker"></span>&nbsp; &nbsp;黑点地图
            </s:a>

        </li>
    </ul>
    <hr>
    <ul class="nav nav-sidebar">
        <li ${param.activeRow == 5 ? "class=\"active\"" : ""}>
            <s:a href="#" onclick="showDevelopingModal()">
                <span class="glyphicon glyphicon-cog"></span>&nbsp; &nbsp;系统设置
            </s:a>
        </li>
    </ul>
</div>