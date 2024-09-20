package org.example.demo2.service;

import org.example.demo2.model.ClassName;
import org.example.demo2.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student>getStudentByid(int id);
     void addNewStudent(Student student) throws SQLException;
     void save(Student student);
    void showDeleteForm(int id);
    boolean emailExists(String email,int id) throws SQLException;


    boolean isValidEmail(String email) throws SQLException;

    List<ClassName> findClasses();


}
