<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Board Sangse View</title>
		<style>
			.none{display:none;}
		</style>
		<script>
			$(document).ready(function(){
				$('#insertBoardCommentFormButton').click(function(){
					if($('#insertBoardCommentForm').hasClass('none')){
						$('#insertBoardCommentForm').removeClass('none');
						
					}else{
						$('#insertBoardCommentForm').addClass('none');
					}
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
						
						<div>
							<a href="./updateBoardForm?boardNo=${board.boardNo}">
								[수정]
							</a>&nbsp;&nbsp;
							<a href="./deleteBoard?boardNo=${board.boardNo}">
								[삭제]
							</a>&nbsp;&nbsp;
							<a href="./selectBoardList">
								[목록]
							</a>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="col-sm-4">
										글 번호 : ${boardView.boardNo}<br/>
										작성자 : ${boardView.memberId}
									</div>
									<div class="col-sm-4 text-center">
										<h3 class="panel-title">${boardView.boardTitle}</h3>
									</div>
									<div class="col-sm-4 text-right">
										작성일 : ${boardView.boardDate}
									</div>
								</div>
							</div>
							<div class="panel-body" style="height:100px;">
								${boardView.boardContent}
							</div>
						</div>
						
						<!-- Begin Write Comment -->
						<button id="insertBoardCommentFormButton" class="btn btn-default" type="button">댓글 쓰기</button>
						<div id="insertBoardCommentForm" class="none">
							<div class="panel panel-default">
								<div class="panel-body">
									<strong>boardNo : ${boardView.boardNo}</strong><br/>
									<strong>memberId : ${loginMember.memberId}</strong>
									<form action="${pageContext.request.contextPath}/insertBoardComment" method="post">
										<input type="hidden" name="boardNo" value="${boardView.boardNo}">
										<input type="hidden" name="memberId" value="${loginMember.memberId}">
										<div class="form-group">
											<textarea class="form-control" rows="3" name="commentContent" placeholder="댓글 입력"></textarea>
										</div>
										<button style="margin:0px 0px 15px 0px;" type="submit" class="btn btn-default">입력 완료</button>
									</form>
								</div>
							</div>
						</div>
						<!-- End Write Comment -->
					
						
						<!-- Begin CommentList -->
						
						
						<div class="bs-example" data-example-id="simple-table">
							<table class="table">
								<caption>boardComment List</caption>
								<thead>
									<tr>
										<td>commentNo</td>
										<td>memberId</td>
										<td>CommentContent</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td scope="row">1</td>
										<td>dd</td>
										<td>Marksefsfasfesafee bnsfewafevafvaesvefszbvsbszfsefvfszsefzsffeszvzbsbsMarksefsfasfesafee bnsfewafevafvaesvefszbvsbszfsefvfszsefzsffeszvzbsbs</td>
									</tr>
									<tr>
										<td scope="row">1</td>
										<td>dd</td>
										<td>54</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						
						<!-- End CommentList -->
						
						
					<!-- End Content -->
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
	
	</body>
</html>