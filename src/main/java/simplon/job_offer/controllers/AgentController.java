package simplon.job_offer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import simplon.job_offer.dto.AgentDto;
import simplon.job_offer.entities.Agent;
import simplon.job_offer.services.AgentService;
import simplon.job_offer.services.impl.AgentServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
@EnableWebSecurity
@RequiredArgsConstructor
public class AgentController {

    private final AgentServiceImp agentServiceImp;

    @GetMapping("/getAllAgents")
    @PreAuthorize("hasAuthority('AGENT')")
    public ResponseEntity<List<Agent>> getAll(){

        return ResponseEntity.ok().body(agentServiceImp.getAllAgents());
    }
}
