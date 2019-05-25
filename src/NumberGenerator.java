

public class NumberGenerator {
   // private boolean numberSaved;
    private int inputNumber;
    private int randomNumber;

    public NumberGenerator(){
       // this.numberSaved=false;
        this.randomNumber=0;
        this.inputNumber=0;
    }

    ///////////// For input(button)
    public void setRange() {
        if(inputNumber==59) {
            inputNumber=0;
        } else {
            inputNumber++;
        }
    }

    public void resetRange(){
        this.inputNumber=0;
    }

    ///////////// For display
    public int getInputNumber(){
        return this.inputNumber;
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }

    public void generateRandomNumber() {
        randomNumber = (int) (Math.random()*this.inputNumber);      // 0~99까지 표현 가능
    }
}
