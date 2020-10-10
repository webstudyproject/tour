<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		
<style>
  <style>
    html,
    body {
      position: relative;
      height: 100%;
    }

    body {
      background: #eee;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color: #000;
      margin: 0;
      padding: 0;
    }

    .swiper-container {
      width: 100%;
      height: 500px;

    }

    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;

      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
    
    .Tour_box{
      width:100%;
      height:100%;
      text-align: center;
      
    }
    .box_way{
    	width:80%;
    	height:400px;
    	margin:0 auto;
    	background-color:coral;
    }
    .Tour{
    	display: inline-block;
    	margin-top:150px;
    }

    .Tour.start_item{
    	
    }
    
    .Tour.end_item{
    	
    }
    
    .Tour.search_btn{
		
	}
	
	.search_input {
	  width: 300px;
	  padding: 12px 20px;
	  margin: 8px 0;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	

	
	#search_btn{
		
	}
	
	.map_div{
		width:80%; 
		margin:0 auto;
	}
	
	.ad_1{
		width:80%;
		height:800px;
		background-color:blue; 
		margin:0 auto; 
	}
	.ad_2{
		width:80%;
		height:800px;
		background-color:yellow;
		margin:0 auto; 
	}

</style>

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6bb59bbd75b137acb6934d0bfcd41172&libraries=services"></script>
 <!-- Swiper JS -->
 <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<!-- BODY  -->
<body onload="initTmap();">
<!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide">Slide 1</div>
      <div class="swiper-slide">Slide 2</div>
      <div class="swiper-slide">Slide 3</div>
      <div class="swiper-slide">Slide 4</div>
      <div class="swiper-slide">Slide 5</div>
      <div class="swiper-slide">Slide 6</div>
      <div class="swiper-slide">Slide 7</div>
      <div class="swiper-slide">Slide 8</div>
      <div class="swiper-slide">Slide 9</div>
      <div class="swiper-slide">Slide 10</div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </div>

 <!--  여행 searchTab -->
	<div class="Tour_box" style="">
		<div class = "box_way">
	 		<div class = "Tour start_item" style="">
		 		<span class="tit">출발지</span>
		 		<input type = 'text' class='search_input' placeholder="출발지를 입력해 주세요."></input>
		 	</div>
	 	
	 		<div class = "Tour end_item" style="">
		 		<span class="tit">도착지</span>
		 		<input type='text' class=search_input placeholder="도착지를 입력해 주세요."></input>
	 		</div>
	 	
	 	
		 	<div class= "Tour search_btn" style="">
		 		<button type="button" class = "btn btn-primary" id="search_btn">추천</button>
		 		<button type="button" class = "btn btn-primary" id="delete_btn">초기화</button>
		 	</div>
		 </div>
	
		

	 	<!-- Tmap지도 -->
		<div class ="map_div" style = "">
	     	  <!-- 190430 기존 지도를 모두 이미지 처리 위해 주석 처리 S -->
	      <div id="map_wrap" class="map_wrap3">
	         <div id="map_div"></div>
	      </div>
	      <div class="map_act_btn_wrap clear_box"></div>
	      	<p id="result"></p>
	   	</div>
	   	
	   	
		   	<!-- 광고1 -->
		<div class = "ad_1" style="">
			<b style="color:black; font-size:30px">광고1</b>
			<hr>
		</div>
		
		<!-- 광고2 -->
		<div class = "ad_2" style="">
			<b style="color:black; font-size:30px">광고2</b>
			<hr>
		</div>
	</div>		






		
	 <!--  카카오 Maps 
	<div id="map" style="width:500px;height:400px; display: none;" ></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6bb59bbd75b137acb6934d0bfcd41172"></script>
		<script>
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(33.450701, 126.570667),
				level: 3
			};
		
			var map = new kakao.maps.Map(container, options);
		</script>
	
	</div> 



<!-- 위치기반 검색 페이지 버튼/ 디테일검색페이지 이동 버튼-->
<!--  
<div class ="search_btn_div">
	
	<button id = "location_btn" type="button" class="btn btn-primary" onclick="location.href='detailPage'">위치기반 검색 페이지 버튼</button>

	<button id = "datailPage_btn" type="button" class="btn btn-primary" onclick="location.href=''" >디테일검색페이지 이동 버튼</button>
	
</div>
-->


<!-- JS  -->
<!-- 경로를 보여주는 지도JS  -->
<script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx677a71e26da643e3bbc8f61c8901a646"></script>
<script type="text/javascript">
   var map;
   var marker_s, marker_e, marker_p1, marker_p2;
   var totalMarkerArr = [];
   var drawInfoArr = [];
   var resultdrawArr = [];
   
   function initTmap() {
      // 1. 지도 띄우기
      map = new Tmapv2.Map("map_div", {
         center : new Tmapv2.LatLng(37.570028, 126.989072),
         width : "100%",
         height : "400px",
         zoom : 15,
         zoomControl : true,
         scrollwheel : true
      });

      // 2. 시작, 도착 심볼찍기
      // 시작
      marker_s = new Tmapv2.Marker(
            {
               position : new Tmapv2.LatLng(37.56689860, 126.97871544),
               icon : "http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_s.png",
               iconSize : new Tmapv2.Size(24, 38),
               map : map
            });

      // 도착
      marker_e = new Tmapv2.Marker(
            {
               position : new Tmapv2.LatLng(37.57081522, 127.00160213),
               icon : "http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_e.png",
               iconSize : new Tmapv2.Size(24, 38),
               map : map
            });

      // 3. 경로탐색 API 사용요청
      $
            .ajax({
               method : "POST",
               url : "https://apis.openapi.sk.com/tmap/routes/pedestrian?version=1&format=json&callback=result",
               async : false,
               data : {
                  "appKey" : "l7xx677a71e26da643e3bbc8f61c8901a646",
                  "startX" : "126.97871544",
                  "startY" : "37.56689860",
                  "endX" : "127.00160213",
                  "endY" : "37.57081522",
                  "reqCoordType" : "WGS84GEO",
                  "resCoordType" : "EPSG3857",
                  "startName" : "출발지",
                  "endName" : "도착지"
               },
               success : function(response) {
                  var resultData = response.features;

                  //결과 출력
                  var tDistance = "총 거리 : "
                        + ((resultData[0].properties.totalDistance) / 1000)
                              .toFixed(1) + "km,";
                  var tTime = " 총 시간 : "
                        + ((resultData[0].properties.totalTime) / 60)
                              .toFixed(0) + "분";

                  $("#result").text(tDistance + tTime);
                  
                  //기존 그려진 라인 & 마커가 있다면 초기화
                  if (resultdrawArr.length > 0) {
                     for ( var i in resultdrawArr) {
                        resultdrawArr[i]
                              .setMap(null);
                     }
                     resultdrawArr = [];
                  }
                  
                  drawInfoArr = [];

                  for ( var i in resultData) { //for문 [S]
                     var geometry = resultData[i].geometry;
                     var properties = resultData[i].properties;
                     var polyline_;


                     if (geometry.type == "LineString") {
                        for ( var j in geometry.coordinates) {
                           // 경로들의 결과값(구간)들을 포인트 객체로 변환 
                           var latlng = new Tmapv2.Point(
                                 geometry.coordinates[j][0],
                                 geometry.coordinates[j][1]);
                           // 포인트 객체를 받아 좌표값으로 변환
                           var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(
                                 latlng);
                           // 포인트객체의 정보로 좌표값 변환 객체로 저장
                           var convertChange = new Tmapv2.LatLng(
                                 convertPoint._lat,
                                 convertPoint._lng);
                           // 배열에 담기
                           drawInfoArr.push(convertChange);
                        }
                     } else {
                        var markerImg = "";
                        var pType = "";
                        var size;

                        if (properties.pointType == "S") { //출발지 마커
                           markerImg = "http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_s.png";
                           pType = "S";
                           size = new Tmapv2.Size(24, 38);
                        } else if (properties.pointType == "E") { //도착지 마커
                           markerImg = "http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_e.png";
                           pType = "E";
                           size = new Tmapv2.Size(24, 38);
                        } else { //각 포인트 마커
                           markerImg = "http://topopen.tmap.co.kr/imgs/point.png";
                           pType = "P";
                           size = new Tmapv2.Size(8, 8);
                        }

                        // 경로들의 결과값들을 포인트 객체로 변환 
                        var latlon = new Tmapv2.Point(
                              geometry.coordinates[0],
                              geometry.coordinates[1]);

                        // 포인트 객체를 받아 좌표값으로 다시 변환
                        var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(
                              latlon);

                        var routeInfoObj = {
                           markerImage : markerImg,
                           lng : convertPoint._lng,
                           lat : convertPoint._lat,
                           pointType : pType
                        };

                        // Marker 추가
                        marker_p = new Tmapv2.Marker(
                              {
                                 position : new Tmapv2.LatLng(
                                       routeInfoObj.lat,
                                       routeInfoObj.lng),
                                 icon : routeInfoObj.markerImage,
                                 iconSize : size,
                                 map : map
                              });
                     }
                  }//for문 [E]
                  drawLine(drawInfoArr);
                  postArray(drawInfoArr);
                  
                 // console.log(drawInfoArr);

                  
                  
               },
               error : function(request, status, error) {
                  console.log("code:" + request.status + "\n"
                        + "message:" + request.responseText + "\n"
                        + "error:" + error);
               }
               
            });

   }

   function postArray(arrPoint) {
	   console.log(arrPoint)
	   $.ajax({
		  url : '/app/arr/',
		  type : 'POST',
		  dataType : "JSON",
		  contentType : "application/json",
		  data : JSON.stringify(arrPoint),
		  sccess : function(){
			  console.log("성공");
		  },error : function(){
			  console.log('실패')
		  }
	   });
   }
   
   function addComma(num) {
      var regexp = /\B(?=(\d{3})+(?!\d))/g;
      return num.toString().replace(regexp, ',');
   }
   
   function drawLine(arrPoint) {
      var polyline_;

      polyline_ = new Tmapv2.Polyline({
         path : arrPoint,
         strokeColor : "#DD0000",
         strokeWeight : 6,
         map : map
      });
      resultdrawArr.push(polyline_);
   }
   
</script>

  <!--카카오맵 행선지 검색 JS -->
	<script>
		$(function(){
			$('#box_btn').click(function(){
				if($('#map').css('display') == 'none'){
					$('#map').css('display', 'block');
				}
			});
		});
	</script>



</body>
</html>