<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<jsp:include page="/res/include/head.jsp">
    <jsp:param name="subTitle" value="投诉列表"/>
</jsp:include>
<body>
<jsp:include page="/res/include/javascript.jsp"/>
<jsp:include page="/res/include/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/res/include/sidebar.jsp">
            <jsp:param name="activeRow" value="1"/>
        </jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <%--Main body goes here--%>
            <h3 class="page-header">噪声投诉列表&nbsp;
                <small>点击查看详情</small>
            </h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>投诉单号</th>
                    <th>设备类型</th>
                    <th>投诉地点</th>
                    <th>噪声强度</th>
                    <th>噪声类型</th>
                    <th>声功能区</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="formList" id="form" status="st">
                    <s:if test="#session.complainForm.formId == #form.formId">
                        <tr onclick="gotoDetail('<s:property
                            value="#form.formId"/>')" style="cursor: pointer" class="info">
                    </s:if>
                    <s:else>
                        <tr onclick="gotoDetail('<s:property value="#form.formId"/>')" style="cursor: pointer">
                    </s:else>
                    <td><s:property value="#st.count"/></td>
                    <td><s:property value="#form.formId"/></td>
                    <td><s:property value="#form.devType"/></td>
                    <td><s:property value="#form.address"/></td>
                    <td><s:property value="#form.averageIntensity"/></td>
                    <td><s:property value="#form.noiseType"/></td>
                    <td><s:property value="#form.sfaType"/></td>
                    </tr>
                </s:iterator>
                </tbody>
                <script>
                    function gotoDetail(formId) {
                        window.location.href = "detail?formId=" + formId;
                    }
                </script>
            </table>
        </div>
    </div>
</div>
<jsp:include page="/res/include/modal.jsp"/>
</body>
</html>


