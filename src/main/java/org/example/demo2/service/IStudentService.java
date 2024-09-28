package org.example.demo2.service;

import org.example.demo2.model.ClassModel;
import org.example.demo2.model.ClassModel;
import org.example.demo2.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<ClassModel> findAllClass();
    void addNewStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById( int id);
    void save(Student student);
    List<Student> searchByName(String name);
    boolean checkEmailForCreate(String email) throws SQLException;
    boolean checkEmailForUpdate(int id, String email) throws SQLException;
    List<Student> searchByEmail(String email);

}