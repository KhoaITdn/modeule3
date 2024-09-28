<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lí Học Viên</title>
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Link to external CSS file -->
    <link rel="stylesheet" type="text/css" href="CSS/index.css">
</head>

<body>
<div class="container py-5">
    <div class="card">
        <div class="card-body">
            <div class="text-center mb-4">
                <h1 class="display-4 text-primary"><%= "QUẢN LÍ HỌC VIÊN" %></h1>
                <p class="lead text-muted"><h2>Hệ thống quản lý học viên hiệu quả</h2>
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
                    <a href="student-servlet?action=findAll" class="button">
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
                    <a href="report.jsp" class="button">
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
