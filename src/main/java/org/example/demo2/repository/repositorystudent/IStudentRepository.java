package org.example.demo2.repository.repositorystudent;
import org.example.demo2.model.Student;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
   void addNewStudent(Student student);

}