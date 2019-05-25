import org.junit.Test;

import java.util.Calendar;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class GlobalTimeTest {


    @Test
    public void getIsGlobalTimeEnter() {
    }

    @Test
    public void enterSettingGlobalTime() {
    }

    @Test
    public void exitSettingGlobalTime() {
    }

    @Test
    public void saveHoursAdd() {
    }

    @Test
    public void saveHoursMinus() {
    }

    @Test
    public void saveMinutesAdd() {
    }

    @Test
    public void saveMinutesMinus() {
    }

    @Test
    public void getCurrentGlobalTime() {
        GlobalTime gt = new GlobalTime();
        String testTime;
        StringTokenizer st, st1;
        Calendar time = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st= new StringTokenizer(gt.getCurrentGlobalTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st.nextToken(),st1.nextToken());
        assertEquals(st.nextToken(),st1.nextToken());
        assertEquals(st.nextToken(),st1.nextToken());
        assertEquals(st.nextToken(),st1.nextToken());
        assertEquals(st.nextToken(),st1.nextToken());
        assertEquals(st.nextToken(),st1.nextToken());
    }

    @Test
    public void getGlobalDayOfWeek() {
    }
}