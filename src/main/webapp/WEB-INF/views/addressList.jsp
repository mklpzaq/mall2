<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Address List</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<strong>${currentPage} / ${lastPage} Page</strong><br/>
									pagePerRow : <strong id="textPagePerRow">${pagePerRow}</strong>
								</div>
								<div class="col-sm-6">
									<h3>Address List</h3>
								</div>
								<div class="col-sm-3">
									<select id="selectPagePerRow" name="selectPagePerRow">
										<option value="5">5</option>
										<option value="10">10</option>
										<option value="15">15</option>
										<option value="20">20</option>
										<option value="30">30</option>
										<option value="40">40</option>
										<option value="50">50</option>
									</select>개씩 보기
								</div>
							</div>
							<hr/>
							<table class="table table-striped">
								<thead>
									<tr>
										<td><strong>addressNo</strong></td>
										<td><strong>memberNo</strong></td>
										<td><strong>addressContent</strong></td>
										<td><strong>수정</strong></td>
										<td><strong>삭제</strong></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${list}">
										<tr>
											<td><strong>${member.memberNo}</strong></td>
											<td>${member.memberId}</td>
											<td>${member.memberPw}</td>
											<td><a href="${pageContext.request.contextPath}/updateMember?sendNo=${member.memberNo}">수정</a></td>
											<td><a href="${pageContext.request.contextPath}/deleteMember?sendNo=${member.memberNo}">삭제</a></td>
										</tr>
									</c:forEach>
									<%-- <c:choose>
										<c:when test="${currentPage == lastPage}">
											<c:forEach var="remainderRow" begin="1" end="${pagePerRow - lastPageMemberCnt}" step="1">
												<tr>
													<td><strong>- -</strong></td>
													<td>- -</td>
													<td>- -</td>
												</tr>
											</c:forEach>
										</c:when>
									</c:choose> --%>
								</tbody>
							</table>
							<nav>
								<ul class="pagination">
									<li>
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=1&pagePerRow=${pagePerRow}" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
									<li>
										<c:choose>
											<c:when test="${currentPage > 1}">
												<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}"aria-label="Previous">
													<span aria-hidden="true">&lt;</span>
												</a>
											</c:when>
											<c:otherwise>
												<a href="${pageContext.request.contextPath}/getMemberList?currentPage=1&pagePerRow=${pagePerRow}"aria-label="Previous">
													<span aria-hidden="true">&lt;</span>
												</a>
											</c:otherwise>
										</c:choose>
									</li>
									<c:choose>
										<c:when test="${lastPage > beginPageNumForCurrentPage + 4}">
											<c:forEach var="pageNum" begin="${beginPageNumForCurrentPage}" end="${beginPageNumForCurrentPage + 4}" step="1">
												<c:choose>
													<c:when test="${pageNum == currentPage}">
														<li class="active"><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}&pagePerRow=${pagePerRow}">${pageNum}</a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}&pagePerRow=${pagePerRow}">${pageNum}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach var="pageNum" begin="${beginPageNumForCurrentPage}" end="${lastPage}" step="1">
												<c:choose>
													<c:when test="${pageNum == currentPage}">
														<li class="active"><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}&pagePerRow=${pagePerRow}">${pageNum}</a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${pageNum}&pagePerRow=${pagePerRow}">${pageNum}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:otherwise>
									</c:choose>
									<li>
										<c:choose>
											<c:when test="${currentPage < lastPage}">
												<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}" aria-label="Next">
													<span aria-hidden="true">&gt;</span>
												</a>
											</c:when>
											<c:otherwise>
												<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}&pagePerRow=${pagePerRow}"aria-label="Next">
													<span aria-hidden="true">&gt;</span>
												</a>
											</c:otherwise>
										</c:choose>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}&pagePerRow=${pagePerRow}" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</ul>
							</nav>
						</div>
					</div>					
					
					<!-- End Content -->
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
			
	</body>
</html>