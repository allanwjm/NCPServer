<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<jsp:include page="/res/include/head.jsp">
    <jsp:param name="subTitle" value="投诉列表"/>
</jsp:include>
<body>
<jsp:include page="/res/include/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/res/include/sidebar.jsp">
            <jsp:param name="activeRow" value="1"/>
        </jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <%--Main body goes here--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>投诉表单号</th>
                        <th>投诉地点</th>
                        <th>噪声类型</th>
                        <th>声功能区</th>
                        <th>描述信息</th>
                    </tr>
                    </thead>
                    <s:iterator value="formList" id="formId" status="st">
                        <tr>
                            <td><s:property value="#st.count"/></td>
                            <td><s:property value="formId"/></td>
                            <td><s:property value="address"/></td>
                            <td><s:property value="noiseType"/></td>
                            <td><s:property value="sfaType"/></td>
                            <td><s:property value="comment"/></td>
                        </tr>
                    </s:iterator>
                </table>
        </div>
    </div>
</div>
<jsp:include page="/res/include/modal.jsp"/>
<jsp:include page="/res/include/javascript.jsp"/>
</body>
</html>
