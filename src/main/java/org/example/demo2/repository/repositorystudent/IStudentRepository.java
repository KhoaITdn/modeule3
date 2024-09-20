package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.ClassName;
import org.example.demo2.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    List<Student> getStudentByid(int id);
  void addNewStudent(Student student) throws SQLException;
    void showDeleteForm(int id);
    void save(Student student);
    boolean emailExists(String email,int id) throws SQLException;
    boolean isValidEmail(String email) throws SQLException;
    List<ClassName> findClasses();
}