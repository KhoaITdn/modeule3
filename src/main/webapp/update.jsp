
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin học viên</title>

</head>
<body>


<form action="?action=edit" method="post">
    <h1>Form chỉnh sửa </h1>
    ID: <input value="${st.id}" type="number" name="id" readonly> <br>
    Tên: <input value="${st.name}" type="text" name="name"> <br>
    Email: <input  value="${st.email}" type="text" name="email"> <br>
    Giới tính :  <input type="radio" name="gender" value="1" ${st.gender == 1? "checked" : ""}>Nam
    <input type="radio" name="gender" value="0" ${st.gender == 0? "checked" : ""}>Nữ  <br>
    Điểm: <input value="${st.point}" type="number" name="point"> <br>
    Lớp: <input value="${st.class_name}" type="text" name="class_name">  <br>

    <input type="submit" value="Cập nhật">

</form>

</body>
</html>