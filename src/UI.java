//import java.util.TimerTask;
import java.util.StringTokenizer;


public class UI {        // UI에서는 각 파트별로 뭘 나타낼지만 알려준다.
    long time;

    int hourPart, minutePart, secondPart, yearPart, monthPart, dayPart;
    //boolean isHourPartSelected, isMinutePartSelected, isSecondPartSelected, isYearPartSelected, isMonthPartSelected, isDayPartSelected;

    private int modeIndex;
    private int dateIndex;
    private boolean blinkMinutePart;
    private boolean blinkHourPart;
    private boolean blinkDayPart;
    private boolean blinkMonthPart;
    private boolean blinkYearPart;
    private boolean isAlarmActivated;
   // int modeIndex;

    private boolean buzzer;




    String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    String stringTime;
    StringTokenizer stringTimeTokenized;

    WatchSystem system = new WatchSystem();

    public UI(){
        modeIndex=0;
        dateIndex=0;
        blinkMinutePart=false;          // 이 부분은 button 쓰레드에서 해야하나???
        blinkHourPart=false;
        blinkDayPart=false;
        blinkMonthPart=false;
        blinkYearPart=false;
        hourPart=0;
        minutePart=0;
        secondPart=0;
        yearPart=0;
        monthPart=0;
        dayPart=0;
        buzzer=false;
    }

    Runnable displayThread = new Runnable() {
        @Override
        public void run() {
            while (true) {
                // Display
                modeIndex=system.setModes.getCurrentMode();
                isAlarmActivated = system.alarmManager.isAlarmActivated();   // 모드에 상관 없이 보여진다.

                switch (modeIndex){
                    case 0:         // Set Time
                            dateIndex=system.getDayOfWeek();
                            stringTime = system.getCurrentTime();
                            stringTimeTokenized = new StringTokenizer(stringTime, " -:");
                            yearPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            monthPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            dayPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            hourPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            minutePart=Integer.parseInt(stringTimeTokenized.nextToken());
                            secondPart=Integer.parseInt(stringTimeTokenized.nextToken());

                        break;

                    case 1:        // Timer

                        // 설정시 깜빡임 구현해야 함!!!
                        secondPart=(int)system.timerT.getTimerTime();
                        minutePart=(int)(system.timerT.getTimerTime() / 60 );
                        hourPart=(int)(system.timerT.getTimerTime() / (60*60) );
                        break;

                    case 2:        // Stopwatch
                        secondPart=(int)system.stopwatch.getStopwatchTime();
                        minutePart=(int)(system.stopwatch.getStopwatchTime() / 60 );
                        break;

                    case 3:         // Alarm
                        secondPart=0;
                        minutePart=system.alarmManager.getAlarmTimeMinute();
                        hourPart=system.alarmManager.getAlarmTimeHour();
                        break;

                    case 4:         // Random Number Generator
                        hourPart=system.numberGenerator.getInputNumber();
                        minutePart=system.numberGenerator.getRandomNumber();
                        break;

                    case 5:         // GMT
                            dateIndex = system.getGlobalDayOfWeek();
                            stringTime = system.getCurrentGlobalTime();
                            stringTimeTokenized = new StringTokenizer(stringTime, " -:");
                            yearPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            monthPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            dayPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            hourPart=Integer.parseInt(stringTimeTokenized.nextToken());
                            minutePart=Integer.parseInt(stringTimeTokenized.nextToken());
                            secondPart=Integer.parseInt(stringTimeTokenized.nextToken());

                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }
    };

    Runnable buzzerThread = new Runnable() {
        @Override
        public void run() {
            while(true) {
                if(system.setModes.getCurrentModes()[1]){       // 모드 인덱스 1 타이머
                    system.isTimerBuzzerOn();
                }

                if(system.setModes.getCurrentModes()[3]){        // 모드 인덱스 3 알람
                    system.isAlarmBuzzerOn();
                }

                try{
                    Thread.sleep(100);
                } catch(InterruptedException e){
                    e.getMessage();
                }
            }
        }
    };

    Runnable button = new Runnable() {
        @Override
        public void run() {
            while(true){





            }
        }
    };

}
