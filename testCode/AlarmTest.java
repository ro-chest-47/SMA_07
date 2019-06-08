import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {


    @Test
    public void isAlarmSound() {
        Alarm am = new Alarm();
        am.setThisAlarmHourAdd();
        am.setThisAlarmMinuteAdd();
        am.isAlarmSound(1,1);
        assertEquals(am.getBuzzerOn(), true);
    }

    @Test
    public void setThisAlarmHour() {
    }

    @Test
    public void setThisAlarmMinute() {
    }

    @Test
    public void setAlarmOn() {
    }

    @Test
    public void setAlarmOff() {
    }

    @Test
    public void killAlarm() {
        Alarm am = new Alarm();
        am.setThisAlarmHourAdd();
        am.setThisAlarmMinuteAdd();
        am.isAlarmSound(1,1);
        am.killAlarm();
        assertEquals(am.getBuzzerOn(), false);
    }

    @Test
    public void getAlarmTimeHour() {
    }

    @Test
    public void getAlarmTimeMinute() {
    }

    @Test
    public void getIsAlarmActivated() {
    }

    @Test
    public void getBuzzerOn() {
    }
}