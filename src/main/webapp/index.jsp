<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>СУС</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/students" class="link-a">Студенты</a></li>
        <li class="mainmenu-li"><a href="/disciplines" class="link-a">Дисциплины</a></li>
        <li class="mainmenu-li"><a href="/terms" class="link-a">Семестры</a></li>
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
    <div class="div-text">
        <h2>Привет!</h2>
        <h3>Вы находитесь на сайте Артемова Алексея.</h3>
        Этот сайт был создан в рамках обучающего курса и является его результатом. В рамках данного проекта продемонстрированы базовые знания в следующих дисциплинах:
        <ul>
            <li>Основы Java</li>
            <li>Работа с Maven</li>
            <li>Основы работы СУБД MySQL</li>
            <li>Основы HTML & CSS</li>
            <li>Работа с TomCat</li>
            <li>Работа с интерфейсом Java Servlets</li>
            <li>Создание JSP-страниц</li>
            <li>Работа с драйвером JDBC</li>
            <li>Применение тегов JSTL</li>
            <li>Основы JavaScript, JQuery</li>
            <li>Работа с хостингом</li>
        </ul>
        <br>
        Я обучался в <a href="https://it.easyum.ru/" target="_blank">EasyUM</a> на курсе <a href="https://it.easyum.ru/courses/java-junior/" target="_blank">Java Junior программист
        (web-разработчик)</a> и получил <a href="https://it.easyum.ru/certificates/java_junior_umit-190719-132/" target="_blank">сертификат</a>.
        <br>

        <br>
        Доступ на сайт:
        <ul>
            <li>Администратор: Login: admin Пароль: 123</li>
            <li>Студент: Login: stud Пароль: 321</li>
        </ul>

    </div>
</div>

<div class="div-end">2019г.</div>

</body>
</html>