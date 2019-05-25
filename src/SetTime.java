//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetTime {
    private int saveDay;
    private int saveMonth;
    private int saveYear;
    private int saveTimeMinute;
    private int saveTimeHour;
    private boolean isEnterSettingTimeTrue;
    private boolean isTimeSaved;


    String stringTimeWhenSettingTime;

    TimeKeeping timeKeeping;
    SimpleDateFormat simpleDateFormatWhenSettingTime;
    Calendar currentTime;

    public SetTime(){
        this.saveYear=0;
        this.saveMonth=0;
        this.saveDay=0;
        this.saveTimeHour=0;
        this.saveTimeMinute=0;
        this.isEnterSettingTimeTrue=false;



        simpleDateFormatWhenSettingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        stringTimeWhenSettingTime = simpleDateFormatWhenSettingTime.format(timeKeeping.time.getTime());

        timeKeeping = new TimeKeeping();
        currentTime = timeKeeping.time;
        isTimeSaved=false;
    }

    public void enterSettingTime(){
        isTimeSaved=false;
        isEnterSettingTimeTrue=true;
    }

    public boolean getEnterSettingTimeTrue(){
        return isEnterSettingTimeTrue;
    }

    public void exitSettingTime(){
       /* if(isTimeSaved==false){
            this.setTimeUnsave();
        }*/
        this.saveYear=0;
        this.saveMonth=0;
        this.saveDay=0;
        this.saveTimeHour=0;
        this.saveTimeMinute=0;
        isEnterSettingTimeTrue=false;
    }



    public void setTimeMinutesAdd() { // 이 button은 +1 혹은 -1 이다.
        isTimeSaved=false;
        this.saveTimeMinute += 1;
        timeKeeping.setMinuteAdd();
    }

    public void setTimeMinutesMinus() {
        isTimeSaved=false;
        this.saveTimeMinute -= 1;
        timeKeeping.setMinuteMinus();
    }


    public void setTimeHourAdd() {
        isTimeSaved=false;
        this.saveTimeHour += 1;
        timeKeeping.setHourAdd();
    }

    public void setTimeHourMinus() {
        isTimeSaved=false;
        this.saveTimeHour -= 1;
        timeKeeping.setHourMinus();
    }

    public void setDayAdd() {
        isTimeSaved=false;
        this.saveDay += 1;
        timeKeeping.setDayAdd();
    }

    public void setDayMinus() {
        isTimeSaved=false;
        this.saveDay -= 1;
        timeKeeping.setDayMinus();
    }

    public void setMonthAdd() {
        isTimeSaved=false;
        this.saveMonth += 1;
        timeKeeping.setMonthAdd();
    }

    public void setMonthMinus() {
        isTimeSaved=false;
        this.saveMonth -= 1;
        timeKeeping.setMonthMinus();
    }

    public void setYearAdd() {
        isTimeSaved=false;
        this.saveYear += 1;
        timeKeeping.setYearAdd();
    }

    public void setYearMinus() {
        isTimeSaved=false;
        this.saveYear -= 1;
        timeKeeping.setYearMinus();
    }

    public void setTimeSave(){      //이 버튼은 저장할지 안할지를 판단한다.
        this.saveYear=0;
        this.saveMonth=0;
        this.saveDay=0;
        this.saveTimeHour=0;
        this.saveTimeMinute=0;
        timeKeeping.setSecond();
        isTimeSaved=true;
    }

    public void setTimeUnsave(){
        timeKeeping.setTime(-saveYear, -saveMonth, -saveDay, -saveTimeHour, -saveTimeMinute);
    }

    public boolean getIsSetTimeSave(){
        return isTimeSaved;
    }



    ////////////////// For display

    public String getCurrentTime(){
        if(isEnterSettingTimeTrue){
            return stringTimeWhenSettingTime;
        }
        return timeKeeping.getCurrentTime();
    }

    public int getDayOfWeek(){
        return timeKeeping.getDayOfWeek();
    }
}
