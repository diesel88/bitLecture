<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입사지원</h1>
<p>아래 항목을 입력해 주세요</p>
<form action="quiz03output.jsp" method="post">
		<table>
			<tr>
				<th colspan="2" align="left">개인정보:</th>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>이메일주소</td>
				<td><input type="text" name="email" size="30"></td>
			</tr>
			<tr>
				<th colspan="2" align="left">학과를 선택해 주세요.</th>
			</tr>
			<tr>
				<td colspan="2">
				<input type="radio" id="major1" name="major" value="1">
				<label for="major1">컴퓨터공학</label>
				<input type="radio" id="major2" name="major" value="2">
				<label for="major2">전자과</label>
				<input type="radio" id="major3" name="major" value="3">
				<label for="major3">수학과</label>
				<input type="radio" id="major4" name="major" value="4">
				<label for="major4">산업공학과</label>
				</td>
			</tr>
			<tr>
				<th colspan="2" align="left">이수 과목은 무엇입니까?</th>
			</tr>
			<tr>
				<td colspan="2">
				<input type="checkbox" id="detail1" name="detail" value="1">
				<label for="detail1">EJB</label>
				<input type="checkbox" id="detail2" name="detail" value="2">
				<label for="detail2">Spring</label>
				<input type="checkbox" id="detail3" name="detail" value="3">
				<label for="detail3">UML</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="checkbox" id="detail4" name="detail" value="4">
				<label for="detail4">JDBC</label>
				<input type="checkbox" id="detail5" name="detail" value="5">
				<label for="detail5">서블릿</label>
				<input type="checkbox" id="detail6" name="detail" value="6">
				<label for="detail6">JSP</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
				정보 발송방법
				<select name="method">
					<option value="1">이메일</option>
					<option value="2">우편발송</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
				<input type="checkbox" id="agree1" name="agree" value="1">
				<label for="agree1">개인정보 이용 약관에 동의합니다.</label>
				
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><button>전송</button></td>
			</tr>
		</table>
	</form>
</body>
</html>