<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%

	String userId = "admin"; 
	HttpSession s = request.getSession();
	if (s.getAttribute("userId") == null){
		s.setAttribute("userId", userId);
	}
	
%>
	<table class="table table-striped"> <!--  https://tworab.tistory.com/79?category=689942 -->
		<thead>
			<tr>
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 작성자 </th>
				<th> 날짜 </th>
				<th> 조회수 </th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<a class="btn btn-default pull-right" href="/app/post/write/page"> 글쓰기 </a>
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#"> 1 </a> </li>
			<li><a href="#"> 2 </a> </li>
			<li><a href="#"> 3</a> </li>
			<li><a href="#"> 4 </a> </li>
			<li><a href="#"> 5 </a> </li>
		</ul>
	</div>
	

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>

<script>

	const getParam = (sname) => {
		var params = location.search.substr(location.search.indexOf("?") + 1);

		params = params.split("&");
		temp = params[0].split("=");
		if ([temp[0]] == sname) {
			return temp[1];
		}
	}
	
	const init = (postList) => {
		function convertToDate(createDate) {
			const sysdate = new Date(createDate);
			return moment(sysdate).format('YYYY.MM.DD HH:mm:ss');
		}
		const table = document.getElementsByTagName('TABLE');
		
		for (const index in postList) {
			const row = table[0].insertRow(table[0].rows.length);
			row.insertCell(0).innerHTML = '<td>' + postList[index].postId + '</td>';
			row.insertCell(1).innerHTML = '<td>' + postList[index].postTitle + '</td>';
			row.insertCell(2).innerHTML = '<td>' + postList[index].postMemberId + '</td>';

			row.insertCell(3).innerHTML = '<td>' + convertToDate(postList[index].postCreateDate) + '</td>';
			row.insertCell(4).innerHTML = '<td>' + postList[index].postHitsNumber + '</td>';
		}
		
	}
 		
	window.addEventListener('DOMContentLoaded', function() {
		const boardType = getParam("boardType");
		if (boardType === "1"){
			alert('공지사항 게시판');
		}
		else if (boardType == "2"){
			alert("맛집추천 게시판");
		}
		
		$.get('/app/post/list', {boardType: boardType}, function(data) {
			console.log(data);
			init(data);
		});
		
	})

	
</script>
 <!--  <link rel="stylesheet" href="/app/resources/css/bootstrap.css"> --> 
	


</html>