package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.ClassModel;
import org.example.demo2.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<ClassModel> findAllClass();
    void addNewStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById( int id);
    void save(Student student);
    boolean checkEmailForCreate(String email) throws SQLException;
    boolean checkEmailForUpdate(int id, String email) throws SQLException;
    List<Student> searchByName(String name);

    List<Student> searchByEmail(String email) throws SQLException;

}