package simplon.job_offer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simplon.job_offer.entities.Recruiter;


@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Recruiter findByEmail(String email);
}
