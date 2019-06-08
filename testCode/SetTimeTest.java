import org.junit.Test;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class SetTimeTest {


    @Test
    public void enterSettingTime() {
    }

    @Test
    public void getEnterSettingTimeTrue() {
    }

    @Test
    public void exitSettingTime() {
    }

    @Test
    public void setTimeMinutesAdd() {
    }

    @Test
    public void setTimeMinutesMinus() {
    }

    @Test
    public void setTimeHourAdd() {
    }

    @Test
    public void setTimeHourMinus() {
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
        SetTime st = new SetTime();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;

        st.setYearAdd();
        time.add(Calendar.YEAR,1);
        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st0= new StringTokenizer(st.getCurrentTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        //assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void setYearMinus() {
        SetTime st = new SetTime();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;

        st.setYearMinus();
        time.add(Calendar.YEAR,-1);
        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st0= new StringTokenizer(st.getCurrentTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
       // assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void setTimeSave() {
        SetTime st = new SetTime();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;

        st.setTimeSave();
        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:00");
        testTime = simpleDateFormat.format(time.getTime());
        st0= new StringTokenizer(st.getCurrentTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
       // assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void getIsSetTimeSave() {
    }

    @Test
    public void setTimeUnsave() {
        SetTime st = new SetTime();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;

        st.setYearAdd();
        st.setMonthMinus();
        st.setTimeMinutesMinus();
        st.setTimeMinutesMinus();
        st.setTimeMinutesMinus();
        st.setTimeUnsave();


        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st0= new StringTokenizer(st.getCurrentTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
      //  assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void getCurrentTime() {
        SetTime st = new SetTime();
        String testTime;
        StringTokenizer st0, st1;
        Calendar time = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;


        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        testTime = simpleDateFormat.format(time.getTime());
        st0= new StringTokenizer(st.getCurrentTime(), " :-");
        st1 = new StringTokenizer(testTime, " :-");
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
        assertEquals(st0.nextToken(),st1.nextToken());
      //  assertEquals(st0.nextToken(),st1.nextToken());
    }

    @Test
    public void getDayOfWeek() {
    }
}