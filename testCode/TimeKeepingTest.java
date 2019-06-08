import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class TimeKeepingTest {

    @Test
    public void getCurrentTime() {
    }

    @Test
    public void getDayOfWeek() {
    }

    @Test
    public void setTime() {
    }

    @Test
    public void setSecond() {
    }

    @Test
    public void setMinuteAdd() {
    }

    @Test
    public void setMinuteMinus() {
    }

    @Test
    public void setHourAdd() {
    }

    @Test
    public void setHourMinus() {
    }

    @Test
    public void setDayAdd() {
    }

    @Test
    public void setDayMinus() {
    }

    @Test
    public void setMonthAdd() {
    }

    @Test
    public void setMonthMinus() {
    }

    @Test
    public void setYearAdd() {
        TimeKeeping tk = new TimeKeeping();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;

        tk.setYearAdd();
        time.add(Calendar.YEAR, 1);
        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st0=new StringTokenizer(tk.getCurrentTime(), " -:");
        st1=new StringTokenizer(testTime, " -:");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void setYearMinus() {
    }
}