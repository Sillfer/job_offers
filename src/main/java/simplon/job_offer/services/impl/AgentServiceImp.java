package simplon.job_offer.services.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import simplon.job_offer.dto.AgentDto;
import simplon.job_offer.entities.Agent;
import simplon.job_offer.repositories.AgentRepository;
import simplon.job_offer.security.PasswordEncoder;
import simplon.job_offer.services.AgentService;
import simplon.job_offer.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AgentServiceImp implements AgentService {
    private final AgentRepository agentRepository;
    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent addAgents(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent loadAgentByEmail(String email) {
        return agentRepository.findAgentsByEmail(email);
    }
}

