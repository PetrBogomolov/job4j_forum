<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <title> Forum </title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>Тема</th>
        <th>Дата создания</th>
        <th>Статус</th>
        <th>Автор</th>
        <th>Постов</th>
        <th>Действия</th>
    </tr>
    </thead>
    <ul class="nav float-left">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value='/topic/create'/>">
                Добавить тему
            </a>
        </li>
    </ul>
    <ul class="nav float-right">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value='/logout'/>">
                <c:out value="${user.username}"/> | Выход
            </a>
        </li>
    </ul>
    <tbody>
    <c:forEach items="${topics}" var="topic">
        <tr>
            <th>
                <a href="<c:url value='/post/discussion?topicId=${topic.id}'/>">
                    <c:out value="${topic.name}"/>
                </a>
            </th>
            <th><fmt:formatDate type="date" value="${topic.created}" pattern="d MMMM yyyy HH:mm"/></th>
            <th><c:out value="${topic.status.name}"/></th>
            <th><c:out value="${topic.user.username}"/></th>
            <th><c:out value="${topic.posts.size()}"/></th>
            <th><a href="<c:url value='/topic/update?id=${topic.id}'/>"><i class="bi bi-pencil-square"></i></a></th>
            <th><a href="<c:url value='/topic/delete?id=${topic.id}'/>"><i class="bi bi-trash-fill"></i></a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
