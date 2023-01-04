package simplon.job_offer.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simplon.job_offer.entities.Offers;
import simplon.job_offer.repositories.OfferRepository;
import simplon.job_offer.services.OffersService;

@Service
@Transactional
@RequiredArgsConstructor
public class OfferServiceImp implements OffersService {
    private final OfferRepository offerRepository;
    @Override
    public Offers addOffer(Offers offer) {
        return offerRepository.save(offer);
    }
}
