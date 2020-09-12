<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 10/17/2019
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css">
<html>
<head>
    <title>Modify</title>
</head>
<body>
<spf:form action="/update/modify" method="post" modelAttribute="loadedObject">
    <label class="text-dark">Give Nice Title</label>
    <spf:input path="title" value="${loadedObject.title}"/><br>
    <label class="text-white">Description</label>
    <spf:textarea path="description" value="${loadedObject.description}"/><br>
    <spf:button type="submit" class="btn btn-dark">OK</spf:button>
</spf:form>
</body>
</html>
