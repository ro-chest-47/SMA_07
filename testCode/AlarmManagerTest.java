import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmManagerTest {

    @Test
    public void getAlarmIndex() {
        AlarmManager am = new AlarmManager();
        assertEquals(am.getAlarmIndex(), 0);
    }

    @Test
    public void addAlarmIndex() {
        AlarmManager am = new AlarmManager();
        am.addAlarmIndex();
        assertEquals(am.getAlarmIndex(), 1);
        am.addAlarmIndex();
        assertEquals(am.getAlarmIndex(), 2);
        am.addAlarmIndex();
        assertEquals(am.getAlarmIndex(), 3);
        am.addAlarmIndex();
        assertEquals(am.getAlarmIndex(), 0);
    }

    @Test
    public void setAlarmHour() {
        AlarmManager am = new AlarmManager();
        int i=0;
        am.alarm0.setThisAlarmHourAdd();
        assertEquals(am.getAlarmTimeHour(), 1);
        i++;
        while(i<24){
            am.alarm0.setThisAlarmHourAdd();

            i++;
            if(i != 24) {
                assertEquals(am.getAlarmTimeHour(), i);
            }
        }
        assertEquals(am.getAlarmTimeHour(), 0);
    }

    @Test
    public void setAlarmMinute() {
        AlarmManager am = new AlarmManager();
        int i=0;
        am.alarm0.setThisAlarmMinuteAdd();
        assertEquals(am.getAlarmTimeMinute(), 1);
        i++;
        while(i<60){
            am.alarm0.setThisAlarmMinuteAdd();
            i++;
            if(i != 60){
                assertEquals(am.getAlarmTimeMinute(), i);
            }
        }
        assertEquals(am.getAlarmTimeMinute(), 0);
    }

    @Test
    public void activateAlarm() {
        
    }

    @Test
    public void deactivateAlarm() {
        
    }

    @Test
    public void killAlarm() {
        
    }

    @Test
    public void isBuzzerOn() {
        
    }

    @Test
    public void getAlarmTimeHour() {
        
    }

    @Test
    public void getAlarmTimeMinute() {
        
    }

    @Test
    public void isAlarmActivated() {
        
    }
}
