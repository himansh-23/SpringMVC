
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2 >Your Are </h2>
	<%
    int value = (int)request.getAttribute("value");
	if(value==1)
	{
		out.print("Successfully Login");
	}
	else if(value==2)
	{
		out.print("Not A Valid User");
	}
	else
	{
		out.print("Successfully Register");
	}
	%>
	<a href="index.jsp">Home</a>
</body>
</html>