<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>카테고리 리스트</title>
<script type="text/javascript">
	/* $(document).ready(function(){
		$("option").click(function(){			
			$("a").("[href]"="${pageContext.request.contextPath}/selectCategoryList?pagePerRow=$("option").val()")
				
		});		
	}); */
</script>
</head>
<body>
<button><a href="${pageContext.request.contextPath}/insertCategoryForm">카테고리 등록</a></button>

	<form action="${pageContext.request.contextPath}/selectCategoryList" method="get">
		<select name="pagePerRow">
			<option value="10">10개씩보기</option>
			<option value="15">15개씩보기</option>
			<option value="20">20개씩보기</option>
		</select>
	 <button type="submit">작성</button>
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<td>categoryNo</td>
				<td>categoryName</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
		</thead>
		<c:forEach var="category" items="${list}">
			<tbody>
				<tr>
					<th scope = "row">${category.categoryNo}</th>
					<td>${category.categoryName}</td>
					<td><a href="${pageContext.request.contextPath}/updateCategoryForm?categoryNo=${category.categoryNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteCategory?categoryNo=${category.categoryNo}">삭제</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<button><a href="${pageContext.request.contextPath}/selectCategoryList">처음으로</a></button>
	<c:if test="${currentPage>1}">
		<button><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${currentPage-1}">이전</a></button>
	</c:if>
	
	<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
		<button><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${iCount}">${iCount}</a></button>
	</c:forEach>
	
	<c:if test="${currentPage < lastPage}">
		<button><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${currentPage+1}">다음</a></button>
		<button><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${lastPage}">마지막으로</a></button>
	</c:if>
</body>
</html>