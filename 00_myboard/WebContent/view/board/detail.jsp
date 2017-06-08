<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
		<c:import url="/view/include/topMenu.jsp" />
	</div>	
	<div>
		<table>		
		<tr>		
		  <td>번호<td>
			<td><c:out value="${board.no}" /><td>
		</tr>		
		<tr>		
		  <td>제목<td>
			<td><c:out value="${board.title}" /><td>
		</tr>		
		<tr>		
		  <td>글쓴이<td>
			<td><c:out value="${board.writer}" /><td>
		</tr>		
		<tr>		
		  <td>내용<td>
			<td><c:out value="${board.content}" /><td>
		</tr>		
		<tr>		
		  <td>등록일<td>
		  <td>
		  	  <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
		  </td>	  
		</tr>
		<tr>		
		  <td>첨부파일<td>
			<td><a href="download?path=<c:out value="${file.filePath}" />&sName=<c:out value="${file.systemName }"/>&dName=<c:out value="${file.oriName }"/>"><c:out value="${file.oriName }"/></a><td>
		</tr>		
		</table>		
		<a href='updateForm?no=<c:out value="${board.no}" />'>수정</a>
		<a href='delete?no=<c:out value="${board.no}" />'>삭제</a>
		<a href='list'>목록</a>
		<form action="writeComment">
		<table>
		<tr>
			<td>댓글달기</td>
			<td><input type="text" readonly value="${user.id}"/></td>
			<td><input type="text" name="comment"/><button>등록</button></td>
		</tr>
		<c:forEach var="comment" items="list">
		<tr>
			<td><c:out value="${comment.userId }"/></td>	
			<td><c:out value="${comment.content }"/></td>	
			<td><c:out value="${comment.regDate }"/></td>	
		</tr>
		</c:forEach>
		</table>
		</form>
	</div>	
	<div>
		<c:import url="/view/include/footer.jsp" />
	</div>	
</div>
</body>
</html>