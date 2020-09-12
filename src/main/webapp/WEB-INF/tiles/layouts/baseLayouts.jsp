<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<style>
#baseHeader {
	width: 100%;
	height: 50px;
	text-align: center;
	background-color: #00D8FF;
}

#baseNavigation {
	float: left;
	width: 15%;
	background-color: #5CD1E5;
}

#baseContents {
	float: left;
	width: 85%;
	background-color: #FFFFFF;
}

#baseFooter {
	width: 100%;
	height: 50px;
	text-align: center;
	background-color: #B2EBF4;
	clear: both;
}
#baseNavigation, #baseContents{
     min-height: 600px;
}
</style>

<meta charset="UTF-8">
<title>baseLayouts</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<div id="baseHeader">
		<tiles:insertAttribute name="baseHeader" />
	</div>
	<div id="baseNavigation">
		<tiles:insertAttribute name="baseNavigation" />
	</div>
	<div id="baseContents">
		<tiles:insertAttribute name="baseContents" />
	</div>
	<div id="baseFooter">
		<tiles:insertAttribute name="baseFooter" />
	</div>

</body>
</html>