<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>СУС</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Список семестров</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li"><a href="/students" class="link-a">Студенты</a></li>
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
    <p>Выбрать семестр</p>
    <form action="/terms" method="get" id="ChoiseSemForm">
        <select name="selectedTermId" id="multipleSelect">
            <c:forEach items="${semestrs}" var="sem">
                <c:choose>
                    <c:when test="${sem.id eq selectedTerm.id}">
                        <option value="${sem.id}" selected>${sem.semestr}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${sem.id}">${sem.semestr}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <input type="submit" value="Выбрать" id="idChoiseSem">
    </form>
    <p>Длительность семестра: ${selectedTerm.duration}</p>

    <table class="table-cl">
        <caption>Список дисциплин семестра</caption>
        <th>Наименование</th>
        <c:forEach items="${disciplinesByTerm}" var="ds">
            <tr>
                <td class="td-cl">${ds.discipline}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test = "${role eq 'admin'}">
        <form action="/create-term" method="get">
            <input type="submit" value="Создать семестр" class="input-line">
        </form>
        <form action="/modify-term" id="modiftermForm">
            <input type="submit" value="Изменить семестр" class="input-line">
            <input type="hidden" name="idModifSem" value="${selectedTerm.id}">
        </form>
        <form action="/delete-term" method="get" id="deleteSemForm">
            <input type="submit" value="Удалить выдранный семестр" class="input-line">
            <input type="hidden" name="idsDeleteSem" value="${selectedTerm.id}">
        </form>
    </c:if>

</div>
<div class="div-end">2019г.</div>
</body>
</html>