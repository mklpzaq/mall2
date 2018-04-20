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
					$(location).attr('href', './orderList?pagePerRow=' + $('#pagePerRow > option:selected').val()+'&searchOption='+$('#searchOption').val()+'&keyword='+$('#keyword').val());
				});
			});
			
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
				var show = $("#keyword");
				if(property=="order_date"){
					$("#keyword").html('<input type="date" name="keyword">~<input type="date" name="keyword">');
				}else {
					$("#keyword").html('<input type="text" name="keyword">');
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
					<%-- <button><a href = "${pageContext.request.contextPath}/insertBoardForm">글쓰기</a></button> --%>
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<strong>${currentPage} / ${lastPage} Page</strong><br/>
									pagePerRow : <strong id="textPagePerRow">${pagePerRow}</strong><br/>
									searchOption : <strong id="textSearchOption">${searchOption}</strong><br/>
									keyword : <strong id="textKeyword">
																			
											</strong>
								</div>
								<div class="col-sm-6">
									<h3>Order List</h3>
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
										<td width="15%">주문번호</td>
										<td width="20%">주문자아이디</td>
										<td width="15%">카테고리명</td>
										<td width="20%">아이템명</td>
										<td width="15%">가격</td>
										<td width="15%">주문날짜</td>
									</tr>
								</thead>
								<tbody>
									<form id="form1" method="get" action="${pageContext.request.contextPath}/deleteOrder">
										<c:forEach var="order" items="${list}">
											<tbody>
												<tr>
													<th><input type="checkbox" name="deleteCheckbox" value="${order.orderNo}"></th>
													<th scope = "row">${order.orderNo}</th>
													<td>${order.memberId}</td>
													<td>${order.categoryName}</td>
													<td>${order.itemName}</td>
													<td>${order.itemPrice}</td>
													<td>${order.orderDate}</td>
												</tr>
											</tbody>
										</c:forEach>
									</form>
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
										<li><a href="${pageContext.request.contextPath}/orderList?pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">처음으로</a></li>
										<li><a href="${pageContext.request.contextPath}/orderList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">이전</a></li>
									</c:if>
									
									<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
										<c:choose>
											<c:when test="${iCount == currentPage}">
												<li class="active"><a href="${pageContext.request.contextPath}/orderList?currentPage=${iCount}&pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">${iCount}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageContext.request.contextPath}/orderList?currentPage=${iCount}&pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">${iCount}</a></li>
											</c:otherwise>
										</c:choose>								
									</c:forEach>
									
									<c:if test="${currentPage < lastPage}">
										<li><a href="${pageContext.request.contextPath}/orderList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">다음</a></li>
										<li><a href="${pageContext.request.contextPath}/orderList?currentPage=${lastPage}&pagePerRow=${pagePerRow}&searchOption=${searchOption}&keyword=${keyword}">마지막으로</a></li>
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
									</li> 
																		
									<c:out value="${searchOption == 'member_id'?'selected':''}"/>
									--%>
								</ul>
							</nav>
							<div>
								<form action="<%=request.getContextPath()%>/orderList" method="get">
									<select id="searchOption" name="searchOption" onclick="changehtml();">											
										<option value="member_id" <c:if test="${member_id == 'member_id'}">selected</c:if>>주문아이디</option>
										<option value="item_name"  <c:if test="${item_name == 'item_name'}">selected</c:if>>주문제품</option>											
										<option value="order_date" <c:if test="${order_date == 'order_date'}">selected</c:if>>주문날짜</option>		
									</select>
									<dr id="keyword"></dr>
									<%-- <input id="keyword" name="keyword" value="${keyword}"> --%>
									<input type="submit" value="검색버튼" >
								</form>
							</div>
							<div>
						  		<button id="button">주문 취소</button>
							</div>	
						</div>
					</div>
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>
	</body>
</html>