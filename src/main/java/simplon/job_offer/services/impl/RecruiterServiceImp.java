package simplon.job_offer.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import simplon.job_offer.dto.RecruiterDto;
import simplon.job_offer.entities.Recruiter;
import simplon.job_offer.repositories.RecruiterRepository;
import simplon.job_offer.services.RecruiterService;
import simplon.job_offer.utils.Utils;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecruiterServiceImp implements RecruiterService {

    private final RecruiterRepository recruiterRepository;
    @Override
    public Recruiter loadRecruiterByEmail(String email) {
        return recruiterRepository.findByEmail(email);
    }

    @Override
    public List<Recruiter> getAllRecruiter() {
        return recruiterRepository.findAll();
    }
}
