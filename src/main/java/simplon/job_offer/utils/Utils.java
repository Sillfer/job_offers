package simplon.job_offer.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHANUMERIC = "azertyuiopmlkjhgfdsqwxcvbnAZERTYUIOPMLKJHGFDSQWXCVBN0987654321";

    public String generateId(int length){
        StringBuilder returnvalue =  new StringBuilder(length);
        for(int i = 0 ; i < length ;i++){
            returnvalue.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return new String(returnvalue);
    }
}
