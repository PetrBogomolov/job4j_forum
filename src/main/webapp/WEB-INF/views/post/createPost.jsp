<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/savePost?topicId=${topicId}'/>" method='POST'>
    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name' required></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='description' required></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Опубликовать"/></td>
        </tr>
    </table>
</form>
</body>
</html>
