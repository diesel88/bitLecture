<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th colspan="2">입사 지원 내용</th>
		</tr>
		<tr>
			<td>이름</td>
			<td><c:out value="${param.name}" default="정보 없음" /></td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><c:out value="${param.phone}" default="정보 없음" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><c:out value="${param.email}" default="정보 없음" /></td>
		</tr>
		<tr>
			<td>학과</td>
			<td>
				<c:choose>
						<c:when test="${param.major=='1'}">
							<c:out value="컴퓨터공학" />
						</c:when>
						<c:when test="${param.major=='2'}">
							<c:out value="전자과" />
						</c:when>
						<c:when test="${param.major=='3'}">
							<c:out value="수학과" />
						</c:when>
						<c:when test="${param.major=='4'}">
							<c:out value="산업공학과" />
						</c:when>
						<c:otherwise>
							<c:out value="선택안함" />
						</c:otherwise>
					</c:choose>			
			</td>
		</tr>
		<tr>
			<td>이수 과목</td>
			<td><c:if test="${fn:length(paramValues.detail) == 0 }">입력하지 않음</c:if>
				<c:forEach var="d" items="${paramValues.detail}" varStatus="loop">
					<c:if test="${not loop.first }">,</c:if>
					<c:choose>
						<c:when test="${d=='1'}">
							<c:out value="EJB" />
						</c:when>
						<c:when test="${d=='2'}">
							<c:out value="Spring" />
						</c:when>
						<c:when test="${d=='3'}">
							<c:out value="UML" />
						</c:when>
						<c:when test="${d=='4'}">
							<c:out value="JDBC" />
						</c:when>
						<c:when test="${d=='5'}">
							<c:out value="서블릿" />
						</c:when>
						<c:when test="${d=='6'}">
							<c:out value="JSP" />
						</c:when>
					</c:choose>
				</c:forEach></td>
		</tr>
		<tr>
			<td>정보 발송 방법</td>
			<td><c:choose>
					<c:when test="${param.mehod=='1' }">
						<c:out value="이메일" />
					</c:when>
					<c:otherwise>
						<c:out value="우편발송" />
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<td>정보 발송 여부</td>
			<td><c:choose>
					<c:when test="${param.agree=='1' }">
						<c:out value="동의함" /></td>
			</c:when>
			<c:otherwise>
				<c:out value="동의하지 않음" />
			</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>