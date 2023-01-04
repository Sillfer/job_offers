package simplon.job_offer.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simplon.job_offer.entities.Recruiter;
import simplon.job_offer.services.impl.RecruiterServiceImp;

import java.util.List;


@RestController
@RequestMapping("/api/recruiter")
@RequiredArgsConstructor
@EnableWebSecurity
public class RecruiterController {
    private final RecruiterServiceImp recruiterServiceImp;

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('RECRUITER')")
    public ResponseEntity<List<Recruiter>> getAllRecruters(){
        return ResponseEntity.ok().body(recruiterServiceImp.getAllRecruiter());
    }
}
