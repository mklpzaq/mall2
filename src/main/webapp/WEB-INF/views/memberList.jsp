<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<!-- Begin Content -->
					<h3>Member List</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>memberNo</th>
								<th>memberId</th>
								<th>memberPw</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="member" items="${list}">
								<tr>
									<th>${member.memberNo}</th>
									<td>${member.memberId}</td>
									<td>${member.memberPw}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<nav>
						<ul class="pagination">
							<li>
								<a href="${pageContext.request.contextPath}/getMemberList?currentPage=1" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
							<c:forEach var="pageNum" begin="1" end="${lastPage}" step="1">
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}">${pageNum}</a></li>
							</c:forEach>
							<li>
								<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</ul>
					</nav>
					
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>
			<!-- End row -->
			</div>
		<!-- End container-fluid -->	
		</div>
		



		
	</body>
</html>