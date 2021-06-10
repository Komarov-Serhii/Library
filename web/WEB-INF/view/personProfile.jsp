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
            <a class="btn" href="${pageContext.request.contextPath}/view/language/personProfile?language=RU">RU</a>
            <a class="btn" href="${pageContext.request.contextPath}/view/language/personProfile?language=EN">EN</a>
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
                            <h1><fmt:message key="myProfile"/></h1>
                        </div>
                    </div>
                    <div class="plansBlockProfile">

                        <div class="serviceBlock">
                            <table class="tableService sortable">
                                <thead>
                                <tr>
                                    <th><fmt:message key="name"/></th>
                                    <th>Email</th>
                                    <th><fmt:message key="password"/></th>
                                    <th><fmt:message key="edit"/></th>
                                </tr>

                                <tr>
                                    <td> ${person.name}</td>
                                    <td> ${person.email}</td>
                                    <td> ****</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/view/personProfile?id=${person.id}&button=set&name=${person.name}&email=${person.email}&password=${person.password}"
                                           onclick="return confirm('<fmt:message
                                                   key="editPersonConfirm"/>')"><fmt:message key="edit"/></a>
                                    </td>
                                </tr>
                                </thead>
                            </table>
                            <c:if test="${requestScope.wrongData}">
                                <p><fmt:message key="incorrectEmailOrPass"/></p>
                            </c:if>
                        </div>
                        <c:if test="${tab}">
                        <div class="serviceBlock">
                            <p><fmt:message key="edit"/></p>
                            <form method="post"
                                  action="${pageContext.request.contextPath}/view/personProfile?id=${param.get("id")}&button=update">
                                <p>
                                    <label>
                                        <input class="tariff1" type="text" value="${param.get("name")}" required placeholder="Name"
                                               name="name">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="email" value="${param.get("email")}"
                                               required placeholder="Email" name="email">
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="tariff1" type="password" required placeholder="password"
                                               name="password">
                                    </label>
                                </p>
                                <input class="submitBtn" type="submit"
                                       onclick="return confirm('<fmt:message key="updateProfile"/>')"
                                       value="<fmt:message key="update"/>">
                            </form>
                        </div>
                        </c:if>
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
