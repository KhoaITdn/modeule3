package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.ClassName;
import org.example.demo2.model.Student;
import org.example.demo2.repository.BaseRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private final BaseRepository baseRepository  = new BaseRepository();
    private static final String FIND_ALL = "select s.id , s.name , s.email,s.gender , s.point , c.class_id , c.class_name from student s \n" +
            "inner join class c on s.class_id = c.class_id";
    private static final String INSERT_STUDENT = "INSERT INTO student2 (name, email, gender,point, class_name) \n" + " VALUES ( ?, ?, ?, ?, ?)";
   private static final String DELETE_STUDENT = "DELETE FROM student2 WHERE id = ?";
   private static final String UPDATE_STUDENT = "UPDATE student2 SET name = ?, email = ?, gender = ?, point = ?, class_name = ? WHERE id = ?";
    private static final String GET_STUDENT_BY_ID = "SELECT * FROM student2 WHERE id = ?";
//    @Override
    public List<Student> findAll() {
        Connection connection = baseRepository.getConnection();
        List<Student> students = new ArrayList<>();
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
                int gender = resultSet.getInt("gender");
                double point = resultSet.getDouble("point");
                int classId = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                ClassName clazz = new ClassName(classId, className);
                students.add(new Student(id, name,email, gender , point,clazz ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setDouble(4, student.getPoint());
            preparedStatement.setString(5, student.getClass_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudentByid(int id) {
        Connection connection = baseRepository.getConnection();
        List<Student> listId = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int gender = resultSet.getInt("gender");
                double point = resultSet.getDouble("point");
                String class_name = resultSet.getString("class_name");
                listId.add(new Student(id1 , name,email, gender , point, class_name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listId;
    }





    @Override
    public void showDeleteForm(int id) {
        Connection connection = baseRepository.getConnection();
        try {PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Student student){
        Connection connection = baseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setDouble(4, student.getPoint());
            preparedStatement.setString(5, student.getClass_name());
            preparedStatement.setInt(6, student.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}



}


