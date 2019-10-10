<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../resources/css/jquery-ui.css">
    <link rel="stylesheet" href="../../../resources/lib/jquery-ui/jquery-ui.css">
    <script src="../../../resources/lib/jquery-ui/jquery-ui.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Exo+2:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <script>
        $( function() {
            $( "#sDate" ).datepicker();
        } );
    </script>

</head>

<body>

<div class="div-heading">
    <h1>Система управления студентами и их успеваемостью</h1>
    <h2>Изменение выбранного студента студента</h2>
</div>

<nav class="mainmenu">
    <ul class="mainmenul-ul">
        <li class="mainmenu-li"><a href="/toMain" class="link-a">На главную</a></li>
        <li class="mainmenu-li"><a href="/students" class="link-a">Студенты</a></li>
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
    <p>Для того чтобы изменить данные студента, заполните все поля и нажмите кнопку "Изменить"</p>

    <form action="/modifyStudent" method="post">
        <div class="field">
            <label for="sSurname">Фамилия</label>
            <input type="text" id="sSurname" name="sSurname" placeholder="${student.surname}" required>
        </div>
        <div class="field">
            <label for="sName">Имя</label>
            <input type="text" id="sName" name="sName" placeholder="${student.name}" required>
        </div>
        <div class="field">
            <label for="sGroup">Группа</label>
            <input type="text" id="sGroup" name="sGroup" placeholder="${student.group}" required>
        </div>
        <div class="field">
            <label for="sDate">Дата</label>
            <input type="text" id="sDate" name="sDate" placeholder="${student.date}" required>
        </div>
        <input type="hidden" name="sId" value="${student.id}">
        <input type="submit" value="Изменить">
    </form>

</div>
<div class="div-end">2019г.</div>

</body>
</html>