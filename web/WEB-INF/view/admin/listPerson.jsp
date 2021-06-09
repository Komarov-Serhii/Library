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
    <title><fmt:message key="listPerson"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">
    <div class="logoBlock">
        <div style="font-size: 16px; text-align: end;">
            <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/listPerson?language=RU">RU</a>
            <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/listPerson?language=EN">EN</a>
        </div>
        <p id="pageLogo">ISPAdmin</p>
        <div class="adminmenu">
            <ul>
                <li><a class="scroll-animite btn"
                       href="${pageContext.request.contextPath}/view/admin/adminPage"><fmt:message key="admin"/></a>
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
                            <h1><fmt:message key="listPerson"/></h1>
                        </div>
                    </div>

                    <c:if test="${win}">
                        <div class="serviceBlock">
                            <c:if test="${requestScope.notBooks}">
                                <p><fmt:message key="PersonDon'tHaveBooks"/></p>
                            </c:if>
                            <c:if test="${!requestScope.notBooks}">
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
                                    </tr>
                                    </thead>

                                    <c:forEach items="${books}" var="b">
                                        <tr>
                                            <td> ${b.id}</td>
                                            <td> ${b.name}</td>
                                            <td> ${b.author}</td>
                                            <td> ${b.genre}</td>
                                            <td> ${b.publisher}</td>
                                            <td> ${b.publisherDate}</td>
                                            <td> ${b.description}</td>
                                            <td> ${b.price}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </div>
                    </c:if>

                    <div class="plansBlock">
                        <table class="tableService sortable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th><fmt:message key="name"/></th>
                                <th>Email</th>
                                <th><fmt:message key="status"/></th>
                                <th><fmt:message key="check"/></th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${people}" var="a">
                                <tr class="highlight">
                                    <td> ${a.id}</td>
                                    <td> ${a.name}</td>
                                    <td> ${a.email}</td>
                                    <c:if test="${a.status == 1}">
                                        <td><a class="block"
                                               href="${pageContext.request.contextPath}/view/admin/listPerson?button=block&id=${a.id}"
                                               onclick="return confirm('<fmt:message
                                                       key="blockPersonConfirm"/>')"><fmt:message key="block"/></a>
                                        </td>
                                    </c:if>
                                    <c:if test="${a.status == 2}">
                                        <td><a class="unblock"
                                               href="${pageContext.request.contextPath}/view/admin/listPerson?button=unblock&id=${a.id}"
                                               onclick="return confirm('<fmt:message
                                                       key="unblockPersonConfirm"/>')"><fmt:message key="unblock"/></a>
                                        </td>
                                    </c:if>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/admin/listPerson?id=${a.id}&button=book">
                                            <fmt:message key="checkBooks"/></a></td>

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
