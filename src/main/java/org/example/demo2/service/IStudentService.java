package org.example.demo2.service;

import org.example.demo2.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

     void addNewStudent(Student student);
//
////    void save(Student student);


}
