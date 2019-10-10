<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>СУС</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../../../resources/js/functions.js"></script>
</head>
<body>
<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Изменение семестра</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
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

    <p>Выбирите все дисциплины в семестре</p>
    <table class="table-cl">
        <caption>Все доступные дисциплины</caption>
        <th> </th>
        <th>Название дисциплины</th>
        <c:forEach items="${activeDisciplines}" var="activeDisc">
            <tr>
                <td class="td-cl-checkbox"><input type="checkbox" value="${activeDisc.id}"></td>
                <td class="td-cl">${activeDisc.discipline}</td>
            </tr>
        </c:forEach>
    </table>

    <form action="/modify-term" id="modifyTermForm" method="post">
        <input type="hidden" name="idSelectDisc" id="idSelectDisc">
    </form>
    <input type="submit" onclick="modifyTerm()" value="Изменить" class="input-line">
</div>
<div class="div-end">2019г.</div>
</body>
</html>
