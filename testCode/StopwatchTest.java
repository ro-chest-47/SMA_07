import org.junit.Test;

import static org.junit.Assert.*;

public class StopwatchTest {

    @Test
    public void startStopwatch() {
    }

    @Test
    public void stopStopwatch() {
        Stopwatch st = new Stopwatch();
        st.startStopwatch();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        st.stopStopwatch();
        assertEquals(st.getStopwatchTime(),100);
    }

    @Test
    public void resetStopwatch() {
        Stopwatch st = new Stopwatch();
        st.startStopwatch();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        st.stopStopwatch();
        assertEquals(st.getStopwatchTime(),100);
        st.resetStopwatch();
        assertEquals(st.getStartStopwatch(), false);
        assertEquals(st.getStopwatchTime(),0);

    }

    @Test
    public void getStopwatchTime() {
    }
}