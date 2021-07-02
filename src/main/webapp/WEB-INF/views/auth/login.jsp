<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<a href="<c:url value='/reg'/>">Регистрация</a>
<div class="card-header">
    <h4>Вход</h4>
</div>
<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
        <c:out value="${errorMessage}"/>
    </div>
</c:if>
<form name='login' action="<c:url value='/login'/>" method='POST'>
    <table>
        <tr>
            <td>Пользователь:</td>
            <td>
                <input type='text' name='username' placeholder="Введите ваш логин..." required>
            </td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td>
                <input type='password' name='password' placeholder="Введите ваш пароль..." required/>
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Войти"/></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
