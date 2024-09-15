package org.example.demo2.service;
import org.example.demo2.model.Student;
import org.example.demo2.repository.repositorystudent.IStudentRepository;
import org.example.demo2.repository.repositorystudent.StudentRepositoryImpl;
import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private final IStudentRepository iStudentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }
//
    @Override
    public List<Student> getStudentByid(int id) {
        return iStudentRepository.getStudentByid(id);
    }

    @Override
    public void addNewStudent(Student student) {
    iStudentRepository.addNewStudent(student);

    }
//
//
//
    @Override
    public void save(Student student) {
    iStudentRepository.save(student);
    }

    @Override
    public void showDeleteForm(int id) {
        iStudentRepository.showDeleteForm(id);
    }

}
