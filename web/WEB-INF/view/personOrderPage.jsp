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


