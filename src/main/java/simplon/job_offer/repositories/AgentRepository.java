package simplon.job_offer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simplon.job_offer.entities.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findAgentsByEmail(String email);
}
