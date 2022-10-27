<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:bundle basename="messages">
		<fmt:message key="page.title" />
	</fmt:bundle></title>
</head>
<body>
	<div align="center">
		<h1>
			<fmt:bundle basename="messages">
				<fmt:message key="page.home.heading" />
			</fmt:bundle>
		</h1>
		<a href="${pageContext.request.contextPath}/admin"><fmt:bundle
				basename="messages">
				<fmt:message key="page.goto.admin" />
			</fmt:bundle></a>
	</div>
</body>
</html>
