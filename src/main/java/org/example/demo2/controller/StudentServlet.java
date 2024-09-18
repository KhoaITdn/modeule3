package org.example.demo2.controller;
import org.example.demo2.model.ClassName;
import org.example.demo2.model.Student;
import org.example.demo2.service.IStudentService;
import org.example.demo2.service.StudentServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private final IStudentService iStudentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                break;
            default:
                findAll(request,response);
        }

    }

private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
    requestDispatcher.forward(request, response);

}
    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("studentList", iStudentService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    addNewStudent(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    save(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "findAll":
                findAll(request,response);
            default:
                findAll(request, response);
        }

    }

    private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int gender  = Integer.parseInt(request.getParameter("gender"));
        double point = Double.parseDouble(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("class_id"));

        // Kiểm tra email có tồn tại và có hợp lệ không
        if (! iStudentService.isValidEmail(email)) {
            request.setAttribute("errorMessage", "Định dạng email không hợp lệ. Vui lòng nhập lại.");
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("gender", gender);
            request.setAttribute("point", point);
            request.setAttribute("class_id", classId);
            request.getRequestDispatcher("create.jsp").forward(request, response);
            return;
        }

        if (iStudentService.emailExists(email,classId)) {
            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("gender",gender);
            request.setAttribute("point", point);
            request.setAttribute("class_id", classId);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }else {
            ClassName clazz = new ClassName(classId);
            Student student = new Student(name, email, gender, point, clazz);
            iStudentService.addNewStudent(student);
            response.sendRedirect(request.getContextPath() + "?action=findAll");
        }
    }

 private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        iStudentService.showDeleteForm(id);
     response.sendRedirect(request.getContextPath() + "?action=findAll");
 }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        List<Student> studentList = iStudentService.getStudentByid(id);
        if (!studentList.isEmpty()) {
            Student student = studentList.get(0);
            request.setAttribute("st", student);
        }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
            requestDispatcher.forward(request, response);
        }

//    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        int gender  = Integer.parseInt(request.getParameter("gender"));
//        double point = Double.parseDouble(request.getParameter("point"));
//        int classId = Integer.parseInt(request.getParameter("class_id"));
//
////        // Kiểm tra định dạng email
////        if (!iStudentService.isValidEmail(email)) {
////            request.setAttribute("errorMessage", "Định dạng email không hợp lệ. Vui lòng nhập lại.");
////            request.setAttribute("name", name);
////            request.setAttribute("email", email);
////            request.setAttribute("gender", gender);
////            request.setAttribute("point", point);
////            request.setAttribute("class_id", classId);
////            request.getRequestDispatcher("update.jsp").forward(request, response);
////            return;
////        }
////
////
////        if (iStudentService.emailExists(email)) {
////            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
////            request.getRequestDispatcher("create.jsp").forward(request, response);
////        }else{
////            ClassName clazz = new ClassName(classId);
////            Student student = new Student(id, name, email, gender, point, clazz);
////            iStudentService.save(student);
////            response.sendRedirect(request.getContextPath() + "?action=findAll");
////
////        }
//        // Lấy email hiện tại của học viên
//        Student existingStudent = iStudentService.getStudentById(id).get(0);
//        String existingEmail = existingStudent.getEmail();
//
//        // Kiểm tra email
//        if (!email.equals(existingEmail) && iStudentService.emailExists(email)) {
//            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
//            request.getRequestDispatcher("update.jsp").forward(request, response);
//        } else {
//            ClassName clazz = new ClassName(classId);
//            Student student = new Student(id, name, email, gender, point, clazz);
//            iStudentService.save(student);
//            response.sendRedirect(request.getContextPath() + "?action=findAll");
//        }
//
private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    int gender = Integer.parseInt(request.getParameter("gender"));
    double point = Double.parseDouble(request.getParameter("point"));
    int classId = Integer.parseInt(request.getParameter("class_id"));

    ClassName clazz = new ClassName(classId);
    Student student = new Student(id, name, email, gender, point, clazz);
    iStudentService.save(student);
    response.sendRedirect(request.getContextPath() + "?action=findAll");
}




    }








