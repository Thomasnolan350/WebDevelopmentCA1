<%@ page language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp" />

<h2>Login</h2>

<s:form action="userLogin">
    <s:textfield name="loginUsername" label="Username" />
    <s:password  name="loginPassword" label="Password" />
    <s:submit value="Login" />
</s:form>

</body>
</html>
