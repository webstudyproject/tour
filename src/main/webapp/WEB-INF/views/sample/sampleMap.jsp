<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지도 생성하기</title>
<!-- <script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script> -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d4010f350f5b0bab59888418f9242c38"></script>
<!-- 
https://map.kakao.com/?sName=구로역&eName=신도림역
 -->
<script>
	window.onload = function() {
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		//지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
	}
</script>

</head>


<body>
	<!-- 지도를 표시할 div 입니다 -->
	<!-- <div id="map" style="width: 100%; height: 600px;"></div> -->
	<div>하핫</div>
	<iframe src="https://map.kakao.com/?sName=역곡역 1호선&eName=르하임스터디카페 역곡역점(2020년9월6일까지 휴업)" 
		width="70%" height="800" 
		frameborder="0" style="border:0; zoom:50%" allowfullscreen>
	</iframe>

</body>



</html>

