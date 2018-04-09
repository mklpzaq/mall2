<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>카테고리 리스트</title>
<script>	
	
	$(document).ready(function(){			
	  $('#pagePerRow').change(function(){			  
	     	 
	     	 $(location).attr('href', './selectCategoryList?pagePerRow='+$('#pagePerRow > option:selected').val());
	  });
	});
		
	/* $(document).ready(function(){	
		$('button[name=move]').click(function(){
			$("#pagePerRowForm").submit();
		});
	}); */
		
</script>
</head>
<body>
	<button><a href="${pageContext.request.contextPath}/insertCategoryForm">카테고리 등록</a></button>
			
	<%-- <form id="pagePerRowForm" action="${pageContext.request.contextPath}/selectCategoryList" method="get">
		<select name="pagePerRow">
			<option	class="option" value=10 <c:if test="${pagePerRow == 10}">selected</c:if>>10개씩보기</option>
			<option class="option" value=15 <c:if test="${pagePerRow == 15}">selected</c:if>>15개씩보기</option>
			<option class="option" value=20 <c:if test="${pagePerRow == 20}">selected</c:if>>20개씩보기</option>
		</select>
	 	<button name="move" type="button">작성</button>
	</form>	 --%>
		
		<select id="pagePerRow">
			<option	class="option" value=5 <c:if test="${pagePerRow == 5}">selected</c:if>>5개씩보기</option>
			<option	class="option" value=10 <c:if test="${pagePerRow == 10}">selected</c:if>>10개씩보기</option>
			<option class="option" value=15 <c:if test="${pagePerRow == 15}">selected</c:if>>15개씩보기</option>
			<option class="option" value=20 <c:if test="${pagePerRow == 20}">selected</c:if>>20개씩보기</option>			
		</select>
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
					<td><a href="${pageContext.request.contextPath}/updateCategoryForm?categoryNo=${category.categoryNo}&pagePerRow=${pagePerRow}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteCategory?categoryNo=${category.categoryNo}&pagePerRow=${pagePerRow}">삭제</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
		
		
	<c:if test="${currentPage>1}">
		<button name="move"><a href="${pageContext.request.contextPath}/selectCategoryList?pagePerRow=${pagePerRow}">처음으로</a></button>
		<button name="move"><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">이전</a></button>
	</c:if>
	
	<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
		<button name="move"><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></button>
	</c:forEach>
	
	<c:if test="${currentPage < lastPage}">
		<button name="move"><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">다음</a></button>
		<button name="move"><a href="${pageContext.request.contextPath}/selectCategoryList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">마지막으로</a></button>
	</c:if>
</body>
</html>