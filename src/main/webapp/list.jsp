<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách lớp C0324 </title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">  

    <style>

        .button-29 {
            align-items: center;
            appearance: none;
            background-image: radial-gradient(100% 100% at 100% 0, #80f0ff 0, #54d1ff 100%);
            border: 0;
            border-radius: 6px;
            box-shadow: rgba(45, 35, 66, .4) 0 2px 4px, rgba(45, 35, 66, .3) 0 7px 13px -3px, rgba(58, 65, 111, .5) 0 -3px 0 inset;
            box-sizing: border-box;
            color: #fff;
            cursor: pointer;
            display: inline-flex;
            font-family: "JetBrains Mono", monospace;
            height: 32px;
            justify-content: center;
            line-height: 1;
            list-style: none;
            overflow: hidden;
            padding-left: 10px;
            padding-right: 10px;
            position: relative;
            text-align: left;
            text-decoration: none;
            transition: box-shadow .15s, transform .15s;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            white-space: nowrap;
            will-change: box-shadow, transform;
            font-size: 15px;
        }

        .button-29:focus {
            box-shadow: #009dff 0 0 0 1.5px inset, rgba(45, 35, 66, .4) 0 2px 4px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #54d1ff 0 -3px 0 inset;
        }

        .button-29:hover {
            box-shadow: rgba(45, 35, 66, .4) 0 4px 8px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #54d1ff 0 -3px 0 inset;
            transform: translateY(-2px);
        }

        .button-29:active {
            box-shadow: #5387ba 0 3px 7px inset;
            transform: translateY(2px);
        }
        .add-student {
            text-align: center;
            margin-top: 1rem;
        }
            .container
                {
                    max-width: 80%;
                    margin: 0 auto;
                }

                .student-list h1 {
                   font-family: Serif, sans-serif;
                   text-align: center;
                   color: #020617;
                    margin-bottom: 1rem;
               }


        /* From Uiverse.io by vinodjangid07 */
        .Btn {
            position: relative;
            display: flex;
            align-items: center;
            justify-content: flex-start;
            width: 100px;
            height: 40px;
            border: none;
            padding: 0px 20px;
            background-color: rgb(168, 38, 255);
            color: white;
            font-weight: 500;
            cursor: pointer;
            border-radius: 10px;
            box-shadow: 5px 5px 0px rgb(140, 32, 212);
            transition-duration: .3s;
        }

        .svg {
            width: 13px;
            position: absolute;
            right: 0;
            margin-right: 20px;
            fill: white;
            transition-duration: .3s;
        }

        .Btn:hover {
            color: transparent;
        }

        .Btn:hover svg {
            right: 43%;
            margin: 0;
            padding: 0;
            border: none;
            transition-duration: .3s;
        }

        .Btn:active {
            transform: translate(3px , 3px);
            transition-duration: .3s;
            box-shadow: 2px 2px 0px rgb(140, 32, 212);
        }
    </style>



<%--    .container--%>
<%--        {--%>
<%--            max-width: 80%;--%>
<%--            margin: 0 auto;--%>
<%--        }--%>

<%--        .table-responsive {--%>
<%--            overflow-x: auto;--%>
<%--        }--%>

<%--        .student-list h1 {--%>
<%--            font-family: Serif, sans-serif;--%>
<%--            text-align: center;--%>
<%--            color: #198754;--%>
<%--            margin-bottom: 1rem;--%>
<%--        }--%>

<%--        .add-student {--%>
<%--            text-align: center;--%>
<%--            margin-top: 1rem;--%>
<%--        }--%>
<%--        .btn-primary{--%>
<%--            background-color: #479cc2;--%>
<%--        }--%>
<%--        .btn-primary:hover{--%>
<%--            background-color: #5fb0e3;--%>
<%--        }--%>
<%--        .btn-danger{--%>
<%--            background-color: #479cc2;--%>
<%--        }--%>
<%--        .btn-danger:hover{--%>
<%--            background-color: #5fb0e3;--%>
<%--        }--%>
<%--    --%>
</head>
<body>
<div class="container">
    <div class="student-list">
        <h1>Danh sách học viên </h1>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                <tr style="background-color: #54d1ff;">
<%--                    <th scope="col">ID</th>--%>
                    <th scope="col">Tên</th>
                    <th scope="col">Email</th>
                    <th scope="col">Giới tính</th>
                    <th scope="col">Điểm</th>
                    <th scope="col">Xếp loại</th>
                    <th scope="col">Lớp</th>
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${studentList}" var="s">
                <tr>
<%--                    <td><c:out value="${s.id}"/></td>--%>
                    <td><c:out value="${s.name}"/></td>
                    <td><c:out value="${s.email}"/></td>
                    <td>
                        <c:if test="${s.gender==1}">
                        <c:out value="Nam"/>
                    </c:if>
                        <c:if test="${s.gender==0}">
                            <c:out value="Nữ"/>
                        </c:if>
                    </td>
                    <td><c:out value="${s.point}"/></td>
                    <td>
                        <c:choose>
                        <c:when test="${s.point > 8.9}">
                            Loại giỏi
                        </c:when>
                        <c:when test="${s.point > 7.9}">
                            Loại khá
                        </c:when>
                        <c:when test="${s.point > 6.9}">
                            Loại trung bình
                        </c:when>
                        <c:when test="${s.point <6.9}">
                            Loại yếu
                        </c:when>
                    </c:choose>
                    </td>
                    <td><c:out value="${s.clazz.class_name}"/></td>
                    <td>
                        <a href="?action=edit&sid=${s.id}" class="button-29" role="button">Chỉnh sửa</a>
                    </td>
    <td>
        <a href="#" onclick="showMess(${s.id}, '${s.name}')" class="button-29" role="button">Xóa</a>
<%--    <a href="delete?id=${s.id}" class="button-29" role="button" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>--%>
    </td>

                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="add-student">
        <a href="?action=create" class="button-29" role="button">Thêm mới học viên</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4HCgxDaUyExNSe0zWXM7xo4pB4BBuJL6Z2jykzYL8"  
        crossorigin="anonymous"></script>
<script>
    function showMess(id, name) {
        let option = confirm("Bạn có muốn xóa học viên " + name + " không?");
        if (option === true) {
            window.location.href = "?action=delete&sid=" + id;
        }
    }

</script>
</body>
</html>