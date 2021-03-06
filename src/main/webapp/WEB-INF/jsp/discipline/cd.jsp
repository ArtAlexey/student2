<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Создание новой дисциплины</h2>
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
<p>Для того чтобы создать новую дисциплину заполните все поля и нажмите кнопку "Создать"</p>

    <form action="/cd" method="post">
        <div class="field">
            <label for="dName">Название</label>
            <input type="text" id="dName" name="dName">
        </div>
        <input class="input-line" type="submit" value="Создать дисциплину">
    </form>

</div>
<div class="div-end">2019г.</div>

</body>
</html>