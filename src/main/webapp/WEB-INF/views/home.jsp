<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 9/23/2019
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<link rel="stylesheet" href="<st:url value="/resources/css/bootstrap.min.css"/>">--%>
<link href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/example.css" rel="stylesheet">
<c:set var="M" value="M"/>
<c:set var="F" value="F"/>
<fmt:bundle basename="messages"/>
<fmt:message key="message.welcome" var="welcome"/>

<html>
<head>

<%--

    <script src="/webjars/popper.js/1.14.7/dist/popper.min.js"></script>
--%>

    <script src="/webjars/jquery/3.2.1/dist/jquery.slim.min.js"></script>

<title>home</title>
</head>
<header>
    <h1 class="text-lg-center text-info bg-dark"> Admins only can modify news <a href="/update" class="btn btn-success">Modify-News</a></h1>
</header>
<body>
<script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="/webjars/jquery/3.2.1/dist/jquery.min.js"></script>


<div class="container Rmargin">
<div id="crsl" class="carousel slide w-50 border border-primary" data-ride="carousel" style="alignment: center">

    <ol class="carousel-indicators">
        <li data-target="#crsl" data-slide-to="0" class="active"></li>

    </ol>

    <div class="carousel-inner">
        <c:forEach var="cur" items="${news}" varStatus="index">


            <c:if test="${index.count eq 1}">
                <div class="carousel-item active">
            </c:if>
            <c:if test="${index.count ne 1}">
                <div class="carousel-item">
            </c:if>

            <img class="d-block w-100 h-50" src="/imgs?imgID=${cur.imagePath}" alt="${cur.imagePath}"/>
                <div href="#crsl" class="carousel-caption"><h3>${cur.title}</h3></div>
        </div>

        </c:forEach>
    </div>

    <a class="carousel-control-prev" href="#crsl" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#crsl" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>

</div>
</div>


    <div class="row">
        <c:forEach var="cur" items="${news}" varStatus="index">
            <div class="col col-md-12">
                <div class="card">
                    <div class="card-header">
                        ${cur.title}
                    </div>
                    <div class="card-body">
                        <img width="100px" height="100px"  src="/imgs?imgID=${cur.imagePath}">
                        <p class="card-text">${cur.description.substring(0,5)}...</p>
                        <a href="/news?id=${cur.id}"  class="btn btn-info">See More</a>
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

<%--
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
--%>
</html>
