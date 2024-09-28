package org.example.demo2.service;
import org.example.demo2.model.ClassModel;
import org.example.demo2.model.ClassModel;
import org.example.demo2.model.Student;
import org.example.demo2.repository.repositorystudent.IStudentRepository;
import org.example.demo2.repository.repositorystudent.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository iStudentRepo = new StudentRepositoryImpl();


    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public List<ClassModel> findAllClass() {
        return iStudentRepo.findAllClass();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepo.addNewStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        iStudentRepo.deleteStudent(id);
    }

    @Override
    public Student getStudentById(int id) {
        return iStudentRepo.getStudentById(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> searchByName(String name) {
        return iStudentRepo.searchByName(name);
    }

    @Override
    public boolean checkEmailForUpdate(int id, String email) throws SQLException {
        return iStudentRepo.checkEmailForUpdate(id, email);
    }

    @Override
    public List<Student> searchByEmail(String email) {
        try {
            return iStudentRepo.searchByEmail(email); // Đảm bảo rằng iStudentRepo trả về List<Student>
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public boolean checkEmailForCreate(String email) throws SQLException {
        return iStudentRepo.checkEmailForCreate(email);
    }

//    @Override
//    public Account checkLogin(String user, String pass) {
//        return iStudentRepo.checkLogin(user, pass);
//    }




}