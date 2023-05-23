package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class JerseyNumberGenerator implements Serializable, NumberGenerator {

    public Integer generateJerseyNumber() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedJerseyNumber = new Random().nextInt(100);
        return generatedJerseyNumber;
    }
}