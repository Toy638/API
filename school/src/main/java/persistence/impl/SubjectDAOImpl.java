package persistence.impl;

import models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.SubjectDAO;
import repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Component // Esto significa que puedes inyectar instancias de esta clase en otras partes de tu aplicación utilizando la inyección de dependencias de Spring.
public class SubjectDAOImpl implements SubjectDAO {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Long id) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);
        if(subjectOptional.isPresent()) {
            return subjectOptional.get();
        } else {
            throw new RuntimeException("No se encontró la materia con el ID: " + id);
        }
    }

    @Override
    public void softDelete(Subject subject) {
        subject.setSoftDelete(true);
        subjectRepository.save(subject);
    }
}
