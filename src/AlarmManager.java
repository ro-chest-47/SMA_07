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


    public void setAlarmHourAdd() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmHourAdd();
                break;
            case 1:
                alarm1.setThisAlarmHourAdd();
                break;
            case 2:
                alarm2.setThisAlarmHourAdd();
                break;
            case 3:
                alarm3.setThisAlarmHourAdd();
                break;
        }
    }

    public void setAlarmMinuteAdd() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmMinuteAdd();
                break;
            case 1:
                alarm1.setThisAlarmMinuteAdd();
                break;
            case 2:
                alarm2.setThisAlarmMinuteAdd();
                break;
            case 3:
                alarm3.setThisAlarmMinuteAdd();
                break;
        }
    }

    public void setAlarmHourMinus() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmHourMinus();
                break;
            case 1:
                alarm1.setThisAlarmHourMinus();
                break;
            case 2:
                alarm2.setThisAlarmHourMinus();
                break;
            case 3:
                alarm3.setThisAlarmHourMinus();
                break;
        }
    }

    public void setAlarmMinuteMinus() {
        switch (this.alarmIndex){
            case 0:
                alarm0.setThisAlarmMinuteMinus();
                break;
            case 1:
                alarm1.setThisAlarmMinuteMinus();
                break;
            case 2:
                alarm2.setThisAlarmMinuteMinus();
                break;
            case 3:
                alarm3.setThisAlarmMinuteMinus();
                break;
        }
    }

    public void activateAlarm() {
        switch (this.alarmIndex) {
            case 0:
                if(alarm0.getIsAlarmActivated()){
                    alarm0.setAlarmOff();
                } else {
                    alarm0.setAlarmOn();
                }
                 break;

            case 1:
                if(alarm1.getIsAlarmActivated()){
                    alarm1.setAlarmOff();
                } else {
                    alarm1.setAlarmOn();
                }
                 break;

            case 2:
                if(alarm2.getIsAlarmActivated()){
                    alarm2.setAlarmOff();
                } else {
                    alarm2.setAlarmOn();
                }
                break;
            case 3:
                if(alarm3.getIsAlarmActivated()){
                    alarm3.setAlarmOff();
                } else {
                    alarm3.setAlarmOn();
                }
                break;
        }
    }

    /*public void deactivateAlarm() {
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
    }*/

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

    public boolean isThisAlarmActivated(){  // 알람 메뉴에서 알람 하나마다 켜졌는지 확인
        switch(this.alarmIndex){
            case 0:
                return alarm0.getIsAlarmActivated();

            case 1:
                return alarm1.getIsAlarmActivated();

            case 2:
                return  alarm2.getIsAlarmActivated();

            case 3:
                return alarm3.getIsAlarmActivated();
        }

        return false;
    }
}
