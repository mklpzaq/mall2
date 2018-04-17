<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Update Address</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<!-- Begin Content -->
					
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-6 text-center">
										<h3>Update Address</h3>
									</div>
									<div class="col-sm-3"></div>
								</div>
								<hr/>
								<form class="form-horizontal" action="${pageContext.request.contextPath}/updateAddress" method="post">
									<div class="form-group">
										<label for="addressNo" class="col-sm-2 control-label">addressNo</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = addressNo id="addressNo" value="${address.addressNo}" placeholder="addressNo" readonly>
										</div>
									</div>
									<div class="form-group">
										<label for="memberNo" class="col-sm-2 control-label">memberNo</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = memberNo id="memberNo" value="${address.memberNo}" placeholder="memberNo" readonly>
										</div>
									</div>
									<div class="form-group">
										<label for="addressContent" class="col-sm-2 control-label">addressContent</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "addressContent" id="addressContent" value="${address.addressContent}" placeholder="addressContent">
										</div>
									</div>									
									<div class="form-group">
										<div class="col-sm-12">
											<button id="loginButton" type="submit" class="btn btn-default">수정 완료</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					
					<!-- End Content -->
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</body>
</html>