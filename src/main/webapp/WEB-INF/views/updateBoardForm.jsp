<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateBoardForm" method="post">
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">board 게시판</td>
	</tr>
	<input type="hidden" name="boardNo" value="${boardUpdate.boardNo}"></td>	
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목&nbsp;&nbsp;</div>
		</td>
		
		<td style="font-family:돋음; font-size:12">
			<input name="boardTitle" size="50" maxlength="100" value="${boardUpdate.boardTitle}"></td>		
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12">
			<table border=0 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td valign=top style="font-family:돋음; font-size:12">
					<textarea name="boardContent" cols="67" rows="15">${boardUpdate.boardContent}</textarea>
					</td>				
				</tr>
			</table>
		</td>
	</tr>
	<tr>
				<td colspan="4"><input type="submit" value="수정하기"></td>
	</tr>
	<%-- <tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">첨부파일</div>
		</td>
		<td style="font-family:돋음; font-size:12">
		<%if(!(board.getBOARD_FILE()==null)){ %>
		<a href="<%= request.getContextPath() %>/board/filedown.jsp?filename=<%=board.getBOARD_FILE()%>">
			<%=board.getBOARD_FILE() %>			
			
			
		</a>
		<%} %>
		</td>
	</tr> --%>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>	
	
</table>
</form>
</body>
</html>