<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Insert BoardCommentForm</title>
	</head>
	<body>
		<!-- Begin Write Comment -->					
			<div class="panel panel-default">
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/insertBoardComment?boardNo=${board.boardNo}" method="post">
						<button style="margin:0px 0px 15px 0px;" type="submit" class="btn btn-default">입력 완료</button>
						<div class="form-group">
							<textarea  class="form-control" rows="3"></textarea>
						</div>
					</form>
				</div>
			</div>
			
		<!-- End Write Comment -->	
	</body>
</html>