<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>СУС</title>
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Изменение дисциплины</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li"><a href="/disciplines" class="link-a">Дисциплины</a></li>
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

    <form action="/modify-discipline" method="post">
        <div class="field">
            <label for="nameDiscipline">Название</label>
            <input type="text" id="nameDiscipline" name="secondName" placeholder="${discipline.discipline}" required autofocus>
        </div>
        <input type="submit" value="Изменить дисциплину" class="input-line">
        <input type="hidden" name="discId" value="${discipline.id}">
    </form>
</div>
<div class="div-end">2019г.</div>

</body>
</html>