<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>		
		<h1>Welcome Mall2!</h1>	
		<c:choose>
			<c:when test="${!empty loginMember}">
				<h3>${loginMember.memberId} 님 환영합니다.</h3>
			</c:when>
		</c:choose>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
		<P>  The time on the server is ${serverTime}. </P>
		
		<a href="${pageContext.request.contextPath}/getLogin">login</a>
		<a href="${pageContext.request.contextPath}/insertMemberForm">insertMember</a>
		<a href="${pageContext.request.contextPath}/getMemberList">memberList</a>
		<a href="${pageContext.request.contextPath}/insertCategoryForm">insertCategory</a>
		<a href="${pageContext.request.contextPath}/selectCategoryList">categoryList</a>
		<a href="${pageContext.request.contextPath}/insertBoardForm">insertBoard</a>
		<a href="${pageContext.request.contextPath}/#">새로 추가하시오</a>
		
		
		
	</body>
</html>
