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
					현재 페이지 : <input value="${currentPage}">
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
							<li>
								<c:choose>
									<c:when test="${currentPage > 1}">
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage-1}"aria-label="Previous">
											<span aria-hidden="true">&lt;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=1"aria-label="Previous">
											<span aria-hidden="true">&lt;</span>
										</a>
									</c:otherwise>
								</c:choose>
							</li>
							<c:forEach var="pageNum" begin="1" end="${lastPage}" step="1">
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}">${pageNum}</a></li>
							</c:forEach>
							<li>
								<c:choose>
									<c:when test="${currentPage < lastPage}">
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage+1}" aria-label="Previous">
											<span aria-hidden="true">&gt;</span>
										</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}"aria-label="Previous">
											<span aria-hidden="true">&gt;</span>
										</a>
									</c:otherwise>
								</c:choose>
							</li>
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
		
<%-- <c:set var="it" value="빨간색"/>
  <c:choose>
<c:when test="${it eq '빨간색'}">
빨간색입니다.
</c:when>
   <c:when test="${it eq '파란색'}">
    파란색입니다.
   </c:when>
   <c:otherwise>
   다른색입니다.
   </c:otherwise>
  </c:choose>
 --%>





		


		
	</body>
</html>