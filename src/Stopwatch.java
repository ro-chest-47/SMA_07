import java.util.TimerTask;
import java.util.Timer;

public class Stopwatch{
    private boolean startStopwatch;
    private long stopwatchTime;

    Timer timer = new Timer();

    public Stopwatch(){
        startStopwatch=false;
        stopwatchTime=719500;
        timer.scheduleAtFixedRate(task, 0, 10);


    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(startStopwatch) {
                if(stopwatchTime<720000) {
                    stopwatchTime++;
                }
            }
        }
    };


////////////// For input(button)
    public void startStopwatch() {
        this.startStopwatch=true;
        timer = new Timer();
        //timer.scheduleAtFixedRate(task, 0, 10);
        //return this.stopwatchTime;
    }

    public void stopStopwatch() {
        this.startStopwatch=false;
        //return this.stopwatchTime;
    }

    public boolean getStartStopwatch(){
        return this.startStopwatch;
    }

    public void resetStopwatch() {       // 아마도 system에서 그냥 null로 넣어줘도 되겠지만..
        this.startStopwatch=false;
        //timer = null;
        this.stopwatchTime=0;
        //return 0;
    }


//////////////// For display
    public long getStopwatchTime(){
        return this.stopwatchTime;          // display가 이 부분을 계속 본다.
                                            // 근데 10밀리초씩 커지기만 하니까
                                            // 이 return 값은 display에서 100 * 60 을 나눠줘야 한다.
                                            // 타이머에서도 비슷하게 100*60*60을 나눠줘야 한다.
    }

}
