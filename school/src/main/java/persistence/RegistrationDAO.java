package persistence;


import models.Registration;

import java.util.List;

public interface RegistrationDAO {

    public void save(Registration registration);
    public void softDelete(Registration registration);
    public void update(Registration registration);
    public Registration findById(Long id);

    public List<Registration> findByStudentId(Long id);

}
