<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 9/23/2019
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/example.css">
<html>
<head>
    <title>update</title>
    <script src="/webjars/jquery/3.2.1/dist/jquery.slim.min.js"></script>
</head>
<body>

<script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="/webjars/jquery/3.2.1/dist/jquery.min.js"></script>


<div class="container row Rmargin border border-danger">
<spf:form action="/update" method="post" modelAttribute="news" enctype="multipart/form-data">
    <div class="form-group">
        <spf:label path="title" for="tit">Give Nice Title</spf:label>
    <spf:input class="form-control" path="title" id="tit" />
    </div>
    <div class="form-group">
        <spf:label path="description" for="des">Give Meaningful Description</spf:label>
    <spf:textarea class="form-control" path="description" id="des" />
    </div>
    <div class="form-group custom-file">
        <spf:label class="custom-file-label" for="customFile" path="image">Choose file</spf:label>
        <spf:input type="file" class="custom-file-input" id="customFile" path="image"/>
    </div>
    <div class="form-group">
    <spf:button type="submit" class="btn btn-primary">Save</spf:button>
    </div>
</spf:form>
</div>
<div id="clsBtn" class="container "><br/>
    <div class="alert alert-success">
        <a href="#clsBtn" class="close" data-dismiss="alert" aria-label="close">×</a>
        <strong>Success!</strong> you are logged in with <strong>${auth.name}</strong> username.
    </div>
</div>
</div>
<div>
    <c:forEach var="cur" items="${newses}" varStatus="index">
        <div class="col col-md-12">
            <div class="card">
                <div class="card-header">
                        ${cur.title}
                </div>
                <div class="card-body">
                    <img width="100px" height="100px"  src="/imgs/${cur.imagePath}">
                    <p class="card-text">${cur.description.substring(0,5)}...</p>
                    <a href="/update/modify?id=${cur.id}" class="btn btn-warning">Modify It</a>
                    <a href="/update/delete?id=${cur.id}"  class="btn btn-danger">Delete It</a>

                </div>
                <div class="card-footer">
                    <hr>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</div>
</body>
</html>
