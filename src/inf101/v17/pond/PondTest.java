package inf101.v17.pond;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.util.Random;

public class PondTest {
    Pond testPond;
    Position pos;
    Duck female, duckling;
    public static final double NOMINAL_WIDTH = 1900, NOMINAL_HEIGHT = 1000;
    final Random random = new Random();

    private Position randomPos() {
        return new Position(random.nextGaussian() * NOMINAL_WIDTH / 4 + NOMINAL_WIDTH / 2, //
                random.nextGaussian() * NOMINAL_HEIGHT / 4 + NOMINAL_HEIGHT / 2);
    }

    @Before
    public void createPond(){
        testPond = new Pond(1900,1000);
        pos = new Position(1600, 500);
        female = new FemaleDuck(randomPos(), new Direction(-1.0, 0.0), testPond);
        duckling = new Duckling(randomPos(), new Direction(1.0, 0.0), testPond);

        testPond.addObject(female);
        testPond.addObject(duckling);
    }

    /**
     * Test that the distance between the female duck and the duckling is reduced after a certain
     * amount of steps.
     */
    @Test
    public void moveTest(){
        double startDifference, endDifference;
        boolean largeFemale = false;
        duckling.swim();

        if (female.getX()+female.getY() > duckling.getX()+duckling.getY()) {
            startDifference = (female.getX()+female.getY()) - (duckling.getX()+duckling.getY());
            largeFemale = true;
        } else {
            startDifference = (duckling.getX()+duckling.getY()) - (female.getX()+female.getY());
        }

        for (int i = 0; i < 2000; i++) {testPond.step();}

        if (largeFemale) {
            endDifference = (female.getX()+female.getY()) - (duckling.getX()+duckling.getY());
        } else {
            endDifference = (duckling.getX()+duckling.getY()) - (female.getX()+female.getY());
        }

        assert endDifference < startDifference;

    }
}
