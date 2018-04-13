<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>item List</title>
<script>	
	$(document).ready(function(){			
	  $('#pagePerRow').change(function(){	     	 
	     	 $(location).attr('href', './selectItemList?pagePerRow='+$('#pagePerRow > option:selected').val());
	  });
	});
	
	$(document).ready(function(){
		$("#button").click(function(){
			$('input[name="deleteCheckbox"]:checked').each(function(){							
				var text = $(this).val();
				alert("itemNo"+text+"삭제");					
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
					<button><a href="${pageContext.request.contextPath}/insertItemForm">상품 등록</a></button>
					<div class="panel panel-default">
						<div class="panel-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<strong>${currentPage} / ${lastPage} Page</strong><br/>
									pagePerRow : <strong id="textPagePerRow">${pagePerRow}</strong>
								</div>
								<div class="col-sm-6">
									<h3>Item List</h3>
								</div>>
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
										<td width="10%">번호</td>
										<td width="10%">카테고리번호</td>
										<td width="10%">카테고리명</td>
										<td width="35%">상품명</td>
										<td width="15%">상품 가격</td>
										<td width="10%">수정</td>
										<td width="10%">삭제</td>
									</tr>
								</thead>
								<tbody>
									<form id="form1" method="get" action="${pageContext.request.contextPath}/deleteItem">
										<c:forEach var="item" items="${list}">
											<tbody>
												<tr>
													<th><input type="checkbox" name="deleteCheckbox" value="${item.itemNo}"></th>
													<th scope = "row">${item.itemNo}</th>
													<td>${category.categoryNo}</td>
													<td>${category.categoryName}</td>
													<td>${item.itemName}</td>
													<td>${item.itemPrice}</td>
													<td><a href="${pageContext.request.contextPath}/updateItemForm?itemNo=${item.itemNo}&pagePerRow=${pagePerRow}">수정</a></td>
													<td><a href="${pageContext.request.contextPath}/deletItem?itemNo=${item.itmNo}&pagePerRow=${pagePerRow}">삭제</a></td>
												</tr>
											</tbody>
										</c:forEach>
									</form>
								</tbody>
							</table>
							<nav>
								<ul class="pagination">
								
								<c:if test="${currentPage>1}">
									<li><a href="${pageContext.request.contextPath}/selectItemList?pagePerRow=${pagePerRow}">처음으로</a></li>
									<li><a href="${pageContext.request.contextPath}/selectItemList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">이전</a></li>
								</c:if>
								
								<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${iCount == currentPage}">
											<li class="active"><a href="${pageContext.request.contextPath}/selectItemList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${pageContext.request.contextPath}/selectItemList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></li>
										</c:otherwise>
									</c:choose>								
								</c:forEach>				
								
								<c:if test="${currentPage < lastPage}">
									<li><a href="${pageContext.request.contextPath}/selectItemList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">다음</a></li>
									<li><a href="${pageContext.request.contextPath}/selectItemList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">마지막으로</a></li>
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
						</div>
					</div>
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>

</body>
</html>
							