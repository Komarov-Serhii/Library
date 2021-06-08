<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: komarov_s_s--%>
<%--  Date: 24.05.2021--%>
<%--  Time: 23:03--%>
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
<%--    <title><fmt:message key="listBooks"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div align="center">--%>
<%--    <div class="w3-center">--%>
<%--        <h3><fmt:message key="listBooks"/></h3>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div align="left">--%>
<%--    <h2><fmt:message key="myLibrary"/></h2>--%>
<%--</div>--%>
<%--<div align="right">--%>
<%--    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">--%>
<%--        <div class=" w3-green">--%>
<%--            <a href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/admin/adminPage"><fmt:message key="admin"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/admin/listBook?language=RU">RU</a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/language/admin/listBook?language=EN">EN</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div align="left">--%>
<%--    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">--%>
<%--        <div class=" w3-green">--%>
<%--            <a href="${pageContext.request.contextPath}/view/admin/listBook?sort=sortName"><fmt:message key="name"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/admin/listBook?sort=sortAuthor"><fmt:message--%>
<%--                    key="author"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/admin/listBook?sort=sortPublisher"><fmt:message--%>
<%--                    key="publisher"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/view/admin/listBook?sort=sortPublisherDate"><fmt:message--%>
<%--                    key="publisherDate"/></a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<table>--%>
<%--    <tr>--%>
<%--        <th>№</th>--%>
<%--        <th><fmt:message key="name"/></th>--%>
<%--        <th><fmt:message key="author"/></th>--%>
<%--        <th><fmt:message key="genre"/></th>--%>
<%--        <th><fmt:message key="publisher"/></th>--%>
<%--        <th><fmt:message key="publisherDate"/></th>--%>
<%--        <th><fmt:message key="description"/></th>--%>
<%--        <th><fmt:message key="price"/></th>--%>
<%--        <th><fmt:message key="delete"/></th>--%>
<%--        <th><fmt:message key="edit"/></th>--%>
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
<%--            <td><a href="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=delete"--%>
<%--                   onclick="return confirm('<fmt:message key="removeBookConfirm"/>')"><fmt:message key="delete"/></a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <form class="w3-container" align="center" method="post"--%>
<%--                      action="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=set&name=${a.name}&author=${a.author}&genre=${a.genre}&publisher=${a.publisher}&publisherDate=${a.publisherDate}&description=${a.description}&price=${a.price}"--%>
<%--                      onclick="return confirm('<fmt:message key="editBookConfirm"/>')">--%>

<%--                    <button type="submit" value="set" name="button"><fmt:message key="edit"/></button>--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<%--    <c:if test="${win}">--%>
<%--        <form class="w3-container" align="center" method="post"--%>
<%--              action="${pageContext.request.contextPath}/view/admin/listBook?id=${param.get("id")}&button=update"--%>
<%--              onclick="return confirm('<fmt:message key="updateBookConfirm"/>')">--%>


<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("name")}"--%>
<%--                           name="name">--%>
<%--                </label>--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("author")}" name="author">--%>
<%--                </label>--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("genre")}" name="genre">--%>
<%--                </label>--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("publisher")}" name="publisher">--%>
<%--                </label>--%>
<%--            </p>--%>
<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("publisherDate")}" name="publisherDate">--%>
<%--                </label>--%>
<%--            </p>--%>
<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("description")}" name="description">--%>
<%--                </label>--%>
<%--            </p>--%>

<%--            <p>--%>
<%--                <label>--%>
<%--                    <input class="w3-input" type="text" value="${param.get("price")}" name="price">--%>
<%--                </label>--%>
<%--            </p>--%>

<%--            <button type="submit" value="update" name="button"><fmt:message key="update"/></button>--%>
<%--        </form>--%>
<%--    </c:if>--%>
<%--</table>--%>


<%--<form class="w3-container" align="center" method="post"--%>
<%--      action="${pageContext.request.contextPath}/view/admin/listBook">--%>

<%--    <button type="submit" value="add" name="button"><fmt:message key="add"/></button>--%>
<%--</form>--%>
<%--<c:if test="${window}">--%>
<%--    <form class="w3-container" align="center" method="post"--%>
<%--          action="${pageContext.request.contextPath}/view/admin/listBook?button=addSubmit"--%>
<%--          onclick="return confirm('<fmt:message key="addBookConfirm"/>')">--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="name"/>"--%>
<%--                       name="name">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="author"/>" name="author">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="genre"/>" name="genre">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="publisher"/>"--%>
<%--                       name="publisher">--%>
<%--            </label>--%>
<%--        </p>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="publisherDate"/>"--%>
<%--                       name="publisher_date">--%>
<%--            </label>--%>
<%--        </p>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="description"/>"--%>
<%--                       name="description">--%>
<%--            </label>--%>
<%--        </p>--%>

<%--        <p>--%>
<%--            <label>--%>
<%--                <input class="w3-input" type="text" required placeholder="<fmt:message key="price"/>" name="price">--%>
<%--            </label>--%>
<%--        </p>--%>


<%--        <input class="w3-button w3-green" type="submit" value="<fmt:message key="add"/>" name="button">--%>
<%--    </form>--%>
<%--</c:if>--%>
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
    <title><fmt:message key="listBooks"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">

        <div class="logoBlock">
            <div style="font-size: 16px; text-align: end;">
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/logout"><fmt:message key="logout"/></a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/admin/adminPage"><fmt:message key="admin"/></a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/language/admin/listBook?language=RU">RU</a>
                <a class="loginBtn"
                   href="${pageContext.request.contextPath}/view/language/admin/listBook?language=EN">EN</a>
            </div>
            <p id="pageLogo">ISPAdmin</p>
            <div class="searchFormDiv">
                <form class="searchForm" method="post"
                      action="${pageContext.request.contextPath}/view/admin/listBook">
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
                            <h1><fmt:message key="listBooks"/></h1>
                            <div class="addBookBtn">
                                <a class="addBut" href="${pageContext.request.contextPath}/view/admin/listBook?button=add"
                                   onclick="return confirm('<fmt:message
                                           key="removeBookConfirm"/>')">Add Book</a>
                            </div>
                        </div>
                    </div>
                    <c:if test="${win1}">
                        <div class="newTariff">
                            <form method="post"
                                  action="${pageContext.request.contextPath}/view/admin/listBook?param=${param.get('param')}&id=${param.get("id")}&command=updateCommand">
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("name")}" required
                                               placeholder="1"
                                               name="name">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("description")}" required
                                               placeholder="2"
                                               name="description">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("price")}" required
                                               placeholder="3"
                                               name="price">
                                    </label>
                                </p>
                                <input class="submitBtn" type="submit"
                                       onclick="return confirm('<fmt:message key="updateConfirm"/>')"
                                       value="<fmt:message key="update"/>">
                            </form>
                        </div>
                    </c:if>
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
                                    <th><fmt:message key="delete"/></th>
                                    <th><fmt:message key="edit"/></th>
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
                                        <td>
                                            <a href="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=delete"
                                               onclick="return confirm('<fmt:message
                                                       key="removeBookConfirm"/>')"><fmt:message key="delete"/></a>
                                        </td>
                                        <td>
                                            <a class="updateButton"
                                               href="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=set&name=${a.name}&author=${a.author}&genre=${a.genre}&publisher=${a.publisher}&publisherDate=${a.publisherDate}&description=${a.description}&price=${a.price}"><fmt:message
                                                    key="edit"/></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <c:if test="${win}">
                        <div class="newTariff">
                            <form method="post"
                                  action="${pageContext.request.contextPath}/view/admin/listBook?param=${param.get('param')}&id=${param.get("id")}&command=updateCommand">
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("name")}" required
                                               placeholder="1"
                                               name="name">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("description")}" required
                                               placeholder="2"
                                               name="description">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("price")}" required
                                               placeholder="3"
                                               name="price">
                                    </label>
                                </p>
                                <input class="submitBtn" type="submit"
                                       onclick="return confirm('<fmt:message key="updateConfirm"/>')"
                                       value="<fmt:message key="update"/>">
                            </form>
                        </div>
                    </c:if>
                    <div class="plansBlock">

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
                                <th><fmt:message key="delete"/></th>
                                <th><fmt:message key="edit"/></th>
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
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=delete"
                                           onclick="return confirm('<fmt:message
                                                   key="removeBookConfirm"/>')"><fmt:message key="delete"/></a>
                                    </td>
                                    <td>
                                        <a class="updateButton"
                                           href="${pageContext.request.contextPath}/view/admin/listBook?id=${a.id}&button=set&name=${a.name}&author=${a.author}&genre=${a.genre}&publisher=${a.publisher}&publisherDate=${a.publisherDate}&description=${a.description}&price=${a.price}"><fmt:message
                                                key="edit"/></a>
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