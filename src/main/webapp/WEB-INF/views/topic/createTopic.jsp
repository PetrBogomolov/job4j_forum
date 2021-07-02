<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/saveTopic'/>" method='POST'>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type='text' name='name' required></td>
        </tr>
        <tr>
            <td>Статус:</td>
            <td>
                <select name="status">
                    <c:forEach var="status" items="${statuses}">
                        <option value="${status.id}">${status.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form>
</body>
</html>
