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
    <title><fmt:message key="listOrders"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" media="screen">
</head>

<body>
<div id="home"></div>
<div class="ournet-inter-area">
    <header id="header" class="header-area">
    <div class="logoBlock">
        <div style="font-size: 16px; text-align: end;">
            <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/orderPage?language=RU">RU</a>
            <a class="btn" href="${pageContext.request.contextPath}/view/language/admin/orderPage?language=EN">EN</a>
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
                            <h1><fmt:message key="listOrders"/></h1>
                        </div>
                    </div>
                    <div class="plansBlock">
                        <table class="tableService sortable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th><fmt:message key="namePerson"/></th>
                                <th>Email</th>
                                <th><fmt:message key="idBook"/></th>
                                <th><fmt:message key="nameBook"/></th>
                                <th><fmt:message key="author"/></th>
                                <th><fmt:message key="accept"/></th>
                                <th><fmt:message key="reject"/></th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${order}" var="a">
                                <tr class="highlight">
                                    <td> ${a.value.id} <br></td>
                                    <td> ${a.value.name} <br></td>
                                    <td> ${a.value.email} <br></td>
                                    <td> ${a.key.id} <br></td>
                                    <td> ${a.key.name} <br></td>
                                    <td> ${a.key.author} <br></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/admin/orderPage?id=${a.key.id}&button=accept"
                                           onclick="return confirm('<fmt:message key="acceptConfirm"/>')"><fmt:message
                                                key="accept"/></a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/admin/orderPage?id=${a.key.id}&button=reject"
                                           onclick="return confirm('<fmt:message key="rejectConfirm"/>')"><fmt:message
                                                key="reject"/></a>
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

