import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Bell extends Thread {
    private AudioInputStream audioIn;
    private Clip clip;

    public Bell() {
        File f = new File("./Alarm.wav");
        try {
            audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.stop();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

    public void play(){
        this.start();
    }

    public void pause(){
        clip.stop();
    }

    public boolean isPlaying(){
        return clip.isActive();
    }
}