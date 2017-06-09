<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
// 	List<VO> list = new ArrayList<>();
// 	VO vo = new VO();
// 	vo.setMsg("성공");
// 	list.add(vo); 

	List<Map<String,String>> list = new ArrayList<>();
	Map<String, String> map = new HashMap<>();
	map.put("msg", "성공");
	list.add(map);
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 실행시 화면에 "성공"이 뜨도록 코드 작성 --%>
	${list[0].msg }<br>
</body>
</html>