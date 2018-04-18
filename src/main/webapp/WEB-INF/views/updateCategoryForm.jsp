<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 수정</title>
</head>
<body>
	<jsp:include page="./navbar.jsp"/>		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<form action="${pageContext.request.contextPath}/updateCategoryForm" method="post">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="categoryName">번호</label>
								<input type="text" class="form-control" name="categoryNo" size="10" value="${categoryForm.categoryNo}" readonly>
							</div>
							<div class="form-group">
								<label for="categoryName">제목</label>
								<input type="text" class="form-control" name="categoryName" size="50" value="${categoryForm.categoryName}">
							</div>
							<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">수정</button>
							</div>
						</div>
						</div>
						<div class="col-md-3"></div>							
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>		
</body>
</html>