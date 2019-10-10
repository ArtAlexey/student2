<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Вход в систему</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li">
            <c:choose>
                <c:when test="${isLogin eq 1}">
                    <a href="/logout" class="link-a">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="/login" class="link-a">Login</a>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</nav>

<div class="div-general">
    <h2>Вход в систему: </h2>
    <form action="/login" method="post">
        <div class="field">
            <label for="login">Введите логин</label>
            <input type="text" id="login" name="login" placeholder="Ваш логин" required autofocus>
        </div>
        <div class="field">
            <label for="password">Введите пароль</label>
            <input type="text" id="password" name="password" placeholder="Ваш пароль" required autofocus>
        </div>
        <div class="field">
            <label for="role">Выберите роль</label>
            <select id="role" name="role">
                <option value="admin">Администратор</option>
                <option value="student">Студент</option>
            </select>
        </div>
        <input type="submit" value="Войти">
        <c:if test="${error eq 1}">
            <p>Пользователь не найден</p>
        </c:if>
    </form>
</div>
<div class="div-end">2019г.</div>
</body>
</html>