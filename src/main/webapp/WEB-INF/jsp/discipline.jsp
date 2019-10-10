<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Список дисциплин</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li"><a href="/students" class="link-a">Студенты</a></li>
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
    <table class="table-cl">
        <caption>Перечень дисциплин</caption>
        <c:forEach items="${disc}" var="d">
            <tr>
                <td class="td-cl-checkbox">
                    <input type="checkbox" value="${d.id}">
                </td>
                <td class="td-cl">${d.discipline}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test = "${role eq 'admin'}">
        <form action="/cd" id="createDiscForm">
            <input class="input-line" type="submit" value="Создать дисциплину">
        </form>
        <input class="input-line" type="submit" onclick="modifineDiscipline()" value="Модифицировать">
        <form action="/modify-discipline" id="modifDiscForm">
            <input type="hidden" name="idModifDisc" id="idModifDisc">
        </form>
        <input class="input-line" type="submit" onclick="deleteDiscipline()" value="Удалить">
        <form action="/delete-discipline" method="get" id="deleteDiscForm">
            <input type="hidden" name="idsDeleteDisc" id="idsDeleteDisc">
        </form>
    </c:if>
</div>
<div class="div-end">2019г.</div>
</body>
</html>