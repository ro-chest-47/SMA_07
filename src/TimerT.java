import java.util.TimerTask;
import java.util.Timer;

public class TimerT{
    //private long minute;
    //private long hour;
    private float time;
    private boolean isTimerStart;
    private boolean isCountDownZero;
    //private boolean isTimerTimeSaved;

    Timer timer= new Timer();

    public TimerT(){
       // this.hour=0;
       // this.minute=0;
        this.time=0;
        this.isTimerStart=false;
        this.isCountDownZero=false;
        timer.scheduleAtFixedRate(task,0,10);
    }

    private TimerTask task= new TimerTask() {
       @Override
       public void run() {
           if(isTimerStart) {
               if(isCountDownZero){
                   time+=0.01;
               } else {
                   time-=0.01;
               }

               if(time<=0.02){
                   isCountDownZero=true;
               }

               if(time >= 7200){        // 원래 타이머 시간 1시간 59분 까지 설정 가능. 계속 커지다가 2시간이 되면 리셋.
                   resetTimer();
               }
           }
       }
   };





/////////// button으로 입력받는다.
    public void saveMinutesAdd() {        // setTime과 동일하게 1번 누르면 +1 혹은 -1

        if(this.time<7200){
            this.time += 60;
        }
    }

    public void saveMinutesMinus(){

        if(this.time>0){
            this.time -= 60;
        }
    }


    public void saveHour() {            // 시간은 1시간만 설정할 수 있다. 이 때 이 함수를 다시 부르면 0시간으로!

        if(this.time<3600){
            this.time += 3600;
        } else {
            this.time -= 3600;
        }
    }



    public void startTimer() {
        if(this.time != 0) {
            this.isTimerStart = true;
        }

        //return this.time;
    }

    public void stopTimer() {
        this.isTimerStart=false;
        this.isCountDownZero=false;             // 타이머 시간이 0이 된 후 부저가 울릴 때, 한번 멈췄다가 다시 시작해주면 부저는 안울리는데 계속 시간은 커진다.
       // return this.time;
    }

    public void resetTimer(){
       // timer.
        this.isTimerStart=false;
        this.isCountDownZero=false;
        this.time=0;
    }

    public boolean getIsTimerStart(){
        return this.isTimerStart;
    }

   /////////////// For display
    public float getTimerTime(){
        return this.time;
    }

    /////////////// For buzzer
    public boolean isBuzzerOn(){
        if(this.isCountDownZero){
            return true;
        } else {
            return false;
        }
    }
}
