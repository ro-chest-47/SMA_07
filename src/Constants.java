//import TravelerDigitalWatchJDKError.lib;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public final class Constants {

    static String APP_TITLE = "TravelClock";
    final URL ICO_URL = getClass().getClassLoader().getResource("clock_icon.png");
    final URL APP_BACKGROUND = getClass().getClassLoader().getResource("clock.png");
    final URL seg_image_h1 = getClass().getClassLoader().getResource("horizontal_1.png");
    final URL seg_image_h2 = getClass().getClassLoader().getResource("horizontal_2.png");
    final URL seg_image_v1 = getClass().getClassLoader().getResource("vertical_1.png");
    final URL seg_image_v2 = getClass().getClassLoader().getResource("vertical_2.png");
    //URL imageURL = getClass().getClassLoader().getResource();
    public Constants(){

    }

     final URL[] icon_image =
            {
                    getClass().getClassLoader().getResource("icon_1.png"), getClass().getClassLoader().getResource("icon_2.png"),
                    getClass().getClassLoader().getResource("icon_3.png"), getClass().getClassLoader().getResource("icon_4.png"),
                    getClass().getClassLoader().getResource("icon_5.png"), getClass().getClassLoader().getResource("icon_6.png"),
                    getClass().getClassLoader().getResource("icon_7.png"),  getClass().getClassLoader().getResource("icon_8.png"),
                    getClass().getClassLoader().getResource("icon_9.png")
            };
     final URL[] button_image =
            {
                    getClass().getClassLoader().getResource("button_1.png"),
                    getClass().getClassLoader().getResource("button_2.png"),
                    getClass().getClassLoader().getResource("button_3.png"),
                    getClass().getClassLoader().getResource("button_4.png")
            };

    public static final boolean[][] CLOCKBIN =
            {
                    new boolean[] { true, true, true, true, true, true, false }, 			// 0
                    new boolean[] { false, true, true, false, false, false, false }, 		// 1
                    new boolean[] { true, true, false, true, true, false, true },			// 2
                    new boolean[] { true, true, true, true, false, false, true },			// 3
                    new boolean[] { false, true, true, false, false, true, true },			// 4
                    new boolean[] { true, false, true, true, false, true, true },			// 5
                    new boolean[] { true, false, true, true, true, true, true },			// 6
                    new boolean[] { true, true, true, false, false, false, false },		// 7
                    new boolean[] { true, true, true, true, true, true, true },			// 8
                    new boolean[] { true, true, true, true, false, true, true },			// 9
                    new boolean[] { true, true, true, false, true, true, true },			// A
                    new boolean[] { false, true, true, true, true, false, true },			// D
                    new boolean[] { true, false, false, true, true, true, true },			// E
                    new boolean[] { true, false, false, false, true, true, true },			// F
                    new boolean[] { false, true, true, false, true, true, true },			// H
                    new boolean[] { false, false, false, false, true, true, false },			// I
                    new boolean[] { true, false, true, false, true, false, true },			// M
                    new boolean[] { false, false, true, false, true, false, true },			// N
                    new boolean[] { false, false, true, true, true, false, true },			// O
                    new boolean[] { false, false, false, false, true, false, true },			// R
                    new boolean[] { true, false, true, true, false, true, true },			// S
                    new boolean[] { false, false, false, true, true, true, true },			// T
                    new boolean[] { false, false, true, true, true, false, false },			// U
                    new boolean[] { false, true, false, true, false, true, true },			// W
            };

    public static int getNthDigit(int number, int base, int n) {
        return (int) ((number / Math.pow(base, n - 1)) % base);
    }

    public static int getDayOFWeekDigit(int number, int base){
        switch (base){      // 세그먼트 위치
            case 0:
                switch (number){        // 요일
                    case 1:
                        return 20;

                    case 2:
                        return 16;

                    case 3:
                        return 21;

                    case 4:
                        return 23;

                    case 5:
                        return 21;

                    case 6:
                        return 13;

                    case 7:
                        return 20;

                        default:
                            return 0;
                }

            case 1:         // 두번째 세그먼트
                switch (number){
                    case 1:
                        return 22;

                    case 2:
                        return 18;

                    case 3:
                        return 22;

                    case 4:
                        return 12;

                    case 5:
                        return 14;

                    case 6:
                        return 19;

                    case 7:
                        return 10;


                        default:
                            return 0;
                }

            case 2:
                switch (number){
                    case 1:
                        return 17;

                    case 2:
                        return 17;

                    case 3:
                        return 12;

                    case 4:
                        return 11;

                    case 5:
                        return 22;

                    case 6:
                        return 15;

                    case 7:
                        return 21;

                        default:
                            return 0;
                }


                default:
                    return 0;
        }
    }
}
