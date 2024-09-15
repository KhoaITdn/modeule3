<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách lớp</title>

</head>
<body>
<h1 style="font-family: Serif, sans-serif">Danh sách học viên C0324m4</h1>

<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Giới tính</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
        <th>Lớp</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>
                <c:if test="${s.gender == 1}">
                    Nam
                </c:if>
                <c:if test="${s.gender == 0}">
                    Nữ
                </c:if>
            </td>
            <td>${s.point}</td>
            <td>
                <c:choose>
                    <c:when test="${s.point > 8.9}">
                        Loại giỏi
                    </c:when>
                    <c:when test="${s.point > 7.9}">
                        Loại khá
                    </c:when>
                    <c:when test="${s.point > 6.9}">
                        Loại Trung binh`
                    </c:when>
                    <c:when test="${s.point <6.9}">
                        Yếu
                    </c:when>
                </c:choose>
            </td>
            <td>${s.class_name}</td>
            <td>
                <a href="?action=edit&sid=${s.id}">Chỉnh sửa</a>
            </td>
            <td>
                <a href="#" onclick="showMess(${s.id})">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="text-align: center;">
    <a href="?action=create">Thêm mới học viên</a>
</div>
<script>
    function showMess(id){
        let option = confirm("Are you sure ??? ");
        if (option === true){
            window.location.href = "?action=delete&sid=" + id;
        }
    }
</script>
</body>
</html>