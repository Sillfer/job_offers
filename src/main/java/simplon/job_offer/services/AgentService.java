package simplon.job_offer.services;

import simplon.job_offer.dto.AgentDto;
import simplon.job_offer.entities.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAllAgents();

    Agent addAgents(Agent agent);

    Agent loadAgentByEmail(String email);
}
