package persistence;

import models.Subject;

import java.util.List;

public interface SubjectDAO {

    public void save(Subject subject);

    public List<Subject> getAll();

    public Subject getById(Long id);

    public void softDelete(Subject subject);


}
