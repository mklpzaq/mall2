<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Member List</title>
		<script>
			$(document).ready(function(){
				if($('#selectPagePerRow').val() !== $('#textPagePerRow').text()){
					$('#selectPagePerRow').val($('#textPagePerRow').text());
				}
				$('#selectPagePerRow').change(function(){
					$(location).attr('href', './getMemberList?pagePerRow='+$('#selectPagePerRow > option:selected').val());
				});
				
				$('#deleteMember').click(function(){
					confirm("정말로 삭제 하시겠습니까?");
				});
			});
			
			function change(){
				var property = $('#searchOption').val();
				var show = $('#keyword');
				$('#keyword').html('<input type="text" name="keyword">');
			}
			
		</script>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<!-- Begin Content -->
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<strong>${currentPage} / ${lastPage} Page</strong><br/>
									pagePerRow : <strong id="textPagePerRow">${pagePerRow}</strong>
								</div>
								<div class="col-sm-6">
									<h3>Member List</h3>
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
										<td><strong>memberNo</strong></td>
										<td><strong>memberId</strong></td>
										<td><strong>memberPw</strong></td>
										<td><strong>수정</strong></td>
										<td><strong>삭제</strong></td>
										<td><strong>주소추가</strong></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${list}">
										<tr>
											<td><strong>${member.memberNo}</strong></td>
											<td>${member.memberId}</td>
											<td>${member.memberPw}</td>
											<td><a href="${pageContext.request.contextPath}/updateMember?sendNo=${member.memberNo}">수정</a></td>
											<td id="deleteMember"><a href="${pageContext.request.contextPath}/deleteMember?sendNo=${member.memberNo}">삭제</a></td>
											<td><a href="${pageContext.request.contextPath}/insertAddress?sendNo=${member.memberNo}">주소추가</a></td>											
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
							<div>
								<form action="${pageContext.request.contextPath}/searchMember" method="post">
									<select id="searchOption" name="searchOption" onclick="change();">
										<option value="member_id" <c:out value="${searchOption == 'member_id'?'selected':''}"/>>아이디</option>
									</select>
									<dr id="keyword"></dr>
									<input type="submit" value="검색">
								</form>
							</div>
						</div>												
					</div>
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>
			<!-- End row -->
			</div>
		<!-- End container-fluid -->	
		</div>
	</body>
</html>