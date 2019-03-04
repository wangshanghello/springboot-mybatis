<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="https://cdn.bootcss.com/echarts/4.1.0.rc2/echarts.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/monitor.js"></script>
    <script src="<%=request.getContextPath() %>/code/highcharts.js"></script>
    <script src="<%=request.getContextPath() %>/code/modules/exporting.js"></script>
    <script src="<%=request.getContextPath() %>/code/modules/export-data.js"></script>

    <link href="<%=request.getContextPath() %>/css/dynamic.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        $(function () {
            //饼状图
            renderChartBar01();
            /*setInterval(function () {
                renderChartBar01();
            }, 10000);*/
            //质量监测
            renderLayer03Right();
            setInterval(function () {
                renderLayer03Right();
            }, 2000);

            //围护墙顶竖向位移
            loadTwoLine();
            /*setInterval(function () {
                loadTwoLine();
            }, 10000);*/

            //报警
            baojing();
            setInterval(function () {
                baojing();
            }, 2000);

            setInterval(function () {
                $.post("updateRetaining", {}, function data() {
                })
            }, 10000);
        });

    </script>
    <title>建设工程·大数据运维总览图</title>
    <style type="text/css">
        .val {
            color: white;
            font-size: 20px;
            position: absolute;
            top: 100px;
            left: 45px;
        }
    </style>
</head>
<body style="width: 100%;height: 100%">
<div class="main">
    <div style="color: white;text-align: center"><h2>建设工程·大数据总览图</h2></div>
    <div id="layer03" class="layer" style="height:40%;">
        <div id="layer03_left" style="width:33%;" class="layer03-panel">
            <div id="layer03_left_label01" class="layer03-left-label">监测项目报警状态</div>
            <div style="position: absolute;top: 40px;left: 10px">
                <div style="width: 25px;height: 15px;background-color: #06B535;border-radius:3px 3px 3px 3px;"></div>
                <span style="color: white;font-size: 13px;">正常</span>
                <div style="width: 25px;height: 15px;background-color: red;border-radius:3px 3px 3px 3px;"></div>
                <span style="color: white;font-size: 13px;">警报</span>

            </div>
            <div id="baojing" style="height: 100%;width:100%"></div>
        </div>
        <div id="layer033_left" style="width:30%;" class="layer03-panel">
            <div id="layer03_left_label01" class="layer03-left-label">项目占比</div>
            <div id="layer03_left_01" class="layer03-left-chart" style="width:16%;">
                <canvas width="100" height="200" style="margin:30px 0 0 20px;"></canvas>
            </div>
            <div id="layer03_left_02" class="layer03-left-chart" style="width:80%; position: absolute; top: -40px;"></div>
        </div>
        <div id="layer03_right" style="width:33%;" class="layer03-panel">
            <div id="layer03_right_label">质量监测</div>
            <div id="layer03_right_chart01" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div id="maxvalue" class="val"></div>
                <div class="layer03-right-chart-label">累计最大值</div>
            </div>
            <div id="layer03_right_chart02" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div id="maxbj" class="val"></div>
                <div class="layer03-right-chart-label">报警值</div>
            </div>
            <div id="layer03_right_chart03" class="layer03-right-chart">
                <canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
                <div id="maxsl" class="val"></div>
                <div class="layer03-right-chart-label">最大变化速率</div>
            </div>
            <%--
                           <iframe id="mFrame" name="mFrame"  border="0" width="100%" src="" height="300px" frameborder="no"></iframe>
            --%>

        </div>
    </div>
    <div id="layer04" class="layer" style="height:33%;">
        <div id="layer04_right" class="layer04-panel" style="width:39%;">
            <div id="layer04_right_label" class="layer04-panel-label">
                <span>围护墙顶竖向位移</span>
            </div>
            <div id="layer04_right_chart" class="layer04-panel-chart"></div>
        </div>
        <div id="layer04_left" class="layer04-panel" style="width:60%;">
            <div id="layer04_left_label" class="layer04-panel-label">围护墙顶竖向位移</div>
            <!--<div id="layer04_left_chart" class="layer04-panel-chart"></div>-->
            <div id="container"></div>
        </div>


    </div>

    <!-- 动态折线图-->
    <script src="<%=request.getContextPath() %>/js/dynamic.js"></script>

</div>
</body>
</html>
