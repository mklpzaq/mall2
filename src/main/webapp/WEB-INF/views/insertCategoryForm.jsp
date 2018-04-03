<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 등록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/insertCategoryForm" method="post">
		<table border="1">
			<tr>
				<td>categoryName</td>
				<td><input type="text" name="categoryName" size="50" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="카테고리추가"></td>
			</tr>
		</table>
	</form>


</body>
</html>