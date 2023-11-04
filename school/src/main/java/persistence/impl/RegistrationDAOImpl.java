package persistence.impl;

import models.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.RegistrationDAO;
import repository.RegistrationRepository;

import java.util.Optional;

@Component
public class RegistrationDAOImpl implements RegistrationDAO {


    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

    @Override
    public void softDelete(Registration registration) {

        registration.setSoftDelete(true);
        registrationRepository.save(registration);

    }

    @Override
    public void update(Registration registration) {
        registrationRepository.save(registration);
    }

    @Override
    public Registration findById(Long id) {
        Optional<Registration> registrationOptional = registrationRepository.findById(id);
        if(registrationOptional.isPresent()){
            return registrationOptional.get();
        }else {
            throw new RuntimeException("No se encontró la matrícula con el ID: " + id);
        }
    }


}
