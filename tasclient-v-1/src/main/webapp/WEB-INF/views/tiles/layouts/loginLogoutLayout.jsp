<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link href="static/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="static/css/loginstyle.css"/>
 <link href="static/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/fonts/font-open/stylesheet.css">
<script type="text/javascript" src="static/js/jquery-v3.3.1.min.js"></script>
</head>

<body  class="dash-bg">
	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>
