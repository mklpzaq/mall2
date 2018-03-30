<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		memberList.jsp
		
		<div class="bs-example" data-example-id="simple-table">
			<table class="table">
				<caption>Optional table caption.</caption>
				<thead>
					<tr>
						<th>memberNo</th>
						<th>memberId</th>
						<th>memberPw</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td>${member.memberNo}</td>
							<td>${member.memberId}</td>
							<td>${member.memberPw}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	
	
		
			
		
	</body>
</html>