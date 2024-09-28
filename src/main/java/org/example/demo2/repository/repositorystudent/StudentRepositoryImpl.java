package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.Student;
import org.example.demo2.model.ClassModel;  // Đổi từ Class sang ClassModel
import org.example.demo2.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private final BaseRepository baseRepository;
    {
        baseRepository = new BaseRepository();
    }
    private static final String FIND_ALL = "SELECT s.student_id, s.student_name, s.student_gender,\n" +
            "s.student_email, s.student_point, c.class_id, c.class_name\n" +
            "FROM student s\n" +
            "INNER JOIN class c ON s.class_id = c.class_id\n" +
            "ORDER BY s.student_id ASC;";
    private static final String FIND_ALL_CLASS = "select * from class;";
    private static final String INSERT_STUDENT = "INSERT INTO student (student_name, student_email, student_gender, student_point, class_id) VALUES (?, ?, ?, ?, ?)\n";
    private static final String DELETE_STUDENT = "delete from student where student_id = ?";
    private static final String GETID_STUDENT =
            "select s.student_id, s.student_name, s.student_email ,\n" +
                    "                    s.student_gender, s.student_point, c.class_id, c.class_name  from student s\n" +
                    "                    inner join class c on s.class_id = c.class_id \n" +
                    "                    where student_id = ?;";
    private static final String UPDATE_STUDENT = "UPDATE student SET student_name = ?, student_email = ?, student_gender = ?, student_point = ?, class_id = ? WHERE student_id = ?";
    private static final String SEARCH_BY_NAME = " SELECT s.student_id, s.student_name, s.student_email, s.student_gender, s.student_point, c.class_id, c.class_name  \n" +
            "                  FROM student s\n" +
            "                  INNER JOIN class c ON s.class_id = c.class_id\n" +
            "\t\t\tWHERE s.student_name LIKE ?;";
    private static final String SEARCH_BY_EMAIL =
            "SELECT s.student_id, s.student_name, s.student_email, s.student_gender, s.student_point, c.class_id, c.class_name " +
                    "FROM student s " +
                    "INNER JOIN class c ON s.class_id = c.class_id " +
                    "WHERE s.student_email LIKE ?;";


    @Override
    public List<Student> findAll() {
        Connection connection = baseRepository.getConnection();
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                String email = resultSet.getString("student_email");
                int gender = resultSet.getInt("student_gender");
                double point = resultSet.getDouble("student_point");
                int classId = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                ClassModel clazz = new ClassModel(classId,className);  // Đổi từ Class sang ClassModel
                Student student = new Student(id, name, email, gender, point, clazz);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<ClassModel> findAllClass() {
        Connection connection = baseRepository.getConnection();
        List<ClassModel> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CLASS);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()) {
                int classId = result.getInt("class_id");
                String className = result.getString("class_name");
                list.add(new ClassModel(classId, className));  // Đổi từ Class sang ClassModel
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getGender());
            ps.setDouble(4, student.getPoint());
            ps.setInt(5, student.getClazz().getClassId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) {
        Connection connection = baseRepository.getConnection();
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement(GETID_STUDENT);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            List<Student> list = toList(resultSet);
            if (!list.isEmpty()) {
                student = list.get(0);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return student;
    }

    private List<Student> toList(ResultSet resultSet) throws SQLException {
        List<Student> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("student_id");
            String name = resultSet.getString("student_name");
            String email = resultSet.getString("student_email");
            int gender = resultSet.getInt("student_gender");
            double point = resultSet.getDouble("student_point");
            int classId = resultSet.getInt("class_id");
            String className = resultSet.getString("class_name");
            ClassModel clazz = new ClassModel(classId, className);  // Đổi từ Class sang ClassModel
            list.add(new Student(id, name, email, gender, point, clazz));
        }
        return list;
    }

    @Override
    public void save(Student student) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getGender());
            ps.setDouble(4, student.getPoint());
            ps.setInt(5, student.getClazz().getClassId());
            ps.setInt(6, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean checkEmailForCreate(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM student WHERE student_email = ?";
        Connection connection = baseRepository.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkEmailForUpdate(int id, String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM student WHERE student_email = ? AND student_id != ?";
        Connection connection = baseRepository.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setInt(2, id);  // Bỏ qua học viên với ID hiện tại
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;  // Trả về true nếu có email trùng lặp
                }
            }
        }
        return false;
    }

    @Override
    public List<Student> searchByName(String name) {
        Connection connection = baseRepository.getConnection();
        List<Student> studentList = new ArrayList<>();
        try {
              PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");  // Sử dụng LIKE để tìm kiếm tên có chứa chuỗi ký tự
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String email = resultSet.getString("student_email");
                int gender = resultSet.getInt("student_gender");
                double point = resultSet.getDouble("student_point");
                int classId = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                ClassModel clazz = new ClassModel(classId, className);  // Đổi từ Class sang ClassModel
                Student student = new Student(id, studentName, email, gender, point, clazz);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> searchByEmail(String email) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE student_email = ?";
        Connection connection = baseRepository.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ClassModel classModel = new ClassModel(resultSet.getInt("class_id"));
                    // Khởi tạo đối tượng ClassModel
                    // Truyền đầy đủ các tham số theo constructor của Student
                    Student student = new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("student_name"),
                            resultSet.getString("student_email"),
                            resultSet.getInt("student_gender"), // Hoặc sửa nếu gender là String
                            resultSet.getDouble("student_point"),
                            classModel // Hoặc lấy từ kết quả query nếu có
                    );
                    students.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return students; // Trả về danh sách sinh viên
        }

    

    }}



