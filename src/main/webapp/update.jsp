<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin học viên</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS for styling -->
    <style>
        body {
            background-color: #f8f9fa; /* Light grey background */
        }

        .update-container {
            max-width: 600px; /* Set the max width of the form */
            margin: 0 auto; /* Center the form horizontally */
            padding: 2rem; /* Add padding around the form */
            background-color: #ffffff; /* White background for the form */
            border-radius: 0.5rem; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }

        .update-container h1 {
            color: #007bff; /* Blue color for the title */
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
            border-color: #80bdff; /* Blue border on focus */
            box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25); /* Blue shadow on focus */
        }

        .form-check-input {
            margin-top: 0.3rem; /* Add space for radio buttons */
        }

        .form-check-label {
            margin-left: 0.5rem; /* Add space between radio button and label */
        }

        .btn-primary {
            background-color: #007bff; /* Primary blue color */
            border-color: #007bff; /* Match border color */
        }

        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
            border-color: #004085; /* Darker border on hover */
        }

        .mb-3 {
            margin-bottom: 1.5rem; /* Increase space between form groups */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="update-container">
        <h1>Chỉnh sửa thông tin học viên</h1>
        <form action="?action=edit" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input value="${st.id}" type="number" class="form-control" id="id" name="id" readonly>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Tên</label>
                <input value="${st.name}" type="text" class="form-control" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input value="${st.email}" type="email" class="form-control" id="email" name="email">
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="1" ${st.gender == 1 ? "checked" : ""}>
                    <label class="form-check-label" for="genderMale">Nam</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="0" ${st.gender == 0 ? "checked" : ""}>
                    <label class="form-check-label" for="genderFemale">Nữ</label>
                </div>
            </div>
            <div class="mb-3">
                <label for="point" class="form-label">Điểm</label>
                <input value="${st.point}" step="0.01" type="number" class="form-control" id="point" name="point">
            </div>
            <div class="mb-3">
                <label for="class_id" class="form-label">Lớp</label>
                <input value="${st.clazz.class_id}" type="text" class="form-control" id="class_id" name="class_id">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Cập nhật</button>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>