<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/saveUpdatePost?postId=${post.id}&topicId=${post.topic.id}'/>" method='POST'>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type='text' name='name' value="<c:out value="${post.name}"/>" required></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='description' value="<c:out value="${post.description}"/>" required></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Изменить"/></td>
        </tr>
    </table>
</form>
</body>
</html>
