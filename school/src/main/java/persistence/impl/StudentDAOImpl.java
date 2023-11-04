package persistence.impl;

import jakarta.persistence.EntityNotFoundException;
import models.Course;
import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.StudentDAO;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOImpl implements StudentDAO {

    @Autowired // Inyección de dependencias
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void softDelete(Student student) {
        student.setSoftDelete(true);
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else {
            throw new EntityNotFoundException("No se encontró el estudiante con el ID: " + id);
        }
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentList = studentRepository.findByName(name);
        if(studentList.isEmpty()) {
            throw new EntityNotFoundException("No se encontró el estudiante con el nombre: " + name);
        }
        return studentList;
    }
}
