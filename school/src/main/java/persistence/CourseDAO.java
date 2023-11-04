package persistence;

import models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.CourseRepository;


public interface CourseDAO {



    public void save(Course course);
    public void softDelete(Course course);
    public void update(Course course);
    public Course findById(Long id);
    public Course findByName(String name);



}
