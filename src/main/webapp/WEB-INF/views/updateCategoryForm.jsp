<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/updateCategoryForm" method="post">
		<table border="1">
			<tr>
				<td>categoryNo</td>
				<td><input type="text" name="categoryNo" size="10" value="${category.categoryNo}" readonly></td>
			<tr>
			<tr>
				<td>categoryName</td>
				<td><input type="text" name="categoryName" size="50" value="${category.categoryName}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="수정하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>