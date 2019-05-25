import java.util.TimerTask;
import java.util.Timer;

public class TimerT{
    private int minute;
    private int hour;
    private long time;
    private boolean isTimerStart;
    private boolean isCountDownZero;

    Timer timer = new Timer();

    public TimerT(){
        this.hour=0;
        this.minute=0;
        this.time=0;
        this.isTimerStart=false;
        this.isCountDownZero=false;
    }

   TimerTask task = new TimerTask() {
       @Override
       public void run() {
           if(isTimerStart) {
               if(isCountDownZero){
                   time++;
               } else {
                   time--;
               }

               if(time==0){
                   isCountDownZero=true;
               }

               if(time >= 7200){        // 원래 타이머 시간 1시간 59분 까지 설정 가능. 계속 커지다가 2시간이 되면 리셋.
                   resetTimer();
               }
           }
       }
   };



/////////// button으로 입력받는다.
    public void saveMinutesAdd() {        // setTime과 동일하게 1번 누르면 +5 혹은 -5
        if(this.minute==59){
            if(this.hour==0) {
                this.minute = 0;
                this.hour=1;
            } else {
                this.minute=59;
            }
        } else {
            this.minute ++;
        }
        this.time=60*this.minute;
        this.time=3600*this.hour;
    }

    public void saveMinutesMinus(){
        if(this.minute==0){
            if(this.hour==1) {
                this.minute = 59;
                this.hour = 0;
            } else {
                this.minute=0;
            }
        } else {
            this.minute--;
        }
        this.time = 60*this.minute;
        this.time=3600*this.hour;
    }


    public void saveHour() {            // 시간은 1시간만 설정할 수 있다. 이 때 이 함수를 다시 부르면 0시간으로!
        if(this.hour==1){
            this.hour=0;
        } else {
            this.hour=1;
        }
        this.time=3600*this.hour;
    }



    public void startTimer() {                              // display가 이 함수를 계속 참조하면.
                                                            // this.time이 계속 초기화가 된다!!!
                                                            // 그래서 display용 함수 따로 만듦.
        this.isTimerStart=true;
        timer.scheduleAtFixedRate(task,0,1000);
        //return this.time;
    }

    public void stopTimer() {
        this.isTimerStart=false;
        this.isCountDownZero=false;             // 타이머 시간이 0이 된 후 부저가 울릴 때, 한번 멈췄다가 다시 시작해주면 부저는 안울리는데 계속 시간은 커진다.
       // return this.time;
    }

    public void resetTimer(){
        this.isTimerStart=false;
        this.isCountDownZero=false;
        this.hour=0;
        this.minute=0;
        this.time=0;
        timer = null;
        //return 0;
    }

    /////////////// For display
    public long getTimerTime(){
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
