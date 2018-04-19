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
				$('#memberId').keyup(function(){
					if($('#memberId').val().length < 3){
						$('#memberId').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('ID를 3자 이상 입력해주세요.');
					}else if($('#memberId').val().length >= 10){
						$('#memberId').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('ID를 10자 이하 입력해주세요.');
					}else{
						$('#memberId').parent().removeClass('has-error has-feedback').addClass('has-success has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-remove form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
						$('#idHelper').text('');
					}				
				});
				
				$('#memberPw').keyup(function(){
					if($('#memberPw').val().length < 3){
						$('#memberPw').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('PW를 3자 이상 입력해주세요.');
					}else if($('#memberPw').val().length >= 10){
						$('#memberPw').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('PW를 10자 이하 입력해주세요.');
					}else{
						$('#memberPw').parent().removeClass('has-error has-feedback').addClass('has-success has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-remove form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
						$('#pwHelper').text('');
					}
				});	
				
				$('#loginButton').click(function(){
					if($('#memberId').val().length < 3 || $('#memberId').val().length > 10){
						$('#memberId').focus();
						$('#memberId').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('올바른 ID가 아닙니다.');
						return ;
					}else if($('#memberPw').val().length < 3 || $('#memberPw').val().length > 10){
						$('#memberPw').focus();
						$('#memberPw').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('올바른 PW가 아닙니다.');
						return ;
					}				
					$('#loginForm').submit();
				});				
								
				
				
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
								<form id="loginForm" class="form-horizontal" action="${pageContext.request.contextPath}/getLogin" method="post">
									<div class="form-group">
										<label for="memberId" class="col-sm-2 control-label">ID</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "memberId" id="memberId" placeholder="ID">
											<span id="idIcon"></span>
											<span id="idHelper"></span>
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
											<button id="loginButton" type="button" class="btn btn-default">Sign in</button>
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