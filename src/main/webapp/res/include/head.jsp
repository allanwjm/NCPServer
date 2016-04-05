<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--HEAD element--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1">



    <title>${(param.subTitle != null) && param.subTitle != ""?
            "中大噪声投诉中心 - ".concat(param.subTitle):
            "中大噪声投诉中心"}</title>

    <%--CSS files--%>
    <link href="${pageContext.request.contextPath}/res/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/res/css/dashboard.css" rel="stylesheet">
</head>