public class AlarmManager {
    private int alarmIndex;
   // private int modifiedHour;
   // private int modifiedMinute;
    /*private boolean alarm0Activated;
    private boolean alarm1Activated;
    private boolean alarm2Activated;
    private boolean alarm3Activated;*/
   // private boolean alarmSaveHour;
   // private boolean alarmSaveMinute;
  //  private boolean alarmKilled;

    Alarm alarm0 = new Alarm();
    Alarm alarm1 = new Alarm();
    Alarm alarm2 = new Alarm();
    Alarm alarm3 = new Alarm();


    public AlarmManager(){
        alarmIndex=0;
    }

    public int getAlarmIndex() {
        return this.alarmIndex;
    }

    public void addAlarmIndex(){         // 이 알람 인덱스에 따라 화면에 표시되는 정보가 달라져야...
        if(this.alarmIndex==3) {
            this.alarmIndex = 0;
        } else {
            this.alarmIndex++;
        }
    }

    public void setAlarmHour() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmHour();
                break;
            case 1:
                alarm1.setThisAlarmHour();
                break;
            case 2:
                alarm2.setThisAlarmHour();
                break;
            case 3:
                alarm3.setThisAlarmHour();
                break;
        }
    }

    public void setAlarmMinute() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmMinute();
                break;
            case 1:
                alarm1.setThisAlarmMinute();
                break;
            case 2:
                alarm2.setThisAlarmMinute();
                break;
            case 3:
                alarm3.setThisAlarmMinute();
                break;
        }
    }

    public void activateAlarm() {
        switch (this.alarmIndex) {
            case 0:
                 alarm0.setAlarmOn();
                 break;
            case 1:
                 alarm1.setAlarmOn();
                 break;
            case 2:
                alarm2.setAlarmOn();
                break;
            case 3:
                alarm3.setAlarmOn();
                break;
        }
    }

    public void deactivateAlarm() {
        switch (this.alarmIndex) {
            case 0:
                alarm0.setAlarmOff();
                break;
            case 1:
                alarm1.setAlarmOff();
                break;
            case 2:
                alarm2.setAlarmOff();
                break;
            case 3:
                alarm3.setAlarmOff();
                break;
        }
    }

    public void killAlarm() {
        if(alarm0.getBuzzerOn()){
            alarm0.killAlarm();
        }

        if(alarm1.getBuzzerOn()){
            alarm1.killAlarm();
        }

        if(alarm2.getBuzzerOn()){
            alarm2.killAlarm();
        }

        if(alarm3.getBuzzerOn()){
            alarm3.killAlarm();
        }
    }

    public boolean isBuzzerOn(){        // 부저 울릴거냐고.
        if(alarm0.getBuzzerOn() || alarm1.getBuzzerOn() || alarm2.getBuzzerOn() || alarm3.getBuzzerOn()){
            return true;
        } else {
            return false;
        }
    }

///////////////////// For display
    public int getAlarmTimeHour(){
        switch(this.alarmIndex){
            case 0:
                return alarm0.getAlarmTimeHour();
            case 1:
                return alarm1.getAlarmTimeHour();
            case 2:
                return alarm2.getAlarmTimeHour();
            case 3:
                return alarm3.getAlarmTimeHour();
        }
        return 0;       // 이거 없으면 compile error.
    }

    public int getAlarmTimeMinute(){
        switch(this.alarmIndex){
            case 0:
                return alarm0.getAlarmTimeMinute();
            case 1:
                return alarm1.getAlarmTimeMinute();
            case 2:
                return alarm2.getAlarmTimeMinute();
            case 3:
                return alarm3.getAlarmTimeMinute();
        }
        return 0;       // 이거 없으면 compile error.
    }



    public boolean isAlarmActivated(){      // GUI에서 종모양 아이콘 전용.
        if(alarm0.getIsAlarmActivated() || alarm1.getIsAlarmActivated() || alarm2.getIsAlarmActivated() || alarm3.getIsAlarmActivated()){
            return true;
        } else {
            return false;
        }
    }
}
