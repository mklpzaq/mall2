<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>insertItemForm</title>
	</head>
	<body>
		<h1>Item</h1>
		<form action="${pageContext.request.contextPath}/insertItemForm" method="post">
			<select id="itemList" name="itemNo">
				<option>[카테고리선택]</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
			상품이름: <input type="text" name="itemName">
			상품가격: <input type="text" name="itemPrice">
			<button type="submit">상품추가</button>
		</form>
	</body>
</html>