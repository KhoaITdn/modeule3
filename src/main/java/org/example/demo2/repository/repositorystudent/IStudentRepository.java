package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.Student;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    List<Student> getStudentByid(int id);
  void addNewStudent(Student student);
    void showDeleteForm(int id);
    void save(Student student);
}