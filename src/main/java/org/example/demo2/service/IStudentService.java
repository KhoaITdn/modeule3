package org.example.demo2.service;

import org.example.demo2.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student>getStudentByid(int id);
     void addNewStudent(Student student);
     void save(Student student);
    void showDeleteForm(int id);

}
