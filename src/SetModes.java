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
        System.arraycopy(currentModes, 1, newModes, 1, 5);  //들어올 땐, 예전에 갖고있던 모드 정보를 갖고 있는다.
        numberOfModes=3;
        isEnterSettingModes=true;
    }

    public boolean getEnterSettingModesTrue(){

        return isEnterSettingModes;
    }

    public void exitSettingModes(){
        if(this.numberOfModes==3) {         // 세 개를 고르지 않으면 저장되지 않는다.
            System.arraycopy(newModes, 1, currentModes, 1, 5);
        }
        this.resetNewModes();
        this.modesArrayIndex=0;
        isEnterSettingModes = false;
    }


///////////////////////// For display

    public boolean[] getNewModes(){     // 모드 설정 도중에 새로 선택된 모드를 보여준다.
        return this.newModes;
    }

    public boolean[] getCurrentModes(){
        return this.currentModes;
    }

    public int getSavableModeIndex(){
        return this.savableModeIndex;
    }

///////////////////////// 현재 메뉴에서 모드 선택

    public int getCurrentMode(){     // 현재 선택된 모드가 무엇있지 알기 위해!!! 이 index에 맞춰서 System이나 UI에서 switch 문으로..

        return this.modesArrayIndex;
    }

    ///////////////////////////////////TESTESTESTESTE

    public void selectNextSelectableMode(int arrayIndex){      //입력값은 modesArrayIndex // 일반 모드에서 다음모드 선택.

      /*  this.modesArrayIndex=arrayIndex;
        //System.out.println(" mode index: "+this.modesArrayIndex);
        if(this.modesArrayIndex==5){
            this.modesArrayIndex=0;

        } else {
            if(currentModes[modesArrayIndex+1]){
                modesArrayIndex++;
            } else {
                this.selectNextSelectableMode(modesArrayIndex+1);
            }
        }
*/

        if(this.modesArrayIndex==5){
            this.modesArrayIndex=0;
            return;
        } else {
            while(this.modesArrayIndex<5){
                if(this.modesArrayIndex+1==5 && currentModes[5]==false){
                    this.modesArrayIndex=0;
                    break;
                }

                if(currentModes[this.modesArrayIndex+1]){
                    this.modesArrayIndex++;
                    break;
                } else {
                    this.modesArrayIndex++;
                }
            }
        }
        return;
    }



//////////////////// For Save new modes

    /*public void saveNewModes() {      // 그냥 3개 고르고 나가면 자동으로 저장된다.

    }*/

   /* public int getSavableModeIndex(){
        return this.savableModeIndex;
    }*/

    public void changeToNextMode() {          // 모드 메뉴 설정(모드 선택 모드)에서 모드를 고를 때는 TimeKeeping 뺴고만 고를 수 있으니까.
        if(savableModeIndex==5) {
            savableModeIndex=1;
        } else {
            savableModeIndex++;
        }
       // System.out.println(savableModeIndex);
    }

    public void saveMode() {                          // 선택한 모드를 newMode에 저장하거나, 제거한다.
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
        for(int i=1; i<6; i++){
            this.newModes[i]=false;
        }
        this.numberOfModes=0;
    }
}
