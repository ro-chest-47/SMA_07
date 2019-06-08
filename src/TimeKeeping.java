//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.TimerTask;
import java.util.Timer;

public class TimeKeeping {

    int modifiedYear;
    int modifiedMonth;
    int modifiedDay;
    int modifiedHour;
    int modifiedMinute;
    private boolean isTimeKeepingStop;
    private String stringTime;
    Calendar time;
    SimpleDateFormat simpleDateFormat;


    Timer timer = new Timer();

    private  TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(isTimeKeepingStop==false) {
                time.add(Calendar.SECOND, 1);
                stringTime = simpleDateFormat.format(time.getTime());
            }
        }
    };

    public TimeKeeping(){
        this.modifiedYear=0;
        this.modifiedMonth=0;
        this.modifiedDay=0;
        this.modifiedHour=0;
        this.modifiedMinute=0;
        this.isTimeKeepingStop=false;
        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        this.time = Calendar.getInstance();
        stringTime = simpleDateFormat.format(time.getTime());
        timer.scheduleAtFixedRate(task,0,1000);
    }

    //////////////// For display
    public String getCurrentTime() {
        stringTime = simpleDateFormat.format(time.getTime());
        return this.stringTime;          // 주의. month는 0~11 이다.
    }

    public int getDayOfWeek(){
        return this.time.get(Calendar.DAY_OF_WEEK);
    }


    /////////////// For input(button)
    public void setTime(int year, int month, int day, int hour, int minute) {
        this.modifiedYear=year;
        this.modifiedMonth=month;
        this.modifiedDay=day;
        this.modifiedHour=hour;
        this.modifiedMinute=minute;
        time.add(Calendar.YEAR, this.modifiedYear);
        time.add(Calendar.MONTH, this.modifiedMonth);            // 주의. month는 0~11 이다.
        time.add(Calendar.DATE, this.modifiedDay);
        time.add(Calendar.HOUR_OF_DAY, this.modifiedHour);
        time.add(Calendar.MINUTE, this.modifiedMinute);
        //stringTime = simpleDateFormat.format(time.getTime());  // TimerTask에서 해주는중!
    }

    public void stopTimeKeeping(){
        this.isTimeKeepingStop=true;
    }

    public void startTimeKeeping(){
        this.isTimeKeepingStop=false;
    }

    public void setMilliSecondAdd(long i){
        time.add(Calendar.MILLISECOND, (int)i);
    }

    public void setSecond(){
        time.set(Calendar.SECOND, 0);
    }

    public void setMinuteAdd(){
        time.add(Calendar.MINUTE, 1);
    }

    public void setMinuteMinus(){
        time.add(Calendar.MINUTE, -1);
    }

    public void setHourAdd(){
        time.add(Calendar.HOUR, 1);
    }

    public void setHourMinus(){
        time.add(Calendar.HOUR, -1);
    }

    public void setDayAdd(){
        time.add(Calendar.DATE, 1);
    }

    public void setDayMinus(){
        time.add(Calendar.DATE, -1);
    }

    public void setMonthAdd(){
        time.add(Calendar.MONTH, 1);
    }

    public void setMonthMinus(){
        time.add(Calendar.MONTH, -1);
    }

    public void setYearAdd(){
        time.add(Calendar.YEAR, 1);
    }

    public void setYearMinus(){
        time.add(Calendar.YEAR, -1);
    }
}
