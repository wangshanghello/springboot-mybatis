<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="https://cdn.bootcss.com/echarts/4.1.0.rc2/echarts.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/monitor.js"></script>
	<script src="<%=request.getContextPath() %>/code/highcharts.js"></script>
	<script src="<%=request.getContextPath() %>/code/modules/exporting.js"></script>
	<script src="<%=request.getContextPath() %>/code/modules/export-data.js"></script>
	<link href="<%=request.getContextPath() %>/css/dynamic.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
        $(function () {
            renderLayer03Right();
        })
	</script>
</head>
<body>
<div class="main">

	<div id="layer03_right_label">质量监测</div>
	<div id="layer03_right_chart01" class="layer03-right-chart">
		<canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
		<div class="layer03-right-chart-label">累计最大值</div>
	</div>
	<div id="layer03_right_chart02" class="layer03-right-chart">
		<canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
		<div class="layer03-right-chart-label">报警值</div>
	</div>
	<div id="layer03_right_chart03" class="layer03-right-chart">
		<canvas width="130" height="150" style="margin:40px 0 0 20px;"></canvas>
		<div class="layer03-right-chart-label">最大变化速率</div>
	</div>-
</div>
</body>
</html>