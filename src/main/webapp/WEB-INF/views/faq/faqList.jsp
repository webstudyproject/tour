<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel='stylesheet' href='../../resources/css/bootstrap.css'> -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<style>
/* 탭 */
.w-max {
	max-width: 1280px;
	margin: 0 auto;
}

.tab-menu {
	position: relative;
	padding: 0;
	background: #fff;
}

.tab-menu ul {
	position: relative;
	width: 100%;
	display: table;
	border: 1px solid #ddd;
	border-bottom: 0;
	padding-inline-start: 0px !important;
}

.tab-menu ul>li {
	position: relative;
	display: table-cell;
	height: 5.3rem;
	vertical-align: middle;
	border-left: 1px solid #ddd;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

.tab-menu ul>li a {
	position: relative;
	display: block;
	width: 100%;
	max-height: 5.3rem;
	padding: 5px 15px;
	text-align: center;
	font-size: 15px;
	cursor: pointer
}

.tab-menu ul>li a>span {
	position: relative;
	display: inline-block;
	height: 100%;
}

.tab-menu ul>li:first-child {
	border-left: 0;
}

.tab-menu ul>li.active {
	border-bottom: 0;
}

.tab-menu ul>li.active a {
	border-bottom: 1px solid transparent;
	font-weight: bold;
	color: #333;
}

.tab-menu ul>li.active:before {
	display: block;
	content: '';
	position: absolute;
	z-index: 1;
	top: -1px;
	left: -1px;
	width: calc(100% + 2px);
	height: 2px;
	background: #da291c;
}

/* 리스트 */
.faq-list {
	max-width: 1280px;
	margin: 0 auto;
}

.faq-list>ul {
	border-top: 1px solid #333333;
	list-style: none;
	padding-inline-start: 0px !important;
}

.faq-list>ul>li {
	border-bottom: 1px solid #eeeeee;
}

.faq-list>ul>li>div {
	position: relative;
}

.faq-list .question a {
	font-size: 16px;
	color: #333333;
	font-weight: 800;
	display: block;
	padding: 30px 100px 30px 108px;
}

.faq-list .question {
	width: 100%
}

.faq-list .answer {
	padding: 50px 100px 50px 108px;
	font-size: 16px;
	background: #fbfbfb;
	display: none;
	line-height: 1.4em
}

.total {
	max-width: 1280px;
	margin: 0 auto;
	font-size: 20px;
	color: #333;
}

.total em {
	color: #da291c;
	font-weight: 700;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {

		$('#btnT').on('click', function() {

		});

	});

	function queClick(obj) {
		//$(".answer").css("display","none");
		var disVal = $("#" + obj).css("display");
		if (disVal == "none") {
			$("#" + obj).css("display", "block");
		} else if (disVal == "block") {
			$("#" + obj).css("display", "none");
		} else {
			$("#" + obj).css("display", "none");
		}
	}

	function tabClick(cd) {
		tabAct(cd);
		$
				.ajax({
					url : "/ajaxFaqList.do",
					type : "POST",
					data : {
						"catCd2" : cd
					},
					ansy : true,
					//dataType : 'JSON',
					success : function(data) {
						var htmlStr = "";
						var results = data.list;
						$.each(
								results,
								function(index) {
									//	질
									htmlStr += "<ul style='padding-inline-start: 0px !important;'";
									htmlStr += "<li style='list-style: none; border-bottom: 1px solid #eeeeee;'>";
									htmlStr += "<div class='question'>";
									htmlStr += "<a href='javascript:queClick("
											+ results[index].id + ")'>";
									htmlStr += results[index].que
											+ "</a>";
									htmlStr += "</div>";
									//	답
									htmlStr += "</li>";
									htmlStr += "<li style='list-style: none;'>";
									htmlStr += "<div class='answer' id='" + results[index].id + "'>";
									htmlStr += "<span class='ansTxt'>"
											+ results[index].answer
											+ "</span>";
									htmlStr += "</div>";
									htmlStr += "</li>";
								});
						$(".faq-list").html(htmlStr);
						$("#totCnt").text(results.length); 
					}, //	end success
					error : function() {
						console.log("error...!");
					}
				}); //	end ajax

	}
	function tabAct(cd) {
		$(".ui-tab").children().attr('class', 'non-active');
		$("#tab" + cd).attr('class', 'active');
	}
</script>

</head>

<body>
	<h1>#FFFFFF</h1>

	<div class="tab-menu col-9 responsive-scroll w-max" id="tab-scroll"
		style="touch-action: pan-y pinch-zoom;">
		<div class="scroller"
			style="transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);">
			<ul class="ui-tab">

				<c:forEach var="tab" items="${tabList}">
					<li id="tab${tab.catCd2 }" class="non-active"><a
						href="javascript:tabClick('${tab.catCd2 }');"><span>${tab.catNm2 }</span></a></li>
				</c:forEach>

			</ul>
		</div>
	</div>

	<div class="total">
		총 <em id="totCnt">${total }</em>건
	</div>

	<div id="outer">
		<div class="faq-list">
			<ul>
				<c:forEach var="faq" items="${faqList}">
					<li>
						<div class="question">
							<a href="javascript:queClick('${faq.id }')">${faq.que }</a>
						</div>
					</li>

					<li>
						<div class="answer" id="${faq.id }">
							<span class="ansTxt">${faq.answer }</span>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>