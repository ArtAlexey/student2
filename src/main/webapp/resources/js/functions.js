function modifineDiscipline() {
    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одну дисциплину!");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Выберете только одну дисциплину!");
        return;
    }
    var idDisc = checkboxes[0].value;
    $("#idModifDisc").val(idDisc);
    $("#modifDiscForm").submit();

}

function deleteDiscipline() {
    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одну дисциплину!");
        return;
    }

    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsDeleteDisc").val(ids);
    $("#deleteDiscForm").submit();
}

function  deleteStudent() {
    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одного студента!");
        return;
    }
    var idStd = "";
    for (var i = 0; i < checkboxes.length; i++) {
        idStd = idStd + checkboxes[i].value + ",";
    }
    $("#idDeleteStudent").val(idStd);
    $("#deleteStudentForm").submit();
}

function modifyStudent() {
    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одго студента!");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Выберете только одного студента!");
        return;
    }
    var idMStudent = checkboxes[0].value;
    $("#idModifyStudent").val(idMStudent);
    $("#modifyStudentForm").submit();
}

function studentProgress() {

    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одного студента!");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Выберете только одного студента!");
        return;
    }
        var idStud = checkboxes[0].value;
    $("#idStudentProgress").val(idStud);
    $("#studentProgressForm").submit();
}

function idStudent() {
    var idSt = document.getElementById('idS').rows[1].cells[0].innerHTML;
    $("#idStudent").val(idSt);
    $("#getIdTermForm").submit();
}

function  createNewTerm() {
    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одну дисциплину!");
        return;
    }
    var idTerms = "";
    for (var i = 0; i < checkboxes.length; i++) {
        idTerms = idTerms + checkboxes[i].value + ",";
    }
    $("#idTermDisc").val(idTerms);
    $("#createNewTerm").submit();
}

function  modifyTerm() {
    var checkboxes = $('input[type = checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одну дисциплину!");
        return;
    }
    var idDis = "";
    for (var i = 0; i < checkboxes.length; i++) {
        idDis = idDis + checkboxes[i].value + ",";
    }
    $("#idSelectDisc").val(idDis);
    $("#modifyTermForm").submit();
}

function selectStudent() {

    var checkboxes = $('input[type = checkbox]:checked');

    if (checkboxes.length == 0) {
        alert("Выберете хотя бы одного студента!");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Выберете только одного студента!");
        return;
    }
    var idStud = checkboxes[0].value;
    $("#idSetStudent").val(idStud);
    $("#setStudentForm").submit();
}

function setMarks() {
    var marksAndIdDisc = "";
    var inputs = document.getElementsByTagName("input");
    for (var i = 0; i < inputs.length; i++) {
        var val = inputs[i].value;
        marksAndIdDisc = marksAndIdDisc + val + ",";
    }
    $("#markAndIdDisc").val(marksAndIdDisc);
    $("#setMarksForm").submit();

}

function isright(obj){
    if (obj.value>5) obj.value=5;
    if (obj.value<0) obj.value=0;
}




