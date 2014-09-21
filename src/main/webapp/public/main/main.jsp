<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template</title>


<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/stylesheet.css">

<script src="/resources/js/jquery-1.9.1.min.js"></script>
</head>

<body>
	<div class="container">
		<div id="header"></div>
		<div id="content">
			<div id="main">
				<tiles:insertAttribute name="body" />
			</div>
			<div id="sidebar">
				<tiles:insertAttribute name="sidebar" />
			</div>
		</div>
		<div id="footer">
			<p id="legal">Copyright &copy; 2014</p>
		</div>
	</div>

	<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>




