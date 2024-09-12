<%--
  Created by IntelliJ IDEA.
  User: 84763
  Date: 9/5/2024
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học viênnn</title>
</head>
<body>
<form action ="?action=create" method="post">
    <h1>Thêm mới học viên ở đây</h1>
    ID : <input type="text" name="id"> <br>
    Tên: <input type="text" name="name"> <br>
    Email: <input type="text" name="email"> <br>
    Giới tính : <input type="radio" name="gender" value="1">Nam
    <input type="radio" name="gender" value="0">Nữ  <br>
    Điểm: <input type="number" name="point"> <br>
    Lớp: <input type="text" name="class_name">  <br>
    <input type="submit" value="Thêm mới">
    <input type="submit" value="Sửa">
    <input type="submit" value="Xóa">
    <input type="submit" value="Update">
</form>
</body>
</html>