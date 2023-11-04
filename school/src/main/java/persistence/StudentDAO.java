package persistence;

import models.Course;
import models.Student;

import java.util.List;

public interface StudentDAO {


    public void save(Student student);
    public void softDelete(Student student);
    public void update(Student student);
    public Student findById(Long id);
    public List<Student> findByName(String name);

}
