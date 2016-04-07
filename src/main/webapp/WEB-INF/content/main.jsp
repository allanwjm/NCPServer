<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<jsp:include page="/res/include/head.jsp">
    <jsp:param name="subTitle" value=""/>
</jsp:include>
<body>
<jsp:include page="/res/include/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/res/include/sidebar.jsp">
            <jsp:param name="activeRow" value="0"/>
        </jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <%--Main body goes here--%>
            Main Page!
        </div>
    </div>
</div>
<jsp:include page="/res/include/modal.jsp"/>
<jsp:include page="/res/include/javascript.jsp"/>
</body>
</html>
