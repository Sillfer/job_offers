package simplon.job_offer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simplon.job_offer.enums.OfferStatus;

@Entity
 @Data
@NoArgsConstructor
@AllArgsConstructor
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int offresId;

    private String offreName;

    private String description;

    private String profilSearching;

    private String city;

    private String educationLevel;

    private int salary;

    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Recruiter recruiterChief;
}
