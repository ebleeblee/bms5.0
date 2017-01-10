<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">

<title>BMS</title>
<!-- for fullcalendar -->
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css" />
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css" media="print"/>
				
<link href="${contextPath}/resources/bootstrap-3.0.3-dist/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<link href="${contextPath}/resources/bootstrap-3.0.3-dist/css/sticky-footer-navbar.css" rel="stylesheet">

<!-- eblee css -->
<link href="${contextPath}/resources/eblee/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/eblee/css/justified-nav.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/eblee/css/navbar.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/eblee/css/bootstrap-select.css" rel="stylesheet">
<link href="${contextPath}/resources/eblee/css/style.css" rel="stylesheet">
<!-- 달력관련 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<!--/.eblee css -->

<!-- eblee datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="${contextPath}/resources/demos/style.css">

<!--/. eblee datepicker -->


<!--  Modal 2016.08.06 hw.park 추가-->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
</head>
<body>
	<!-- Wrap all page content here -->
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		
		<!-- Begin page content -->
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<tiles:insertAttribute name="footer" />

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	
	<!-- date picker -->
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<!-- 2016.08.19 hwpark 페이징처리 --> 
	<script src="${contextPath}/resources/js/bmsquery.js"></script>
	
</body>
</html>
