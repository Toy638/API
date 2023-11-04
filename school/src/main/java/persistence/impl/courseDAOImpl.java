package persistence.impl;

import jakarta.persistence.EntityNotFoundException;
import models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.CourseDAO;
import repository.CourseRepository;

import java.util.Optional;

@Component
public class courseDAOImpl implements CourseDAO {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void softDelete(Course course) {
        course.setSoftDelete(true);
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            // Puedes manejar el caso de que no se encuentra el registro, por ejemplo, lanzando una excepción personalizada
            throw new EntityNotFoundException("No se encontró el curso con el ID: " + id);
        }
    }
    @Override
    public Course findByName(String name) {
        Optional<Course> optionalCourse = courseRepository.findByName(name);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            throw new EntityNotFoundException("No se encontró el curso con el nombre: " + name);
        }
    }
}
