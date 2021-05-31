<%--
  Created by IntelliJ IDEA.
  User: komarov_s_s
  Date: 24.05.2021
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<div align="center">
    <div class="w3-center">
        <h3>List books</h3>
    </div>
</div>
<div align="left">
    <h2>My Library</h2>
</div>
<div align="right">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/logout">logout</a>
            <a href="${pageContext.request.contextPath}/view/adminPage">admin</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=RU">RU</a>
            <a href="${pageContext.request.contextPath}/view/language/registration?language=EN">EN</a>
        </div>
    </div>
</div>

<div align="left">
    <div class="w3-card-4 w3-quarter w3-margin-top w3-display-topmiddle">
        <div class=" w3-green">
            <a href="${pageContext.request.contextPath}/view/listBook?sort=sortName">Name</a>
            <a href="${pageContext.request.contextPath}/view/listBook?sort=sortAuthor">Author</a>
            <a href="${pageContext.request.contextPath}/view/listBook?sort=sortPublisher">Publisher</a>
            <a href="${pageContext.request.contextPath}/view/listBook?sort=sortPublisherDate">Publisher_Date</a>
        </div>
    </div>
</div>

<table>
    <tr>
        <th>№</th>
        <th>Название</th>
        <th>Автор</th>
        <th>Жанр</th>
        <th>Издательство</th>
        <th>Год издательства</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Удалить</th>
        <th>Изменить</th>
    </tr>

    <c:forEach items="#{books}" var="a">
        <tr>
            <td> ${a.id}</td>
            <td> ${a.name}</td>
            <td> ${a.author}</td>
            <td> ${a.genre}</td>
            <td> ${a.publisher}</td>
            <td> ${a.publisher_date}</td>
            <td> ${a.description}</td>
            <td> ${a.price}</td>
            <td><a href="${pageContext.request.contextPath}/view/listBook?id=${a.id}&button=delete"
                   onclick="return confirm('Are you sure you want to remove this book?')">delete</a>
            </td>
            <td>
                <form class="w3-container" align="center" method="post"
                      action="${pageContext.request.contextPath}/view/listBook?id=${a.id}&button=set&name=${a.name}&author=${a.author}&genre=${a.genre}&publisher=${a.publisher}&publisher_date=${a.publisher_date}&description=${a.description}&price=${a.price}"
                      onclick="return confirm('Are you sure you want to setting this book?')">

                    <button type="submit" value="set" name="button">SET</button>
                </form>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${win}">
        <form class="w3-container" align="center" method="post"
              action="${pageContext.request.contextPath}/view/listBook?id=${param.get("id")}&button=update"
              onclick="return confirm('Are you sure you want to update this book?')">


            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("name")}"
                           name="name">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("author")}" name="author">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("genre")}" name="genre">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("publisher")}" name="publisher">
                </label>
            </p>
            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("publisher_date")}" name="publisher_date">
                </label>
            </p>
            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("description")}" name="description">
                </label>
            </p>

            <p>
                <label>
                    <input class="w3-input" type="text" value="${param.get("price")}" name="price">
                </label>
            </p>

                <button type="submit" value="update" name="button">Update</button>
        </form>
    </c:if>
</table>


<form class="w3-container" align="center" method="post"
      action="${pageContext.request.contextPath}/view/listBook">

    <button type="submit" value="add" name="button">ADD</button>
</form>
<c:if test="${window}">
    <form class="w3-container" align="center" method="post"
          action="${pageContext.request.contextPath}/view/listBook">

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="name"
                       name="name">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="author" name="author">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="genre" name="genre">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="publisher" name="publisher">
            </label>
        </p>
        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="publisher_date" name="publisher_date">
            </label>
        </p>
        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="description" name="description">
            </label>
        </p>

        <p>
            <label>
                <input class="w3-input" type="text" required placeholder="price" name="price">
            </label>
        </p>


        <input class="w3-button w3-green" type="submit" value="addSubmit" name="button">
    </form>
</c:if>
</body>
</html>
