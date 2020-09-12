<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<style>

/* #baseNavigation { */
/* 	float: left; */
/* 	width: 15%; */
/* 	background-color: #5CD1E5; */
/* } */

	footer{
    	left: 0;
    	bottom: 0;
    	width: 100%;
		padding: 15px 0;
		text-align: center;
		color: white;
		background: blue;
	}
</style>

<meta charset="UTF-8">
<title>baseLayouts</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

	<header>
		<tiles:insertAttribute name="baseHeader" />
	</header>
	<nav>
		<tiles:insertAttribute name="baseNavigation" />
	</nav>
	<section>
		<tiles:insertAttribute name="baseContents" />
	</section>
	<footer>
		<tiles:insertAttribute name="baseFooter" />	
	</footer>
</body>



</html>