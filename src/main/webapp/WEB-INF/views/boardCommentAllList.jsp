<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>AllBoardCommentList</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<!-- Begin Content -->
					
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<h3>BoardCommentAllList</h3>
							<hr/>
							<div class="bs-example" data-example-id="striped-table">
								<table class="table table-striped">
									<thead>
										<tr>
											<td><strong>commentNo</strong></td>
											<td><strong>boardNo</strong></td>
											<td><strong>memberId</strong></td>
											<td><strong>commentContent</strong></td>
											<td><strong>수정</strong></td>
											<td><strong>삭제</strong></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="boardComment" items="${list}">
											<tr>
												<td><strong>${boardComment.commentNo}</strong></td>
												<td>${boardComment.boardNo}</td>
												<td>${boardComment.memberId}</td>
												<td>${boardComment.commentContent}</td>
												<td><a href="#">수정(공사중)</a></td>
												<td><a href="${pageContext.request.contextPath}/deleteBoardComment?sendNo=${boardComment.commentNo}">삭제</a></td>
											</tr>
										</c:forEach>
									 </tbody>
								</table>
							</div>	
						</div>
					</div>
					
					
					<!-- End Content -->
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
			
	</body>
</html>