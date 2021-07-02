<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<a href="<c:url value='/login'/>">Войти</a>
<div class="card-header">
    <h4>Регистрация</h4>
</div>
<div style="color:red; font-weight: bold; margin: 30px 0px;">
    <c:out value="${error}"/>
</div>
<form action="<c:url value='/reg'/>" method='POST'>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type='text' name='username' placeholder="Введите ваш логин..." required></td>
        </tr>
        <tr>
            <td>Почта:</td>
            <td><input type='text' name='email' placeholder="Введите ваш email..." required></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password' placeholder="Введите ваш пароль..." required/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Зарегистрироваться"/></td>
        </tr>
    </table>
</form>
</body>
</html>
