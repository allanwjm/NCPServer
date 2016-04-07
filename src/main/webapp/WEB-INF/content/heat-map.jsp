<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>

    <title>噪声黑点图</title>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=KB0GPScR2Ivm6skk4CIIZF3g6GZG1dIy"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
    <style type="text/css">
        ul, li {
            list-style: none;
            margin: 0;
            padding: 0;
            float: left;
        }

        html {
            height: 100%
        }

        body {
            height: 100%;
            margin: 0px;
            padding: 0px;
            font-family: "微软雅黑";
        }

        #container {
            height: 100%;
            width: 100%;
        }

    </style>

</head>
<body>
<div id="container"></div>
</body>
</html>

<script type="text/javascript">
    var map = new BMap.Map("container");
    <!--地图初始中心点-->
    var center = new BMap.Point(116.418261, 39.921984);
    <!--设置中心点坐标和地图级别-->
    map.centerAndZoom(center, 15);
    <!--允许滚轮缩放-->
    map.enableScrollWheelZoom();
    <!--设置地图控件-->
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.MapTypeControl());
    map.addControl(new BMap.GeolocationControl());

    <!--检查浏览器是否能够使用热力图-->
    function isSupportCanvas() {
        var elem = document.createElement('canvas');
        return !!(elem.getContext && elem.getContext('2d'));
    }

    <!--检查浏览器是否能够使用热力图-->
    if (!isSupportCanvas()) {
        alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~');
    }

    <!--开始显示热力图-->
    var points = <s:property value="pointList" escape="false"/>;
    heatmapOverlay = new BMapLib.HeatmapOverlay({
        "radius": 20
    });
    map.addOverlay(heatmapOverlay);
    heatmapOverlay.setDataSet({
        data: points,
        max: 120
    });
    var gradient = {
        '0': 'rgb(128, 128, 128)',
        '0.5': 'rgb(64, 64, 64)',
        '1': 'rgb(0, 0, 0)'
    };
    heatmapOverlay.setOptions({
        "gradient": gradient
    });
</script>