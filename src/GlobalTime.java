import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class GlobalTime extends TimeKeeping{

    boolean isGlobalTimeEnter;
    int modifiedHour;
    int modifiedMinute;
    String stringGTime;
    Calendar gTime;
    SimpleDateFormat simpleDateFormat;
    Timer timer = new Timer();

    public GlobalTime(){
        this.isGlobalTimeEnter=false;
        gTime = super.time;
        this.modifiedMinute = 15;
        this.modifiedHour = 1;
       // this.modifiedHour = super.modifiedHour;
      //  this.modifiedMinute = super.modifiedMinute;
       // this.gTime.add(Calendar.HOUR, modifiedHour);
       // this.gTime.add(Calendar.MINUTE, modifiedMinute);

        simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
      //  this.gTime = Calendar.getInstance();
        stringGTime = simpleDateFormat.format(gTime.getTime());
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
           // time.add(Calendar.SECOND,1);
            stringGTime = simpleDateFormat.format(gTime.getTime());
        }
    } ;


////////////////// For UI. 얘네들로, setTime 모드인지, 그냥 GMT를 보여주는 모드인지 알려준다.

    public boolean getIsGlobalTimeEnter(){

        return this.isGlobalTimeEnter;
    }

    public void enterSettingGlobalTime(){
        this.isGlobalTimeEnter=true;
    }

    public void exitSettingGlobalTime(){
        this.isGlobalTimeEnter=false;
    }

/////////////////// For button

    public void saveHoursAdd() {
       // this.modifiedHour++;
        gTime.add(Calendar.HOUR, this.modifiedHour);
    }

    public void saveHoursMinus() {
       // this.modifiedHour--;
        gTime.add(Calendar.HOUR, -(this.modifiedHour));
    }

    public void saveMinutesAdd() {      // 15분 단위로 더하고 빼져야 한다.
       // this.modifiedMinute += 15;
        gTime.add(Calendar.MINUTE, this.modifiedMinute);
    }

    public void saveMinutesMinus() {      // 15분 단위로 더하고 빼져야 한다.
       // this.modifiedMinute -= 15;
        gTime.add(Calendar.MINUTE, -(this.modifiedMinute));
    }



///////////////// For display

    public String getCurrentGlobalTime(){
        stringGTime = simpleDateFormat.format(gTime.getTime());
        return this.stringGTime;
    }

    public int getGlobalDayOfWeek(){
        return this.gTime.get(Calendar.DAY_OF_WEEK);
    }
}
