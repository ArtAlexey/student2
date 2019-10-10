<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>СУС</title>
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <script src="../../../resources/js/functions.js"></script>
</head>
<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Установка оценок</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li"><a href="/students" class="link-a">Выбор студента</a></li>
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
    <h1>Поставьте оценки в семестре</h1>
    <table class="table-cl">
        <th>Дисциплина</th>
        <th>Оценка</th>
        <c:forEach items="${disciplineByTerm}" var="discipline">
            <tr>
                <td class="td-cl">${discipline.discipline}</td>
                <td class="td-cl">
                    <input type="number" value=0 max=5 min=0 onkeyup="this.value=this.value.replace(/[^0-9]+/g,''); isright(this);">
                    <input type="hidden" value="${discipline.id}">
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        Если по какой-либо дисциплине нет оценки - установить 0.
    </div>

    <form action="/setMarks" id="setMarksForm" method="post">
        <input type="hidden" name="markAndIdDisc" id="markAndIdDisc">
    </form>
    <input type="submit" onclick="setMarks()" value="Поставить оценки">

</div>
<div class="div-end">2019г.</div>
</body>
</html>
