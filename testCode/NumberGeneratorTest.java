import org.junit.Test;

import static org.junit.Assert.*;

public class NumberGeneratorTest {
    int testInputNumber=10;
    int testRandomNumber=0;



    @Test
    public void setRange() {
        NumberGenerator ng = new NumberGenerator();
        int i=0;
        while(i<11) {
            ng.setRange();
            i++;
        }

        assertEquals(ng.getInputNumber(), testInputNumber);
    }

    @Test
    public void resetRange() {
        NumberGenerator ng = new NumberGenerator();
        ng.resetRange();
        assertEquals(ng.getInputNumber(), 0);
    }

    @Test
    public void getInputNumber() {
    }

    @Test
    public void getRandomNumber() {
    }

    @Test
    public void generateRandomNumber() {
        NumberGenerator ng = new NumberGenerator();
        int i=0;
        while(i<11) {
            ng.setRange();
            i++;
        }
        ng.generateRandomNumber();
        testRandomNumber=ng.getRandomNumber();
        assertTrue(testRandomNumber<10);
    }
}