package simplon.job_offer.security;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import simplon.job_offer.dto.AgentDto;
import simplon.job_offer.entities.Agent;
import simplon.job_offer.entities.Recruiter;
import simplon.job_offer.services.impl.AgentServiceImp;
import simplon.job_offer.services.impl.RecruiterServiceImp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConf {
    private final PasswordEncoder passwordEncoder;
    private final RecruiterServiceImp recruiterServiceImp;
    private final AgentServiceImp agentServiceImp;


    @Bean
    UserDetailsService userDetailsService() {
        return email -> {

            User user = null;

            Recruiter recruiter = recruiterServiceImp.loadRecruiterByEmail(email);
            if(recruiter == null){
                Agent agent = agentServiceImp.loadAgentByEmail(email);
                GrantedAuthority authority = new SimpleGrantedAuthority(agent.getRole());
                List<GrantedAuthority> authorities = Collections.singletonList(authority);
                user =  new User(agent.getEmail(), agent.getPassword(),authorities);
            }else {
                GrantedAuthority authority = new SimpleGrantedAuthority(recruiter.getRole());
                List<GrantedAuthority> authorities = Collections.singletonList(authority);

                user =  new User(recruiter.getEmail(), recruiter.getPassword(),authorities);
            }

            return user;



        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http
                .authorizeHttpRequests()
                .requestMatchers("/api/recruiter/**").hasAuthority("RECRUITER");

        http
                .authorizeHttpRequests().requestMatchers("/api/agent/**").hasAuthority("AGENT");

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults());
        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        // create an authentication manager with a custom user details service
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        return new ProviderManager(Arrays.asList(provider));
    }
}
