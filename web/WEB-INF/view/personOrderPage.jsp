<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: komarov_s_s--%>
<%--  Date: 02.06.2021--%>
<%--  Time: 02:34--%>
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
<%--    <title><fmt:message key="myOrders"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--    <div class="w3-center">--%>
<%--        <h3><fmt:message key="myOrders"/></h3>--%>
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
<%--            <a href="${pageContext.request.contextPath}/view/language/personOrderPage?language=RU">RU</a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/personOrderPage?language=EN">EN</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<table>--%>
<%--    <tr>--%>
<%--        <th><fmt:message key="name"/></th>--%>
<%--        <th><fmt:message key="author"/></th>--%>
<%--        <th><fmt:message key="genre"/></th>--%>
<%--        <th><fmt:message key="publisher"/></th>--%>
<%--        <th><fmt:message key="publisherDate"/></th>--%>
<%--        <th><fmt:message key="description"/></th>--%>
<%--        <th><fmt:message key="price"/></th>--%>
<%--        <th><fmt:message key="decline"/></th>--%>
<%--    </tr>--%>

<%--    <c:forEach items="#{books}" var="a">--%>
<%--        <tr>--%>
<%--            <td> ${a.id}</td>--%>
<%--            <td> ${a.name}</td>--%>
<%--            <td> ${a.author}</td>--%>
<%--            <td> ${a.genre}</td>--%>
<%--            <td> ${a.publisher}</td>--%>
<%--            <td> ${a.publisherDate}</td>--%>
<%--            <td> ${a.description}</td>--%>
<%--            <td> ${a.price}</td>--%>
<%--            <td><a href="${pageContext.request.contextPath}/view/personOrderPage?id=${a.id}&button=decline"--%>
<%--                   onclick="return confirm('<fmt:message key="declineOrderConfirm"/>')"><fmt:message key="decline"/></a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

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
    <title><fmt:message key="myOrders"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">
    <div class="logoBlock">
        <div style="font-size: 16px; text-align: end;">
            <a class="btn" href="${pageContext.request.contextPath}/view/language/personOrderPage?language=RU">RU</a>
            <a class="btn" href="${pageContext.request.contextPath}/view/language/personOrderPage?language=EN">EN</a>
        </div>
        <p id="pageLogo"><fmt:message key="myLibrary"/></p>
        <div class="adminmenu">
            <ul>
                <li><a class="scroll-animite btn"
                       href="${pageContext.request.contextPath}/view/personPage"><fmt:message key="personPage"/></a>
                </li>
                <li><a class="scroll-animite logOutBtn"
                       href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a></li>
            </ul>
        </div>
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
                            <h1><fmt:message key="myOrders"/></h1>
                        </div>
                    </div>
                    <div class="plansBlock">
                        <table class="tableService sortable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th><fmt:message key="name"/></th>
                                <th><fmt:message key="author"/></th>
                                <th><fmt:message key="genre"/></th>
                                <th><fmt:message key="publisher"/></th>
                                <th><fmt:message key="publisherDate"/></th>
                                <th><fmt:message key="description"/></th>
                                <th><fmt:message key="price"/></th>
                                <th><fmt:message key="decline"/></th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orders}" var="a">
                                <tr class="highlight">
                                    <td> ${a.id}</td>
                                    <td> ${a.name}</td>
                                    <td> ${a.author}</td>
                                    <td> ${a.genre}</td>
                                    <td> ${a.publisher}</td>
                                    <td> ${a.publisherDate}</td>
                                    <td> ${a.description}</td>
                                    <td> ${a.price}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/personOrderPage?id=${a.id}&button=decline"
                                           onclick="return confirm('<fmt:message
                                                   key="declineOrderConfirm"/>')"><fmt:message key="decline"/></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
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


