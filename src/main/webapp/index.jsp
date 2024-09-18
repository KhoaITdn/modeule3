<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <title>JSP - Hello World</title>
    <!-- Thêm Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .button {
            cursor: pointer;
            font-size: large;
            font-family: inherit;
            font-weight: bold;
            color: #54d1ff;
            background-color: #f8f8fd;
            padding: 0.8em 2.2em;
            border-radius: 50em;
            border: 6px solid #54d1ff;
            box-shadow: 0px 8px #54d1ff;
        }
        .button:active {
            position: relative;
            top: 8px;
            border: 6px solid #00319a;
            box-shadow: 0px 0px;
        }

    </style>
</head>

<body>
<!-- Sử dụng Bootstrap container và căn giữa nội dung -->
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 text-center">
            <h1><%= "QUẢN LÍ HỌC VIÊN" %></h1>
            <br/>
            <a href="student" class="button">Danh Sách Lớp </a>
        </div>
    </div>
</div>

<!-- Thêm Bootstrap JS và jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
