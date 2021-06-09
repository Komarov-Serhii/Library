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
    <title><fmt:message key="myLibrary"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">

<%--        <div class="logoBlock">--%>
<%--            <div style="font-size: 16px; text-align: end;">--%>
<%--                <a class="btn"--%>
<%--                   href="${pageContext.request.contextPath}/view/registration"><fmt:message key="registration"/>--%>
<%--                </a>--%>
<%--                <a class="btn"--%>
<%--                   href="${pageContext.request.contextPath}/view/login"><fmt:message key="login"/>--%>
<%--                </a>--%>
<%--                <a class="btn"--%>
<%--                   href="${pageContext.request.contextPath}/view/language/mainPage?language=RU">--%>
<%--                    RU--%>
<%--                </a>--%>
<%--                <a class="btn"--%>
<%--                   href="${pageContext.request.contextPath}/view/language/mainPage?language=EN">--%>
<%--                    EN--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <p id="pageLogo"><fmt:message key="myLibrary"/></p>--%>
<%--            <div class="searchFormDiv">--%>
<%--                <form class="searchForm" method="post"--%>
<%--                      action="${pageContext.request.contextPath}/view/mainPage">--%>
<%--                    <p>--%>
<%--                        <label>--%>
<%--                            <input class="searchField" type="search" required--%>
<%--                                   placeholder="<fmt:message key="searchSite"/>"--%>
<%--                                   name="search">--%>
<%--                        </label>--%>
<%--                    </p>--%>
<%--                    <div>--%>
<%--                        <input class=searchBtn" type="submit"--%>
<%--                               value="<fmt:message key="search"/>" name="sear">--%>
<%--                    </div>--%>
<%--                    <c:if test="${requestScope.notFoundSearch}">--%>
<%--                        <div class="notFoundMessage">--%>
<%--                            <p><fmt:message key="notFoundSearch"/></p>--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>

    <div class="logoBlock">
        <div style="font-size: 16px; text-align: end;">
            <a class="btn" href="${pageContext.request.contextPath}/view/language/mainPage?language=RU">RU</a>
            <a class="btn" href="${pageContext.request.contextPath}/view/language/mainPage?language=EN">EN</a>
        </div>
        <p id="pageLogo"><fmt:message key="myLibrary"/></p>
        <div class="searchFormDiv">
            <form class="searchForm" method="post"
                  action="${pageContext.request.contextPath}/view/mainPage">
                <p>
                    <label>
                        <input class="searchField" type="search" required
                               placeholder="<fmt:message key="searchSite"/>"
                               name="search">
                    </label>
                </p>
                <div>
                    <input class=searchBtn" type="submit"
                           value="<fmt:message key="search"/>" name="sear">
                </div>
                <c:if test="${requestScope.notFoundSearch}">
                    <div class="notFoundMessage">
                        <p><fmt:message key="notFoundSearch"/></p>
                    </div>
                </c:if>
            </form>
        </div>
        <div class="mainmenu">
            <ul>
                <li><a class="scroll-animite btn"
                       href="${pageContext.request.contextPath}/view/registration"><fmt:message key="registration"/></a></li>
                <li><a class="scroll-animite btn"
                       href="${pageContext.request.contextPath}/view/login"><fmt:message key="login"/></a></li>
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
                            <h1><fmt:message key="mainPage"/></h1>
                        </div>
                    </div>
                    <div class="plansBlock">
                        <c:if test="${window}">
                            <div class="serviceBlock">
                                <table class="tableService sortable">
                                    <thead>
                                    <tr>
                                        <th><fmt:message key="name"/></th>
                                        <th><fmt:message key="author"/></th>
                                        <th><fmt:message key="genre"/></th>
                                        <th><fmt:message key="publisher"/></th>
                                        <th><fmt:message key="publisherDate"/></th>
                                        <th><fmt:message key="description"/></th>
                                        <th><fmt:message key="price"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="a">
                                        <tr class="highlight">
                                            <td> ${a.name}</td>
                                            <td> ${a.author}</td>
                                            <td> ${a.genre}</td>
                                            <td> ${a.publisher}</td>
                                            <td> ${a.publisherDate}</td>
                                            <td> ${a.description}</td>
                                            <td> ${a.price}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                        <div class="serviceBlock">
                            <div class="mainmenuSort">
                                <ul class="topSort">
                                    <li><a class="btnSort"><fmt:message key="sort"/> ><i
                                            class="fa fa-angle-down"></i></a>
                                        <ul class="subSort">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortName"><fmt:message
                                                        key="name"/></a>
                                            </li>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortAuthor"><fmt:message
                                                        key="author"/></a>
                                            </li>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisher"><fmt:message
                                                        key="publisher"/></a>
                                            </li>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/view/mainPage?sort=sortPublisherDate"><fmt:message
                                                        key="publisherDate"/>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <table class="tableService sortable">
                                <thead>
                                <tr>
                                    <th><fmt:message key="name"/></th>
                                    <th><fmt:message key="author"/></th>
                                    <th><fmt:message key="genre"/></th>
                                    <th><fmt:message key="publisher"/></th>
                                    <th><fmt:message key="publisherDate"/></th>
                                    <th><fmt:message key="description"/></th>
                                    <th><fmt:message key="price"/></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${books}" var="a">
                                    <tr class="highlight">
                                        <td> ${a.name}</td>
                                        <td> ${a.author}</td>
                                        <td> ${a.genre}</td>
                                        <td> ${a.publisher}</td>
                                        <td> ${a.publisherDate}</td>
                                        <td> ${a.description}</td>
                                        <td> ${a.price}</td>
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