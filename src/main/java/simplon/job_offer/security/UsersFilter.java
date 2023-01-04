package simplon.job_offer.security;

import lombok.AllArgsConstructor;
import simplon.job_offer.dto.AgentDto;
import simplon.job_offer.entities.Agent;
import simplon.job_offer.entities.Recruiter;
import simplon.job_offer.services.impl.AgentServiceImp;
import simplon.job_offer.services.impl.RecruiterServiceImp;

@AllArgsConstructor
public class UsersFilter<T> {

    private final RecruiterServiceImp recruiterServiceImp;
    private final AgentServiceImp agentServiceImp;

    public String getUser(String email){
        Recruiter recruiter = recruiterServiceImp.loadRecruiterByEmail(email);
        Agent agent = agentServiceImp.loadAgentByEmail(email);

        if(recruiter.getEmail().equals(email)) return "RECRUITER";
        else return "AGENT";
    }
}
