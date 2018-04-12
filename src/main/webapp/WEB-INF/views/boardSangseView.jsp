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
	<jsp:include page="./navbar.jsp"/>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- Begin Content -->
					<table cellpadding="0" cellspacing="0">
						<tr align="center" valign="middle">
							<td colspan="5">board 게시판</td>
						</tr>
						
						<tr>
							<td style="font-family:돋음; font-size:12" height="16">
								<div align="center">제 목&nbsp;&nbsp;</div>
							</td>
							
							<td style="font-family:돋음; font-size:12">
							${boardView.boardTitle}
							</td>
						</tr>
						
						<tr bgcolor="cccccc">
							<td colspan="2" style="height:1px;">
							</td>
						</tr>
						
						<tr>
							<td style="font-family:돋음; font-size:12" height="16">
								<div align="center">작성자&nbsp;&nbsp;</div>
							</td>
							
							<td style="font-family:돋음; font-size:12">
							${boardView.memberId}
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
										${boardView.boardContent}
										</td>
									</tr>
								</table>
							</td>
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
						
						<tr align="center" valign="middle">
							<td colspan="5">
								<font size=2>
								<a href="./updateBoardForm?boardNo=${board.boardNo}">
								[수정]
								</a>&nbsp;&nbsp;
								<a href="./deleteBoard?boardNo=${board.boardNo}">
								[삭제]
								</a>&nbsp;&nbsp;
								<a href="./selectBoardList">[목록]</a>&nbsp;&nbsp;
								</font>
							</td>
						</tr>
					</table>
										
					<!-- End Content -->
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>

</body>
</html>