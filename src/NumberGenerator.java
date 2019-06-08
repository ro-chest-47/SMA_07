import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class NumberGenerator {
   // private boolean numberSaved;
    private int inputNumber;
    private int randomNumber;
    SecureRandom random;

    public NumberGenerator(){
       // this.numberSaved=false;
        this.randomNumber=0;
        this.inputNumber=1;
        SecureRandom random=null;
    }

    ///////////// For input(button)
    public void setRange() {
        if(inputNumber==59) {
            inputNumber=1;
        } else {
            inputNumber++;
        }
    }

    public void resetRange(){
        this.inputNumber=1;
    }

    ///////////// For display
    public int getInputNumber(){
        return this.inputNumber;
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }

    public void generateRandomNumber() {
        //randomNumber = ((int) (Math.random()*this.inputNumber))+1;      // 0~59까지 표현 가능


        try{
            random = SecureRandom.getInstance("SHA1PRNG");
        }catch(NoSuchAlgorithmException e){
            String exception = e.getMessage();
            System.out.println("Random Number Generator Exception occurred : "+exception);
        }

        randomNumber = (random.nextInt(this.inputNumber))+1;
    }
}
