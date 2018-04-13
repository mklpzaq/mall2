<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Member Login</title>
		<script>
			$(document).ready(function(){
				
				
					
			});
		</script>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<!-- Begin Content -->
						<a href="${pageContext.request.contextPath}/">Home</a>
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-6 text-center">
										<h3>Member Login</h3>
									</div>
									<div class="col-sm-3"></div>
								</div>
								<hr/>
								<form class="form-horizontal" action="${pageContext.request.contextPath}/getLogin" method="post">
									<div class="form-group">
										<label for="memberId" class="col-sm-2 control-label">ID</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "memberId" id="memberId" placeholder="ID">
										</div>
									</div>
									<div class="form-group">
										<label for="memberPw" class="col-sm-2 control-label">PW</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "memberPw" id="memberPw" placeholder="PW">
										</div>
									</div>									
									<div class="form-group">
										<div class="col-sm-12">
											<button id="loginButton" type="submit" class="btn btn-default">Sign in</button>
										</div>
									</div>
								</form>
							</div>
						</div>
				
				
				
					<!-- End Content -->
				</div>
				<div class="col-sm-3"></div>
			<!-- End row -->
			</div>
		<!-- End container-fluid -->
		</div>
	</body>
</html>