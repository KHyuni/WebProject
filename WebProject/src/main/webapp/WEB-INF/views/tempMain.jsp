<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/tempMain.css" media="screen"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/tempMain.js"></script>
<title></title>
</head>

<body style="width: 98%;">

<div id="wrap" style="width: 1000px; margin: 0 auto 0 auto;">
		<form action="login" method="post">
			<div id="loginArea">
				<ul class="loginBox">
					<li>
						아이디 :&nbsp;&nbsp;<input type="text" id="userId" name="userId" size="15">&nbsp;
						패스워드 :&nbsp;&nbsp;<input type="password" id="userPwd" name="userPwd" size="15"/>&nbsp;&nbsp;
						<input type="submit" value="로그인"/>
					</li>
				</ul>&nbsp;&nbsp;&nbsp;&nbsp;
				<ul class="linkArea">
					<li>
						<p><a href="/web/signUp">회원가입</a></p>
					</li>
				</ul>
			</div>
		</form>	
		
		<h1>Spring Web Project Main Page</h1>
		
		<ul id="navigation">
			<li class="one selected"><a href="#home">Home</a></li>
			<li class="two"><a href="#freeBoard">자유게시판</a></li>
			<li class="three"><a href="#picture">사진게시판</a></li>
			<li class="four"><a href="#guestBoard">방명록</a></li>
			<li class="five"><a href="#QNA">Q&A</a></li>
			<li class="shadow"></li>
		</ul>
		
		<div id="content">
			<div id="home">
					<p>
						1994년 캐나다 몬트리올의 마약 재활 센터를 나온 25살 청년 수루시 앨비는 
						친구 개빈 맥긴스를 찾아가 자신이 구상한 새로운 잡지에 관한 아이디어를 들려준다. 
						이를 들은 개빈 맥긴스는 유럽에 거주 중인 불알친구 셰인 스미스를 데려온다. 마약, 
						교도소 생활, 펑크 음악 등을 다루는 16쪽짜리 무가지 ‘몬트리올의 소리(Voice of Montreal)’는 
						그해 10월 세 사람의 합작품으로 탄생한다. 발행은 아이티 출신 이민자 알릭스 로랑이 맡았다. 
						당시 몬트리올시가 진행하던 이민자 지원 프로그램의 혜택을 받기 위해서였다. 
						세 사람의 급여는 몬트리올시의 지원금으로 충당했다. 셰인 스미스는 광고 영업을 담당했는 데, 
						그가 따온 광고비는 잡지 출판 비용으로 쓰였다. 1995년 세 사람은 부모로부터 1만 5,000달러를 빌려 
						‘몬트리올의 소리’를 발행인으로부터 인수하고 ‘보이스(Voice)’로 잡지 이름을 줄인다. 
						이듬해 다시 ‘오(o)’를 떼어낸다. 우리가 아는 그 ‘바이스(Vice)’는 이렇게 탄생한다.
					</p>
			</div>
		</div>
</div>
</body>
</html>