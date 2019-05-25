public class WatchSystem {

   // private int currentMode;
    SetTime setTime;
    AlarmManager alarmManager;
    GlobalTime globalTime;
    NumberGenerator numberGenerator;
    SetModes setModes;
    Stopwatch stopwatch;
    TimerT timerT;

    public WatchSystem(){
        setTime = new SetTime();
        timerT = new TimerT();
        stopwatch = new Stopwatch();
        alarmManager = new AlarmManager();
        numberGenerator = new NumberGenerator();
        globalTime = new GlobalTime();
        setModes = new SetModes();
        //currentMode = setModes.getCurrentMode();
    }

   /* public void setButton(int button){
        this.button = button;
    }*/




   /////////////////////////// ALARM FUNCTION /////////////////////////////////////
   public int getAlarmIndex(){
       return alarmManager.getAlarmIndex();
   }

   public void addAlarmIndex(){
       alarmManager.addAlarmIndex();
   }

   public void setAlarmHour(){
       alarmManager.setAlarmHour();
   }

   public void setAlarmMinute(){
       alarmManager.setAlarmMinute();
   }

   public void activateAlarm(){
       alarmManager.activateAlarm();
   }

    public void deactivateAlarm(){
        alarmManager.deactivateAlarm();
    }

   public void killAlarm(){
       alarmManager.killAlarm();
   }


   public int getAlarmTimeHour(){
      return alarmManager.getAlarmTimeHour();
   }

   public int getAlarmTimeMinute(){
        return alarmManager.getAlarmTimeMinute();
   }

   public boolean isAlarmActivated(){
      return alarmManager.isAlarmActivated();
   }





    /////////////////////////// SETTIME FUNCTION /////////////////////////////////////


    public void enterSettingTime() {
        setTime.enterSettingTime();
    }

    public boolean getEnterSettingTimeTrue(){
       return setTime.getEnterSettingTimeTrue();
    }

    public void exitSettingTime() {
       if(setTime.getIsSetTimeSave()==false){
           setTime.setTimeUnsave();
       }
        setTime.exitSettingTime();
    }

    public void setTimeMinutesAdd(){
       setTime.setTimeMinutesAdd();
    }

    public void setTimeMinutesMinus(){
       setTime.setTimeMinutesMinus();
    }

    public void setTimeHourAdd(){
       setTime.setTimeHourAdd();
    }

    public void setTimeHourMinus(){
       setTime.setTimeHourMinus();
    }

    public void setDayAdd(){
       setTime.setDayAdd();
    }

    public void setDayMinus(){
       setTime.setDayMinus();
    }

    public void setMonthAdd(){
       setTime.setMonthAdd();
    }

    public void setMonthMinus(){
       setTime.setMonthMinus();
    }

    public void setYearAdd(){
       setTime.setYearAdd();
    }

    public void setYearMinus(){
        setTime.setYearMinus();
    }

    public void setTimeSave(){
       setTime.setTimeSave();
    }


    /////////////////////////////// For display

    public String getCurrentTime(){
       return setTime.getCurrentTime();
    }

    public int getDayOfWeek(){
       return setTime.getDayOfWeek();
    }


    /////////////////////////// TIMERT FUNCTION /////////////////////////////////////

    public void saveMinutesAdd(){
       timerT.saveMinutesAdd();
    }

    public void saveMinutesMinus(){
       timerT.saveMinutesMinus();
    }

    public void saveHour(){
       timerT.saveHour();
    }

    public void startTimer(){
       timerT.startTimer();
    }

    public void stopTImer(){
       timerT.stopTimer();
    }

    public void resetTimer(){
       timerT.resetTimer();
    }

    ///////////// For display
    public long getTimerTime(){
       return timerT.getTimerTime();
    }


    ///////////// For buzzer

    public boolean isTimerBuzzerOn(){
        return timerT.isBuzzerOn();
    }

    public boolean isAlarmBuzzerOn(){
       return alarmManager.isBuzzerOn();
    }


    /////////////////////////// STOPWATCH FUNCTION /////////////////////////////////////

    public void startStopwatch(){
       stopwatch.startStopwatch();
    }

    public void stopStopwatch(){
       stopwatch.stopStopwatch();
    }

    public void resetStopwatch(){
       stopwatch.resetStopwatch();
    }

    public long getStopwatchTime(){
       return stopwatch.getStopwatchTime();
    }




    /////////////////////////// RANDOM NUMBER FUNCTION /////////////////////////////////////

    public void setRandomNumberRange(){
       numberGenerator.setRange();
    }

    public void generateRandomNumber(){
       numberGenerator.generateRandomNumber();
    }

    public int getRandomNumber(){
        return numberGenerator.getRandomNumber();
    }

    public int getInputNumber(){
        return numberGenerator.getInputNumber();
    }

    public void resetRandomNumberRange(){
       numberGenerator.resetRange();
    }




    /////////////////////////// GLOBAL TIME FUNCTION /////////////////////////////////////

    public boolean getIsGlobalTimeEnter(){
       return globalTime.getIsGlobalTimeEnter();
    }

    public void enterSettingGlobalTime(){
       globalTime.enterSettingGlobalTime();
    }

    public void exitSettingGlobalTime(){
       globalTime.exitSettingGlobalTime();
    }


    public void setGlobalTimeSaveHoursAdd(){
       globalTime.saveHoursAdd();
    }

    public void setGlobalTimeSaveHoursMinus(){
        globalTime.saveHoursMinus();
    }

    public void setGlobalTimeSaveMinutesAdd(){
       globalTime.saveMinutesAdd();
    }

    public void setGlobalTimeSaveMinutesMinus(){
        globalTime.saveMinutesMinus();
    }


    public String getCurrentGlobalTime(){
       return globalTime.getCurrentGlobalTime();
    }

    public int getGlobalDayOfWeek(){
       return globalTime.getGlobalDayOfWeek();
    }



    /////////////////////////// SET MODES FUNCTION /////////////////////////////////////

    public void enterSettingModes(){
       setModes.enterSettingModes();
    }

    public boolean getEnterSettingModesTrue(){
       return setModes.getEnterSettingModesTrue();
    }

    public void exitSettingModes(){
       setModes.exitSettingModes();
    }

    public boolean[] getNewModes(){
       return setModes.getNewModes();
    }

    public boolean[] getCurrentModes(){
       return setModes.getCurrentModes();
    }

    public int getCurrentMode(){
       return setModes.getCurrentMode();
    }

    public void selectNextSelectableMode(){
       setModes.selectNextSelectableMode(this.getCurrentMode());
    }

    public void changeToNextSelectableMode(){
        setModes.changeToNextSelectableMode();
    }

    public void saveMode(){
       setModes.saveMode();
    }

    public void resetNewModes(){
       setModes.resetNewModes();
    }
}
