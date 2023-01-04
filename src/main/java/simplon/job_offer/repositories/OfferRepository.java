package simplon.job_offer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simplon.job_offer.entities.Offers;

public interface OfferRepository extends JpaRepository<Offers, Long> {

}
