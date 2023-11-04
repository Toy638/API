package repository;

import models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

    Optional<Registration> findByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Registration> findByStudentId(Long studentId);

}

