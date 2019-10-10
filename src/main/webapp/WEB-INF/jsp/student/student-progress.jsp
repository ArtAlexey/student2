<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
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
    <h2>Просмотр успеваемости студента</h2>
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
    <table class="table-cl"  id="idS">
        <caption>Успеваемость студента</caption>
        <th>ID</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата</th>
        <tr>
            <td class="td-cl">${student.id}</td>
            <td class="td-cl">${student.surname}</td>
            <td class="td-cl">${student.name}</td>
            <td class="td-cl">${student.group}</td>
            <td class="td-cl"><f:formatDate value="${student.date}" pattern="yy/MMM/dd"></f:formatDate></td>
        </tr>
    </table>
    <br>

    <form action="/student-progress" id="getIdTermForm" method="get">
        <select class="input-line" name="getTermId" id="getTermId">
            <c:forEach items="${terms}" var="term">
                <c:choose>
                    <c:when test="${term.id eq selectedSemestr.id}">
                        <option value="${term.id}" selected>${term.semestr}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${term.id}">${term.semestr}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <input type="hidden" name="idStudent" id="idStudent">
    </form>
    <input class="input-line" onclick="idStudent()" type="submit" value="Посмотреть">

    <table class="table-cl">
        <caption>Перечень дисциплин</caption>
        <th>Дисциплина</th>
        <th>Оценка</th>
        <c:forEach items="${marks}" var="mark">
            <tr>
                <td class="td-cl">${mark.discipline.discipline}</td>
                <td class="td-cl">${mark.mark}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="div-res">
        Среднее значение оценки студента за весь период - ${avgMarksAll}, за текущий семестр - ${avgMarkTerm}
    </div>
    <c:if test = "${role eq 'admin'}">
        <form action="/setMarks" method="get" id="setStudentForm">
            <input type="hidden" name="idSetStudent" value="${student.id}">
            <input type="hidden" name="idSetTerm" value="${selectedSemestr.id}">
            <input type="submit" value="Проставить оценки" class="input-line">
        </form>
 </c:if>

</div>
<div class="div-end">2019г.</div>
</body>
</html>