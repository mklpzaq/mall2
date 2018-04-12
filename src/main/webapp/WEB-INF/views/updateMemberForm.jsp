<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					
					<form class="form-horizontal" action="${pageContext.request.contextPath}/updateMember" method="post">
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
							</div>
						</div>
						<div class="form-group">
							<label for="inputMemberPassword3" class="col-sm-2 control-label">memberId</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputMemberPassword3" value="${memberForUpdate.memberPw}" name="memberPw">
							</div>
						</div>					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">회원수정</button>
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