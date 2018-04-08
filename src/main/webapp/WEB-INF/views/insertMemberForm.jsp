<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Member Insert</title>
		<script>
			$(document).ready(function(){
					
				$('#memberId').keyup(function(){
					if($('#memberId').val().length < 3){
						$('#memberId').parent().addClass('has-error');
						$('#idWarning').text('ID를 3자 이상 입력해주세요.');
					}else if($('#memberId').val().length >= 10){
						$('#memberId').parent().addClass('has-error');
						$('#idWarning').text('ID를 10자 이하 입력해주세요.');
					}else{
						$('#memberId').parent().removeClass('has-error').addClass('has-success');
						$('#idWarning').text('');
					}
				});
				
				$('#memberPw').keyup(function(){
					if($('#memberPw').val().length < 3){
						$('#memberPw').parent().addClass('has-error');
						$('#pwWarning').text('PW를 3자 이상 입력해주세요.');
					}else if($('#memberPw').val().length >= 10){
						$('#memberPw').parent().addClass('has-error');
						$('#pwWarning').text('PW를 10자 이하 입력해주세요.');
					}else{
						$('#memberPw').parent().removeClass('has-error').addClass('has-success');
						$('#pwWarning').text('');
					}
				});
					
				$('#memberPwCheck').keyup(function(){
					if($('#memberPwCheck').val() != $('#memberPw').val()){
						$('#pwCheckWarning').parent().addClass('has-error');
						$('#pwCheckWarning').text('입력한 PW와 동일하게 입력해주세요.');
					}else{
						$('#pwCheckWarning').parent().removeClass('has-error').addClass('has-success');
						$('#pwCheckWarning').text('');
					}
				});
				
				$('#insertButton').click(function(){
					if($('#memberId').val().length < 3 || $('#memberId').val().length > 10){
						$('#memberId').focus();
						$('#memberId').parent().addClass('has-error');
						$('#idWarning').text('올바른 ID가 아닙니다.');
						return ;
					}else if($('#memberPw').val().length < 3 || $('#memberPw').val().length > 10){
						$('#memberPw').focus();
						$('#memberPw').parent().addClass('has-error');
						$('#pwWarning').text('올바른 PW가 아닙니다.');
						return ;
					}else if($('#memberPwCheck').val() != $('#memberPw').val()){
						$('#memberPwCheck').focus();
						$('#pwCheckWarning').parent().addClass('has-error');
						$('#pwCheckWarning').text('올바른 PW확인이 아닙니다.');
						return ;
					}
					
					$('#insertMemberForm').submit();
				});
				
				
			});
		</script>
	</head>
	<body>
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
										<h3>Member Insert</h3>
									</div>
									<div class="col-sm-3"></div>
								</div>
								<hr/>
								<form id="insertMemberForm" class="form-horizontal" action="${pageContext.request.contextPath}/insertMemberForm" method="post">
									<div class="form-group">
										<label for="memberId" class="col-sm-2 control-label">ID</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "memberId" id="memberId" placeholder="ID">
											<span id="idWarning"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="memberPw" class="col-sm-2 control-label">PW</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name = "memberPw" id="memberPw" placeholder="PW">
											<span id="pwWarning"></span>
										</div>
									</div>
									<div class="form-group">
										<label for="memberPwCheck" class="col-sm-2 control-label">PWCheck</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="memberPwCheck" placeholder="PWCheck">
											<span id="pwCheckWarning"></span>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-12">
											<button id="insertButton" type="button" class="btn btn-default">Insert Button</button>
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