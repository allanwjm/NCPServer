<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<jsp:include page="/res/include/head.jsp">
    <jsp:param name="subTitle" value="投诉详情"/>
</jsp:include>
<body>
<script src="${pageContext.request.contextPath}/res/js/json2.js"></script>
<jsp:include page="/res/include/javascript.jsp"/>
<jsp:include page="/res/include/navbar.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/res/include/sidebar.jsp">
            <jsp:param name="activeRow" value="2"/>
        </jsp:include>
        <div class="container col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <%--Main body goes here--%>
            <h3 class="page-header">噪声投诉详情&nbsp;
                <small><s:property value="form.formId"/></small>
            </h3>

            <div class="row">
                <%--Progress Div--%>
                <div class="col-sm-6 col-md-6">
                    <h4 class="text-center">投诉受理进度&nbsp;
                        <s:if test="progresses != null">
                            <small>共有<s:property value="progresses.size()"/>条记录</small>
                        </s:if>
                        <s:else>
                            <small>无法查询受理进度</small>
                        </s:else>
                    </h4>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>时间</th>
                            <th>进度标题</th>
                        </tr>
                        </thead>
                        <tbody>
                        <script>
                            var progresses = {};
                        </script>
                        <s:iterator value="progresses" id="progress" status="st">
                            <tr onclick="showProgressDetailModal('progress<s:property value="#progress.progressId"/>')"
                                style="cursor: pointer">
                                <td><s:property value="#st.count"/></td>
                                <td><s:date name="#progress.date" format="yyyy/MM/dd hh:mm:ss"/></td>
                                <td><s:property value="#progress.title"/></td>
                            </tr>
                            <script>
                                progresses.progress<s:property value="#progress.progressId"/>
                                        = <s:property value="#progress.jsonString" escape="false"/>;
                            </script>
                        </s:iterator>
                        </tbody>
                    </table>
                    <button type="button" class="btn btn-default" onclick="showNewProgressModal()">
                        <span class="glyphicon glyphicon-plus"></span>
                        添加受理记录
                    </button>
                </div>

                <%--Detail Div--%>
                <div class="col-sm-6 col-md-6">
                    <h4 class="text-center">投诉详情</h4>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>属性</th>
                            <th>值</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>投诉单号</td>
                            <td><s:property value="form.formId"/></td>
                        </tr>
                        <tr>
                            <td>投诉时间</td>
                            <td><s:date name="form.date" format="yyyy/MM/dd hh:mm:ss"/></td>
                        </tr>
                        <tr>
                            <td>客户端平台</td>
                            <td><s:property value="form.platform"/></td>
                        </tr>
                        <tr>
                            <td>设备类型</td>
                            <td><s:property value="form.devType"/></td>
                        </tr>
                        <tr>
                            <td>设备编号</td>
                            <td><s:property value="form.devId"/></td>
                        </tr>
                        <tr>
                            <td>平均噪声强度</td>
                            <td><s:property value="form.averageIntensity"/></td>
                        </tr>
                        <tr>
                            <td>坐标类型</td>
                            <td><s:property value="form.coord"/></td>
                        </tr>
                        <tr>
                            <td>定位地点</td>
                            <td><s:property value="form.autoAddress"/></td>
                        </tr>
                        <tr>
                            <td>定位纬度</td>
                            <td><s:property value="form.autoLatitude"/></td>
                        </tr>
                        <tr>
                            <td>定位经度</td>
                            <td><s:property value="form.autoLongitude"/></td>
                        </tr>
                        <tr>
                            <td>定位海拔</td>
                            <td><s:property value="form.autoAltitude"/></td>
                        </tr>
                        <tr>
                            <td>定位水平精度</td>
                            <td><s:property value="form.autoHorizontalAccuracy"/></td>
                        </tr>
                        <tr>
                            <td>定位垂直精度</td>
                            <td><s:property value="form.autoVerticalAccuracy"/></td>
                        </tr>
                        <tr>
                            <td>手动选择地点</td>
                            <td><s:property value="form.manualAddress"/></td>
                        </tr>
                        <tr>
                            <td>手动选择纬度</td>
                            <td><s:property value="form.manualLatitude"/></td>
                        </tr>
                        <tr>
                            <td>手动选择经度</td>
                            <td><s:property value="form.manualLongitude"/></td>
                        </tr>
                        <tr>
                            <td>噪声类型</td>
                            <td><s:property value="form.noiseType"/></td>
                        </tr>
                        <tr>
                            <td>声功能区类型</td>
                            <td><s:property value="form.sfaType"/></td>
                        </tr>
                        </tbody>
                    </table>

                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>描述信息</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><s:property value="form.comment"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/res/include/modal.jsp"/>
<script>
    // Orgainize progress details and show modal
    function showProgressDetailModal(progressName) {
        var progress = eval('progresses.' + progressName);
        var body =
                '<tr><td>受理进度ID</td><td>' + progress['progressId'] + '</td></tr>\n' +
                '<tr><td>对应投诉单号</td><td>' + progress['formId'] + '</td></tr>\n' +
                '<tr><td>受理时间</td><td>' + progress['date'] + '</td></tr>\n' +
                '<tr><td>标题</td><td>' + progress['title'] + '</td></tr>\n' +
                '<tr><td>描述信息</td><td>' + progress['comment'] + '</td></tr>\n';
        for (var detailKey in progress['details']) {
            if (progress['details'].hasOwnProperty(detailKey)) {
                body += '<tr><td>' + detailKey + '</td><td>' + progress['details'][detailKey] + '</td></tr>\n';
            }
        }
        $('#progressDetailModalBody').html(body);
        $('#progressDetailModal').modal();
    }
</script>
<%--Modal: Progress Detail--%>
<div class="modal fade" id="progressDetailModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">受理进度详情</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>属性</th>
                        <th>值</th>
                    </tr>
                    </thead>
                    <tbody id="progressDetailModalBody">
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<script>
    // Insert new Progress
    function showNewProgressModal() {
        details.length = 0;
        displayDetails();
        $('#newProgressModal').modal();
    }
    // Details array
    var details = [];
    // Constructor of Detail Object
    function Detail() {
        this.detailKey = '';
        this.detailValue = '';
    }
    // Insert an new detail
    function newDetail() {
        saveDetails();
        details[details.length] = new Detail();
        displayDetails();
    }
    // Save detail info from input to array
    function saveDetails() {
        for (var i = 0; i < details.length; i++) {
            var detail = details[i];
            var detailKeyId = 'inputDetailKey' + i;
            var detailValueId = 'inputDetailValue' + i;
            detail.detailKey = document.getElementById(detailKeyId).value;
            detail.detailValue = document.getElementById(detailValueId).value;
        }
    }
    // Refresh HTML elements to display details
    function displayDetails() {
        var group = "";
        for (var i = 0; i < details.length; i++) {
            group +=
                    '<div class="row form-group">' +
                    '<div class="col-md-6 col-sm-6">\n' +
                    '<input id="inputDetailKey' + i + '" type="text" ' +
                    'class="form-control" placeholder="属性' + (i + 1) + '" name="details"/>\n' +
                    '</div>\n' +
                    '<div class="col-md-6 col-sm-6">\n' +
                    '<input id="inputDetailValue' + i + '" type="text" ' +
                    'class="form-control" placeholder="值"/>\n' +
                    '</div>\n' +
                    '</div>\n';
        }
        $('#groupDetails').html(group);
        for (i = 0; i < details.length; i++) {
            var detail = details[i];
            var detailKeyId = 'inputDetailKey' + i;
            var detailValueId = 'inputDetailValue' + i;
            document.getElementById(detailKeyId).value = detail.detailKey;
            document.getElementById(detailValueId).value = detail.detailValue;
        }
    }
    // Submit new Progress request to Backend
    function submitNewProgress() {
        // Save details
        saveDetails();
        // Check Progress
        var valid = true;
        var title = document.getElementById('inputTitle').value;
        var comment = document.getElementById('inputComment').value;
        valid = validateString(title) ? valid : false;
        valid = validateString(comment) ? valid : false;
        var detailMap = {};
        for (var i = 0; i < details.length; i++) {
            var detail = details[i];
            var key = detail['detailKey'];
            var value = detail['detailValue'];
            valid = validateString(key) ? valid : false;
            valid = validateString(value) ? valid : false;
            detailMap[key] = value;
        }
        if (!valid) {
            $('#textInvalidProgress').html('信息填写不完整, 无法添加新记录!');
            $('#alertInvalidProgress').removeClass('hidden');
            return;
        }
        // Send POST to backend
        var paras = {};
        paras['formId'] = '<s:property value="form.formIdString"/>';
        paras['title'] = title;
        paras['comment'] = comment;
        paras['details'] = JSON.stringify(detailMap);
        $.post('api/new-progress', paras, function (data, status) {
            var progressId = data['progressId'];
            if (progressId == undefined || progressId == null || progressId == 0) {
                var errorMessage = data['error'];
                if (validateString(errorMessage)) {
                    $('#textInvalidProgress').html(errorMessage);
                } else {
                    $('#textInvalidProgress').html('服务器异常, 添加新纪录失败!');
                }
                $('#alertInvalidProgress').removeClass('hidden');
            } else {
                window.location.reload(true);
            }
        });
    }
    // Check a string
    function validateString(string) {
        return !(string == undefined || string == null || string.length == 0);
    }
</script>
<%--Modal: New Progress--%>
<div class="modal fade" id="newProgressModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">添加受理记录</h4>
            </div>
            <div class="modal-body">

                <div id="alertInvalidProgress" class="alert alert-danger alert-dismissible hidden" role="alert">
                    <button type="button" class="close"
                            onclick="$('#alertInvalidProgress').addClass('hidden')"><span>&times;</span></button>
                    <p id="textInvalidProgress"></p>
                </div>

                <div class="form-group">
                    <label for="inputTitle">标题</label>
                    <input class="form-control" type="text" id="inputTitle" placeholder="请输入受理内容..."/>
                </div>

                <div class="form-group">
                    <label for="inputComment">描述信息</label>
                    <textarea class="form-control" rows="3" id="inputComment" placeholder="请输入受理情况描述..."></textarea>
                </div>

                <div id="groupDetails">
                </div>

                <div class="form-group">
                    <button type="button" class="btn btn-default" onclick="newDetail()">
                        <span class="glyphicon glyphicon-plus"></span>
                        添加属性
                    </button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="submitNewProgress()">完成</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
