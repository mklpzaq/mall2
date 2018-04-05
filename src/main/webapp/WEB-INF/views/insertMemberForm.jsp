<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<form class="form-inline" method="post" action="${pageContext.request.contextPath}/insertMemberForm">
		<div class="form-group">
			<label for="exampleInputEmail2">MemberId</label>
			<input type="text" class="form-control" id="memberId" name="memberId" placeholder="memberId">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">MemberPw</label>
			<input type="text" class="form-control" id="memberPw" name="memberPw" placeholder="memberPw">
		</div>
			<button type="submit" class="btn btn-default">입력완료</button>
		</form>		
	</body>
</html>