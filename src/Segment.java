
//import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;


public class Segment extends JPanel {
    private static final long serialVersionUID = -4980210296562972446L;

    private Rectangle[] rect = {
            new Rectangle(2,0,12,3),
            new Rectangle(13,2,3,12),
            new Rectangle(13,15,3,12),
            new Rectangle(2,26,12,3),
            new Rectangle(0,15,3,12),
            new Rectangle(0,2,3,12),
            new Rectangle(2,13,12,3)
    };

    int size[] = {5,3};


    private JPanel[] pnlSeg;
    private JLabel[] imgSeg;

    public JPanel getPanelSeg(int index)
    {
        return this.pnlSeg[index];
    }

    public Segment() {
        super();
        initSegment(new Dimension(80,140), 1);

    }

    public Segment(Dimension dim, int level) {
        super();
        initSegment(dim, level);
    }

    private void initSegment(Dimension dim, int level)
    {
        this.setName("mSegment");
        this.setBackground(new Color(225,228,230));
        this.setSize(dim);
        Constants constants = new Constants();

        this.pnlSeg = new JPanel[7];
        this.imgSeg = new JLabel[7];

        for (int j = 0; j < 7; j++)
        {
            this.pnlSeg[j] = new JPanel();

            if(j==1||j==2||j==4||j==5) {
                if(level == 0)  this.imgSeg[j] = new JLabel(new ImageIcon(constants.seg_image_v1));
                if(level == 1)  this.imgSeg[j] = new JLabel(new ImageIcon(constants.seg_image_v2));
                this.imgSeg[j].setBounds(0,0,3*size[level],12*size[level]);
            }
            else   {
                if(level == 0)  this.imgSeg[j] = new JLabel(new ImageIcon(constants.seg_image_h1));
                if(level == 1)  this.imgSeg[j] = new JLabel(new ImageIcon(constants.seg_image_h2));
                this.imgSeg[j].setBounds(0,0,12*size[level],3*size[level]);
            }

            this.pnlSeg[j].setName("SegmentNum #"+j);
            this.pnlSeg[j].setBounds(rect[j].x*size[level],rect[j].y*size[level],rect[j].width*size[level],rect[j].height*size[level]); //크기 설정
            this.pnlSeg[j].setOpaque(false); //투명설정 false=투명

            //this.pnlSeg[j].setBackground(new Color(61,66,82)); 어차피 imgSeg 로 이미지를 덮을 거라 pnlSeg 배경 색 필요없음
            this.pnlSeg[j].add(imgSeg[j]);
            this.pnlSeg[j].setLayout(null);
        }

    }

    public Rectangle getRect(int index)
    {
        return rect[index];
    }
}
