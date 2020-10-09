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
		HttpSession s = request.getSession();
		String userId = (String) s.getAttribute("userId");  
		// 여기서 session에 id가 없으면 login 페이지로 넘김
	%>
	
	<!-- 출처: https://webdir.tistory.com/433 [WEBDIR] -->
	<div class="container">
		<form id="writeForm">
			<input type="hidden" name="userId" value="<%=userId %>" />
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2"
							style="background-color: #eeeeee; text-align: center;"> 게시판 글쓰기 양식 </th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label class="radio-inline"> <input type="radio"
								name="boardType" id="boardType1" value="1">
								공지사항
						</label>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<label class="radio-inline"> <input type="radio"
								name="boardType" id="boardType2" value="2">
								맛집추천
						</label></td>
					</tr>
					<tr>
						<td><input type="text" class="form-control"
							placeholder="글 제목" name="title" maxlength="50" /></td>
					</tr>
					<tr>
						<td><textarea class="form-control" placeholder="글내용"
								name="content" maxlength="2048" style="height: 350px;"></textarea></td>
					</tr>
				</tbody>
			</table>
			<button type="button" class="btn btn-primary pull-right"> 글쓰기 </button>
		</form>
		<br> <br> <br>
	</div>



	<!-- : https://tbbrother.tistory.com/70  -->
</body>
<script>

	function getObject(writeForm) {
		let boardTypeId;
		for (index in writeForm["boardType"]){
			if (writeForm["boardType"][index].checked){
				boardTypeId = writeForm["boardType"][index].value;
			}
		}
		return {
			postBoardTypeId : boardTypeId,
			postTitle : writeForm["title"].value,
			postMemberId : writeForm["userId"].value,
			postNotifyFlag : false,
			postHitsNumber : 0,
			postContent : {
				postBoardTypeId : boardTypeId,
				postContent : writeForm["content"].value
			}
		};
	}
	

	function validation(writeForm) {
		if (writeForm["title"].value === ""){
			alert("글 제목을 입력해주세요");
			return false;
		}
		else if (writeForm["content"].value === ""){
			alert("글 내용을 입력해주세요");
			return false;
		}
		
		for (index in writeForm["boardType"]){
			if (writeForm["boardType"][index].checked){
				return true;
			}
		}
		alert("게시판 종류를 선택해주세요");
		return false;
	}
	
	postJSON = function(url,data){
	    return $.ajax({url:url,data:JSON.stringify(data), type:'POST', contentType:'application/json'});
	};
	
	window.addEventListener('DOMContentLoaded', function() {
		const button = document.getElementsByClassName("btn")[0];

		button.addEventListener('click', function (event) {
			const writeForm = document.getElementById("writeForm");
			if (validation(writeForm) === false){
				return;
			}
			const postObject = getObject(writeForm);
			
			postJSON('/app/post/', postObject)
			.done(function() {
				alert("게시물 작성 완료");
				location.href="/app/post/page?boardType=" + postObject.postBoardTypeId;
			})
			.fail(function(){
				alert("게시물 작성 실패");
			})
/* 			 https://stackoverflow.com/questions/2845459/jquery-how-to-make-post-use-contenttype-application-json */
 		})
	})

	
</script>
</html>