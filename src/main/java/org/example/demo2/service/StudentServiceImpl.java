package org.example.demo2.service;

import org.example.demo2.model.Student;
import org.example.demo2.repository.repositorystudent.IStudentRepository;
import org.example.demo2.repository.repositorystudent.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepositoryImpl();
    {
        iStudentRepository = new StudentRepositoryImpl();
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
    iStudentRepository.addNewStudent(student);
    }

}
