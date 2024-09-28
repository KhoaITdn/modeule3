package org.example.demo2.controller;
import org.example.demo2.model.ClassModel;
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

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private final IStudentService iStudentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                deleteStudent(request, response);
                break;
            case "search":
                searchByName(request, response);
            case "searchByEmail":  // Thêm case này
                try {
                    searchByEmail(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                findAll(request, response);
        }
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
            default:
                findAll(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClassModel> list = iStudentService.findAllClass();
        request.setAttribute("listCr", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = (request.getParameter("email"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        double point = Double.parseDouble(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));

        if (regaxName(name)) {
            request.setAttribute("errorMessage", "Tên không chứa số và kí tự đặc biệt.");
            forwardCreateForm(request, response, name, email, gender, point, classId);
            return;
        }


        if (iStudentService.checkEmailForCreate(email)) {
            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
            forwardCreateForm(request, response, name, email, gender, point, classId);
            return;
        }

        if (point < 0 || point > 10) {
            request.setAttribute("errorMessage", "Điểm chỉ nằm trong khoảng 0 đến 10.");
            forwardCreateForm(request, response, name, email, gender, point, classId);
            return;
        }
        iStudentService.addNewStudent(new Student(name, email, gender, point, new ClassModel(classId)));
        response.sendRedirect("student-servlet");
    }

    public void forwardCreateForm(HttpServletRequest request, HttpServletResponse response, String name, String email, int gender, double point, int classId) throws ServletException, IOException {
        Student student = new Student(name, email, gender, point, new ClassModel(classId));
        request.setAttribute("students", student);
        List<ClassModel> classList = iStudentService.findAllClass();
        request.setAttribute("listCr", classList);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        Student studentList = iStudentService.getStudentById(id);
        List<ClassModel> classList = iStudentService.findAllClass();
        request.setAttribute("st", studentList);
        request.setAttribute("listU", classList);
        // Điều hướng đến trang JSP hiển thị chi tiết sinh viên
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
//        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String email = request.getParameter("email");
        int gender = Integer.parseInt(request.getParameter("gender"));
        double point = Double.parseDouble(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));

        if (regaxName(name)) {
            request.setAttribute("errorMessage", "Tên không chứa số và kí tự đặc biệt.");
            forwardToEditForm(request, response, id, name, email, gender, point, classId);
            return;
        }

        if (iStudentService.checkEmailForUpdate(id, email)) {
            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
            forwardToEditForm(request, response, id, name, email, gender, point, classId);
            return;
        }

        Student currentStudent = iStudentService.getStudentById(id);
        if (!email.equals(currentStudent.getEmail())) {
            if (iStudentService.checkEmailForCreate(email)) {
                request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng nhập lại.");
                forwardToEditForm(request, response, id, name, email, gender, point, classId);
                return;
            }
        }

        if (point < 0 || point > 10) {
            request.setAttribute("errorMessage", "Điểm chỉ nằm trong khoảng 0 đến 10.");
            forwardToEditForm(request, response, id, name, email, gender, point, classId);
            return;
        }
        iStudentService.save(new Student(id, name, email, gender, point, new ClassModel(classId)));
        response.sendRedirect("student-servlet");

    }

    public void forwardToEditForm(HttpServletRequest request, HttpServletResponse response, int id, String name, String email, int gender, double point, int classId) throws ServletException, IOException {
        Student student = new Student(id, name, email, gender, point, new ClassModel(classId));
        request.setAttribute("st", student);
        List<ClassModel> classList = iStudentService.findAllClass();
        request.setAttribute("listU", classList);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        // Kiểm tra ô tìm kiếm không được rỗng
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng nhập tên cần tìm kiếm.");
            findAll(request, response); // Hoặc redirect về trang danh sách
            return;
        }
        // Nếu không rỗng, thực hiện tìm kiếm
        List<Student> students = iStudentService.searchByName(name);
        request.setAttribute("students", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        iStudentService.deleteStudent(id);
        response.sendRedirect("student-servlet");
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("students", iStudentService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }


    private boolean regaxName(String name) {
        return !name.matches("^[\\p{L}\\s]{1,150}$");
    }

    private void searchByEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String email = request.getParameter("email");
        List<Student> students = iStudentService.searchByEmail(email);

        if (students.isEmpty()) {
            request.setAttribute("errorMessage", "Không tìm thấy sinh viên với email này.");
        } else {
            request.setAttribute("students", students);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }








}



