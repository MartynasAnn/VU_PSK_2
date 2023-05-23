package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.util.Random;


//Cia yra alternatyva - suletintas thread sleep
@ApplicationScoped
@Alternative
public class SlowNumberGenerator implements NumberGenerator{

    @Override
    public Integer generateJerseyNumber() {
        try {
            Thread.sleep(5000); // Simulate EVEN MORE intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedJerseyNumber = new Random().nextInt(100);
        return generatedJerseyNumber;
    }
}