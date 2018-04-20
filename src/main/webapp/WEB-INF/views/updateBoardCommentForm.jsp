<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Update BoardComment Form</title>
	</head>
	<body>
		<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<!-- Begin Content -->
					
						<div id="insertBoardCommentForm" class="none">
							<div class="panel panel-default">
								<div class="panel-body">
									<strong>commentNo : ${boardComment.commentNo}</strong><br/>
									<strong>boardNo : ${boardComment.boardNo}</strong><br/>
									<strong>memberId : ${boardComment.memberId}</strong>
									<form action="${pageContext.request.contextPath}/updateBoardComment" method="post">
										<input type="hidden" name="commentNo" value="${boardComment.commentNo}">
										<input type="hidden" name="boardNo" value="${boardComment.boardNo}">
										<input type="hidden" name="memberId" value="${boardComment.memberId}">
										<div class="form-group">
											<textarea class="form-control" rows="3" name="commentContent" placeholder="댓글 입력">${boardComment.commentContent}</textarea>
										</div>
										<button style="margin:0px 0px 15px 0px;" type="submit" class="btn btn-default">수정 완료</button>
									</form>
								</div>
							</div>
						</div>
					
					
					<!-- End Content -->
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</body>
</html>