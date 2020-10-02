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
	.search_input {
	  width: 500px;
	  padding: 12px 20px;
	  margin: 8px 0;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	.search_btn_div{
		width:80%;
		height:400px;
		background-color:coral; 
		margin:0 auto;
		text-align: center;
	}
	.btn-primary{
		width:300px;
		height:50px;
		
	}
	
	#location_btn{
		margin: 0 auto;
		margin-top:200px;
	}
	
	#datailPage_btn{
		margin: 0 auto;
		margin-top:200px;
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

</head>
<body>
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


	
<!-- 행선지 검색 -->

<!-- 
<script>
	$(function(){
		$('#box_btn').click(function(){
			if($('#map').css('display') == 'none'){
				$('#map').css('display', 'block');
			}
		});
	});
</script>
	 여행 searchTab 
	<div class="Tour_box" style="width:100%;height:800px;">
		<div class = "box_way">
		 	<div class = "start_item" style="margin-left:15%; display:inline-block;">
		 		<span class="tit">출발지</span>
		 		<input type = 'text' class='search_input' placeholder="출발지를 입력해 주세요."></input>
		 	</div>
		 	
		 	<div class = "end_item" style="display:inline;">
		 		<span class="tit">도착지</span>
		 		<input type='text' class=search_input placeholder="도착지를 입력해 주세요."></input>
		 	</div>
		 	
		 	
		 	<div id = "box_btn" style="display:inline;">
		 		<button type="button" id="search_btn">추천</button>
		 	</div>
			
		</div>
		 카카오 Maps 
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
-->
<!-- 위치기반 검색 페이지 버튼/ 디테일검색페이지 이동 버튼-->
<div class ="search_btn_div">
	
	<button id = "location_btn" type="button" class="btn btn-primary" onclick="location.href='detailPage'">위치기반 검색 페이지 버튼</button>

	<button id = "datailPage_btn" type="button" class="btn btn-primary" onclick="location.href=''" >디테일검색페이지 이동 버튼</button>
	
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
	




  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      spaceBetween: 30,
      centeredSlides: true,
      autoplay: {
        delay: 2500,
        disableOnInteraction: false,
      },
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  </script>



</body>
</html>