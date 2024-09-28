<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học viên</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="CSS/create.css">
</head>
<body>
<div class="container">
    <h2>Thêm mới học viên</h2>
    <form action="student-servlet?action=create" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="name" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="name" name="name" value="${students.name}" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${students.email}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính:</label>
            <div class="form-check">
                <input type="radio" id="male" name="gender" value="1" class="form-check-input" ${students.gender == '1' ? 'checked' : ''}>
                <label for="male" class="form-check-label">Nam</label>
            </div>
            <div class="form-check">
                <input type="radio" id="female" name="gender" value="0" class="form-check-input" ${students.gender == '0' ? 'checked' : ''}>
                <label for="female" class="form-check-label">Nữ</label>
            </div>
        </div>
        <div class="mb-3">
            <label for="point" class="form-label">Điểm:</label>
            <input type="number" class="form-control" id="point" name="point" step="0.01" value="${students.point}" required>
        </div>
        <div class="mb-3">
            <label for="classId" class="form-label">Lớp:</label>
            <select class="form-select" id="classId" name="classId" required>
                <option>
                    <c:forEach var="c" items="${listCr}">
                <option value="${c.classId}" ${c.classId == students.clazz.classId ? 'selected' : ''}>${c.className}</option>
                </c:forEach>
                </option>
            </select>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Thêm mới</button>
        </div>
    </form>
</div>

<%-- Modal for email validation error --%>
<% if (request.getAttribute("errorMessage") != null) { %>
<div class="modal fade" id="emailErrorModal" tabindex="-1" aria-labelledby="emailErrorModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="emailErrorModalLabel">Bị Lỗi</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ${errorMessage}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script>
    <% if (request.getAttribute("errorMessage") != null) { %>
    let emailErrorModal = new bootstrap.Modal(document.getElementById('emailErrorModal'));
    emailErrorModal.show();
    <% } %>
</script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        if (document.getElementById('emailErrorModal')) {
            let emailErrorModal = new bootstrap.Modal(document.getElementById('emailErrorModal'));
            emailErrorModal.show();
        }
    });
</script>
<% } %>

<!-- Bootstrap JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
