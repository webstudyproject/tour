<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 여행지 검색   -->
<div class = "Tour_searche_div" style="width:80%;height:800px;background-color:coral; margin:0 auto; ">
	
	<div id = "location_search_div" style="width:;height:40%;">
		<b style="color:black; font-size:30px">지역기반검색</b>
		<hr>
		<br><br><br>
		
		<form style="margin:0 auto; width:500px; background-color:white;">
		  <!-- 지역 Select bar -->
		  <div class = "div_select" style = "float: left">
		  <label for="location">지역:</label>
		  <select name="location" id="location">
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
		  
		  <div class = "div_select"style="float: right">
		  <!-- 관광타입 Select bar -->
		  <label for="tour_type">관광타입:</label>
		  <select name="tour_type" id="tour_type">
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
		  <input type="submit" value="Submit" style=" display : block; margin:0 auto; width:200px">
		</form>
	</div>
	
</div>
</body>
</html>