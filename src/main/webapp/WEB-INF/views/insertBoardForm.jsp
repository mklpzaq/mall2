<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	
	<h2> 게시글 작성 </h2>
 
<div class="container">
    <form action="${pageContext.request.contextPath}/insertBoardForm" method="post">
      <div class="form-group">
        <label for="boardTitle">제목</label>
        <input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목을 입력하세요.">
      </div>
     <!--  <div class="form-group">
        <label for="writer">작성자</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="내용을 입력하세요.">
      </div> -->
      <div class="form-group">
        <label for=boardContent">내용</label>
        <textarea class="form-control" id="boardContent" name="boardContent" rows="3"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>

</body>
</html>