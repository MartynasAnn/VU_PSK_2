package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.util.Random;

//Specializes - komandoms kurios zaidzia 13x13 zmoniu, todel 26
@Specializes
@ApplicationScoped
public class JerseyNumberGenerator13x13 extends JerseyNumberGenerator{

    @Override
    public Integer generateJerseyNumber() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedJerseyNumber = new Random().nextInt(26);
        return generatedJerseyNumber;
    }
}
