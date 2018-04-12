<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 등록</title>
</head>
<body>
	<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h2>카테고리 작성 </h2>
					<form action="${pageContext.request.contextPath}/insertCategoryForm" method="post">
						<div class="form-group">
							<label for="categoryName">카테고리명</label>
							<input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="카테고리명을 입력하세요.">
						</div>
						<button type="submit" class="btn btn-primary">작성</button>						
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
</body>
</html>