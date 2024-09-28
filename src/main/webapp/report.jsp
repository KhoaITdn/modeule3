<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="org.example.demo2.model.Student" %>--%>
<%--<%@ page import="org.example.demo2.repository.repositorystudent.StudentRepositoryImpl" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Top 10 Học Sinh</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <style>--%>
<%--        .rank-icon {--%>
<%--            width: 32px;--%>
<%--            height: 32px;--%>
<%--            display: inline-flex;--%>
<%--            align-items: center;--%>
<%--            justify-content: center;--%>
<%--            border-radius: 50%;--%>
<%--            color: white;--%>
<%--            font-weight: bold;--%>
<%--            margin: 0 auto;--%>
<%--        }--%>
<%--        .rank-1 { background-color: #ffd700; }--%>
<%--        .rank-2 { background-color: #c0c0c0; }--%>
<%--        .rank-3 { background-color: #cd7f32; }--%>
<%--        .rank-other { background-color: #ffa500; }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h1 class="mt-4 mb-4 text-center">Top 10 Học Sinh Cao Điểm Nhất</h1>--%>
<%--    <table class="table table-bordered">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th class="text-center">Xếp hạng</th>--%>
<%--            <th>Tên</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>Giới tính</th>--%>
<%--            <th>Điểm</th>--%>
<%--            <th>Lớp</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <%--%>
<%--            StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();--%>
<%--            List<Student> topStudents = studentRepository.getTop10Students();--%>
<%--            for (int i = 0; i < topStudents.size(); i++) {--%>
<%--                Student student = topStudents.get(i);--%>
<%--                String rankClass = "";--%>
<%--                if (i == 0) rankClass = "rank-1";--%>
<%--                else if (i == 1) rankClass = "rank-2";--%>
<%--                else if (i == 2) rankClass = "rank-3";--%>
<%--                else rankClass = "rank-other";--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td class="text-center">--%>
<%--                <div class="rank-icon <%= rankClass %>">--%>
<%--                    <%= i + 1 %>--%>
<%--                </div>--%>
<%--            </td>--%>
<%--            <td><%= student.getName() %></td>--%>
<%--            <td><%= student.getEmail() %></td>--%>
<%--            <td><%= student.getGender() == 1 ? "Nam" : "Nữ" %></td>--%>
<%--            <td><%= student.getPoint() %></td>--%>
<%--            <td><%= student.getClazz().getClassId() %></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>