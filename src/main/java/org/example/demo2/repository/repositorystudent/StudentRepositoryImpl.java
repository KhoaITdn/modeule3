package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.Student;
import org.example.demo2.repository.BaseRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private final BaseRepository baseRepository;

    {
        try {
            baseRepository = new BaseRepository();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String FIND_ALL = "SELECT * FROM student";
    private static final String ADD_STUDENT= "INSERT INTO student (id,name, gender, email, class_name, point) \n" + " VALUES (?, ?, ?, ?, ?, ?)";


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            // Statement là 1 trong 3 đối tượng java cung cấp để connect với DB
            // thường sẽ dùng phương thức executeQuery(dùng cho trường hợp select), chỉ lấy ra mà không thêm vào , xóa , update data
            // dùng cho select ko where , limit , having
            //executeUpdate() : dùng cho các TH insert , update , delete
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            // ResultSet sẽ hứng các data mà user thêm vào
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                boolean gender = resultSet.getBoolean("gender");
                double point = resultSet.getDouble("point");
                String class_name = resultSet.getString("class_name");
                studentList.add(new Student(id, name,email, gender , point, class_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public void addNewStudent(Student student) {
    Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setBoolean(3,student.getGender());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getClassName());
            preparedStatement.setDouble(6, student.getPoint());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}



