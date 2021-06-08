<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: komarov_s_s--%>
<%--  Date: 30.05.2021--%>
<%--  Time: 13:27--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"--%>
<%--       scope="session"/>--%>
<%--<fmt:setLocale value="${language}"/>--%>
<%--<fmt:setBundle basename="text"/>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title><fmt:message key="myProfile"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--    <div class="w3-center">--%>
<%--        <h3><fmt:message key="myProfile"/></h3>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div align="left">--%>
<%--    <h2><fmt:message key="myLibrary"/></h2>--%>
<%--</div>--%>
<%--<div align="right">--%>
<%--    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">--%>
<%--        <div class=" w3-green">--%>
<%--            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/personPage"><fmt:message key="personPage"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/personProfile?language=RU">RU</a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/personProfile?language=EN">EN</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<table>--%>
<%--    <tr>--%>
<%--        <th><fmt:message key="name"/></th>--%>
<%--        <th>Email</th>--%>
<%--        <th><fmt:message key="password"/></th>--%>
<%--        <th><fmt:message key="edit"/></th>--%>
<%--    </tr>--%>

<%--        <tr>--%>
<%--            <td> ${person.name}</td>--%>
<%--            <td> ${person.email}</td>--%>
<%--            <td> **** </td>--%>
<%--            <td>--%>
<%--                <form class="w3-container" align="left" method="post"--%>
<%--                      action="${pageContext.request.contextPath}/view/personProfile?id=${person.id}&button=set&name=${person.name}&email=${person.email}&password=${person.password}&status=${person.status}"--%>
<%--                      onclick="return confirm('<fmt:message key="editPersonConfirm"/>')">--%>

<%--                    <button type="submit" value="set" name="button"><fmt:message key="edit"/></button>--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--</table>--%>

<%--<c:if test="${tab}">--%>
<%--    <form class="w3-container" align="left" method="post"--%>
<%--          action="${pageContext.request.contextPath}/view/personProfile?id=${param.get("id")}&button=update"--%>
<%--          onclick="return confirm(<fmt:message key="updateProfile"/>)">--%>


<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" value="${param.get("name")}"--%>
<%--                       name="name">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" value="${param.get("email")}" name="email">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" value="****" name="password">--%>
<%--            </label>--%>
<%--        </p>--%>



<%--        <button type="submit" value="update" name="button"><fmt:message key="update"/></button>--%>
<%--    </form>--%>
<%--</c:if>--%>

<%--</body>--%>
<%--</html>--%>


<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: komarov_s_s--%>
<%--  Date: 21.05.2021--%>
<%--  Time: 13:50--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"--%>
<%--       scope="session"/>--%>
<%--<fmt:setLocale value="${language}"/>--%>
<%--<fmt:setBundle basename="text"/>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title><fmt:message key="personPage"/></title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div align="center">--%>
<%--<div class="w3-center">--%>
<%--    <h3><fmt:message key="personPage"/></h3>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div align="left">--%>
<%--    <h2><fmt:message key="myLibrary"/></h2>--%>
<%--    <form class="w3-container" align="left" method="post"--%>
<%--          action="${pageContext.request.contextPath}/view/personPage">--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="search" required placeholder="<fmt:message key="searchSite"/>"--%>
<%--                       name="search">--%>
<%--            </label>--%>
<%--        </p>--%>
<%--        <div>--%>
<%--            <input class="w3-button w3-margin-bottom w3-green" type="submit"--%>
<%--                   value="<fmt:message key="search"/>" name="sear">--%>
<%--        </div>--%>
<%--        <c:if test="${requestScope.notFoundSearch}">--%>
<%--            <div class="w3-container">--%>
<%--                <p><fmt:message key="notFoundSearch"/></p>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--    </form>--%>

<%--    <div align="center">--%>
<%--        <c:if test="${window}">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th><fmt:message key="name"/></th>--%>
<%--                <th><fmt:message key="author"/></th>--%>
<%--                <th><fmt:message key="genre"/></th>--%>
<%--                <th><fmt:message key="publisher"/></th>--%>
<%--                <th><fmt:message key="publisherDate"/></th>--%>
<%--                <th><fmt:message key="description"/></th>--%>
<%--                <th><fmt:message key="price"/></th>--%>

<%--            </tr>--%>

<%--            <c:forEach items="${list}" var="b">--%>
<%--            <tr>--%>
<%--                <td> ${b.name}</td>--%>
<%--                <td> ${b.author}</td>--%>
<%--                <td> ${b.genre}</td>--%>
<%--                <td> ${b.publisher}</td>--%>
<%--                <td> ${b.publisherDate}</td>--%>
<%--                <td> ${b.description}</td>--%>
<%--                <td> ${b.price}</td>--%>
<%--            </tr>--%>
<%--            </c:forEach>--%>
<%--            </c:if>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div align="right">--%>
<%--    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">--%>
<%--        <div class=" w3-green">--%>
<%--            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/personInfoBookPage"><fmt:message key="navigation"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/personProfile"><fmt:message key="myProfile"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/personPage?language=RU">RU</a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/personPage?language=EN">EN</a>--%>
<%--        </div>--%>
<%--        </div>--%>
<%--        </div>--%>

<%--<div align="left">--%>
<%--    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">--%>
<%--        <div class=" w3-green">--%>
<%--            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortName"><fmt:message key="name"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortAuthor"><fmt:message key="author"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisher"><fmt:message key="publisher"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisherDate"><fmt:message key="publisherDate"/></a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--    <table>--%>
<%--        <tr>--%>
<%--            <th><fmt:message key="name"/></th>--%>
<%--            <th><fmt:message key="author"/></th>--%>
<%--            <th><fmt:message key="genre"/></th>--%>
<%--            <th><fmt:message key="publisher"/></th>--%>
<%--            <th><fmt:message key="publisherDate"/></th>--%>
<%--            <th><fmt:message key="description"/></th>--%>
<%--            <th><fmt:message key="price"/></th>--%>
<%--            <th><fmt:message key="order"/></th>--%>

<%--        </tr>--%>

<%--        <c:forEach items="${books}" var="a">--%>
<%--            <tr>--%>
<%--                <td> ${a.name}</td>--%>
<%--                <td> ${a.author}</td>--%>
<%--                <td> ${a.genre}</td>--%>
<%--                <td> ${a.publisher}</td>--%>
<%--                <td> ${a.publisherDate}</td>--%>
<%--                <td> ${a.description}</td>--%>
<%--                <td> ${a.price}</td>--%>
<%--                <td><a href="${pageContext.request.contextPath}/view/personPage?id=${a.id}&button=order"--%>
<%--                       onclick="return confirm('<fmt:message key="orderBookConfirm"/>')"><fmt:message key="order"/></a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>


<%--        <c:if test="${win}">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th><fmt:message key="name"/></th>--%>
<%--                <th><fmt:message key="author"/></th>--%>
<%--                <th><fmt:message key="genre"/></th>--%>
<%--                <th><fmt:message key="publisher"/></th>--%>
<%--                <th><fmt:message key="publisherDate"/></th>--%>
<%--                <th><fmt:message key="description"/></th>--%>
<%--                <th><fmt:message key="price"/></th>--%>

<%--            </tr>--%>

<%--            <c:forEach items="${list}" var="b">--%>
<%--                <tr>--%>
<%--                    <td> ${b.name}</td>--%>
<%--                    <td> ${b.author}</td>--%>
<%--                    <td> ${b.genre}</td>--%>
<%--                    <td> ${b.publisher}</td>--%>
<%--                    <td> ${b.publisherDate}</td>--%>
<%--                    <td> ${b.description}</td>--%>
<%--                    <td> ${b.price}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </c:if>--%>

<%--    </table>--%>

<%--</body>--%>
<%--</html>--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : pageContext.request.locale}"
       scope="application"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<!DOCTYPE html>
<html lang="java">
<meta charset="utf-8">

<head>
    <title><fmt:message key="myProfile"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">

        <div class="logoBlock">
            <div style="font-size: 16px; text-align: end;">
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/>
                </a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/personPage"><fmt:message key="personPage"/>
                </a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/language/personPage?language=RU">
                    RU
                </a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/language/personPage?language=EN">
                    EN
                </a>
            </div>
            <p id="pageLogo"><fmt:message key="myLibrary"/></p>
        </div>
        <div id="time"><span id="datetime"></span></div>
    </header>
    <!-- Slider area Start -->
    <div class="slider-area">
        <div class="slider-bg text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="slidertext">
                            <h1><fmt:message key="myProfile"/></h1>
                        </div>
                    </div>
                    <div class="plansBlock">

                        <div class="serviceBlock">
                            <table class="tableService sortable">
                                <thead>

                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/styles/js/time.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/rowLight.js"></script>
<script src="${pageContext.request.contextPath}/styles/js/sorttable.js"></script>
</body>
</html>

