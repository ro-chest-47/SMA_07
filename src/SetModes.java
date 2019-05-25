public class SetModes {
    private boolean[] currentModes;
    private boolean[] newModes;
    private boolean isEnterSettingModes;
    private int numberOfModes;
    private int modesArrayIndex;
    private int savableModeIndex;

    public SetModes(){
        isEnterSettingModes=false;
        numberOfModes=0;
        modesArrayIndex=0;
        savableModeIndex=1;
        currentModes = new boolean[]{true, true, true, true, false, false};
        newModes = new boolean[]{true, false, false, false, false, false};
    }

    public void enterSettingModes(){
        savableModeIndex=1;             // 0번 Time Keeping은 뺄 수 없으니까.
        isEnterSettingModes=true;
    }

    public boolean getEnterSettingModesTrue(){
        return isEnterSettingModes;
    }

    public void exitSettingModes(){
        if(this.numberOfModes==3) {
            System.arraycopy(newModes, 1, currentModes, 1, 5);
        }
        this.resetNewModes();
        isEnterSettingModes = false;
    }


    /*public int getModesArrayIndex(){
        return this.modesArrayIndex;
    }*/


///////////////////////// For display
    public boolean[] getNewModes(){     // 모드 설정 도중에 새로 선택된 모드를 보여준다.
        return this.newModes;
    }

    public boolean[] getCurrentModes(){
        return this.currentModes;
    }



///////////////////////// 현재 메뉴에서 모드 선택

    public int getCurrentMode(){     // 현재 선택된 모드가 무엇있지 알기 위해!!! 이 index에 맞춰서 System이나 UI에서 switch 문으로..

        return this.modesArrayIndex;
    }

    public void selectNextSelectableMode(int arrayIndex){      //입력값은 modesArrayIndex // 일반 모드에서 다음모드 선택.
        if(arrayIndex==5){
            arrayIndex=0;
            /*if(currentModes[0]==false){
                selectNextSelectableMode(arrayIndex+1);
            }*/
        } else {
            if(currentModes[arrayIndex+1]){
                arrayIndex++;
            } else {
                selectNextSelectableMode(arrayIndex+1);
            }
        }
        this.modesArrayIndex = arrayIndex;
    }



//////////////////// For Save new modes

    /*public void saveNewModes() {      // 그냥 3개 고르고 나가면 자동으로 저장된다.

    }*/

    public void changeToNextSelectableMode() {          // 모드 메뉴 설정(모드 선택 모드)에서 모드를 고를 때는 TimeKeeping 뺴고만 고를 수 있으니까.
        if(savableModeIndex==5) {
            savableModeIndex=1;
        } else {
            savableModeIndex++;
        }
    }

    public void saveMode() {                          // 선택한 모드를 newMode에 저장한다.
        if(this.newModes[savableModeIndex]) {
            this.newModes[savableModeIndex] = false;
            this.numberOfModes--;
        } else {
            if(numberOfModes<3) {
                this.newModes[savableModeIndex] = true;
                this.numberOfModes++;
            } else {
                ///////////// 이미 모드 세 개를 다 고른 후에는???
            }
        }
    }

    public void resetNewModes() {
        this.newModes = new boolean[]{true, false, false, false, false, false};
    }
}
