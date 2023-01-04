package simplon.job_offer;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import simplon.job_offer.entities.Agent;
import simplon.job_offer.entities.Offers;
import simplon.job_offer.entities.Recruiter;
import simplon.job_offer.enums.OfferStatus;
import simplon.job_offer.security.PasswordEncoder;
import simplon.job_offer.services.RecruiterService;
import simplon.job_offer.services.impl.AgentServiceImp;
import simplon.job_offer.services.impl.OfferServiceImp;

@SpringBootApplication
@AllArgsConstructor
public class JobOfferApplication {

	private final OfferServiceImp offersServiceImp;
	private final PasswordEncoder passwordEncoder;

	private final AgentServiceImp agentServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(JobOfferApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RecruiterService recruiterService){
		return args -> {
//			OfferServiceImp.addOffer(
//					new Offers(
//							1,
//							"Developer Java",
//							"raanddommdmdmdmmdk",
//							"Developer Java",
//							"rabat",
//							"Bac + 5",
//							5000,
//							OfferStatus.UNPUBLISHED,
//							new Recruiter(
//									1,
//									"zk@gmail.com",
//									passwordEncoder.bCryptPasswordEncoder().encode("katlife"),
//									"0631703116",
//									"https://www.google.com/url?sa=i&url=https%3A%2F%2Fcomicbook.com%2Fgaming%2Fnews%2Fleague-of-legends-yasuo-origins%2F&psig=AOvVaw3ZLFuDeULVFofHlnOSDCcN&ust=1672413657822000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJia9MGQn_wCFQAAAAAdAAAAABAJ",
//									"RECRUITER",
//									null
//							)
//
//					)
//			);
//
//			offersServiceImp.addOffer(
//					new Offers(
//							2,
//							"Developer js",
//							"raanddommdmdmdmmdk",
//							"Developer js",
//							"rabat",
//							"Bac + 2",
//							5000,
//							OfferStatus.UNPUBLISHED,
//							new Recruiter(
//									2,
//									"tj@gmail.com",
//									passwordEncoder.bCryptPasswordEncoder().encode("katlife"),
//									"0631703116",
//									"https://www.google.com/url?sa=i&url=https%3A%2F%2Fcomicbook.com%2Fgaming%2Fnews%2Fleague-of-legends-yasuo-origins%2F&psig=AOvVaw3ZLFuDeULVFofHlnOSDCcN&ust=1672413657822000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJia9MGQn_wCFQAAAAAdAAAAABAJ",
//									"RECRUITER",
//									null
//							)
//
//					)
//			);

			agentServiceImp.addAgents(
					new Agent(
							1,
							"agent@gmail.com",
							passwordEncoder.bCryptPasswordEncoder().encode("mahdi"),
							"AGENT"
					)
			);


		};
	}
	}

