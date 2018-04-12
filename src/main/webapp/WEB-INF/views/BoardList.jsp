<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>BoardList</title>
		<script>
			$(document).ready(function() {
				$('#pagePerRow').change(function() {
					$(location).attr('href', './selectBoardList?pagePerRow=' + $('#pagePerRow > option:selected').val());
				})
			})
		</script>
	</head>
	<body>
		<button><a href = "${pageContext.request.contextPath}/insertBoardForm">글쓰기</a></button>
		<select id="pagePerRow">
			<option	class="option" value=5 <c:if test="${pagePerRow == 5}">selected</c:if>>5개씩보기</option>
			<option	class="option" value=10 <c:if test="${pagePerRow == 10}">selected</c:if>>10개씩보기</option>
			<option class="option" value=15 <c:if test="${pagePerRow == 15}">selected</c:if>>15개씩보기</option>
			<option class="option" value=20 <c:if test="${pagePerRow == 20}">selected</c:if>>20개씩보기</option>			
		</select>
		<table border="1">
			<thead>
				<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성날짜</td>
				</tr>
			</thead>
			<c:forEach var="board" items="${list}">
				<tbody>
					<tr>
						<th scope = "row">${board.boardNo}</th>
						<td><a href="${pageContext.request.contextPath}/boardView?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
						<td>${board.memberId}</td>
						<td>${board.boardDate}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		
		<c:if test="${currentPage>1}">
			<button name="move"><a href="${pageContext.request.contextPath}/selectBoardList?pagePerRow=${pagePerRow}">처음으로</a></button>
			<button name="move"><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">이전</a></button>
		</c:if>
		
		<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
			<button name="move"><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${iCount}&pagePerRow=${pagePerRow}">${iCount}</a></button>
		</c:forEach>
		
		<c:if test="${currentPage < lastPage}">
			<button name="move"><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">다음</a></button>
			<button name="move"><a href="${pageContext.request.contextPath}/selectBoardList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">마지막으로</a></button>
		</c:if>

	</body>
</html>