package simplon.job_offer.services;

import simplon.job_offer.entities.Recruiter;

import java.util.List;

public interface RecruiterService {
    Recruiter loadRecruiterByEmail(String email);

    List<Recruiter> getAllRecruiter();
}
