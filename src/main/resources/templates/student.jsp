<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/webjars/bootstrap/4.6.0-1/css/bootstrap.min.css}"/>
</head>
<body>
<script th:src="@{/webjars/bootstrap/4.6.0-1/js/bootstrap.bundle.min.js}"></script>
<form action="#" th:action="@{/student}" method="post" th:object="${student}" class="actionForm">
    <div class="mb-3">
        <label class="form-label">Студент</label>
        <input type="text" class="form-control" id="name" name="name"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Возраст</label>
        <input type="text" class="form-control" id="age" name="age"/>
    </div>

    <div class="mb-3">
        <button type="submit" class="btn-primary">Добавить</button>
    </div>
</form>
<table class="table">
    <tr><th>ID</th><th>Имя</th><th>Возраст</th></tr>
    <tr th:each=" student: ${students}">
        <td th:text="${student.id}">...</td>
        <td th:text="${student.name}">...</td>
        <td th:text="${student.age}">...</td>
        <td><a class="btn btn-danger" th:href="@{'/student/' + ${student.id} }">Удалить</a></td>
    </tr>
</table>
</body>
</html>

