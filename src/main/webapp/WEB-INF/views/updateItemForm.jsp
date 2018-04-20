<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>updateItemForm</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					
					<form class="form-horizontal" action="${pageContext.request.contextPath}/updateItemForm" method="post">
						<div class="form-group">
							<label for="inputItemNo" class="col-sm-2 control-label">상품번호</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="itemNo" value="${itemForm.itemNo}"  readonly>   
							</div>
						</div>
						<div class="form-group">
							<label for="inputItemNo" class="col-sm-2 control-label">카테고리</label>
							<div class="col-sm-10">
								<select id="categoryList" name="category.categoryNo">
									<option>카테고리 선택</option>
									<c:forEach var="category" items="${list}">
										<option value="${category.categoryNo}">${category.categoryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputItemName" class="col-sm-2 control-label">상품명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="itemName" value="${itemForm.itemName}">
							</div>
						</div>	
						<div class="form-group">
							<label for="inputItemPrice" class="col-sm-2 control-label">상품가격</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="itemPrice" value="${itemForm.itemPrice}">
							</div>
						</div>				
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">수정</button>
							</div>
						</div>
					</form>			
					<!-- End Content -->
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</body>
</html>