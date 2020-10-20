<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.form-control {
	width: 500px;
	padding: 12px 20px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.has-feedback {
	margin: 10px 50px;
}

#container {
	margin: 50px 0;
}
</style>
<title>회원가입</title>
</head>

<body>
	<section id="container">
		<form action="/member/register" method="get">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디</label> 
				<input class="form-control" type="text" id="userId" name="userId" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userPasswd">패스워드</label> 
				<input class="form-control" type="password" id="userPasswd" name="userPasswd" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userName">이름</label> 
				<input class="form-control" type="text" id="userName" name="userName" />
			</div>
			<div class="form-group has-feedback">
				<button class="btn btn-reserve" type="submit" id="submit">회원가입</button>
				<button class="cancle btn btn-reserve" type="button">취소</button>
			</div>
		</form>
	</section>

</body>
<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				location.href = "/app";
			})
		
			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPasswd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPasswd").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("이름을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
				location.href = "/app";
			});
		})
	</script>
</html>