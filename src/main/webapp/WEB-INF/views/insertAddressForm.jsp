<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert Address</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-6 text-center">
										<h3>Insert Address</h3>
									</div>
									<div class="col-sm-3"></div>
								</div>
								<hr/>
								<form class="form-horizontal" action="${pageContext.request.contextPath}/insertAddress" method="post">
									<div class="form-group">
										<label for="memberNo" class="col-sm-2 control-label">memberNo</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = memberNo id="memberNo" value="${memberNo}"placeholder="memberNo" readonly>
										</div>
									</div>
									<div class="form-group">
										<label for="addressContent" class="col-sm-2 control-label">addressContent</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "addressContent" id="addressContent" placeholder="addressContent">
										</div>
									</div>									
									<div class="form-group">
										<div class="col-sm-12">
											<button id="loginButton" type="submit" class="btn btn-default">입력 완료</button>
										</div>
									</div>
								</form>
							</div>
						</div>	
						
					
					
					
					<!-- End Content -->
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		


	</body>	
</html>