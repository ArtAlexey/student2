<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
    <h2>Список студентов</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
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
    <table class="table-cl">
        <caption>Список студентов</caption>
        <th> </th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата</th>
        <c:forEach items="${stud}" var="s">
            <tr>
                <td class="td-cl-checkbox"><input type="checkbox" value="${s.id}"></td>
                <td class="td-cl">${s.surname}</td>
                <td class="td-cl">${s.name}</td>
                <td class="td-cl">${s.group}</td>
                <td class="td-cl"> <f:formatDate value="${s.date}" pattern="yy/MMM/dd"></f:formatDate></td>
            </tr>
        </c:forEach>
    </table>

    <input class="input-line" onclick="studentProgress()" type="submit" value="Посмотреть успеваемость">
    <form action="/student-progress" id="studentProgressForm" method="get">
        <input type="hidden" name="idStudentProgress" id="idStudentProgress">
    </form>

    <c:if test = "${role eq 'admin'}">
        <form action="/createStudent" method="get">
            <input class="input-line" type="submit" value="Создать студента">
        </form>
        <input class="input-line" type="submit" onclick="modifyStudent()" value="Изменить студента">
        <form action="/modifyStudent" method="get" id="modifyStudentForm">
            <input type="hidden" name="idModifyStudent" id="idModifyStudent">
        </form>
        <input class="input-line" type="submit" onclick="deleteStudent()" value="Удалить студента">
        <form action="/delete-students" method="get" id="deleteStudentForm">
            <input type="hidden" name="idDeleteStudent" id="idDeleteStudent">
        </form>
    </c:if>

</div>
<div class="div-end">2019г.</div>
</body>
</html>