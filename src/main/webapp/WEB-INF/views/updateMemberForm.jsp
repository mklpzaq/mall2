<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert title here</title>
		<script>
			$(document).ready(function(){
				$('#inputMemberId3').keyup(function(){
					if($('#inputMemberId3').val().length < 3) {
						$('#inputMemberId3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('ID를 3자 이상 입력해주세요');
					}else if($('#inputMemberId3').val().length >= 10){
						$('#inputMemberId3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('ID를 10자 이하 입력해주세요.');
					}else{
						$('#inputMemberId3').parent().removeClass('has-error has-feedback').addClass('has-success has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-remove form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
						$('#idHelper').text('');
					}					
				});
				
				$('#inputMemberPassword3').keyup(function(){
					if($('#inputMemberPassword3').val().length < 3){
						$('#inputMemberPassword3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('PW를 3자 이상 입력해주세요.');
					}else if($('#inputMemberPassword3').val().length >= 10){
						$('#inputMemberPassword3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('PW를 10자 이하 입력해주세요.');
					}else{
						$('#inputMemberPassword3').parent().removeClass('has-error has-feedback').addClass('has-success has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-remove form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
						$('#pwHelper').text('');
					}
				});
				
				$('#updateButton').click(function(){
					if($('#inputMemberId3').val().length < 3 || $('inputMemberId3').val().length > 10){
						$('#inputMemberId3').focus();
						$('#inputMemberId3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#idIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#idHelper').text('올바른 ID가 아닙니다.');
						return ;
					}else if($('#inputMemberPassword3').val().length < 3 || $('#inputMemberPassword3').val().length > 10){
						$('#inputMemberPassword3').focus();
						$('#inputMemberPassword3').parent().removeClass('has-success has-feedback').addClass('has-error has-feedback');
						$('#pwIcon').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
						$('#pwHelper').text('올바른 PW가 아닙니다.');
						return ;
					}
					$('#updateForm').submit();				
				});					
			});
		</script>
		
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					
					<form id="updateForm" class="form-horizontal" action="${pageContext.request.contextPath}/updateMember" method="post">
						<div class="form-group">
							<label for="inputMemberNo3" class="col-sm-2 control-label">memberNo</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputMemberNo3" value="${memberForUpdate.memberNo}" name="memberNo" readonly>							
							</div>
						</div>
						<div class="form-group">
							<label for="inputMemberId3" class="col-sm-2 control-label">memberId</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputMemberId3" value="${memberForUpdate.memberId}" name="memberId">
								<span id="idIcon"></span>
								<span id="idHelper"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputMemberPassword3" class="col-sm-2 control-label">memberPw</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputMemberPassword3" value="${memberForUpdate.memberPw}" name="memberPw">
								<span id="pwIcon"></span>
								<span id="pwHelper"></span>
							</div>
						</div>					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="updateButton" type="button" class="btn btn-default">회원수정</button>
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