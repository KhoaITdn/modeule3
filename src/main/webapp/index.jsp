<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lí Học Viên</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background: linear-gradient(to bottom, #e6f2ff, #ffffff);
            min-height: 100vh;
        }
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
            transition: all 0.3s ease;
            display: inline-block;
            margin: 10px;
            text-decoration: none;
        }
        .button:hover {
            background-color: #e6f7ff;
            text-decoration: none;
            color: #54d1ff;
        }
        .button:active {
            position: relative;
            top: 8px;
            border: 6px solid #00319a;
            box-shadow: 0px 0px;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="card">
        <div class="card-body">
            <div class="text-center mb-4">
                <h1 class="display-4 text-primary"><%= "QUẢN LÍ HỌC VIÊN" %></h1>
                <p class="lead text-muted">Hệ thống quản lý học viên hiệu quả</p>
            </div>

            <div class="mb-4">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Tìm kiếm học viên...">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-6 text-center">
                    <a href="student" class="button">
                        <i class="fas fa-users mr-2"></i>Danh Sách Lớp
                    </a>
                </div>
                <div class="col-md-6 text-center">
                    <a href="courses" class="button">
                        <i class="fas fa-book-open mr-2"></i>Khóa Học
                    </a>
                </div>
                <div class="col-md-6 text-center">
                    <a href="add-student" class="button">
                        <i class="fas fa-user-plus mr-2"></i>Thêm Học Viên Mới
                    </a>
                </div>
                <div class="col-md-6 text-center">
                    <a href="reports" class="button">
                        <i class="fas fa-chart-bar mr-2"></i>Báo Cáo & Thống Kê
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>