<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học viên</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS for styling -->
    <style>

        body {
            background-color: #f8f9fa; /* Light grey background */
        }

        .container {
            max-width: 600px; /* Set the max width of the form */
            margin: 20px auto; /* Center the form horizontally */
            padding: 2rem; /* Add padding around the form */
            background-color: #ffffff; /* White background for the form */
            border-radius: 0.5rem; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }

        .container h2 {
            color: #2281c5; /* Blue color for the title */
            margin-bottom: 1.5rem;
            text-align: center;
        }

        .form-label {
            color: #495057; /* Dark grey color for labels */
        }

        .form-control {
            border: 1px solid #ced4da; /* Light grey border */
            border-radius: 0.375rem; /* Rounded corners for input fields */
            box-shadow: none; /* Remove shadow */
        }

        .form-control:focus {
            border-color: #80ffd9; /* Blue border on focus */
            box-shadow: 0 0 0 0.2rem rgba(38, 165, 255, 0.25); /* Blue shadow on focus */
        }

        .form-check-input {
            margin-top: 0.3rem; /* Add space for radio buttons */
        }

        .form-check-label {
            margin-left: 0.5rem; /* Add space between radio button and label */
        }

        .btn-primary {
            background-color: #54d1ff; /* Primary blue color */
            border-color: #54d1ff; /* Match border color */
        }

        .btn-primary:hover {
            background-color: #54d1ff; /* Darker blue on hover */
            border-color: #54d1ff; /* Darker border on hover */
        }

        .mb-3 {
            margin-bottom: 1.5rem; /* Increase space between form groups */
        }

        .btn-secondary {
            background-color: #6c757d; /* Secondary grey color */
            border-color: #6c757d; /* Match border color */
        }

        .btn-secondary:hover {
            background-color: #5a6268; /* Darker grey on hover */
            border-color: #545b62; /* Darker border on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Thêm mới học viên</h2>
    <form action="?action=create" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="name" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="name" name="name" value="${param.name}" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${param.email}" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính:</label>
            <div class="form-check">
                <input type="radio" id="male" name="gender" value="1" class="form-check-input" ${param.gender == '1' ? 'checked' : ''}>
                <label for="male" class="form-check-label">Nam</label>
            </div>
            <div class="form-check">
                <input type="radio" id="female" name="gender" value="0" class="form-check-input" ${param.gender == '0' ? 'checked' : ''}>
                <label for="female" class="form-check-label">Nữ</label>
            </div>
        </div>
        <div class="mb-3">
            <label for="point" class="form-label">Điểm:</label>
            <input type="number" class="form-control" id="point" name="point" value="${param.point}" required>
        </div>
        <div class="mb-3">
            <label for="class_id" class="form-label">Lớp:</label>
            <select class="form-select" id="class_id" name="class_id" required>
                <option>
                    <c:forEach items="${list}" var="c">
                        <option value="${c.class_id}">${c.class_name}</option>
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
