import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;

public class UI {        // UI에서는 각 파트별로 뭘 나타낼지만 알려준다.


    long time;
    private int blinkTIme;
    private int blinkInThisTime;

    int hourPart, minutePart, secondPart, yearPart, monthPart, dayPart;
    //boolean isHourPartSelected, isMinutePartSelected, isSecondPartSelected, isYearPartSelected, isMonthPartSelected, isDayPartSelected;

    private long delay;

    private int modeIndex;
    private int dateIndex;
    private boolean blinkMinutePart;
    private boolean blinkHourPart;
    private boolean blinkDayPart;
    private boolean blinkMonthPart;
    private boolean blinkYearPart;
    private boolean isAlarmActivated;
   // int modeIndex;

    private boolean buzzerA;
    private boolean buzzerT;


    boolean[] copiedNewMode = new boolean[]{true, false, false, false, false, false};
   // String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    String stringTime;
    StringTokenizer stringTimeTokenized;

    GUI gui = new GUI();
    WatchSystem system = new WatchSystem();

    public UI(){
        delay=300;
        blinkTIme = 0;
        blinkInThisTime = 100;

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
        buzzerA=false;
        buzzerT=false;

        gui.setVisible(true);
    }



    MouseListener mouseListener0 = new MouseAdapter() {     // 버튼 0 기능들.
        private long mousePressedTime;
        //private long delay = 500;

        public void mousePressed(MouseEvent e){
            system.killAlarm();
            mousePressedTime=e.getWhen();
        }

        public void mouseReleased(MouseEvent e){
            if(e.getWhen() - mousePressedTime < delay){      // 1초보다 짧게 누르면!!!!

                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.
                    system.saveMode();
                    for(int i=0; i<6; i++) {                                //////////////////////////////////// test Code //////////////////////////////////////
                        System.out.print(" mode" + i + ": " + system.getNewModes()[i]);
                        System.out.println(" ");
                    }

                } else {
                    switch (modeIndex) {        //일반 mode 일 경우.
                        case 0:
                            if(system.getEnterSettingTimeTrue()) {      // set Time 모드일 경우
                                switch(system.getCursor()){        // 커서가 어디에 있는가??
                                    case 0:     // '분'을 조정한다.
                                        system.setTimeMinutesAdd();
                                        break;
                                    case 1:
                                        system.setTimeHourAdd();
                                        break;
                                    case 2:
                                        system.setDayAdd();
                                        break;
                                    case 3:
                                        system.setMonthAdd();
                                        break;
                                    case 4:
                                        system.setYearAdd();
                                        break;
                                }
                            } else {        //Time Keeping 모드일 경우
                                system.enterSettingTime();
                            }
                            break;

                        case 1:         // Timer 모드인 경우
                            if(system.getIsTimerStart()==false) {
                                system.saveMinutesAdd();
                            }
                            break;

                        case 2:
                            if(system.getIsStopwatchStart()==false){
                                system.resetStopwatch();
                            }
                            break;

                        case 3:
                            system.setAlarmMinuteAdd();
                            break;

                        case 4:
                            system.setRandomNumberRange();
                            break;

                        case 5:
                            if(system.getIsGlobalTimeEnter()){  // GMT 세팅 모드일 경우
                                system.setGlobalTimeSaveHoursAdd();
                            } else {        // GMT 시간만 보는 경우.
                                system.enterSettingGlobalTime();
                            }
                            break;
                    }
                }
            } else {             // 1초보다 길게 누르면!!!!!
                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.

                } else {
                    switch (modeIndex) {
                        case 0:
                            break;

                        case 1:         // 버튼 0을 길게 누를 때 유효한 경우는 Timer와 알람, GMT 뿐
                            if(system.getIsTimerStart()==false){
                                system.saveHour();
                            }
                            break;

                        case 2:
                            break;

                        case 3:
                            system.setAlarmHourAdd();
                            break;

                        case 4:
                            break;

                        case 5:
                            if(system.getIsGlobalTimeEnter()){
                                system.setGlobalTimeSaveMinutesAdd();
                            }
                            break;

                    }
                }
            }
        }
    };



    MouseListener mouseListener1 = new MouseAdapter() {
        private long mousePressedTime;
        //private long delay = 1000;

        public void mousePressed(MouseEvent e){
            system.killAlarm();
            mousePressedTime=e.getWhen();
        }

        public void mouseReleased(MouseEvent e){
            if(e.getWhen() - mousePressedTime < delay){      // 1초보다 짧게 누르면!!!!

                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.


                } else {
                    switch (modeIndex) {            // 일반 모드일 경우
                        case 0:
                            if(system.getEnterSettingTimeTrue()){
                                switch (system.getCursor()){
                                    case 0:     // '분'을 조정한다.
                                        system.setTimeMinutesMinus();
                                        break;
                                    case 1:
                                        system.setTimeHourMinus();
                                        break;
                                    case 2:
                                        system.setDayMinus();
                                        break;
                                    case 3:
                                        system.setMonthMinus();
                                        break;
                                    case 4:
                                        system.setYearMinus();
                                        break;
                                }
                            }
                            break;

                        case 1:
                            if(system.getIsTimerStart()==false) {
                                system.saveMinutesMinus();
                            }
                            break;

                        case 2:
                            break;

                        case 3:
                            system.setAlarmMinuteMinus();
                            break;

                        case 4:
                            system.resetRandomNumberRange();
                            break;

                        case 5:
                            if(system.getIsGlobalTimeEnter()){
                                system.setGlobalTimeSaveHoursMinus();
                            }
                            break;
                    }
                }
            } else {             // 1초보다 길게 누르면!!!!!
                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.

                } else {
                    switch (modeIndex) {        // 일반 모드일 경우.
                        case 0:
                            break;

                        case 1:
                            if(system.getIsTimerStart()==false) {
                                system.saveHour();
                            }
                            break;

                        case 2:
                            break;

                        case 3:
                            system.setAlarmHourMinus();
                            break;

                        case 4:
                            break;

                        case 5:
                            if(system.getIsGlobalTimeEnter()){
                                system.setGlobalTimeSaveMinutesMinus();
                            }
                            break;
                    }
                }
            }
        }
    };


    MouseListener mouseListener2 = new MouseAdapter() {
        private long mousePressedTime;
       // private long delay = 1000;

        public void mousePressed(MouseEvent e){
            system.killAlarm();
            mousePressedTime=e.getWhen();
        }

        public void mouseReleased(MouseEvent e){
            if(e.getWhen() - mousePressedTime < delay){      // 1초보다 짧게 누르면!!!!

                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.
                    system.resetNewModes();

                } else {
                    switch (modeIndex) {        // 일반 모드일 경우.
                        case 0:
                            if(system.getEnterSettingTimeTrue()){
                                system.setTimeSave();
                            }
                            break;

                        case 1:
                            if(system.getIsTimerStart()){
                                system.stopTImer();
                            } else {
                                system.startTimer();
                            }
                            break;

                        case 2:
                            if(system.getIsStopwatchStart()){
                                system.stopStopwatch();
                            } else {
                                system.startStopwatch();
                            }
                            break;

                        case 3:
                            system.activateAlarm();
                            break;

                        case 4:
                            system.generateRandomNumber();
                            break;

                        case 5:
                            break;

                    }
                }
            } else {             // 1초보다 길게 누르면!!!!!
                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.

                } else {
                    switch (modeIndex) {        // 일반 모드일 경우.
                        case 0:
                            if(system.getEnterSettingTimeTrue()){
                                system.exitSettingTime();
                            }
                            break;

                        case 1:
                            if(system.getIsTimerStart()==false) {
                                system.resetTimer();
                            }
                            break;


                        case 3:
                            system.addAlarmIndex();
                            break;

                            default:
                                break;
                    }
                }
            }
        }
    };




    MouseListener mouseListener3 = new MouseAdapter() {
        private long mousePressedTime;
       // private long delay = 1000;

        public void mousePressed(MouseEvent e){
            system.killAlarm();
            mousePressedTime=e.getWhen();
        }

        public void mouseReleased(MouseEvent e){
            if(e.getWhen() - mousePressedTime < delay){      // 1초보다 짧게 누르면!!!!

                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.
                    system.changeToNextMode();

                } else {
                    switch (modeIndex) {        // 일반 모드일 경우.
                        case 0:
                            if(system.getEnterSettingTimeTrue()){
                                system.setCursorNext();
                            } else {
                                system.selectNextSelectableMode();
                            }
                            break;

                        case 5:
                            if(system.getIsGlobalTimeEnter()){
                                system.exitSettingGlobalTime();
                            } else {
                                system.selectNextSelectableMode();
                            }
                            break;

                        default:
                            system.selectNextSelectableMode();
                            //System.out.println(system.get);
                            break;

                    }
                }
            } else {             // 1초보다 길게 누르면!!!!!
                if(system.getEnterSettingModesTrue()){          // set mode 일 경우.
                    system.exitSettingModes();

                } else {
                    system.enterSettingModes();
                }


            }
        }
    };

    public void buttonMethod(){
        gui.button[0].addMouseListener(mouseListener0);
        gui.button[1].addMouseListener(mouseListener1);
        gui.button[2].addMouseListener(mouseListener2);
        gui.button[3].addMouseListener(mouseListener3);
    }



    Runnable displayThread = new Runnable() {
         Bell bell = new Bell();
        @Override
        public void run() {
            while (true) {

                // Buzzer
                if(system.setModes.getCurrentModes()[1]){       // 모드 인덱스 1 타이머
                    buzzerT=system.isTimerBuzzerOn();
                }

                if(system.setModes.getCurrentModes()[3]){        // 모드 인덱스 3 알람
                    buzzerA=system.isAlarmBuzzerOn();
                }

                if(buzzerA || buzzerT){
                    gui.updateBuzzer(true);
                    bell.run();
                } else {
                    gui.updateBuzzer(false);
                    bell.pause();
                }


                // Display
                blinkTIme++;                                // 깜빡임 작동기!!!
                if(blinkTIme > blinkInThisTime){
                    blinkTIme=0;
                }

                if (system.getEnterSettingModesTrue()) {         // Set Mode display.

                    gui.setIconInvisible(1);          // Global Time 표시.

                    copiedNewMode = system.getNewModes();
                    System.arraycopy(system.getNewModes(), 1, copiedNewMode, 1, 5);

                    for (int i = 1; i < 6; i++) {       // new mode에서 골라진 것만 표시해준다. 아@!! 현재 커서를 보여줘야 한다.....ㅠㅠ

                        if (copiedNewMode[i]) {
                            if(system.getSavableModeIndex()==i) {       // 커서가 가있는 아이콘은 깜빡이게 해야하고, 커서가 가있지 않은 아이콘은 그냥 표시.
                                if(blinkTIme < blinkInThisTime/3){
                                    gui.setIconInvisible(i+2);     // mode display는 한 모드만 보여준다.
                                } else {
                                    gui.setIconVisible(i+2);
                                }
                            } else {
                                gui.setIconVisible(i+2);
                            }

                        } else {

                            if(system.getSavableModeIndex()==i) {       // 커서가 가있는 아이콘은 깜빡이게 해야하고, 커서가 가있지 않은 아이콘은 그냥 표시.
                                if(blinkTIme < blinkInThisTime/3){
                                    gui.setIconInvisible(i+2);     // mode icon 은 2부터 시작. mode index 2 = TIME
                                } else {
                                    gui.setIconVisible(i+2);
                                }
                            } else {
                                gui.setIconInvisible(i + 2);
                            }
                        }
                        //gui.setIconVisible(system.getSavableModeIndex()+2);
                    }


                    dateIndex = system.getDayOfWeek();

                    stringTime = system.getCurrentTime();
                    stringTimeTokenized = new StringTokenizer(stringTime, " -:");

                    yearPart = Integer.parseInt(stringTimeTokenized.nextToken());
                    monthPart = Integer.parseInt(stringTimeTokenized.nextToken());
                    dayPart = Integer.parseInt(stringTimeTokenized.nextToken());
                    //dayPart = 26;//Integer.parseInt(stringTimeTokenized.nextToken());
                    hourPart = Integer.parseInt(stringTimeTokenized.nextToken());
                    minutePart = Integer.parseInt(stringTimeTokenized.nextToken());
                    secondPart = Integer.parseInt(stringTimeTokenized.nextToken());

                    //if()
                    gui.updateHour(hourPart, true);

                    gui.updateMinute(minutePart, true);

                    gui.updateSecond(secondPart);

                    gui.updateYear(yearPart,true);

                    gui.updateMonth(monthPart,true);

                    gui.updateDay(dayPart,true);

                    gui.updateDate(dateIndex);

                } else {

                modeIndex = system.setModes.getCurrentMode();

                if (system.setModes.getCurrentModes()[3]) {        // 모드 인덱스 3 알람. 알람모드가 set mode에서 선택되어 있으면 보인다.
                    isAlarmActivated = system.alarmManager.isAlarmActivated();   // 현재 선택된 모드에 상관 없이 보여진다.
                    if(modeIndex != 3) {
                        if (isAlarmActivated) {
                            gui.setIconVisible(0);
                        } else {
                            gui.setIconInvisible(0);
                        }
                    }
                }


                switch (modeIndex) {
                    case 0:         // Set Time
                        gui.setIconInvisible(1);
                        gui.modeDisplay(modeIndex);

                        dateIndex = system.getDayOfWeek();
                        //System.out.println("Date Index : "+dateIndex);
                        stringTime = system.getCurrentTime();
                        stringTimeTokenized = new StringTokenizer(stringTime, " -:");
                        yearPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        monthPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        dayPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        //dayPart = 26;//Integer.parseInt(stringTimeTokenized.nextToken());
                        hourPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        minutePart = Integer.parseInt(stringTimeTokenized.nextToken());
                        secondPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        gui.updateDate(dateIndex);

                        if(system.getCursor()==1) {     // 커서 1 -> 시 부분
                            if(blinkTIme < blinkInThisTime/3) {
                                gui.updateHour(hourPart, false);
                            } else {
                                gui.updateHour(hourPart, true);
                            }
                        } else {
                            gui.updateHour(hourPart, true);
                        }

                        if(system.getCursor()==0) {     // 커서 0 -> 분 부분
                            if(blinkTIme < blinkInThisTime/3) {
                                gui.updateMinute(minutePart,false);
                            } else {
                                gui.updateMinute(minutePart, true);
                            }
                        } else {
                            gui.updateMinute(minutePart, true);
                        }

                        gui.updateSecond(secondPart);

                        if(system.getCursor()==4) {
                            if(blinkTIme < blinkInThisTime/3) {
                                gui.updateYear(yearPart,false);
                            } else {
                                gui.updateYear(yearPart, true);
                            }
                        } else {
                            gui.updateYear(yearPart, true);
                        }

                        if(system.getCursor()==3) {
                            if(blinkTIme < blinkInThisTime/3) {
                                gui.updateMonth(monthPart,false);
                            } else {
                                gui.updateMonth(monthPart,true);
                            }
                        } else {
                            gui.updateMonth(monthPart,true);
                        }


                        if(system.getCursor()==2) {
                            if(blinkTIme < blinkInThisTime/3) {
                                gui.updateDay(dayPart, false);

                            } else {
                                gui.updateDay(dayPart, true);
                            }
                        } else {
                            gui.updateDay(dayPart, true);
                        }

                        break;

                    case 1:        // Timer

                        gui.setIconInvisible(1);
                        gui.modeDisplay(modeIndex);


                            hourPart = (int) (system.getTimerTime() / (60 * 60));
                            minutePart = (((int) system.getTimerTime()) % 3600) / 60;
                            secondPart = (int) (system.getTimerTime() % 60);

                        //System.out.println(secondPart);
                        gui.updateHour(hourPart, true);
                        gui.updateMinute(minutePart, true);
                        gui.updateSecond(secondPart);
                        gui.updateYear(yearPart, true);
                        gui.updateMonth(monthPart, true);
                        gui.updateDay(dayPart, true);

                        break;

                    case 2:        // Stopwatch
                        gui.setIconInvisible(1);
                        gui.modeDisplay(modeIndex);

                        secondPart = (int) (system.getStopwatchTime());
                        minutePart = (int) ((system.getStopwatchTime() / 100) % 60);
                        hourPart = (int) ((system.getStopwatchTime() / 100) / 60);
                        gui.updateHour(hourPart, true);
                        gui.updateMinute(minutePart, true);
                        gui.updateSecond(secondPart);
                        gui.updateYear(yearPart, true);
                        gui.updateMonth(monthPart, true);
                        gui.updateDay(dayPart, true);

                        break;

                    case 3:         // Alarm
                        gui.setIconInvisible(1);
                        if(system.isThisAlarmActivated()){
                            gui.setIconVisible(0);
                        } else {
                            gui.setIconInvisible(0);
                        }

                        gui.modeDisplay(modeIndex);

                        secondPart = 0;
                        minutePart = system.getAlarmTimeMinute();
                        hourPart = system.getAlarmTimeHour();
                        gui.updateHour(hourPart, true);
                        gui.updateMinute(minutePart, true);
                        gui.updateSecond(0);
                        gui.updateYear(yearPart, true);
                        gui.updateMonth(monthPart, true);
                        gui.updateDay(dayPart, true);
                        break;

                    case 4:         // Random Number Generator
                        gui.setIconInvisible(1);
                        gui.modeDisplay(modeIndex);

                        hourPart = system.getInputNumber();
                        minutePart = system.getRandomNumber();
                        gui.updateHour(hourPart, true);
                        gui.updateMinute(minutePart, true);
                        gui.updateSecond(0);
                        gui.updateYear(yearPart, true);
                        gui.updateMonth(monthPart, true);
                        gui.updateDay(dayPart, true);

                        break;

                    case 5:         // GMT
                        dateIndex = system.getGlobalDayOfWeek();
                        gui.updateDate(dateIndex);
                        gui.setIconVisible(1);
                        gui.modeDisplay(modeIndex);

                        dateIndex = system.getGlobalDayOfWeek();
                        stringTime = system.getCurrentGlobalTime();
                        stringTimeTokenized = new StringTokenizer(stringTime, " -:");
                        yearPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        monthPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        dayPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        hourPart = Integer.parseInt(stringTimeTokenized.nextToken());
                        minutePart = Integer.parseInt(stringTimeTokenized.nextToken());
                        secondPart = Integer.parseInt(stringTimeTokenized.nextToken());

                        gui.updateHour(hourPart, true);
                        gui.updateMinute(minutePart, true);
                        gui.updateSecond(secondPart);
                        gui.updateYear(yearPart, true);
                        gui.updateMonth(monthPart, true);
                        gui.updateDay(dayPart, true);

                        break;

                }
            }
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    String exception= e.getMessage();
                    System.out.println("UI Interrupted Exception occured : "+exception);
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

}
