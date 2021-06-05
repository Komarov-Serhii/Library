<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<!DOCTYPE html>
<head>
    <title>Admin: Main page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nicepage.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Page-1.css" media="screen">
</head>
<body class="u-body u-overlap">
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/language/admin/adminPage?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/admin/adminPage?language=EN">EN</a>
        </div>
    </div>
</div>
<section class="u-align-center u-clearfix u-hidden-md u-hidden-sm u-hidden-xs u-section-1" id="sec-ac1d">
    <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-container-style u-gradient u-group u-hidden-md u-hidden-sm u-hidden-xs u-group-1">
            <div class="u-container-layout u-valign-middle-xl u-container-layout-1">
                <h1 class="u-align-left u-text u-text-1"><fmt:message key="dispatcher"/></h1>
                <p class="u-text u-text-default u-text-2">Date/Time: <span id="datetime"></span></p>
                <script src="${pageContext.request.contextPath}/js/time.js">
                </script>
            </div>
        </div>
        <div class="u-layout-grid u-list u-list-1">
            <div class="u-repeater u-repeater-1"></div>
        </div>
        <div class="u-border-1 u-border-grey-75 u-container-style u-group u-white u-group-2">
            <div class="u-container-layout u-container-layout-2">
                <h2 class="u-align-center u-text u-text-3"><fmt:message key="mainPage"/></h2>
                <h4 class="u-align-left u-text u-text-4"><fmt:message key="countUser"/>: ${people}</h4>
                <h4 class="u-align-left u-text u-text-6"><fmt:message key="countActive"/>: ${active}</h4>
                <h4 class="u-align-left u-text u-text-8"><fmt:message key="countBlocked"/> : ${blocked}</h4>
                <h4 class="u-align-left u-text u-text-8"><fmt:message key="countOrder"/> : ${order}</h4>
            </div>
        </div>
        <div class="u-border-1 u-border-grey-75 u-container-style u-group u-hidden-md u-hidden-sm u-hidden-xs u-white u-group-3">
            <div class="u-container-layout u-valign-top u-container-layout-3">
                <a href="${pageContext.request.contextPath}/view/admin/adminPage" class="u-border-0 u-btn u-button-style u-none u-text-palette-5-dark-1 u-btn-1"><fmt:message key="mainPage"/></a>
                <a href="${pageContext.request.contextPath}/view/admin/listBook" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-5-dark-1 u-btn-2"><fmt:message key="books"/></a>
                <a href="${pageContext.request.contextPath}/view/admin/listPerson" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-5-dark-1 u-btn-3"><fmt:message key="users"/></a>
                <a href="${pageContext.request.contextPath}/view/admin/orderPage" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-5-dark-1 u-btn-3"><fmt:message key="orders"/></a>
                <a href="${pageContext.request.contextPath}/view/logout" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-5-dark-1 u-btn-4"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>
</section>
</body>
