
import java.awt.*;
import javax.swing.*;
import java.net.*;

public class GUI extends JFrame {
    //private boolean isBlinking;
   // private boolean blinking;

    private static final long serialVersionUID = -4621924450652779205L;
    private Segment[] segment = new Segment[15];
    private boolean isBuzzerOn;
    public JLabel buzzer = new JLabel("BUZZER");
    public JLabel[] icon = new JLabel[9];
    public JButton[] button = new JButton[4];



    //여기서 버튼 크기 조절!!
    private Rectangle[] button_rect = {
            new Rectangle(110,100,50,50),
            new Rectangle(110,630,50,50),
            new Rectangle(630,100,50,50),
            new Rectangle(630,630,50,50)
    };


    //여기서 아이콘 크기 조절!! ICON 크기 조절시 png 파일도 크기에 맞춰주자
    private Rectangle[] icon_rect = {
            new Rectangle(80,205,40,40),
            new Rectangle(80,245,40,40),
            new Rectangle(330,550,40,40),
            new Rectangle(380,550,40,40),
            new Rectangle(430,550,40,40),
            new Rectangle(330,600,40,40),
            new Rectangle(380,600,40,40),
            new Rectangle(430,600,40,40),
            new Rectangle(280,70,180,67)
    };

    //여기서 SEGMENT 크기 조절!! 되도록 건들지 않기
    private Rectangle[] seg_rect = {
            new Rectangle(140,340,80,160),
            new Rectangle(220,340,80,160),
            new Rectangle(340,340,80,160),
            new Rectangle(420,340,80,160),
            new Rectangle(540,396,48,96),
            new Rectangle(588,396,48,96),
            new Rectangle(130,195,48,96),
            new Rectangle(178,195,48,96),
            new Rectangle(260,195,48,96),
            new Rectangle(308,195,48,96),
            new Rectangle(390,195,48,96),
            new Rectangle(438,195,48,96),
            new Rectangle(520,195,48,96),
            new Rectangle(568,195,48,96),
            new Rectangle(616,195,48,96)
    };

   // public final static String IMAGE_PATH = "";

    public GUI() //constructor
    {
        isBuzzerOn=false;
        buzzer.setText("BUZZER ON");
        buzzer.setAlignmentX(JLabel.CENTER);
        this.setName("UI_Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constants constants =  new Constants();
        setIconImage(new ImageIcon(constants.ICO_URL).getImage()); //아이콘 이미지 설정
        setTitle(constants.APP_TITLE); //TITLE 설정
        setSize(800, 800); //창 크기 설정
        setLocation(200, 500); //창 위치 설정
        setResizable(false); //창 크기 변경 가능/불가능





        //segment 생성 level 0 =100% 크기 , level 1 = 75% 크기
        Dimension dim = new Dimension();
        dim.setSize(80, 160);
        for (int i = 0; i < 4; i++) segment[i] = new Segment(dim, 0);
        dim.setSize(60, 120);
        for (int i = 4; i < 15; i++) segment[i] = new Segment(dim, 1);

        //this.isBlinking = false;
       // this.blinking=false;

        ///layout 설정, Panel 이름 설정, segment 붙이기
        for (int i = 0; i < 15; i++) {
            segment[i].setName("Segment #" + i);
            segment[i].setLayout(null);
            for (int j = 0; j < 7; j++) segment[i].add(segment[i].getPanelSeg(j));
        }

        //각 Panel 들 위치조정(seg_rect 좌표) , 및 Frame에 올리기 (getContentPane().add)
        for (int i = 0; i < 15; i++) {
            segment[i].setBounds(seg_rect[i]);
            getContentPane().add(segment[i]);
        }
        //icon 라벨 설정
       // Constants constants new Constants();
        for (int i = 0; i < 9; i++) {
            icon[i] = new JLabel(new ImageIcon(constants.icon_image[i]));
            icon[i].setBounds(icon_rect[i]);
            icon[i].setOpaque(false);
        }



        //label 을 Frame 에 올리기 getContentPane().add 함수
        for (int i = 0; i < 9; i++) getContentPane().add(icon[i]);

        //test함수
        //updateIcon(3,false);

        //버튼 설정

        for (int i = 0; i < 4; i++) {
            button[i] = new JButton(new ImageIcon(constants.button_image[i])); // 다 URL 객체로 바꿀것.
            button[i].setBounds(button_rect[i]);
            button[i].setOpaque(true);
        }
        //button[0].addActionListener();

        for (int i = 0; i < 4; i++) {
            getContentPane().add(button[i]);
        }
        getContentPane().add(buzzer);


        //배경 설정
        JLabel background = new JLabel(new ImageIcon(constants.APP_BACKGROUND));
        background.setBounds(0, 0, 800, 800);
        getContentPane().add(background);
    }


    public void setIconVisible(int index){

        icon[index].setVisible(true);
    }

    public void setIconInvisible(int index){

        icon[index].setVisible(false);
    }

    public void modeDisplay(int index){
        for(int i=2; i<8; i++){
            icon[i].setVisible(false);
        }
        icon[index+2].setVisible(true);
    }

    /*public void selectedModeDisplay(int index){
        if()
            icon[index+2].setVisible(true);
    }*/

   /* public void setIsBlinkingTrue(){
        this.isBlinking=true;
    }

    public void setIsBlinkingFalse(){
        this.isBlinking=false;
    }*/



        public void updateHour ( int hour, boolean isNotBlinking) // 0 & 1
        {
            segment[0].setVisible(isNotBlinking);
            segment[1].setVisible(isNotBlinking);
            for (int i = 0; i < 7; i++) {
                segment[0].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(hour, 10, 2)][i] == true) ? true : false);
                segment[1].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(hour, 10, 1)][i] == true) ? true : false);
            }
        }

        public void updateMinute ( int minute, boolean isNotBlinking) // 2 & 3
        {
            segment[2].setVisible(isNotBlinking);
            segment[3].setVisible(isNotBlinking);
                for (int i = 0; i < 7; i++) {
                    segment[2].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(minute, 10, 2)][i] == true) ? true : false);
                    segment[3].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(minute, 10, 1)][i] == true) ? true : false);
                }
        }

        public void updateSecond ( int second) // 4 & 5
        {
            for (int i = 0; i < 7; i++) {
                segment[4].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(second, 10, 2)][i] == true) ? true : false);
                segment[5].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(second, 10, 1)][i] == true) ? true : false);
            }
        }

        public void updateYear ( int year, boolean isNotBlinking) // 6 & 7
        {
            segment[6].setVisible(isNotBlinking);
            segment[7].setVisible(isNotBlinking);

            for (int i = 0; i < 7; i++) {
                segment[6].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(year, 10, 2)][i] == true) ? true : false);
                segment[7].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(year, 10, 1)][i] == true) ? true : false);
            }
        }

        public void updateMonth ( int month, boolean isNotBlinking) // 8 & 9
        {
            segment[8].setVisible(isNotBlinking);
            segment[9].setVisible(isNotBlinking);

            for (int i = 0; i < 7; i++) {
                segment[8].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(month, 10, 2)][i] == true) ? true : false);
                segment[9].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(month, 10, 1)][i] == true) ? true : false);
            }
        }
        public void updateDay ( int day, boolean isNotBlinking) // 10 & 11
        {
            segment[10].setVisible(isNotBlinking);
            segment[11].setVisible(isNotBlinking);

            for (int i = 0; i < 7; i++) {
                segment[10].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(day, 10, 2)][i] == true) ? true : false);
                segment[11].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getNthDigit(day, 10, 1)][i] == true) ? true : false);
            }
        }

        public void updateDate ( int date) // 12 & 13 & 14
        {

            for (int i = 0; i < 7; i++) {
                segment[12].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getDayOFWeekDigit(date, 0)][i] == true) ? true : false);
                segment[13].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getDayOFWeekDigit(date, 1)][i] == true) ? true : false);
                segment[14].getPanelSeg(i).setVisible((Constants.CLOCKBIN[Constants.getDayOFWeekDigit(date, 2)][i] == true) ? true : false);
            }
        }


        public void updateIcon ( int index, boolean x){
        icon[index].setVisible(x);
    }


        public  void updateBuzzer(boolean isBuzzerOn){
            icon[8].setVisible(isBuzzerOn);

           // System.out.println("in Buzzer Checker");
            /*if(isBuzzerOn){
                //buzzer.setVisible(true);
                icon[8].setVisible(true);           // icon8 = 부저
            } else {
               // buzzer.setVisible(false);
                icon[8].setVisible(false);
            }*/
    }

}