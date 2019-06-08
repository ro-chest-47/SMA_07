import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class TimerTTest {

    @Test
    public void saveMinutesAdd() {
        TimerT tImerT = new TimerT();
        tImerT.saveMinutesAdd();
        assertEquals(tImerT.getTimerTime(), 60);
        tImerT.saveMinutesAdd();
        assertEquals(tImerT.getTimerTime(), 120);
    }

    @Test
    public void saveMinutesMinus() {
        TimerT tImerT = new TimerT();
        tImerT.saveMinutesAdd();
        assertEquals(tImerT.getTimerTime(), 60);
        tImerT.saveMinutesAdd();
        assertEquals(tImerT.getTimerTime(), 120);
        tImerT.saveMinutesMinus();
        assertEquals(tImerT.getTimerTime(), 60);
    }

    @Test
    public void saveHour() {
        TimerT timerT =new TimerT();
        timerT.saveHour();
        assertEquals(timerT.getTimerTime(), 3600);
        timerT.saveHour();
        assertEquals(timerT.getTimerTime(), 0);
    }

    @Test
    public void startTimer() {
    }

    @Test
    public void stopTimer() {
    }

    @Test
    public void resetTimer() {
        TimerT timerT =new TimerT();
        timerT.saveHour();
        assertEquals(timerT.getTimerTime(), 3600);
        timerT.saveMinutesAdd();
        assertEquals(timerT.getTimerTime(), 3660);
        timerT.resetTimer();
        assertEquals(timerT.getTimerTime(), 0);
    }

    @Test
    public void getTimerTime() {
    }

    @Test
    public void isBuzzerOn() {
    }
}