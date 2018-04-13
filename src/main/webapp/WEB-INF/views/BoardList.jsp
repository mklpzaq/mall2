<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>BoardList</title>
		<script>
			$(document).ready(function() {
				$('#pagePerRow').change(function() {
					$(location).attr('href', './selectBoardList?pagePerRow=' + $('#pagePerRow > option:selected').val());
				})
			})
			$(document).ready(function(){
			$("#button").click(function(){
				$('input[name="deleteCheckbox"]:checked').each(function(){							
					var text = $(this).val();
					alert("categoryNo"+text+"삭제");					
					$("#form1").submit();	
					});
				})	
			});
		
			$(document).ready(function(){
				$("#checkboxAll").click(function(){
					if($(this).prop("checked")){
						$("input[type=checkbox]").prop("checked",true);
					}else{
						$("input[type=checkbox]").prop("checked",false);
					}
				});
			});
			
			function changehtml(){
				var property = $("#searchOption").val();
				var show = $("#show");
				if(property=="boardDate"){
					$("#show").html('<input type="date" name="sv1">~<input type="date" name="sv2">');
				}else {
					$("#show").html('<input type="text" name="sv">');
				}
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
					<a href="${pageContext.request.contextPath}/">Home</a>
					<button><a href = "${pageContext.request.contextPath}/insertBoardForm">글쓰기</a></button>
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<strong>${currentPage} / ${lastPage} Page</strong><br/>
									pagePerRow : <strong id="textPagePerRow">${pagePerRow}</strong>
								</div>
								<div class="col-sm-6">
									<h3>Board List</h3>
								</div>
								<div class="col-sm-3">
									<select id="pagePerRow">
										<option	class="option" value=5 <c:if test="${pagePerRow == 5}">selected</c:if>>5개씩보기</option>
										<option	class="option" value=10 <c:if test="${pagePerRow == 10}">selected</c:if>>10개씩보기</option>
										<option class="option" value=15 <c:if test="${pagePerRow == 15}">selected</c:if>>15개씩보기</option>
										<option class="option" value=20 <c:if test="${pagePerRow == 20}">selected</c:if>>20개씩보기</option>			
									</select>
								</div>
							</div>
							<hr/>
							<table class="table table-striped">
								<thead>
									<tr>
										<th><input type="checkbox" id="checkboxAll" value=""></th>
										<td width="8%">번호</td>
										<td width="50%">제목</td>
										<td width="15%">작성자</td>
										<td width="27%">작성날짜</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="board" items="${list}">
										<tbody>
											<tr>
												<th><input type="checkbox" name="deleteCheckbox" value="${category.categoryNo}"></th>
												<th scope = "row">${board.boardNo}</th>
												<td><a href="${pageContext.request.contextPath}/boardView?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
												<td>${board.memberId}</td>
												<td>${board.boardDate}</td>
											</tr>
										</tbody>
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
									<c:if test="${currentPage>1}">
										<li><a href="${pageContext.request.contextPath}/selectBoardList?pagePerRow=${pagePerRow}">처음으로</a></li>
										<li><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">이전</a></li>
									</c:if>
									
									<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
										<c:choose>
											<c:when test="${iCount == currentPage}">
												<li class="active"><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></li>
											</c:otherwise>
										</c:choose>								
									</c:forEach>
									
									<c:if test="${currentPage < lastPage}">
										<li><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">다음</a></li>
										<li><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">마지막으로</a></li>
									</c:if>
																		
									<%-- <li>
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
									</li> --%>
								</ul>
							</nav>
							<div>
								<form action="<%=request.getContextPath()%>/searchBoardList" method="post">
									<select name="searchOption" onclick="changehtml();">											
										<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/>>전체</option>
										<option value="memberId"  <c:out value="${map.searchOption == 'memberId'?'selected':''}"/>>아이디</option>
										<option value="boardTitle"  <c:out value="${map.searchOption == 'boardTitle'?'selected':''}"/>>제목</option>											
										<option value="boardDate"  <c:out value="${map.searchOption == 'boardDate'?'selected':''}"/>>등록날짜</option>		
									</select>
									<dr id="show"></dr>
									<input name="keyword" value="${map.keyword}">
									<input type="submit" value="검색버튼" >
								</form>
							</div>
						</div>
					</div>
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>
	</body>
</html>