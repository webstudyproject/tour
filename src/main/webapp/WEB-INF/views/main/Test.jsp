<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.Tour_searche_div{
		width:80%;
		height:800px;
		background-color:coral;
		margin:0 auto;
	}
	
	.location_search_div{
		width:;height:40%;
	}
	
	.search_Text{
		color:black; 
		font-size:30px
	}
	
	.search_div{
		background-color :black;
	}

	.search_form{
		margin:0 auto; 
		width:800px; 
		background-color:white;
	}
	
	.left_div_select{
		float: left
	}
	
	.select_location{
		width:200px
	}
	
	.right_div_select{
		float: right
	}
	
	.select_tour_type{
		width:200px
	}
	
	.search_submit_btn{
		 display : block; 
		 margin:0 auto; 
		 width:200px
	}
	

</style>
</head>
<body>
	<!-- 여행지 검색   -->
<div class = "Tour_searche_div">
	<div class = "location_search_div">
		<b class = "search_Text">지역기반검색</b>
		<hr>
		<br><br><br>
		<div class = "search_div">
			<form class ="search_form">
			  <!-- 지역 Select bar -->
			  <div class = "left_div_select">
			  <label for="location" >지역:</label>
			  <select class = "select_location " name="location" id="location">
			  	<option value="" selected disabled hidden></option>
			    <option value="1">서울</option>
			    <option value="2">인천</option>
			    <option value="3">대전</option>
			    <option value="4">대구</option>
			    <option value="5">광주</option>
			    <option value="6">부산</option>
			    <option value="7">울산</option>
			    <option value="8">세종특별자치시</option>
			    <option value="31">경기도</option>
			    <option value="32">강원도</option>
			    <option value="33">충청북도</option>
			    <option value="34">충청남도</option>
			    <option value="35">경상북도</option>
			    <option value="36">경상남도</option>
			    <option value="37">전라북도</option>
			    <option value="38">전라남도</option>
			    <option value="39">제주도</option>
			  </select>
			  </div>
			  
			  <div class = "right_div_select">
			  <!-- 관광타입 Select bar -->
			  <label for="tour_type" >관광타입:</label>
			  <select class="select_tour_type" name="tour_type" id="tour_type">
			  	<option value="" selected disabled hidden></option>
			    <option value="12">관광지</option>
			    <option value="14">문화시설</option>
			    <option value="15">축제공연행사</option>
			    <option value="25">여행코스</option>
			    <option value="28">레포츠</option>
			    <option value="38">쇼핑</option>
			    <option value="32">숙박</option>
			    <option value="39">음식점</option>
			  </select>
			  </div>
			  
			  <br><br>
			  <input class="search_submit_btn" type="submit" value="Submit">
			</form>
		</div>
	</div>
	
</div>
</body>
</html>