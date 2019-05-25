import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.lang.InterruptedException;

public class Alarm extends TimeKeeping{
    private boolean isAlarmActivated;
    private int alarmTimeHour;
    private int alarmTimeMinute;
    private boolean isAlarmKilled;
    //private int currentHourModifier;
   // private int currentMinuteModifier;
    private boolean buzzerOn;
    //StringTokenizer st;
    Calendar currentTime;

    TimerTask task = new TimerTask() {
        @Override
        public void run(){
            if(isAlarmActivated) {
                if (isAlarmKilled) {
                    try {
                        Thread.sleep(60000);
                        isAlarmKilled = false;
                    } catch (InterruptedException e) {

                    }
                } else {
                    isAlarmSound(currentTime.get(Calendar.HOUR), currentTime.get(Calendar.MINUTE));
                }
            }
        }
    };

    Timer timer = new Timer();

    public Alarm(){
        this.alarmTimeHour=0;
        this.alarmTimeMinute=0;
        this.buzzerOn = false;
        this.isAlarmActivated=false;
        this.isAlarmKilled=false;
        currentTime = super.time;           // 알람이 TimeKeeping의 시간을 그대로 가져온다.
    }

    //////////////// For task
    public void isAlarmSound(int currentHour, int currentMinute){     // 알람이 제 시간이 되어 울리게 되는지 알려주는 메소드.
        if(this.alarmTimeHour == currentHour && this.alarmTimeMinute == currentMinute){
            buzzerOn = true;
        }
        //Buzzer ON!!!!!
    }

   //////////////////// For input(button)
    public void setThisAlarmHour() {
        if(this.alarmTimeHour == 23){
            this.alarmTimeHour = 0;
        } else {
            this.alarmTimeHour++;
        }
        //return hour;
    }

    public void setThisAlarmMinute() {
        if(this.alarmTimeMinute == 59){
            this.alarmTimeMinute=0;
        } else {
            this.alarmTimeMinute++;
        }
        //return minute;
    }

    public void setAlarmOn() {
        this.isAlarmActivated=true;
        timer.scheduleAtFixedRate(this.task,0, 1000);
        //return this.isAlarmActivated;
    }

    public void setAlarmOff(){       // deactivate alarm
        this.isAlarmActivated=false;
        timer=null;
        //return this.isAlarmActivated;
    }

    public void killAlarm() {       // turn off the alarm when its ringing
        this.isAlarmKilled = true;
        this.buzzerOn = false;              // 1분만 쉬게 해주게 해야한다!!!!
    }


    ///////////////// For display

    public int getAlarmTimeHour(){
        return this.alarmTimeHour;
    }

    public int getAlarmTimeMinute(){
        return  this.alarmTimeMinute;
    }

    public boolean getIsAlarmActivated(){       // UI에 불켜주려고. 알람활성화 확인 메소드.
        return isAlarmActivated;
    }

    ////////////// For buzzer
    public boolean getBuzzerOn(){   // UI클래스에서 부저를 울리는지 안울리는지 판단하기용.
        return buzzerOn;
    }
}
