package simplon.job_offer.dto;

import simplon.job_offer.entities.Agent;

import java.io.Serializable;

public class AgentDto implements Serializable {
    private Integer agentId;
    private String email;
    private String password;
    private String Role;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    AgentDto transformToDto(Agent agent){
        AgentDto agentDto = new AgentDto();
        agentDto.setAgentId(agent.getAgentId());
        agentDto.setEmail(agent.getEmail());
        agentDto.setPassword(agent.getPassword());
        agentDto.setRole(agent.getRole());
        return agentDto;
    }

    Agent transformToEntity(AgentDto agentDto){
        Agent agent = new Agent();
        agent.setAgentId(agentDto.getAgentId());
        agent.setEmail(agentDto.getEmail());
        agent.setPassword(agentDto.getPassword());
        agent.setRole(agentDto.getRole());
        return agent;
    }
}
