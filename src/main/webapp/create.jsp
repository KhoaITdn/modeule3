
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học viên</title>
</head>
<body>
<form action ="?action=create" method="post">
    Tên: <input type="text" name="name"> <br>
    Email: <input type="text" name="email"> <br>
    Giới tính : <input type="radio" name="gender" value="1"> Nam
                <input type="radio" name="gender" value="0"> Nữ  <br>
    Điểm: <input type="number" name="point"> <br>
    Lớp: <input type="text" name="class_name">  <br>
    <input type="submit" value="Thêm mới">

</form>
</body>
</html>