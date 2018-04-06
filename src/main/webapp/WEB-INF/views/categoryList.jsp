<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 리스트</title>
</head>
<body>
<button><a href="${pageContext.request.contextPath}/insertCategoryForm">카테고리 등록</a></button>


	<table border="1">
		<thead>
			<tr>
				<td>categoryNo</td>
				<td>categoryName</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
		</thead>
		<c:forEach var="category" items="${ListCategory}">
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
</body>
</html>